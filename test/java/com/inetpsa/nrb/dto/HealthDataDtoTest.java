/*
 * Creation : 19 Apr 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * class HealthDataDtoTest
 */
@ContextConfiguration
class HealthDataDtoTest {
    /** class HealthDataDto */
    static HealthDataDto healthDataDto;

    /**
     * sets the data
     */
    @BeforeAll
    static void setup() {
        healthDataDto = new HealthDataDto();
        healthDataDto.setMac("3.524");
        healthDataDto.setMic("3.000");
        healthDataDto.setRinsulation("60000");
        healthDataDto.setRinternal("90");
        healthDataDto.setSoc("21");
        healthDataDto.setSoh("103");
        healthDataDto.setT10("381");
        healthDataDto.setTat("18");
    }

    /**
     * test the data
     */
    @Test
    void testData() {
        assertNotNull(healthDataDto.getMac());
        assertNotNull(healthDataDto.getMic());
        assertNotNull(healthDataDto.getRinsulation());
        assertNotNull(healthDataDto.getRinternal());
        assertNotNull(healthDataDto.getSoc());
        assertNotNull(healthDataDto.getSoh());
        assertNotNull(healthDataDto.getT10());
        assertNotNull(healthDataDto.getTat());
    }

    /**
     * test toString data
     */
    @Test
    void testToStrinngData() {
        assertEquals("HealthDataDto [soh=103, soc=21, mic=3.000, mac=3.524, rinsulation=60000, rinternal=90, t10=381, tat=18]",
                healthDataDto.toString());
    }

}
