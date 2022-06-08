/*
 * Creation : 22 Mar 2022
 */
package com.inetpsa.nrb.serviceimpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.inetpsa.nrb.constant.CommonConstant;
import com.inetpsa.nrb.dto.BatteryHealthDataDto;
import com.inetpsa.nrb.dto.BatteryModuleHistoryDto;
import com.inetpsa.nrb.dto.ElectronicBatteryDataDto;
import com.inetpsa.nrb.dto.GeneralBatteryDataDto;
import com.inetpsa.nrb.dto.ModuleAndSubassemblyDto;
import com.inetpsa.nrb.model.HistoryEntity;
import com.inetpsa.nrb.repository.BmuRepository;
import com.inetpsa.nrb.service.BatteryDetailService;

/**
 * The Class BatteryDetailServiceImpl.
 */

@Service
public class BatteryDetailServiceImpl implements BatteryDetailService {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(BatteryDetailServiceImpl.class);

    /** The entity manager. */
    @PersistenceContext
    private EntityManager entityManager;

    /** The total records. */
    long totalRecords;

    /** The code lbl. */
    private String codeLbl;

    /** The sgr lbl. */
    private String sgrLbl;

    /** The status lbl. */
    private String statusLbl;

    /** The general battery detail data. */
    GeneralBatteryDataDto generalBatteryDetailData;

    /** The electronic battery detail data. */
    ElectronicBatteryDataDto electronicBatteryDetailData;

    /** The battery health detail data. */
    BatteryHealthDataDto batteryHealthDetailData;

    /** The category module. */
    List<String> categoryModule = new ArrayList<>();

    /** The category sub assembly. */
    List<String> categorySubAssembly = new ArrayList<>();

