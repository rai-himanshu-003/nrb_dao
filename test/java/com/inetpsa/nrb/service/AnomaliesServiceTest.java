
/*
 * Creation : 1 Feb 2022
 */
package com.inetpsa.nrb.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.inetpsa.nrb.JpaConfig;
import com.inetpsa.nrb.dto.AnomaliesTranslation;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.model.AnomaliesEntity;
import com.inetpsa.nrb.model.TranslationEntity;
import com.inetpsa.nrb.model.TranslationEntityPk;
import com.inetpsa.nrb.repository.AnomaliesRepository;
import com.inetpsa.nrb.repository.TranslationRepository;

/**
 * The Class AnomaliesServiceTest.
 */

@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
class AnomaliesServiceTest {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(AnomaliesServiceTest.class);
    /** The anomalies service impl. */
    @Autowired
    AnomaliesService anomaliesServiceImpl;

    @Autowired
    AnomaliesRepository anomaliesRepository;

    @Autowired
    TranslationRepository translationRepository;

    /** The response dto. */
    ResponseDto responseDto;

    /** The anomalies translation. */
    AnomaliesTranslation anomaliesTranslation;
    AnomaliesEntity anomaliesEntity;
    TranslationEntity translationEntity;

    /**
     * Inits the.
     */
    @BeforeEach
    void init() {
        anomaliesEntity = new AnomaliesEntity();
        anomaliesEntity.setVin("335655648762");
        anomaliesEntity.setBin1Type("562");
        anomaliesEntity.setBin2Type("444");
        anomaliesEntity.setBin2Numero("26648299874");
        anomaliesEntity.setBin1Numero("36728663523");
        anomaliesEntity.setErrorMessage("ERR1:001");
        anomaliesEntity.setMessageValue("{335655648762}");

        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("EN", "ERR1-001"));
        translationEntity.setLbltrad("<BIN1> unknown in CORBAT");
        translationEntity.setTyptrad("2-ERR-ANO");
        anomaliesRepository.save(anomaliesEntity);
        translationRepository.save(translationEntity);

    }

    /**
     * Test anomalies list EN.
     */
    @Test
    void testAnomaliesListERR1() {
        anomaliesEntity = new AnomaliesEntity();
        anomaliesEntity.setVin("335655648762");
        anomaliesEntity.setBin1Type("562");
        anomaliesEntity.setBin2Type("444");
        anomaliesEntity.setBin2Numero("26648299874");
        anomaliesEntity.setBin1Numero("36728663523");
        anomaliesEntity.setErrorMessage("ERR1-001");
        anomaliesEntity.setMessageValue("{335655648762}");
        anomaliesEntity.setDateError(new Timestamp(new java.util.Date().getTime()));
        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("ERR1-001", "EN"));
        translationEntity.setLbltrad("<BIN1> unknown in CORBAT");
        translationEntity.setTyptrad("2-ERR-ANO");
        anomaliesRepository.save(anomaliesEntity);
        translationRepository.save(translationEntity);

        List<AnomaliesTranslation> anomaliesTranslations = anomaliesServiceImpl.getAnomaliesData("EN");
        assertNotNull(anomaliesTranslations);
        logger.info("test Anomalies getAnomaliesData in ServiceImpl");

    }

    @Test
    void testAnomaliesListERR2() {
        anomaliesEntity = new AnomaliesEntity();
        anomaliesEntity.setVin("335655648762");
        anomaliesEntity.setBin1Type("562");
        anomaliesEntity.setBin2Type("444");
        anomaliesEntity.setBin2Numero("26648299874");
        anomaliesEntity.setBin1Numero("36728663523");
        anomaliesEntity.setErrorMessage("ERR1-002");
        anomaliesEntity.setMessageValue("{335655648762}");
        anomaliesEntity.setDateError(new Timestamp(new java.util.Date().getTime()));

        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("ERR1-002", "EN"));
        translationEntity.setLbltrad("<BIN1> not present on a vehicle");
        translationEntity.setTyptrad("2-ERR-ANO");
        anomaliesRepository.save(anomaliesEntity);
        translationRepository.save(translationEntity);

        List<AnomaliesTranslation> anomaliesTranslations = anomaliesServiceImpl.getAnomaliesData("EN");
        assertNotNull(anomaliesTranslations);
        logger.info("test Anomalies getAnomaliesData in ServiceImpl");

    }

    @Test
    void testAnomaliesListERR3() {
        anomaliesEntity = new AnomaliesEntity();
        anomaliesEntity.setVin("335655648762");
        anomaliesEntity.setBin1Type("562");
        anomaliesEntity.setBin2Type("444");
        anomaliesEntity.setBin2Numero("26648299874");
        anomaliesEntity.setBin1Numero("36728663523");
        anomaliesEntity.setErrorMessage("ERR1-003");
        anomaliesEntity.setMessageValue("{335655648762}");
        anomaliesEntity.setDateError(new Timestamp(new java.util.Date().getTime()));

        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("ERR1-003", "EN"));
        translationEntity.setLbltrad("<BIN1> not present on <VIN> : removed from {NRBQTVIN.VIN}");
        translationEntity.setTyptrad("2-ERR-ANO");
        anomaliesRepository.save(anomaliesEntity);
        translationRepository.save(translationEntity);

        List<AnomaliesTranslation> anomaliesTranslations = anomaliesServiceImpl.getAnomaliesData("EN");
        assertNotNull(anomaliesTranslations);
        logger.info("test Anomalies getAnomaliesData in ServiceImpl");

    }

    @Test
    void testAnomaliesListERR4() {
        anomaliesEntity = new AnomaliesEntity();
        anomaliesEntity.setVin("335655648762");
        anomaliesEntity.setBin1Type("562");
        anomaliesEntity.setBin2Type("444");
        anomaliesEntity.setBin2Numero("26648299874");
        anomaliesEntity.setBin1Numero("36728663523");
        anomaliesEntity.setErrorMessage("ERR1-004");
        anomaliesEntity.setMessageValue("{335655648762}");
        anomaliesEntity.setDateError(new Timestamp(new java.util.Date().getTime()));

        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("ERR1-004", "EN"));
        translationEntity.setLbltrad("<BIN2> unknown in CORBAT");
        translationEntity.setTyptrad("2-ERR-ANO");
        anomaliesRepository.save(anomaliesEntity);
        translationRepository.save(translationEntity);

        List<AnomaliesTranslation> anomaliesTranslations = anomaliesServiceImpl.getAnomaliesData("EN");
        assertNotNull(anomaliesTranslations);
        logger.info("test Anomalies getAnomaliesData in ServiceImpl");

    }

    @Test
    void testAnomaliesListERR5() {
        anomaliesEntity = new AnomaliesEntity();
        anomaliesEntity.setVin("335655648762");
        anomaliesEntity.setBin1Type("562");
        anomaliesEntity.setBin2Type("444");
        anomaliesEntity.setBin2Numero("26648299874");
        anomaliesEntity.setBin1Numero("36728663523");
        anomaliesEntity.setErrorMessage("ERR1-005");
        anomaliesEntity.setMessageValue("{335655648762}");
        anomaliesEntity.setDateError(new Timestamp(new java.util.Date().getTime()));

        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("ERR1-005", "EN"));
        translationEntity.setLbltrad("<BIN2> removed from {NRBQTVIN.VIN}");
        translationEntity.setTyptrad("2-ERR-ANO");
        anomaliesRepository.save(anomaliesEntity);
        translationRepository.save(translationEntity);

        List<AnomaliesTranslation> anomaliesTranslations = anomaliesServiceImpl.getAnomaliesData("EN");
        assertNotNull(anomaliesTranslations);
        logger.info("test Anomalies getAnomaliesData in ServiceImpl");

    }

    @Test
    void testAnomaliesListERR6() {
        anomaliesEntity = new AnomaliesEntity();
        anomaliesEntity.setVin("335655648762");
        anomaliesEntity.setBin1Type("562");
        anomaliesEntity.setBin2Type("444");
        anomaliesEntity.setBin2Numero("26648299874");
        anomaliesEntity.setBin1Numero("36728663523");
        anomaliesEntity.setErrorMessage("ERR1-006");
        anomaliesEntity.setMessageValue("{335655648762}");
        anomaliesEntity.setDateError(new Timestamp(new java.util.Date().getTime()));

        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("ERR1-006", "EN"));
        translationEntity.setLbltrad("<BIN2> to move on the vehicle with status {NRBQTORG.STATUS}");
        translationEntity.setTyptrad("2-ERR-ANO");
        anomaliesRepository.save(anomaliesEntity);
        translationRepository.save(translationEntity);

        List<AnomaliesTranslation> anomaliesTranslations = anomaliesServiceImpl.getAnomaliesData("EN");
        assertNotNull(anomaliesTranslations);
        logger.info("test Anomalies getAnomaliesData in ServiceImpl");

    }

    /**
     * Test delete.
     */
    @Test
    void TestDelete() {
        anomaliesEntity = new AnomaliesEntity();
        anomaliesEntity.setVin("335655648762");
        anomaliesEntity.setBin1Type("562");
        anomaliesEntity.setBin2Type("444");
        anomaliesEntity.setBin2Numero("26648299874");
        anomaliesEntity.setBin1Numero("36728663523");
        anomaliesEntity.setErrorMessage("ERR1:001");
        anomaliesEntity.setMessageValue("{335655648762}");

        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("EN", "ERR1-001"));
        translationEntity.setLbltrad("<BIN1> unknown in CORBAT");
        translationEntity.setTyptrad("2-ERR-ANO");
        anomaliesRepository.save(anomaliesEntity);
        translationRepository.save(translationEntity);
        long id = anomaliesRepository.findAll().get(0).getId();

        responseDto = anomaliesServiceImpl.deleteAnomaliesData(id);
        assertNotNull(responseDto.getMessage());
        logger.info("test Anomalies deleteAnomaliesData in ServiceImpl");

    }

}
