/*
 * Creation : 14 Mar 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * The Class BatteryDtoTest.
 */
@ContextConfiguration
class BatteryDtoTest {

    /** The batterydto. */
    static BatteryDto batterydto;

    /** The now. */
    static Timestamp now = new Timestamp(new java.util.Date().getTime());

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        batterydto = new BatteryDto();
        batterydto.setBin("34CBLOT4BAT93");
        batterydto.setFactoryCode("VF-");
        batterydto.setLang("EN");
        batterydto.setStatus("1-Produced");
        batterydto.setExtFromDate(now);
        batterydto.setRefrence("9876543");
        batterydto.setProdDate("20/3/2004");
        batterydto.setExtToDate(now);
        batterydto.setBinOrder("asc");
        batterydto.setFactoryCodeOrder("desc");
        batterydto.setProdDateOrder("desc");
        batterydto.setStatusOrder("asc");
        batterydto.setRefrenceOrder("asc");
        batterydto.setId("23");

    }

    /**
     * Test anomalies data.
     */
    @Test
    void testAnomaliesData() {

        assertEquals("34CBLOT4BAT93", batterydto.getBin());
        assertNotNull(batterydto.getBinOrder());
        assertNotNull(batterydto.getFactoryCode());
        assertNotNull(batterydto.getFactoryCodeOrder());
        assertNotNull(batterydto.getExtToDate());
        assertNotNull(batterydto.getExtFromDate());
        assertNotNull(batterydto.getLang());
        assertNotNull(batterydto.getProdDate());
        assertNotNull(batterydto.getStatus());
        assertNotNull(batterydto.getStatusOrder());
        assertNotNull(batterydto.getRefrence());
        assertNotNull(batterydto.getRefrenceOrder());
        assertNotNull(batterydto.getProdDateOrder());
        assertNotNull(batterydto.getProdDateOrder());
        assertNotNull(batterydto.getId());

    }

    /**
     * Test to string.
     */
    @Test
    void testToString() {
        assertEquals("BatteryDto [id=23, bin=34CBLOT4BAT93, factoryCode=VF-, prodDate=20/3/2004, refrence=9876543, status=1-Produced, extFromDate="
                + batterydto.getExtFromDate() + ", extToDate=" + batterydto.getExtToDate() + "]", (batterydto.toString()));
    }
}
