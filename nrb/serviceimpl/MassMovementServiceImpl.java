/*
 * Creation : 21 Dec 2021
 */
package com.inetpsa.nrb.serviceimpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetpsa.nrb.constant.CommonConstant;
import com.inetpsa.nrb.constant.QueryConstant;
import com.inetpsa.nrb.dto.HealthDataDto;
import com.inetpsa.nrb.dto.MassMvtFileDto;
import com.inetpsa.nrb.dto.MassMvtLineDto;
import com.inetpsa.nrb.dto.MassMvtSetDto;
import com.inetpsa.nrb.dto.MassMvtValidationDto;
import com.inetpsa.nrb.model.MassMvtFile;
import com.inetpsa.nrb.model.MassMvtLine;
import com.inetpsa.nrb.model.MassMvtSet;
import com.inetpsa.nrb.repository.BmuRepository;
import com.inetpsa.nrb.repository.MMFileRepository;
import com.inetpsa.nrb.repository.MMLineRepository;
import com.inetpsa.nrb.repository.MMSetRepository;
import com.inetpsa.nrb.service.MassMovementService;

/**
 * The Class MassMovementServiceImpl.
 */
@Service
@Transactional
public class MassMovementServiceImpl implements MassMovementService {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(MassMovementServiceImpl.class);

    /** The mm set repository. */
    @Autowired
    private MMSetRepository mmSetRepository;

    /** The line repository. */
    @Autowired
    private MMLineRepository lineRepository;

    /** The entity manager. */
    @PersistenceContext
    private EntityManager entityManager;

    /** The em 1. */
    @Autowired
    private EntityManager em1;

    /** The mm file repository. */
    @Autowired
    private MMFileRepository mmFileRepository;

    /** The bmu repository. */
    @Autowired
    private BmuRepository bmuRepository;

    /** The mm mvt file data. */
    private List<MassMvtFile> mmMvtFileData;

