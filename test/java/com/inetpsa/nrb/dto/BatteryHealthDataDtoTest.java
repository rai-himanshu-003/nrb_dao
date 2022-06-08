/*
 * Creation : 19 Apr 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * The Class BatteryHealthDataDtoTest.
 */
@ContextConfiguration
class BatteryHealthDataDtoTest {

    /** The battery health data dto. */
    static BatteryHealthDataDto batteryHealthDataDto;

    /** The battery health data dto 2. */
    static BatteryHealthDataDto batteryHealthDataDto2;

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        batteryHealthDataDto = new BatteryHealthDataDto();
        batteryHealthDataDto.setSoc("30");
        batteryHealthDataDto.setSoh("105");
        batteryHealthDataDto.setRinsulation("30000");
        batteryHealthDataDto.setRinternal("70");
        batteryHealthDataDto.setMac("3000");
        batteryHealthDataDto.setMic("3.23");
        batteryHealthDataDto.setT10("381");
        batteryHealthDataDto.setTat("18");
        batteryHealthDataDto.setUserUpdate("CORBET");
        batteryHealthDataDto.setDateUpdate(new Date(14 - 02 - 20202));
        batteryHealthDataDto2 = new BatteryHealthDataDto(batteryHealthDataDto);
    }

    /**
     * Test health battery data.
     */
    @Test
    void testHealthBatteryData() {
        assertNotNull(batteryHealthDataDto.getSoc());
        assertNotNull(batteryHealthDataDto.getSoh());
        assertNotNull(batteryHealthDataDto.getRinsulation());
        assertNotNull(batteryHealthDataDto.getRinternal());
        assertNotNull(batteryHealthDataDto.getMac());
        assertNotNull(batteryHealthDataDto.getMic());
        assertNotNull(batteryHealthDataDto.getT10());
        assertNotNull(batteryHealthDataDto.getTat());
        assertNotNull(batteryHealthDataDto.getUserUpdate());
        assertNotNull(batteryHealthDataDto.getDateUpdate());
    }

    /**
     * Test copy battery health data.
     */
    @Test
    void testCopyBatteryHealthData() {
        assertNotNull(batteryHealthDataDto2.getSoc());
        assertNotNull(batteryHealthDataDto2.getSoh());
        assertNotNull(batteryHealthDataDto2.getRinsulation());
        assertNotNull(batteryHealthDataDto2.getRinternal());
        assertNotNull(batteryHealthDataDto2.getMac());
        assertNotNull(batteryHealthDataDto2.getMic());
        assertNotNull(batteryHealthDataDto2.getT10());
        assertNotNull(batteryHealthDataDto2.getTat());
        assertNotNull(batteryHealthDataDto2.getUserUpdate());
        assertNotNull(batteryHealthDataDto2.getDateUpdate());

    }

}
