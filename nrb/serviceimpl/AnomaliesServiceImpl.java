/*
 * Creation : 11 Jan 2022
 */
package com.inetpsa.nrb.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
import com.inetpsa.nrb.dto.AnomaliesTranslation;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.model.AnomaliesEntity;
import com.inetpsa.nrb.repository.AnomaliesRepository;
import com.inetpsa.nrb.service.AnomaliesService;

/**
 * The Class AnomaliesServiceImpl.
 */
@Service
public class AnomaliesServiceImpl implements AnomaliesService {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(AnomaliesServiceImpl.class);
    /** The anomalies repository. */
    @Autowired
    private AnomaliesRepository anomaliesRepository;

    /** The entity manager. */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.AnomaliesService#getAnomaliesData(java.lang.String)
     */
    @Override
    public List<AnomaliesTranslation> getAnomaliesData(@Param("id_lang") String idlang) {
        logger.info("Entering get data of AnomaliesServiceIMPL{}", idlang);
        List<AnomaliesTranslation> data = new ArrayList<>();
        try {
            Query query = entityManager.createQuery(
                    "select A.id, A.vin, A.bin1Type || A.bin1Numero AS bin1, A.bin2Type || A.bin2Numero AS bin2, A.errorMessage, A.messageValue, A.dateError, T.lbltrad FROM AnomaliesEntity A JOIN TranslationEntity T ON T.translationEntityPk.idtrad=A.errorMessage where T.translationEntityPk.idlang=:id_lang order by A.dateError DESC");
            query.setParameter("id_lang", idlang);
            List<?> lists = (query.getResultList());
            if (!lists.isEmpty()) {
                Iterator<?> itr = lists.iterator();
                while (itr.hasNext()) {
                    Object[] object = (Object[]) (itr.next());
                    AnomaliesTranslation anomaliesTranslation = new AnomaliesTranslation();

                    anomaliesTranslation.setId((Long) object[CommonConstant.OBJECTNUMBER0.getConstValueInt()]);
                    if (object[CommonConstant.OBJECTNUMBER1.getConstValueInt()] != null) {
                        anomaliesTranslation.setVin(object[CommonConstant.OBJECTNUMBER1.getConstValueInt()].toString());
                    } else {
                        anomaliesTranslation.setVin("");
                    }
                    if (object[CommonConstant.OBJECTNUMBER2.getConstValueInt()] != null) {
                        anomaliesTranslation.setBin1(object[CommonConstant.OBJECTNUMBER2.getConstValueInt()].toString());
                    } else {
                        anomaliesTranslation.setBin1("");
                    }
                    if (object[CommonConstant.OBJECTNUMBER3.getConstValueInt()] != null) {
                        anomaliesTranslation.setBin2(object[CommonConstant.OBJECTNUMBER3.getConstValueInt()].toString());
                    } else {
                        anomaliesTranslation.setBin2("");
                    }
                    if (object[CommonConstant.OBJECTNUMBER5.getConstValueInt()] != null) {
                        anomaliesTranslation.setMessageValue(object[CommonConstant.OBJECTNUMBER5.getConstValueInt()].toString());
                    } else {
                        anomaliesTranslation.setMessageValue("");
                    }
                    anomaliesTranslation.setDateError((Timestamp) object[CommonConstant.OBJECTNUMBER6.getConstValueInt()]);
                    if (object[CommonConstant.OBJECTNUMBER7.getConstValueInt()] != null) {
                        anomaliesTranslation.setLbltrad((object[CommonConstant.OBJECTNUMBER7.getConstValueInt()]).toString());
                    } else {
                        anomaliesTranslation.setLbltrad((""));
                    }
                    String error = object[CommonConstant.OBJECTNUMBER4.getConstValueInt()].toString();

                    if (error.equals("ERR1-001")) {
                        String anomaliesMessage;
                        anomaliesMessage = anomaliesTranslation.getLbltrad();

                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.BIN1.getConstValue(), anomaliesTranslation.getBin1());
                        anomaliesMessage = error + " " + ":" + " " + anomaliesMessage;
                        anomaliesTranslation.setErrorMessage(anomaliesMessage);

                    }
                    if (error.equals("ERR1-002")) {
                        String anomaliesMessage;
                        anomaliesMessage = anomaliesTranslation.getLbltrad();
                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.BIN1.getConstValue(), anomaliesTranslation.getBin1());
                        anomaliesMessage = error + " " + ":" + " " + anomaliesMessage;
                        anomaliesTranslation.setErrorMessage(anomaliesMessage);

                    }

                    if (error.equals("ERR1-003")) {
                        String anomaliesMessage;
                        anomaliesMessage = anomaliesTranslation.getLbltrad();
                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.BIN1.getConstValue(), anomaliesTranslation.getBin1());
                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.VIN.getConstValue(), anomaliesTranslation.getVin());
                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.NRBQTVINVIN.getConstValue(),
                                anomaliesTranslation.getMessageValue());
                        anomaliesMessage = anomaliesMessage.replace("{", "");
                        anomaliesMessage = anomaliesMessage.replace("}", "");
                        anomaliesMessage = error + " " + ":" + " " + anomaliesMessage;
                        anomaliesTranslation.setErrorMessage(anomaliesMessage);

                    }
                    if (error.equals("ERR1-004")) {
                        String anomaliesMessage;
                        anomaliesMessage = anomaliesTranslation.getLbltrad();
                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.BIN2.getConstValue(), anomaliesTranslation.getBin2());
                        anomaliesMessage = error + " " + ":" + " " + anomaliesMessage;
                        anomaliesTranslation.setErrorMessage(anomaliesMessage);

                    }
                    if (error.equals("ERR1-005")) {
                        String anomaliesMessage;
                        anomaliesMessage = anomaliesTranslation.getLbltrad();
                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.BIN2.getConstValue(), anomaliesTranslation.getBin2());
                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.NRBQTVINVIN.getConstValue(),
                                anomaliesTranslation.getMessageValue());
                        anomaliesMessage = anomaliesMessage.replace("{", "");
                        anomaliesMessage = anomaliesMessage.replace("}", "");
                        anomaliesMessage = error + " " + ":" + " " + anomaliesMessage;
                        anomaliesTranslation.setErrorMessage(anomaliesMessage);

                    }
                    if (error.equals("ERR1-006")) {
                        String anomaliesMessage;
                        anomaliesMessage = anomaliesTranslation.getLbltrad();
                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.BIN2.getConstValue(), anomaliesTranslation.getBin2());
                        anomaliesMessage = anomaliesMessage.replace(CommonConstant.NRBQTORGSTATUS.getConstValue(),
                                anomaliesTranslation.getMessageValue());
                        anomaliesMessage = anomaliesMessage.replace("{", "");
                        anomaliesMessage = anomaliesMessage.replace("}", "");
                        anomaliesMessage = error + " " + ":" + " " + anomaliesMessage;
                        anomaliesTranslation.setErrorMessage(anomaliesMessage);

                    }

                    data.add(anomaliesTranslation);

                }
            }
            return data;
        } catch (Exception e) {
            logger.error("Exception in fetching AnomaliesData get api", e);
            return Collections.emptyList();
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.AnomaliesService#deleteAnomaliesData(long)
     */
    @Override
    public ResponseDto deleteAnomaliesData(long id) {

        ResponseDto responseDto = new ResponseDto();
        try {
            Optional<AnomaliesEntity> range = anomaliesRepository.findById(id);
            if (range.isPresent()) {
                anomaliesRepository.deleteById(id);
                responseDto.setId(Long.toString(id));
                responseDto.setMsg(true);
                responseDto.setMessage("Data Deleted successfully");
                logger.info(" Anomalies Data is deleted");

            }
        } catch (Exception e) {
            responseDto.setMsg(false);
            responseDto.setMessage("Data Deleted unsuccessfully");
            logger.error("Error occurred in deleteAnomaliesData  id : {}", id);
            logger.error("Error occurred in deleteAnomaliesData {}", e.getMessage());
        }

        return responseDto;

    }
}