    /** The formatter. */
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    /** The date formatter. */
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /** The bmu repository. */
    @Autowired
    BmuRepository bmuRepository;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryDetailService#getGeneralBatteryData(java.lang.String, java.lang.String)
     */
    public List<GeneralBatteryDataDto> getGeneralBatteryData(@Param("bin") String bin, @Param("lang") String lang) {

        try {
            logger.info("Entering getGeneralBatteryData for bin{} and language {}", bin, lang);
            List<GeneralBatteryDataDto> data = new ArrayList<>();
            generalBatteryDetailData = null;
            codeLbl = "";
            sgrLbl = "";
            statusLbl = " ";
            Query query = entityManager.createQuery(
                    "SELECT org.id, org.reference, org.description2, vin.vin, org.codeUsing, code_usine.lblCode AS lbl_usine, org.dateProduction, org.dateEngagement, org.status, trad.lbltrad AS lbl_status, org.codeSgr, code_sgr.lblCode AS lbl_sgr, org.codeAtelier, org.userMaj, org.dateMaj FROM OrganeEntity org LEFT JOIN CodeTypeEntity code_usine ON (org.codeUsing = code_usine.codeTypeEntityPk.idCode AND code_usine.codeTypeEntityPk.typCode = 'CODE_USINE') LEFT JOIN TranslationEntity trad ON (org.status=SUBSTR(trad.translationEntityPk.idtrad,8,1) AND trad.typtrad='1-STATUS' AND trad.translationEntityPk.idlang=:lang) LEFT JOIN Vin vin ON (org.numeroOrgane=vin.numeroOrgane) LEFT JOIN CodeTypeEntity code_sgr  ON (org.codeSgr=code_sgr.codeTypeEntityPk.idCode AND code_sgr.codeTypeEntityPk.typCode = 'CODE_SGR') WHERE org.typeOrgane||org.numeroOrgane=:bin");
            query.setParameter("bin", bin);
            query.setParameter("lang", lang);
            List<?> lists = (query.getResultList());
            if (!lists.isEmpty()) {
                Iterator<?> itr = lists.iterator();
                while (itr.hasNext()) {
                    Object[] object = (Object[]) (itr.next());
                    GeneralBatteryDataDto generalBatteryData = new GeneralBatteryDataDto();
                    generalBatteryData.setId((Long) object[CommonConstant.OBJECTNUMBER0.getConstValueInt()]);
                    if (object[CommonConstant.OBJECTNUMBER1.getConstValueInt()] != null) {
                        generalBatteryData.setReference(object[CommonConstant.OBJECTNUMBER1.getConstValueInt()].toString());
                    } else {
                        generalBatteryData.setReference("");
                    }
                    if (object[CommonConstant.OBJECTNUMBER2.getConstValueInt()] != null) {
                        generalBatteryData.setDescription2(object[CommonConstant.OBJECTNUMBER2.getConstValueInt()].toString());
                    } else {
                        generalBatteryData.setDescription2("");
                    }
                    if (object[CommonConstant.OBJECTNUMBER3.getConstValueInt()] != null) {
                        generalBatteryData.setVin(object[CommonConstant.OBJECTNUMBER3.getConstValueInt()].toString());
                    } else {
                        generalBatteryData.setVin("");
                    }
                    if (object[CommonConstant.OBJECTNUMBER4.getConstValueInt()] != null
                            && object[CommonConstant.OBJECTNUMBER5.getConstValueInt()] == null) {
                        generalBatteryData.setFactoryCode(object[CommonConstant.OBJECTNUMBER4.getConstValueInt()].toString() + "-");
                    }
                    if (object[CommonConstant.OBJECTNUMBER4.getConstValueInt()] == null
                            && object[CommonConstant.OBJECTNUMBER5.getConstValueInt()] != null) {
                        generalBatteryData.setFactoryCode("-" + object[CommonConstant.OBJECTNUMBER5.getConstValueInt()].toString());
                    }
                    if (object[CommonConstant.OBJECTNUMBER4.getConstValueInt()] != null
                            && object[CommonConstant.OBJECTNUMBER5.getConstValueInt()] != null) {
                        generalBatteryData.setFactoryCode(object[CommonConstant.OBJECTNUMBER4.getConstValueInt()].toString() + "-"
                                + object[CommonConstant.OBJECTNUMBER5.getConstValueInt()].toString());
                    }
                    if (object[CommonConstant.OBJECTNUMBER4.getConstValueInt()] == null
                            && object[CommonConstant.OBJECTNUMBER5.getConstValueInt()] == null) {
                        generalBatteryData.setFactoryCode("");
                    }

                    generalBatteryData.setDateProduction((LocalDateTime) object[CommonConstant.OBJECTNUMBER6.getConstValueInt()]);

                    generalBatteryData.setDateEngagement((LocalDateTime) object[CommonConstant.OBJECTNUMBER7.getConstValueInt()]);
                    if (object[CommonConstant.OBJECTNUMBER8.getConstValueInt()] != null
                            && object[CommonConstant.OBJECTNUMBER9.getConstValueInt()] == null) {
                        generalBatteryData.setStatus(object[CommonConstant.OBJECTNUMBER8.getConstValueInt()].toString() + "-");
                    }
                    if (object[CommonConstant.OBJECTNUMBER8.getConstValueInt()] == null
                            && object[CommonConstant.OBJECTNUMBER9.getConstValueInt()] != null) {
                        generalBatteryData.setStatus("-" + object[CommonConstant.OBJECTNUMBER9.getConstValueInt()].toString());
                    }
                    if (object[CommonConstant.OBJECTNUMBER8.getConstValueInt()] != null
                            && object[CommonConstant.OBJECTNUMBER9.getConstValueInt()] != null) {
                        generalBatteryData.setStatus(object[CommonConstant.OBJECTNUMBER8.getConstValueInt()].toString() + "-"
                                + object[CommonConstant.OBJECTNUMBER9.getConstValueInt()].toString());
                    }
                    if (object[CommonConstant.OBJECTNUMBER8.getConstValueInt()] == null
                            && object[CommonConstant.OBJECTNUMBER9.getConstValueInt()] == null) {
                        generalBatteryData.setStatus("");
                    }

                    if (object[CommonConstant.OBJECTNUMBER10.getConstValueInt()] != null
                            && object[CommonConstant.OBJECTNUMBER11.getConstValueInt()] == null) {
                        generalBatteryData.setCodeSgr(object[CommonConstant.OBJECTNUMBER10.getConstValueInt()].toString() + "-");
                    }
                    if (object[CommonConstant.OBJECTNUMBER10.getConstValueInt()] == null
                            && object[CommonConstant.OBJECTNUMBER11.getConstValueInt()] != null) {
                        generalBatteryData.setCodeSgr("-" + object[CommonConstant.OBJECTNUMBER11.getConstValueInt()].toString());
                    }
                    if (object[CommonConstant.OBJECTNUMBER10.getConstValueInt()] != null
                            && object[CommonConstant.OBJECTNUMBER11.getConstValueInt()] != null) {
                        generalBatteryData.setCodeSgr(object[CommonConstant.OBJECTNUMBER10.getConstValueInt()].toString() + "-"
                                + object[CommonConstant.OBJECTNUMBER11.getConstValueInt()].toString());
                    }
                    if (object[CommonConstant.OBJECTNUMBER10.getConstValueInt()] == null
                            && object[CommonConstant.OBJECTNUMBER11.getConstValueInt()] == null) {
                        generalBatteryData.setCodeSgr("");
                    }

                    if (object[CommonConstant.OBJECTNUMBER12.getConstValueInt()] != null) {
                        generalBatteryData.setShedCode(object[CommonConstant.OBJECTNUMBER12.getConstValueInt()].toString());
                    } else {
                        generalBatteryData.setShedCode("");
                    }
                    generalBatteryData
                            .setUpdateUser(Optional.ofNullable(object[CommonConstant.OBJECTNUMBER13.getConstValueInt()]).orElse("").toString());
                    generalBatteryData.setUpdateDate((Timestamp) object[CommonConstant.OBJECTNUMBER14.getConstValueInt()]);
                    generalBatteryDetailData = new GeneralBatteryDataDto(generalBatteryData);
                    codeLbl = Optional.ofNullable(object[CommonConstant.OBJECTNUMBER5.getConstValueInt()]).orElse("").toString();
                    sgrLbl = Optional.ofNullable(object[CommonConstant.OBJECTNUMBER11.getConstValueInt()]).orElse("").toString();
                    statusLbl = Optional.ofNullable(object[CommonConstant.OBJECTNUMBER9.getConstValueInt()]).orElse("").toString();
                    data.add(generalBatteryData);
                    logger.info("Exiting getGeneralBatteryData after fetching data successfully");
                }

            } else {
                generalBatteryDetailData = new GeneralBatteryDataDto();
            }

            return data;
        } catch (Exception e) {
            logger.error("Exception in fetching GeneralBatteryData get api", e);
            return Collections.emptyList();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryDetailService#getGeneralBatteryHistory(java.lang.String)
     */
    @Override
    public List<GeneralBatteryDataDto> getGeneralBatteryHistory(@Param("bin") String bin) {
        List<GeneralBatteryDataDto> data = new ArrayList<>();
        try {
            logger.info("Entering getGeneralBatteryHistory for bin number {} ", bin);
            Query query = entityManager.createQuery(
                    "select history from HistoryEntity history where history.tableName IN ('NRBQTORG','NRBQTVIN') AND history.typeOrgane ||history.numeroOrgane=:bin order by history.dateUpdate asc");
            query.setParameter("bin", bin);
            List<HistoryEntity> lists = query.getResultList();
            List<HistoryEntity> listHistory;
            Map<Date, List<HistoryEntity>> genBatteryHisData = new LinkedHashMap<>();
            for (HistoryEntity listData : lists) {
                Date date = listData.getDateUpdate();
                String formetupdateDate = formatter.format(date);
                Date updateDate = formatter.parse(formetupdateDate);
                if (genBatteryHisData.containsKey(updateDate)) {
                    listHistory = genBatteryHisData.get(updateDate);
                    listHistory.add(listData);
                    genBatteryHisData.replace(updateDate, listHistory);
                } else {
                    listHistory = new ArrayList<>();
                    listHistory.add(listData);
                    genBatteryHisData.put(updateDate, listHistory);

                }
            }

            for (Map.Entry<Date, List<HistoryEntity>> genBatteryHistMap : genBatteryHisData.entrySet()) {

                logger.info(" getGeneralBatteryHistory key{}", genBatteryHistMap.getKey());
                logger.info(" getGeneralBatteryHistory value{}", genBatteryHistMap.getValue());
                GeneralBatteryDataDto generalBatteryData = new GeneralBatteryDataDto();
                List<HistoryEntity> historyList = new ArrayList<>(genBatteryHistMap.getValue());
                for (HistoryEntity history : historyList) {

                    if ("REFERENCE".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        generalBatteryData.setReference(Optional.ofNullable(history.getNewValue()).orElse(""));
                        generalBatteryDetailData.setReference(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        generalBatteryData.setReference(generalBatteryDetailData.getReference());
                    }

                    if ("DESCRIPTION_2".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        generalBatteryData.setDescription2(Optional.ofNullable(history.getNewValue()).orElse(""));
                        generalBatteryDetailData.setDescription2(Optional.ofNullable(history.getNewValue()).orElse(""));

                    } else {

                        generalBatteryData.setDescription2(generalBatteryDetailData.getDescription2());
                    }

                    if ("VIN".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        generalBatteryData.setVin(Optional.ofNullable(history.getNewValue()).orElse(""));
                        generalBatteryDetailData.setVin(Optional.ofNullable(history.getNewValue()).orElse(""));

                    } else {
                        generalBatteryData.setVin(generalBatteryDetailData.getVin());
                    }

                    generalBatteryData.setUpdateUser(Optional.ofNullable(history.getUserUpdate()).orElse(""));

                    generalBatteryData.setUpdateDate((Timestamp) history.getDateUpdate());
                    if ("CODE_USINE".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        String factoryCode = Optional.ofNullable(history.getNewValue()).orElse("") + "-" + codeLbl;
                        generalBatteryData.setFactoryCode(factoryCode);
                        generalBatteryDetailData.setFactoryCode(factoryCode);

                    } else {
                        generalBatteryData.setFactoryCode(generalBatteryDetailData.getFactoryCode());
                    }

                    if ("DATE_PRODUCTION".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        if (history.getNewValue() != null) {
                            LocalDateTime productionDate = LocalDateTime.parse(history.getNewValue(), dateFormatter);

                            generalBatteryData.setDateProduction(productionDate);
                            generalBatteryDetailData.setDateProduction(productionDate);
                        } else {
                            generalBatteryData.setDateProduction(null);
                            generalBatteryDetailData.setDateProduction(null);
                        }
                    } else {
                        generalBatteryData.setDateProduction(generalBatteryDetailData.getDateProduction());
                    }

                    if ("DATE_ENGAGEMENT".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        if (history.getNewValue() != null) {
                            LocalDateTime engagementDate = LocalDateTime.parse(history.getNewValue(), dateFormatter);

                            generalBatteryData.setDateEngagement(engagementDate);
                            generalBatteryDetailData.setDateEngagement(engagementDate);
                        } else {
                            generalBatteryData.setDateEngagement(null);
                            generalBatteryDetailData.setDateEngagement(null);
                        }
                    } else {
                        generalBatteryData.setDateEngagement(generalBatteryDetailData.getDateEngagement());
                    }

                    if ("STATUS".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        String status = Optional.ofNullable(history.getNewValue()).orElse("") + "-" + statusLbl;
                        generalBatteryData.setStatus(status);
                        generalBatteryDetailData.setStatus(status);
                    } else {
                        generalBatteryData.setStatus(generalBatteryDetailData.getStatus());
                    }

                    if ("CODE_SGR".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        String codesgr = Optional.ofNullable(history.getNewValue()).orElse("") + "-" + sgrLbl;
                        generalBatteryData.setCodeSgr(codesgr);
                        generalBatteryDetailData.setCodeSgr(codesgr);

                    } else {
                        generalBatteryData.setCodeSgr(generalBatteryDetailData.getCodeSgr());
                    }
                    if ("CODE_ATELIER".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        generalBatteryData.setShedCode(Optional.ofNullable(history.getNewValue()).orElse(""));
                        generalBatteryDetailData.setShedCode(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        generalBatteryData.setShedCode(generalBatteryDetailData.getShedCode());
                    }
                }
                data.add(generalBatteryData);
                logger.info("Exiting getGeneralBatteryHistoryData after fetching data successfully");
            }

        } catch (Exception e) {
            logger.error("Exception in fetching getGeneralBatteryHistory get api", e);
        }

        Collections.reverse(data);
        return data;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryDetailService#getElectronicBatteryData(java.lang.String)
     */
    @Override
    public List<ElectronicBatteryDataDto> getElectronicBatteryData(String bin) {

        try {
            logger.info("Entering getElectronicBatteryData for bin number {} ", bin);
            List<ElectronicBatteryDataDto> data = new ArrayList<>();
            electronicBatteryDetailData = null;
            Query query = entityManager.createQuery(
                    "SELECT bmu.serialNumber, bmu.refSoft, bmu.refHard, bmu.dateProduction, bmu.suppliercode, bmu.refCal, bmu.userMaj, bmu.dateMaj from BmuEntity bmu where bmu.typeOrgane || bmu.numeroOrgane= :bin");
            query.setParameter("bin", bin);
            List<?> lists = (query.getResultList());
            if (!lists.isEmpty()) {
                Iterator<?> itr = lists.iterator();
                while (itr.hasNext()) {
                    Object[] obj = (Object[]) (itr.next());
                    ElectronicBatteryDataDto electronicBatteryDto = new ElectronicBatteryDataDto();
                    electronicBatteryDto
                            .setSerialNumber(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString());
                    electronicBatteryDto.setRefSoft(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
                    electronicBatteryDto.setRefHard(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString());
                    electronicBatteryDto.setDateProduction((LocalDateTime) obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]);
                    electronicBatteryDto
                            .setSuppliercode(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString());
                    electronicBatteryDto.setRefCal(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()]).orElse("").toString());
                    electronicBatteryDto
                            .setUserUpdate(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()]).orElse("").toString());
                    electronicBatteryDto.setDateUpdate((Date) obj[CommonConstant.OBJECTNUMBER7.getConstValueInt()]);
                    electronicBatteryDetailData = new ElectronicBatteryDataDto(electronicBatteryDto);
                    data.add(electronicBatteryDto);
                    logger.info("Exiting getElectronicBatteryData after fetching data successfully");
                }
            } else {
                electronicBatteryDetailData = new ElectronicBatteryDataDto();
            }
            return data;
        } catch (Exception e) {

            logger.error("Exception in fetching getElectronicBatteryData get api", e);
            return Collections.emptyList();
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryDetailService#getElectronicBatteryHistoryData(java.lang.String)
     */
    @Override
    public List<ElectronicBatteryDataDto> getElectronicBatteryHistoryData(String bin) {
        List<ElectronicBatteryDataDto> data = new ArrayList<>();
        try {
            logger.info("Entering getElectronicBatteryHistoryData for bin number {} ", bin);
            Query query = entityManager.createQuery(
                    "select history from HistoryEntity history where history.tableName= 'NRBQTBMU' AND history.typeOrgane || history.numeroOrgane=:bin order by history.dateUpdate asc");
            query.setParameter("bin", bin);
            List<HistoryEntity> lists = query.getResultList();
            List<HistoryEntity> listHistory;

            Map<Date, List<HistoryEntity>> electronicBatteryHisData = new LinkedHashMap<>();
            for (HistoryEntity listData : lists) {
                Date date = listData.getDateUpdate();

                String formetupdateDate = formatter.format(date);

                Date updateDate = formatter.parse(formetupdateDate);

                if (electronicBatteryHisData.containsKey(updateDate)) {
                    listHistory = electronicBatteryHisData.get(updateDate);
                    listHistory.add(listData);
                    electronicBatteryHisData.replace(updateDate, listHistory);
                } else {
                    listHistory = new ArrayList<>();
                    listHistory.add(listData);
                    electronicBatteryHisData.put(updateDate, listHistory);

                }
            }

            for (Map.Entry<Date, List<HistoryEntity>> electronicBatteryHistMap : electronicBatteryHisData.entrySet()) {

                logger.info("electronic battery map key{}", electronicBatteryHistMap.getKey());
                logger.info("electronic battery map value{}", electronicBatteryHistMap.getValue());
                ElectronicBatteryDataDto electronicBatteryDataDto = new ElectronicBatteryDataDto();
                List<HistoryEntity> historyList = new ArrayList<>(electronicBatteryHistMap.getValue());
                for (HistoryEntity history : historyList) {

                    if ("REF_HARD".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        electronicBatteryDataDto.setRefHard(Optional.ofNullable(history.getNewValue()).orElse(""));
                        electronicBatteryDetailData.setRefHard(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        electronicBatteryDataDto.setRefHard(electronicBatteryDetailData.getRefHard());
                    }

                    if ("REF_SOFT".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        electronicBatteryDataDto.setRefSoft(Optional.ofNullable(history.getNewValue()).orElse(""));
                        electronicBatteryDetailData.setRefSoft(Optional.ofNullable(history.getNewValue()).orElse(""));

                    } else {
                        electronicBatteryDataDto.setRefSoft(electronicBatteryDetailData.getRefSoft());
                    }

                    if ("SERIAL_NUMBER".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        electronicBatteryDataDto.setSerialNumber(Optional.ofNullable(history.getNewValue()).orElse(""));
                        electronicBatteryDetailData.setSerialNumber(Optional.ofNullable(history.getNewValue()).orElse(""));

                    } else {
                        electronicBatteryDataDto.setSerialNumber(electronicBatteryDetailData.getSerialNumber());
                    }

                    if ("DATE_PRODUCTION".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        if (history.getNewValue() != null) {
                            LocalDateTime productionDate = LocalDateTime.parse(history.getNewValue(), dateFormatter);
                            electronicBatteryDataDto.setDateProduction(productionDate);
                            electronicBatteryDetailData.setDateProduction(productionDate);
                        } else {
                            electronicBatteryDataDto.setDateProduction(null);
                            electronicBatteryDetailData.setDateProduction(null);
                        }
                    } else {
                        electronicBatteryDataDto.setDateProduction(electronicBatteryDetailData.getDateProduction());
                    }

                    if ("SUPPLIER_CODE".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        electronicBatteryDataDto.setSuppliercode(Optional.ofNullable(history.getNewValue()).orElse(""));
                        electronicBatteryDetailData.setSuppliercode(Optional.ofNullable(history.getNewValue()).orElse(""));

                    } else {
                        electronicBatteryDataDto.setSuppliercode(electronicBatteryDetailData.getSuppliercode());
                    }

                    if ("REF_CAL".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        electronicBatteryDataDto.setRefCal(Optional.ofNullable(history.getNewValue()).orElse(""));
                        electronicBatteryDetailData.setRefCal(Optional.ofNullable(history.getNewValue()).orElse(""));

                    } else {
                        electronicBatteryDataDto.setRefCal(electronicBatteryDetailData.getRefCal());
                    }

                    electronicBatteryDataDto.setDateUpdate(history.getDateUpdate());
                    electronicBatteryDataDto.setUserUpdate(Optional.ofNullable(history.getUserUpdate()).orElse(""));

                }

                data.add(electronicBatteryDataDto);
                logger.info("Exiting getElectronicBatteryHistoryData after fetching data successfully");

            }

        } catch (Exception e) {

            logger.error("Exception in fetching getElectronicBatteryHistoryData get api", e);
            return Collections.emptyList();
        }
        Collections.reverse(data);
        return data;

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryDetailService#getBatteryHealthData(java.lang.String)
     */
    @Override
    public List<BatteryHealthDataDto> getBatteryHealthData(String bin) {

        List<BatteryHealthDataDto> data = new ArrayList<>();
        batteryHealthDetailData = null;
        try {
            logger.info("Entering getBatteryHealthData for bin number {} ", bin);
            Query query = entityManager.createQuery(
                    "SELECT soc, soh, rinsulation, rinternal , mic , mac, t10, tat,userMaj, dateMaj from HdataEntity where typeOrgane || numeroOrgane =:bin");
            query.setParameter("bin", bin);
            List<?> lists = (query.getResultList());
            if (!lists.isEmpty()) {
                Iterator<?> itr = lists.iterator();
                while (itr.hasNext()) {
                    Object[] obj = (Object[]) (itr.next());
                    BatteryHealthDataDto batteryHealthDataDto = new BatteryHealthDataDto();
                    batteryHealthDataDto.setSoc(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString());
                    batteryHealthDataDto.setSoh(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
                    batteryHealthDataDto
                            .setRinsulation(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString());
                    batteryHealthDataDto
                            .setRinternal(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse("").toString());
                    batteryHealthDataDto.setMic(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString());
                    batteryHealthDataDto.setMac(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()]).orElse("").toString());
                    batteryHealthDataDto.setT10(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()]).orElse("").toString());
                    batteryHealthDataDto.setTat(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER7.getConstValueInt()]).orElse("").toString());
                    batteryHealthDataDto
                            .setUserUpdate(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER8.getConstValueInt()]).orElse("").toString());
                    batteryHealthDataDto.setDateUpdate((Date) obj[CommonConstant.OBJECTNUMBER9.getConstValueInt()]);
                    batteryHealthDetailData = new BatteryHealthDataDto(batteryHealthDataDto);
                    data.add(batteryHealthDataDto);
                    logger.info("Exiting getBatteryHealthData after fetching data successfully");
                }
            } else {
                batteryHealthDetailData = new BatteryHealthDataDto();
            }

        } catch (Exception e) {

            logger.error("Exception in fetching getBatteryHealthData get api", e);

        }
        return data;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryDetailService#getBatteryHealthHistoryData(java.lang.String)
     */
    @Override
    public List<BatteryHealthDataDto> getBatteryHealthHistoryData(String bin) {

        List<BatteryHealthDataDto> data = new ArrayList<>();
        try {
            logger.info("Entering getBatteryHealthHistoryData for bin number {} ", bin);
            Query query = entityManager.createQuery(
                    "select history from HistoryEntity history where history.tableName= 'NRBQTHDATA' AND history.typeOrgane || history.numeroOrgane=:bin order by history.dateUpdate asc");
            query.setParameter("bin", bin);
            List<HistoryEntity> lists = query.getResultList();
            List<HistoryEntity> listHistory;

            Map<Date, List<HistoryEntity>> batteryHealthHisData = new LinkedHashMap<>();
            for (HistoryEntity listData : lists) {
                Date date = listData.getDateUpdate();

                String formetupdateDate = formatter.format(date);

                Date updateDate = formatter.parse(formetupdateDate);

                if (batteryHealthHisData.containsKey(updateDate)) {
                    listHistory = batteryHealthHisData.get(updateDate);
                    listHistory.add(listData);
                    batteryHealthHisData.replace(updateDate, listHistory);
                } else {
                    listHistory = new ArrayList<>();
                    listHistory.add(listData);
                    batteryHealthHisData.put(updateDate, listHistory);

                }
            }
            for (Map.Entry<Date, List<HistoryEntity>> batteryHealthHistoryMap : batteryHealthHisData.entrySet()) {

                logger.info(" battery health map key{}", batteryHealthHistoryMap.getKey());
                logger.info("battery health map value{}", batteryHealthHistoryMap.getValue());
                BatteryHealthDataDto batteryHealthDataDto = new BatteryHealthDataDto();
                List<HistoryEntity> historyList = new ArrayList<>(batteryHealthHistoryMap.getValue());
                for (HistoryEntity history : historyList) {

                    if ("SOC".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        batteryHealthDataDto.setSoc(Optional.ofNullable(history.getNewValue()).orElse(""));
                        batteryHealthDetailData.setSoc(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {

                        batteryHealthDataDto.setSoc(batteryHealthDetailData.getSoc());
                    }

                    if ("SOH".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        batteryHealthDataDto.setSoh(Optional.ofNullable(history.getNewValue()).orElse(""));
                        batteryHealthDetailData.setSoh(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        batteryHealthDataDto.setSoh(batteryHealthDetailData.getSoh());
                    }

                    if ("RINSULATION".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        batteryHealthDataDto.setRinsulation(Optional.ofNullable(history.getNewValue()).orElse(""));
                        batteryHealthDetailData.setRinsulation(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        batteryHealthDataDto.setRinsulation(batteryHealthDetailData.getRinsulation());
                    }

                    if ("RINTERNAL".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        batteryHealthDataDto.setRinternal(Optional.ofNullable(history.getNewValue()).orElse(""));
                        batteryHealthDetailData.setRinternal(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        batteryHealthDataDto.setRinternal(batteryHealthDetailData.getRinternal());
                    }

                    batteryHealthDataDto.setDateUpdate(history.getDateUpdate());
                    batteryHealthDataDto.setUserUpdate(history.getUserUpdate());

                    if ("MIC".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        batteryHealthDataDto.setMic(Optional.ofNullable(history.getNewValue()).orElse(""));
                        batteryHealthDetailData.setMic(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        batteryHealthDataDto.setMic(batteryHealthDetailData.getMic());
                    }

                    if ("MAC".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        batteryHealthDataDto.setMac(Optional.ofNullable(history.getNewValue()).orElse(""));
                        batteryHealthDetailData.setMac(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        batteryHealthDataDto.setMac(batteryHealthDetailData.getMac());
                    }

                    if ("T10".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        batteryHealthDataDto.setT10(Optional.ofNullable(history.getNewValue()).orElse(""));
                        batteryHealthDetailData.setT10(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        batteryHealthDataDto.setT10(batteryHealthDetailData.getT10());
                    }

                    if ("TAT".equals(Optional.ofNullable(history.getUpdatedColumn()).orElse(""))) {
                        batteryHealthDataDto.setTat(Optional.ofNullable(history.getNewValue()).orElse(""));
                        batteryHealthDetailData.setTat(Optional.ofNullable(history.getNewValue()).orElse(""));
                    } else {
                        batteryHealthDataDto.setTat(batteryHealthDetailData.getTat());
                    }

                }
                data.add(batteryHealthDataDto);
                logger.info("Exiting getBatteryHealthHistoryData after fetching data successfully");
            }
        } catch (Exception e) {
            logger.error("Exception in fetching getBatteryHealthHistoryData get api", e);
        }

        Collections.reverse(data);
        return data;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryDetailService#getBatteryModuleAndAssemblyData(java.lang.String)
     */
    @Override
    public List<ModuleAndSubassemblyDto> getBatteryModuleAndAssemblyData(String bin, String[] componentType) {
        List<ModuleAndSubassemblyDto> data = new ArrayList<>();

        List<String> module = new ArrayList<>();
        totalRecords = 0;
        categoryModule.clear();
        categorySubAssembly.clear();
        String moduleData = "";
        String medalModuleData = "";
        try {
            logger.info("Entering getBatteryModuleAndAssemblyData for bin number {} ", bin);
            Query query = entityManager.createQuery(
                    "SELECT m.typeModule || m.numeroModule AS Module, m.dateCreation FROM Module m where m.typeModule || m.numeroModule NOT IN (SELECT o.typeOrgane || o.numeroOrgane from OrganeEntity o) AND m.typeOrgane || m.numeroOrgane =:bin ORDER BY m.typeModule || m.numeroModule");
            query.setParameter("bin", bin);
            List<?> lists = (query.getResultList());
            logger.info("module list{}", lists);
            if (!lists.isEmpty()) {
                ModuleAndSubassemblyDto moduleAndSubassemblyDto = new ModuleAndSubassemblyDto();
                Iterator<?> itr = lists.iterator();
                while (itr.hasNext()) {
                    Object[] obj = (Object[]) (itr.next());
                    module.add(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()].toString() + "\n");
                    categoryModule.add(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()].toString());
                    totalRecords = totalRecords + 1;

                }
                moduleData = module.toString();
                moduleData = moduleData.replace(",", "");
                moduleData = moduleData.replace("[", "");
                moduleData = moduleData.replace("]", "");
                moduleAndSubassemblyDto.setComponentType(componentType[CommonConstant.OBJECTNUMBER0.getConstValueInt()]);
                moduleAndSubassemblyDto.setModuleMedal(moduleData);
                data.add(moduleAndSubassemblyDto);
            }

            Query query2 = entityManager.createQuery(
                    "SELECT o.id, m.typeModule || m.numeroModule as MODULE, o.reference, o.dateProduction, o.dateEngagement, o.codeUsing, code_usine.lblCode AS LBL_USINE, m.dateCreation FROM Module m , OrganeEntity o LEFT JOIN CodeTypeEntity code_usine ON (o.codeUsing = code_usine.codeTypeEntityPk.idCode AND code_usine.codeTypeEntityPk.typCode ='CODE_USINE') WHERE m.typeModule = o.typeOrgane AND m.numeroModule = o.numeroOrgane AND m.typeOrgane || m.numeroOrgane = :bin order by m.typeModule || m.numeroModule ");
            query2.setParameter("bin", bin);
            List<?> lists2 = (query2.getResultList());
            logger.info("sub Assembly  list{}", lists2);
            if (!lists2.isEmpty()) {
                Iterator<?> itr = lists2.iterator();
                while (itr.hasNext()) {
                    Object[] obj = (Object[]) (itr.next());
                    List<String> moduleMedal = new ArrayList<>();
                    ModuleAndSubassemblyDto moduleAndSubassemblyDto = new ModuleAndSubassemblyDto();
                    moduleAndSubassemblyDto.setComponentType(componentType[CommonConstant.OBJECTNUMBER1.getConstValueInt()]);
                    moduleAndSubassemblyDto
                            .setSubMedal(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
                    moduleAndSubassemblyDto
                            .setReference(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString());
                    moduleAndSubassemblyDto
                            .setProductionDate((LocalDateTime) Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse(""));
                    moduleAndSubassemblyDto
                            .setDateEngagement((LocalDateTime) Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse(""));
                    categorySubAssembly.add(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
                    if (obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()] != null
                            && obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()] == null) {
                        moduleAndSubassemblyDto.setFactoryCode(obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()].toString() + "-");
                    }
                    if (obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()] == null
                            && obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()] != null) {
                        moduleAndSubassemblyDto.setFactoryCode("-" + obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()].toString());
                    }
                    if (obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()] != null
                            && obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()] != null) {
                        moduleAndSubassemblyDto.setFactoryCode(obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()].toString() + "-"
                                + obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()].toString());
                    }
                    if (obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()] == null
                            && obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()] == null) {
                        moduleAndSubassemblyDto.setFactoryCode("");
                    }

                    Query query3 = entityManager.createQuery(
                            "SELECT typeOrgane || numeroOrgane AS ORGANE, typeModule || numeroModule AS MODULE, dateCreation FROM Module  WHERE typeOrgane || numeroOrgane IN (SELECT m.typeModule || m.numeroModule FROM OrganeEntity o , Module m WHERE m.typeModule= o.typeOrgane AND m.numeroModule= o.numeroOrgane AND m.typeOrgane || m.numeroOrgane= :bin)  ORDER BY typeOrgane || numeroOrgane , typeModule || numeroModule");
                    query3.setParameter("bin", bin);
                    List<?> lists3 = (query3.getResultList());
                    logger.info("module of sub Assembly  list{}", lists3);
                    if (!lists3.isEmpty()) {
                        Iterator<?> itr3 = lists3.iterator();
                        while (itr3.hasNext()) {
                            Object[] obj3 = (Object[]) (itr3.next());

                            if (Objects.equals(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString(),
                                    Optional.ofNullable(obj3[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString())) {
                                moduleMedal.add(obj3[CommonConstant.OBJECTNUMBER1.getConstValueInt()].toString() + "\n");

                                totalRecords = totalRecords + 1;
                            }
                        }

                        medalModuleData = moduleMedal.toString();
                        medalModuleData = medalModuleData.replace(",", "");
                        medalModuleData = medalModuleData.replace("[", "");
                        medalModuleData = medalModuleData.replace("]", "");
                    }
                    moduleAndSubassemblyDto.setModuleMedal(medalModuleData);
                    data.add(moduleAndSubassemblyDto);
                    logger.info("Exiting getBatteryModuleAndAssemblyData after fetching data successfully");
                }
            }
            Query query4 = entityManager.createQuery("SELECT MAX(dateUpdate) as latestDate FROM ModuleHistory "
                    + "where typeOrgane || numeroOrgane=:bin or typeOrgane || numeroOrgane "
                    + "IN ( SELECT m.typeModule || m.numeroModule FROM Module m, OrganeEntity o"
                    + " where m.typeModule = o.typeOrgane and m.numeroModule= o.numeroOrgane and m.typeOrgane || m.numeroOrgane =:bin) order by dateUpdate desc");
            query4.setParameter("bin", bin);

            Date updateDate = (Date) query4.getSingleResult();
            for (int i = 0; i < data.size(); i++) {
                data.get(i).setUpdateDate(updateDate);

            }

        } catch (Exception e) {
            logger.error("Exception in fetching getBatteryModuleAndAssemblyData get api", e);
        }
        return data;

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryDetailService#findTotalRecords()
     */
    @Override
    public long findTotalRecords() {
        logger.info("total records of module{}", totalRecords);
        return totalRecords;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryDetailService#getBatteryModuleHistoryData(java.lang.String)
     */
    @Override
    public List<BatteryModuleHistoryDto> getBatteryModuleHistoryData(String bin, String[] componentType) {

        List<BatteryModuleHistoryDto> data = new ArrayList<>();
        try {
            logger.info("Entering getBatteryModuleHistoryData for bin number {} ", bin);
            Query query = entityManager
                    .createQuery("SELECT typeUpdate, typeOrgane, numeroOrgane, typeModule, numeroModule, dateUpdate, userUpdate FROM ModuleHistory "
                            + "where typeOrgane || numeroOrgane=:bin or typeOrgane || numeroOrgane "
                            + "IN ( SELECT m.typeModule || m.numeroModule FROM Module m, OrganeEntity o"
                            + " where m.typeModule = o.typeOrgane and m.numeroModule= o.numeroOrgane and m.typeOrgane || m.numeroOrgane =:bin) order by dateUpdate desc");
            query.setParameter("bin", bin);
            List<?> lists = (query.getResultList());

            if (!lists.isEmpty()) {
                Iterator<?> itr = lists.iterator();
                while (itr.hasNext()) {
                    Object[] obj = (Object[]) (itr.next());
                    BatteryModuleHistoryDto batteryModuleHistoryDto = new BatteryModuleHistoryDto();
                    batteryModuleHistoryDto.setActionType(
                            Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString().substring(0, 1));
                    if (categorySubAssembly.contains(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse("").toString()
                            .concat(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString()))) {
                        batteryModuleHistoryDto.setCategory(componentType[CommonConstant.OBJECTNUMBER1.getConstValueInt()]);
                    }

                    else if (categoryModule.contains(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse("").toString()
                            .concat(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString()))) {
                        batteryModuleHistoryDto.setCategory(componentType[CommonConstant.OBJECTNUMBER0.getConstValueInt()]);
                    } else {
                        batteryModuleHistoryDto.setCategory(componentType[CommonConstant.OBJECTNUMBER2.getConstValueInt()]);

                    }
                    if ("C".equals(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString().substring(0, 1))) {
                        batteryModuleHistoryDto.setOldValue("");
                        batteryModuleHistoryDto.setNewValue(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse("")
                                .toString().concat(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString()));
                    }
                    if ("D".equals(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString().substring(0, 1))) {
                        batteryModuleHistoryDto.setOldValue(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse("")
                                .toString().concat(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString()));
                        batteryModuleHistoryDto.setNewValue("");
                    }
                    batteryModuleHistoryDto
                            .setUpdateDate((Date) Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()]).orElse(""));
                    batteryModuleHistoryDto
                            .setUpdateUser(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()]).orElse("").toString());
                    if (!Objects.equals(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString()
                            .concat(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString()), bin)) {
                        batteryModuleHistoryDto.setSubAssemblyId(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("")
                                .toString().concat(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString()));
                    }

                    data.add(batteryModuleHistoryDto);
                    logger.info("Exiting getBatteryModuleHistoryData after fetching data successfully");

                }
            }

        } catch (Exception e) {
            logger.error("Exception in fetching getBatteryModuleHistoryData get api", e);
        }

        return data;
    }

}
