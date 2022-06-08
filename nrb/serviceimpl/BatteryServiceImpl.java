/*
 * Creation : 7 Mar 2022
 */
package com.inetpsa.nrb.serviceimpl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.inetpsa.nrb.constant.CommonConstant;
import com.inetpsa.nrb.dto.BatteryDto;
import com.inetpsa.nrb.service.BatteryService;

/**
 * The Class BatteryServiceImpl.
 */
@Service
public class BatteryServiceImpl implements BatteryService {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(BatteryServiceImpl.class);
    /** The anomalies repository. */

    /** The formatterdate. */
    SimpleDateFormat formatterdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    /** The entity manager. */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.BatteryService#getBatteryList(com.inetpsa.nrb.dto.BatteryDto, int, int)
     */
    @Override
    public List<BatteryDto> getBatteryList(BatteryDto batteryDto, int offsetPositionToStartFrom, int rowsPerPage) {

        logger.info("getBatteryList in BatteryServiceImpl");
        List<BatteryDto> batteryList = null;
        try {
            batteryList = new ArrayList<>();
            StringBuilder startQuery;
            startQuery = new StringBuilder(
                    "SELECT bt.ID , bt.TYPE_ORGANE || bt.NUMERO_ORGANE AS BIN,bt.REFERENCE, bt.CODE_USINE, cd.LBL_CODE AS LBL_USINE, bt.DATE_PRODUCTION, bt.STATUS, td.LBL_TRAD AS LBL_STATUS FROM NRBQTORG bt LEFT JOIN NRBQTCODE cd ON (bt.CODE_USINE = cd.ID_CODE AND cd.TYPE_CODE = 'CODE_USINE') LEFT JOIN NRBQTTRAD td ON (bt.STATUS = SUBSTR(td.ID_TRAD, 8, 1) AND td.TYP_TRAD = '1-STATUS' AND td.ID_LANG =:lang)  WHERE  1=1 AND CURRENT_VALUE='Y' AND TYPE_ORGANE IN (SELECT VALUE_SETTING FROM NRBQTSET WHERE ID_SETTING = 'BIN_TYPE_ORGANE')");
            Query hql = filterCriteria(batteryDto, startQuery, true);

            hql.setFirstResult(offsetPositionToStartFrom);
            if (rowsPerPage != CommonConstant.OBJECTNUMBER0.getConstValueInt())
                hql.setMaxResults(rowsPerPage);
            List<?> list = (hql.getResultList());
            logger.info("getBatteryList before generate response", list);

            batteryList = generateResponse(list, batteryList);

            return batteryList;

        } catch (Exception e) {
            logger.error("Exception in fetching BatteryListImpl get api", e);

        }
        return batteryList;

    }

    /**
     * Filter criteria.
     *
     * @param batteryListDto the battery list dto
     * @param query          the query
     * @param callFrom       the call from
     * @return the query
     */
    public Query filterCriteria(BatteryDto batteryListDto, StringBuilder query, Boolean callFrom) {
        logger.info("getBatteryList in BatteryService filter query {}", callFrom);
        StringBuilder orderBy = new StringBuilder();
        String finalQuery = null;
        String cons = null;
        String extToDate = null;
        String extFromDate = null;
        SimpleDateFormat formatterdate = new SimpleDateFormat("dd/MMM/yyyy");
        if (batteryListDto != null) {

            if (!(batteryListDto.getExtFromDate() == null || batteryListDto.getExtFromDate().equals("null"))) {
                extFromDate = formatterdate.format(batteryListDto.getExtFromDate());
            }
            if (!(batteryListDto.getExtToDate() == null || batteryListDto.getExtToDate().equals("null"))) {
                extToDate = formatterdate.format(batteryListDto.getExtToDate());
            }

            if (batteryListDto.getExtFromDate() != null) {
                query.append(" AND trunc(bt.DATE_PRODUCTION) >=:extFromDate ");
            }

            if (batteryListDto.getExtToDate() != null) {
                query.append(" AND trunc(bt.DATE_PRODUCTION) <=:extToDate ");
            }

            if (batteryListDto.getBin() != null && batteryListDto.getBin().trim().length() != 0) {
                query.append(" AND upper(bt.TYPE_ORGANE || bt.NUMERO_ORGANE) like :bin ");
            }
            if (batteryListDto.getFactoryCode() != null && batteryListDto.getFactoryCode().trim().length() != 0) {
                query.append(" AND upper(bt.CODE_USINE ||'-'|| cd.LBL_CODE )  like :factoryCode  ");

            }

            if (batteryListDto.getRefrence() != null && batteryListDto.getRefrence().trim().length() != 0) {
                query.append(" AND upper(bt.REFERENCE) like :reference  ");

            }
            if (batteryListDto.getStatus() != null && batteryListDto.getStatus().trim().length() != 0) {
                query.append(" AND upper(bt.STATUS)  in (:status) ");

            }

            if (callFrom) {
                orderBy.append(" Order").append(" by");
                cons = orderBy.toString();
                if (batteryListDto.getFactoryCodeOrder() != null) {
                    if (!orderBy.toString().equals(cons)) {
                        orderBy.append(",");
                    }
                    orderBy.append(" bt.CODE_USINE ").append(batteryListDto.getFactoryCodeOrder());
                }
                if (batteryListDto.getProdDateOrder() != null) {
                    if (!orderBy.toString().equals(cons)) {
                        orderBy.append(",");
                    }
                    orderBy.append(" bt.DATE_PRODUCTION ").append(batteryListDto.getProdDateOrder());

                }
                if (batteryListDto.getRefrenceOrder() != null) {
                    if (!orderBy.toString().equals(cons)) {
                        orderBy.append(",");
                    }
                    orderBy.append(" bt.REFERENCE ").append(batteryListDto.getRefrenceOrder());

                }
                if (batteryListDto.getStatusOrder() != null) {
                    if (!orderBy.toString().equals(cons)) {
                        orderBy.append(",");
                    }
                    orderBy.append(" bt.STATUS ").append(batteryListDto.getStatusOrder());
                }
                if (batteryListDto.getBinOrder() != null) {
                    if (!orderBy.toString().equals(cons)) {
                        orderBy.append(",");
                    }
                    orderBy.append(" BIN ").append(batteryListDto.getBinOrder());

                }

            }

        }

        if (callFrom) {
            if (orderBy.toString().equals(cons)) {
                orderBy.append(" bin ");
            }
            finalQuery = query.append(orderBy).toString();
        } else
            finalQuery = query.append(orderBy).toString();

        Query hql = this.entityManager.createNativeQuery(finalQuery);
        if (batteryListDto != null) {
            logger.info("getBatteryList in BatteryService hql {}", hql);
            if (batteryListDto.getBin() != null && batteryListDto.getBin().trim().length() != 0)
                hql.setParameter("bin", "%" + batteryListDto.getBin().trim().toUpperCase() + "%");

            if (batteryListDto.getFactoryCode() != null && batteryListDto.getFactoryCode().trim().length() != 0)
                hql.setParameter("factoryCode", "%" + batteryListDto.getFactoryCode().trim().toUpperCase() + "%");

            if (batteryListDto.getExtFromDate() != null) {
                hql.setParameter("extFromDate", batteryListDto.getExtFromDate());
            }

            if (batteryListDto.getExtToDate() != null) {
                hql.setParameter("extToDate", batteryListDto.getExtToDate());
            }

            if (batteryListDto.getRefrence() != null && batteryListDto.getRefrence().trim().length() != 0)
                hql.setParameter("reference", "%" + batteryListDto.getRefrence().trim().toUpperCase() + "%");

            if (batteryListDto.getStatus() != null && batteryListDto.getStatus().trim().length() != 0) {
                List<String> statusList = Arrays.asList(batteryListDto.getStatus().toUpperCase().split(","));
                hql.setParameter("status", statusList);
            }

            if (batteryListDto.getLang() != null && batteryListDto.getLang().trim().length() != 0)
                hql.setParameter("lang", batteryListDto.getLang().trim().toUpperCase());
        }

        return hql;
    }

