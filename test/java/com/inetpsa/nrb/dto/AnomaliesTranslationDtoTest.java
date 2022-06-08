/*
 * Creation : 20 Jan 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.constant.CommonConstant;

/**
 * The Class AnomaliesTranslationDtoTest.
 */

@ContextConfiguration
class AnomaliesTranslationDtoTest {

    /** The anomalies translation. */
    static AnomaliesTranslation anomaliesTranslation;

    /** The now. */
    Timestamp now = new Timestamp(new java.util.Date().getTime());

    static CommonConstant commonConstant;

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        anomaliesTranslation = new AnomaliesTranslation();
        anomaliesTranslation.setId(2);
        anomaliesTranslation.setVin("34898976456386364");
        anomaliesTranslation.setBin1("753");
        anomaliesTranslation.setBin2("726");
        anomaliesTranslation.setErrorMessage("ERR1-001");
        anomaliesTranslation.setMessageValue("{34898976456386364}");
        anomaliesTranslation.setLbltrad("En");
        anomaliesTranslation.setDateError(new Timestamp(new java.util.Date().getTime()));

    }

    /**
     * Test anomalies data.
     */
    @Test
    void testAnomaliesData() {

        assertEquals(2, anomaliesTranslation.getId());
        assertNotNull(anomaliesTranslation.getBin1());
        assertNotNull(anomaliesTranslation.getBin2());
        assertNotNull(anomaliesTranslation.getErrorMessage());
        assertNotNull(anomaliesTranslation.getLbltrad());
        assertNotNull(anomaliesTranslation.getMessageValue());
        assertNotNull(anomaliesTranslation.getVin());
        assertNotNull(anomaliesTranslation.getDateError());
        assertEquals("<BIN1>", CommonConstant.BIN1.getConstValue());
        assertEquals("<BIN2>", CommonConstant.BIN2.getConstValue());
        assertEquals("<VIN>", CommonConstant.VIN.getConstValue());
        assertEquals("<VIN>", CommonConstant.VIN.getConstValue());
        assertEquals("{NRBQTVIN.VIN}", CommonConstant.NRBQTVINVIN.getConstValue());
        assertEquals("{NRBQTORG.STATUS}", CommonConstant.NRBQTORGSTATUS.getConstValue());

    }

    /**
     * Test anomalies translation constructor.
     */
    @Test
    void testAnomaliesTranslationConstructor() {
        AnomaliesTranslation anomaliesTranslation = new AnomaliesTranslation(2, "767326728736737", "456276526765", "71756254525", "ERR1-002", now,
                "EN");
        assertNotNull(anomaliesTranslation);
    }

    /**
     * Test not equal anomalies translation.
     */
    @Test
    void testNotEqualAnomaliesTranslation() {
        AnomaliesTranslation anomaliesTranslationOne = new AnomaliesTranslation(2, "767326728736737", "456276526765", "71756254525", "ERR1-002", now,
                "EN");
        AnomaliesTranslation anomaliesTranslationTwo = new AnomaliesTranslation(2, "767326728736737", "456276526765", "71756254525", "ERR1-002", now,
                "FR");
        boolean equal = anomaliesTranslationOne.equals(anomaliesTranslationTwo);
        assertFalse(equal);
    }

    /**
     * Test to string anomalies translation.
     */
    @Test
    void testToStringAnomaliesTranslation() {
        assertEquals(
                "AnomaliesTranslation [id=2, vin=34898976456386364, bin1=753, bin2=726, errorMessage=ERR1-001, messageValue={34898976456386364}, dateError="
                        + anomaliesTranslation.getDateError() + ", lbltrad=En]",
                (anomaliesTranslation.toString()));
    }

}
