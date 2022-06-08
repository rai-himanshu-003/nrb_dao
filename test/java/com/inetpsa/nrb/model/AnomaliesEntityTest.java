/*
 * Creation : 20 Jan 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * The Class AnomaliesEntityTest.
 */
@ContextConfiguration
class AnomaliesEntityTest {

    /** The anomalies entity. */
    static AnomaliesEntity anomaliesEntity;

    /** The now. */
    Timestamp now = new Timestamp(new java.util.Date().getTime());

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        anomaliesEntity = new AnomaliesEntity();
        anomaliesEntity.setVin("335655648762");
        anomaliesEntity.setBin1Type("562");
        anomaliesEntity.setBin2Type("444");
        anomaliesEntity.setBin2Numero("26648299874");
        anomaliesEntity.setBin1Numero("36728663523");
        anomaliesEntity.setErrorMessage("ERR1:001");
        anomaliesEntity.setMessageValue("{335655648762}");
        anomaliesEntity.setId((long) 2);
        anomaliesEntity.setDateError(new Timestamp(new java.util.Date().getTime()));

    }

    /**
     * Test anomalies data.
     */
    @Test
    void testAnomaliesData() {
        assertSame((long) 2, anomaliesEntity.getId());
        assertNotNull(anomaliesEntity.getVin());
        assertNotNull(anomaliesEntity.getBin1Type());
        assertNotNull(anomaliesEntity.getBin2Type());
        assertNotNull(anomaliesEntity.getBin1Numero());
        assertNotNull(anomaliesEntity.getBin2Numero());
        assertNotNull(anomaliesEntity.getErrorMessage());
        assertNotNull(anomaliesEntity.getMessageValue());
        assertNotNull(anomaliesEntity.getDateError());

    }

    /**
     * Test anomalies constructor.
     */
    @Test
    void testAnomaliesConstructor() {
        AnomaliesEntity anomaliesEntity = new AnomaliesEntity((long) 2, "767326728736737", "456", "765", "ERR1-002", "VR1ATTENTKW039309", now);
        assertNotNull(anomaliesEntity);
    }

    /**
     * Test not equal anomalies.
     */
    @Test
    void testNotEqualAnomalies() {
        AnomaliesEntity anomaliesEntityOne = new AnomaliesEntity((long) 2, "767326728736737", "456", "765", "ERR1-002", "VR1ATTENTKW039309", now);
        AnomaliesEntity anomaliesEntityTwo = new AnomaliesEntity();
        boolean equal = anomaliesEntityOne.equals(anomaliesEntityTwo);
        assertFalse(equal);
    }

    /**
     * Test to string anomalies.
     */
    @Test
    void testToStringAnomalies() {
        assertEquals(
                "Anomalies [id=2, vin=335655648762, bin1Type=562, bin1Numero=36728663523, bin2Type=444, bin2Numero=26648299874, errorMessage=ERR1:001, messageValue={335655648762}, dateError="
                        + anomaliesEntity.getDateError() + "]",
                (anomaliesEntity.toString()));
    }

}