    /**
     * Generate response.
     *
     * @param arrayList       the array list
     * @param batteryListDTOs the battery list DT os
     * @return the list
     */
    public List<BatteryDto> generateResponse(List<?> arrayList, List<BatteryDto> batteryListDTOs) {

        Iterator<?> itr = arrayList.iterator();
        try {
            while (itr.hasNext()) {
                Object[] obj = (Object[]) (itr.next());
                BatteryDto batteryListDTO = new BatteryDto();

                batteryListDTO.setId(obj[CommonConstant.OBJECTNUMBER0.getConstValueInt()].toString());
                batteryListDTO.setBin(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER1.getConstValueInt()]).orElse("").toString());
                batteryListDTO.setRefrence(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER2.getConstValueInt()]).orElse("").toString());
                batteryListDTO.setFactoryCode(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER3.getConstValueInt()]).orElse("").toString() + "-"
                        + Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER4.getConstValueInt()]).orElse("").toString());
                batteryListDTO.setStatus(Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER6.getConstValueInt()]).orElse("").toString() + "-"
                        + Optional.ofNullable(obj[CommonConstant.OBJECTNUMBER7.getConstValueInt()]).orElse("").toString());
                if (obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()] != null)
                    batteryListDTO.setProdDate(formatterdate.format((Date) obj[CommonConstant.OBJECTNUMBER5.getConstValueInt()]));
                batteryListDTOs.add(batteryListDTO);

            }
            logger.info("getBatteryList after generate response");
            return batteryListDTOs;
        } catch (Exception ex) {
            logger.error("Error occurred ", ex);
        }
        return batteryListDTOs;

    }

    @Override
    public long getTotalBatteryRecords(BatteryDto batteryDto) {
        long totalRecords = 0;
        try {
            logger.info("enter Battey list total records");
            StringBuilder startQuery;
            startQuery = new StringBuilder(
                    "SELECT  COUNT(*) FROM NRBQTORG bt LEFT JOIN NRBQTCODE cd ON (bt.CODE_USINE = cd.ID_CODE AND cd.TYPE_CODE = 'CODE_USINE') LEFT JOIN NRBQTTRAD td ON (bt.STATUS = SUBSTR(td.ID_TRAD, 8, 1) AND td.TYP_TRAD = '1-STATUS' AND td.ID_LANG =:lang)  WHERE  1=1 AND CURRENT_VALUE='Y' AND bt.TYPE_ORGANE IN (SELECT VALUE_SETTING FROM NRBQTSET WHERE ID_SETTING = 'BIN_TYPE_ORGANE')");
            Query hql = filterCriteria(batteryDto, startQuery, false);
            totalRecords = ((BigDecimal) hql.getSingleResult()).longValue();
            return totalRecords;

        } catch (Exception e) {
            logger.error("Exception in fetching BatteryListImpl total records", e);

        }
        logger.info(" Battey list total records ", totalRecords);
        return totalRecords;
    }

}
