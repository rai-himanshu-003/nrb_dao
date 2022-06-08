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
 * The Class ModuleHistoryDtoTest.
 */
@ContextConfiguration
class ModuleHistoryDtoTest {

    /** The battery module history dto. */
    static BatteryModuleHistoryDto batteryModuleHistoryDto;

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        batteryModuleHistoryDto = new BatteryModuleHistoryDto();
        batteryModuleHistoryDto.setActionType("C");
        batteryModuleHistoryDto.setCategory("module");
        batteryModuleHistoryDto.setSubAssemblyId("RAFTYUSND123");
        batteryModuleHistoryDto.setOldValue("RAFTYUSND122");
        batteryModuleHistoryDto.setNewValue("RAFTYUSND123");
        batteryModuleHistoryDto.setUpdateUser("CORVET");
        batteryModuleHistoryDto.setUpdateDate(new Date(01 - 02 - 2020));

    }

    /**
     * Test module history data.
     */
    @Test
    void testModuleHistoryData() {
        assertNotNull(batteryModuleHistoryDto.getActionType());
        assertNotNull(batteryModuleHistoryDto.getCategory());
        assertNotNull(batteryModuleHistoryDto.getSubAssemblyId());
        assertNotNull(batteryModuleHistoryDto.getOldValue());
        assertNotNull(batteryModuleHistoryDto.getNewValue());
        assertNotNull(batteryModuleHistoryDto.getUpdateUser());
        assertNotNull(batteryModuleHistoryDto.getUpdateDate());
    }

}