    /** The table map. */
    Map<String, Integer> tableMap;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getSettingbyId(java.lang.String)
     */
    @Override
    public MassMvtSetDto getSettingbyId(String id) {
        try {
            MassMvtSetDto dto = new MassMvtSetDto();
            Optional<MassMvtSet> mmSet = mmSetRepository.findById(id);
            if (mmSet.isPresent()) {
                MassMvtSet massMvtSet = mmSet.get();

                dto.convertToDto(massMvtSet);
            }
            return dto;
        } catch (Exception e) {
            logger.error("Exception in fetching getSettingbyId {}", e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getAllSetting()
     */
    @Override
    public List<MassMvtSetDto> getAllSetting() {
        try {
            List<MassMvtSetDto> list = new ArrayList<>();
            List<MassMvtSet> mmSet = mmSetRepository.findAll();
            for (MassMvtSet massMvtSet : mmSet) {
                MassMvtSetDto dto = new MassMvtSetDto();
                list.add(dto.convertToDto(massMvtSet));

            }

            return list;
        } catch (Exception e) {
            logger.error("Exception in fetching getAllSetting {}", e);
        }
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#addUpdateMMFile(com.inetpsa.nrb.model.MassMvtFile)
     */
    @Override
    public MassMvtFile addUpdateMMFile(MassMvtFile dto) {
        try {

            MassMvtFile file = mmFileRepository.save(dto);
            if (file.getIdFile() != null) {
                return file;
            }

        } catch (

        Exception e) {
            logger.error(CommonConstant.EXCEPTION_ADDUPDATE_MMFILE.getConstValue(), e);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#addUpdateMMLine(java.util.List)
     */
    @Override
    public void addUpdateMMLine(List<MassMvtLine> mmLine) {
        try {

            lineRepository.saveAll(mmLine);

        } catch (Exception e) {
            logger.error(CommonConstant.EXCEPTION_ADDUPDATE_MMFILE.getConstValue(), e);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getMMLineList()
     */
    @Override
    public List<MassMvtLineDto> getMMLineList(Long fileId) {
        List<MassMvtLineDto> data = new ArrayList<>();
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT line.ACTION_TYPE, line.ID_DATA, line.TYPE_DATA, line.DATA_VALUE, data.DATA_GROUP, data.FIELD, data.FORMAT, data.SETTINGS, data.NB_CHAR, line.ID_FILE, line.ID_LINE FROM NRBQTMMLINE line JOIN NRBQTMMTDATA data ON line.TYPE_DATA = data.TYPE_DATA WHERE line.ID_FILE =:idFile ORDER BY line.ID_DATA, data.DATA_GROUP,line.ID_LINE");
            query.setParameter("idFile", fileId);
            List list = (query.getResultList());

            Iterator itr = list.iterator();
            while (itr.hasNext()) {
                MassMvtLineDto lineDto = new MassMvtLineDto();
                Object[] obj = (Object[]) (itr.next());
                lineDto.setActionType(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString());
                lineDto.setIdData(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
                lineDto.setTypeData(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString());
                lineDto.setDataValue(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse("").toString());
                lineDto.setDataGroup(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString());
                lineDto.setField(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()]).orElse("").toString());
                lineDto.setFormat(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()]).orElse("").toString());
                lineDto.setSettings(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER7.getConstValueInt()]).orElse("").toString());
                lineDto.setNbChar(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER8.getConstValueInt()]).orElse("").toString());
                lineDto.setIdFile(new Long(obj[CommonConstant.OBJECTNUMBER9.getConstValueInt()].toString()));
                lineDto.setIdLine(new Long(obj[CommonConstant.OBJECTNUMBER10.getConstValueInt()].toString()));
                data.add(lineDto);
            }
            logger.info(CommonConstant.DATA.getConstValue(), data);
            return data;
        } catch (Exception e) {
            logger.error(CommonConstant.EXCEPTION_ADDUPDATE_MMFILE.getConstValue(), e);
            return Collections.emptyList();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getValidatedMMLineList()
     */
    @Override
    public List<MassMvtLineDto> getValidatedMMLineList() {
        List<MassMvtLineDto> data = new ArrayList<>();
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT line.ACTION_TYPE, line.ID_DATA, line.TYPE_DATA, line.DATA_VALUE, data.DATA_GROUP FROM NRBQTMMLINE line JOIN NRBQTMMTDATA data ON line.TYPE_DATA = data.TYPE_DATA WHERE line.CR_ID_TRANSLATION IS NULL OR line.CR_ID_TRANSLATION LIKE :idTra ORDER BY line.ID_DATA, data.DATA_GROUP, line.ID_LINE");
            query.setParameter("idTra", "WAR2-%");
            List list = (query.getResultList());

            Iterator itr = list.iterator();
            while (itr.hasNext()) {
                MassMvtLineDto lineDto = new MassMvtLineDto();
                Object[] obj = (Object[]) (itr.next());
                lineDto.setActionType(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString());
                lineDto.setIdData(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
                lineDto.setTypeData(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString());
                lineDto.setDataValue(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse("").toString());
                lineDto.setDataGroup(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString());

                data.add(lineDto);
            }
            logger.info(CommonConstant.DATA.getConstValue(), data);
            return data;
        } catch (Exception e) {

            logger.error(CommonConstant.EXCEPTION_ADDUPDATE_MMFILE.getConstValue(), e);
            return Collections.emptyList();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getMassMovementFileData()
     */
    @Override
    public List<MassMvtFileDto> getMassMovementFileData(String lang) {
        List<MassMvtFileDto> massMvtFileResultData = new ArrayList<>();
        mmMvtFileData = new ArrayList<>();
        try {
            Query query = entityManager.createNativeQuery(QueryConstant.QUERY_SELECT_MMFILE_DATA.getQuery());
            query.setParameter(1, lang);
            List<Object[]> massMvtFileModel = query.getResultList();
            massMvtFileModel.forEach(object -> {
                MassMvtFile entity = new MassMvtFile();
                entity.setIdFile(object[CommonConstant.OBJECTNUMBER0.getConstValueInt()] != null
                        ? Long.valueOf(object[CommonConstant.OBJECTNUMBER0.getConstValueInt()].toString())
                        : 0);
                entity.setFileName(object[CommonConstant.OBJECTNUMBER1.getConstValueInt()] != null
                        ? object[CommonConstant.OBJECTNUMBER1.getConstValueInt()].toString()
                        : "");
                entity.setDateCreation(object[CommonConstant.OBJECTNUMBER2.getConstValueInt()] != null
                        ? (java.util.Date) object[CommonConstant.OBJECTNUMBER2.getConstValueInt()]
                        : null);
                entity.setDateStart(object[CommonConstant.OBJECTNUMBER3.getConstValueInt()] != null
                        ? (java.util.Date) object[CommonConstant.OBJECTNUMBER3.getConstValueInt()]
                        : null);
                entity.setDateEnd(object[CommonConstant.OBJECTNUMBER4.getConstValueInt()] != null
                        ? (java.util.Date) object[CommonConstant.OBJECTNUMBER4.getConstValueInt()]
                        : null);
                entity.setNumberOk(object[CommonConstant.OBJECTNUMBER5.getConstValueInt()] != null
                        ? Integer.valueOf(object[CommonConstant.OBJECTNUMBER5.getConstValueInt()].toString())
                        : 0);
                entity.setNumberKo(object[CommonConstant.OBJECTNUMBER6.getConstValueInt()] != null
                        ? Integer.valueOf(object[CommonConstant.OBJECTNUMBER6.getConstValueInt()].toString())
                        : 0);
                entity.setUserFile(object[CommonConstant.OBJECTNUMBER7.getConstValueInt()] != null
                        ? object[CommonConstant.OBJECTNUMBER7.getConstValueInt()].toString()
                        : "");
                entity.setTranslationStatus(object[CommonConstant.OBJECTNUMBER8.getConstValueInt()] != null
                        ? object[CommonConstant.OBJECTNUMBER8.getConstValueInt()].toString()
                        : "");
                mmMvtFileData.add(entity);
            });

            massMvtFileResultData = mmMvtFileData.stream().map(MassMvtFileDto::new).collect(Collectors.toList());

        } catch (Exception e) {
            logger.error("Exception at getMassMovementFileData method {}", e.getMessage());
            return Collections.emptyList();
        }
        return massMvtFileResultData;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getBatteryCharList(java.lang.String)
     */
    @Override
    public MassMvtValidationDto getBatteryCharList(String idData) {

        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT TYPE_ORGANE || NUMERO_ORGANE AS organe, reference, status FROM  NRBQTORG WHERE CURRENT_VALUE='Y' AND TYPE_ORGANE || NUMERO_ORGANE =:idData");
            query.setParameter(CommonConstant.IDDATA.getConstValue(), idData);
            Object[] obj = (Object[]) query.getSingleResult();

            MassMvtValidationDto dto = new MassMvtValidationDto();
            dto.setOrgane(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString());
            dto.setReference(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
            dto.setStatus(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString());
            return dto;
        } catch (NoResultException e) {

            logger.error(CommonConstant.NO_RESULT_FOUND.getConstValue());
            return new MassMvtValidationDto();
        } catch (Exception e) {

            logger.error("Exception in  getBatteryCharList {}", e);
            return null;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getBatteryVehicle(java.lang.String)
     */
    @Override
    public MassMvtValidationDto getBatteryVehicle(String idData) {

        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT TYPE_ORGANE || NUMERO_ORGANE AS organe, vin FROM NRBQTVIN WHERE TYPE_ORGANE || NUMERO_ORGANE =:idData");
            query.setParameter(CommonConstant.IDDATA.getConstValue(), idData);
            Object[] obj = (Object[]) query.getSingleResult();

            MassMvtValidationDto dto = new MassMvtValidationDto();
            dto.setOrgane(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString());
            dto.setVin(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
            return dto;
        } catch (NoResultException e) {

            logger.error(CommonConstant.NO_RESULT_FOUND.getConstValue());
            return new MassMvtValidationDto();
        } catch (Exception e) {

            logger.error("Exception in  getBatteryVehicle {}", e);
            return null;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#updateMMLineStatus(java.lang.String)
     */
    @Override
    public int updateMMLineStatus(String status) {

        try {
            Query query = entityManager.createQuery("update MassMvtLine set translationStatus =:status where translationStatus is null");
            query.setParameter("status", status);
            int rows = query.executeUpdate();

            return rows;
        } catch (Exception e) {

            logger.error("Exception in  getBatteryVehicle {}", e);
            return 0;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#verifyBattery(java.lang.String)
     */
    @Override
    public String verifyBattery(String dataValue) {
        logger.info("Entering verifyBattery with dataValue {}", dataValue);
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT TYPE_ORGANE || NUMERO_ORGANE AS organe FROM NRBQTORG WHERE CURRENT_VALUE='Y' AND TYPE_ORGANE || NUMERO_ORGANE =:idData");
            query.setParameter(CommonConstant.IDDATA.getConstValue(), dataValue);
            String obj = (String) query.getSingleResult();

            logger.info(CommonConstant.DATA.getConstValue(), obj);
            return obj;
        } catch (NoResultException e) {

            logger.error(CommonConstant.NO_RESULT_FOUND.getConstValue());
            return null;
        } catch (Exception e) {

            logger.error("Exception in  verifyBattery {}", e);
            return null;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#findModuleSubAssembly(java.lang.String)
     */
    @Override
    public List findModuleSubAssembly(String dataValue) {
        logger.info("Entering findModuleSubAssembly with idData {}", dataValue);
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT TYPE_ORGANE || NUMERO_ORGANE AS organe FROM NRBQTMOD WHERE CURRENT_VALUE='Y' AND TYPE_MODULE || NUMERO_MODULE  =:dataValue");
            query.setParameter("dataValue", dataValue);
            List list = query.getResultList();

            return list;
        } catch (NoResultException e) {

            logger.error(CommonConstant.NO_RESULT_FOUND.getConstValue());
            return Collections.emptyList();
        } catch (Exception e) {

            logger.error("Exception in  findModuleSubAssembly {}", e);
            return Collections.emptyList();
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#findVinBinMapping(java.lang.String)
     */
    @Override
    public String findVinBinMapping(String dataValue) {
        logger.info("Entering findVinBinMapping with dataValue {}", dataValue);
        try {
            Query query = entityManager.createNativeQuery("SELECT TYPE_ORGANE || NUMERO_ORGANE AS ORGANE_VIN FROM NRBQTVIN WHERE VIN =:dataValue");
            query.setParameter("dataValue", dataValue);
            return (String) query.getSingleResult();

        } catch (NoResultException e) {

            logger.error(CommonConstant.NO_RESULT_FOUND.getConstValue());
            return null;
        } catch (Exception e) {

            logger.error("Exception in  findVinBinMapping {}", e);
            return null;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getSerialNoCount(java.lang.String)
     */
    @Override
    public Long getSerialNoCount(String idData) {
        logger.info("Entering getserialNoCount with dataValue {}", idData);
        try {
            Query query = entityManager.createNativeQuery("SELECT COUNT(*) AS NB_48P FROM NRBQTBMU WHERE SERIAL_NUMBER =:idData");
            query.setParameter(CommonConstant.IDDATA.getConstValue(), idData);
            return ((BigDecimal) query.getSingleResult()).longValue();

        } catch (NoResultException e) {

            logger.error(CommonConstant.NO_RESULT_FOUND.getConstValue());
            return null;
        } catch (Exception e) {

            logger.error("Exception in  getserialNoCount {}", e);
            return null;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#findVinByOrgane(java.lang.String)
     */
    @Override
    public String findVinByOrgane(String idData) {
        logger.info("Entering findVinBinMapping with dataValue {}", idData);
        try {
            Query query = entityManager.createNativeQuery("SELECT VIN FROM NRBQTVIN WHERE   TYPE_ORGANE || NUMERO_ORGANE=:idData");
            query.setParameter(CommonConstant.IDDATA.getConstValue(), idData);
            return (String) query.getSingleResult();

        } catch (NoResultException e) {

            logger.error(CommonConstant.NO_RESULT_FOUND.getConstValue());
            return null;
        } catch (Exception e) {

            logger.error("Exception in  findVinBinMapping {}", e);
            return null;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#findModuleSubAssemblyModAssembled(java.lang.String, java.lang.String)
     */
    @Override
    public MassMvtValidationDto findModuleSubAssemblyModAssembled(String idData, String dataValue) {
        logger.info("Entering findModuleSubAssembly with idData {}", idData);
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT TYPE_ORGANE || NUMERO_ORGANE AS organe, TYPE_MODULE || NUMERO_MODULE AS module FROM NRBQTMOD WHERE CURRENT_VALUE='Y' AND TYPE_ORGANE || NUMERO_ORGANE =:idData AND TYPE_MODULE || NUMERO_MODULE  =:dataValue");
            query.setParameter(CommonConstant.IDDATA.getConstValue(), idData);
            query.setParameter("dataValue", dataValue);

            Object[] obj = (Object[]) query.getSingleResult();

            MassMvtValidationDto dto = new MassMvtValidationDto();
            dto.setOrgane(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString());
            dto.setModule(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
            return dto;
        } catch (NoResultException e) {

            logger.error(CommonConstant.NO_RESULT_FOUND.getConstValue());
            return new MassMvtValidationDto();
        } catch (Exception e) {

            logger.error("Exception in  findModuleSubAssembly {}", e);
            return null;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getBatteryHealthData(java.lang.String)
     */
    @Override
    public HealthDataDto getBatteryHealthData(String idData) {
        logger.info("Entering getBatteryHealthData with idData {}", idData);
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT soh, soc, mic, mac, rinsulation, rinternal, t10, tat FROM NRBQTHDATA WHERE TYPE_ORGANE || NUMERO_ORGANE =:idData");
            query.setParameter(CommonConstant.IDDATA.getConstValue(), idData);

            Object[] obj = (Object[]) query.getSingleResult();

            HealthDataDto dto = new HealthDataDto();
            dto.setSoh(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()]).orElse("").toString());
            dto.setSoc(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
            dto.setMic(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString());
            dto.setMac(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse("").toString());
            dto.setRinsulation(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString());
            dto.setRinternal(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()]).orElse("").toString());
            dto.setT10(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()]).orElse("").toString());
            dto.setTat(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER7.getConstValueInt()]).orElse("").toString());
            return dto;
        } catch (NoResultException e) {

            logger.error(CommonConstant.NO_RESULT_FOUND.getConstValue());
            return new HealthDataDto();
        } catch (Exception e) {

            logger.error("Exception in  getBatteryHealthData {}", e);
            return null;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#getMMLineListByFileId(java.lang.Long, java.lang.String)
     */
    @Override
    public List<MassMvtLineDto> getMMLineListByFileId(Long fileId, String idLang) {
        List<MassMvtLineDto> resultData = null;
        try {
            logger.info("Entering getMMLineListByFileId with parameters fileid {} | idLang {} ", fileId, idLang);
            Query query = entityManager.createNativeQuery(QueryConstant.QUERY_SELECT_MMLINE_DATA.getQuery());
            query.setParameter(1, idLang);
            query.setParameter(2, fileId);
            resultData = new ArrayList<>();

            List<Object[]> massMvtLineDtoModel = query.getResultList();

            resultData = massMvtLineDtoModel.stream().map(MassMvtLineDto::new).collect(Collectors.toList());
            logger.info("result data {}", resultData);
            return resultData;
        } catch (Exception e) {
            logger.error("Exception in getMMLineListByFileId {}", e);
            return Collections.emptyList();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#purgeMMData(java.lang.Integer)
     */
    @Override
    public Boolean purgeMMData(Integer purgedatadurationindays) {
        LocalDateTime date = LocalDateTime.now().minusDays(purgedatadurationindays);
        Date ltdToDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        logger.info("Data to be deleted before date {}", ltdToDate);
        try {
            Query query = em1.createQuery("from MassMvtFile where dateEnd <:ltdToDate");
            query.setParameter("ltdToDate", ltdToDate);
            List<MassMvtFile> mmFileList = query.getResultList();

            Query lineQuery = em1.createNativeQuery(
                    " delete from nrbqtmmline l where l.id_file in (select f.id_file from nrbqtmmfile f where f.DATE_END <:ltdToDate)");
            lineQuery.setParameter("ltdToDate", ltdToDate);
            int i = lineQuery.executeUpdate();
            logger.info("Lines deleted {}", i);

            mmFileRepository.deleteAll(mmFileList);

            return true;

        } catch (Exception e) {
            logger.error("Error while purging records for {} days with error {}", purgedatadurationindays, e);
            return false;
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MassMovementService#findMaxSize(java.util.List)
     */
    @Override
    @Cacheable(value = "batteryMetadata")
    public Map<String, Integer> findMaxSize(List<String> tableNames) {
        try {
            for (String tableName : tableNames) {
                logger.info("Entering findMaxSize. Creating Cache for table : {}", tableName);
                Query hql = entityManager.createNativeQuery("select column_name, char_length from dba_tab_columns where table_name = :tableName");
                hql.setParameter("tableName", tableName);
                List list = hql.getResultList();

                generateResponse(list, tableName);
            }
            return tableMap;

        } catch (Exception e) {
            logger.error("Exception findMaxSize {}", e);
            return Collections.emptyMap();
        }
    }

    /**
     * Generate response.
     *
     * @param arrayList the array list
     * @param tableName the table name
     * @return the map
     */
    private Map<String, Integer> generateResponse(List arrayList, String tableName) {
        Iterator itr = arrayList.iterator();
        if (tableMap == null) {
            tableMap = new HashMap<>();
        }
        while (itr.hasNext()) {
            Object[] obj = (Object[]) (itr.next());
            tableMap.put(tableName + "." + Optional.ofNullable(obj[0]).orElse("").toString(),
                    Integer.parseInt(Optional.ofNullable(obj[1]).orElse("").toString()));

        }
        return tableMap;

    }

}
