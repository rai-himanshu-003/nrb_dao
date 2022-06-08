/*
 * Creation : 19 Apr 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * The Class ModuleAndSubAssemblyDtoTest.
 */
@ContextConfiguration
class ModuleAndSubAssemblyDtoTest {

    /** The module and subassembly dto. */
    static ModuleAndSubassemblyDto moduleAndSubassemblyDto;

    /** The date formatter. */
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /** The production eng date. */
    static LocalDateTime productionEngDate = LocalDateTime.parse("14-02-2020 07:49:45", dateFormatter);

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        moduleAndSubassemblyDto = new ModuleAndSubassemblyDto();
        moduleAndSubassemblyDto.setComponentType("MODULE");
        moduleAndSubassemblyDto.setModuleMedal("MBCBLOT5BAT20");
        moduleAndSubassemblyDto.setSubMedal("RFCBLOT5BAT20");
        moduleAndSubassemblyDto.setReference("T46898376");
        moduleAndSubassemblyDto.setProductionDate(productionEngDate);
        moduleAndSubassemblyDto.setDateEngagement(productionEngDate);
        moduleAndSubassemblyDto.setFactoryCode("34-vf");
        moduleAndSubassemblyDto.setUpdateDate(new Date(02 - 02 - 2020));
    }

    /**
     * Test module battery data.
     */
    @Test
    void testModuleBatteryData() {
        assertNotNull(moduleAndSubassemblyDto.getComponentType());
        assertNotNull(moduleAndSubassemblyDto.getModuleMedal());
        assertNotNull(moduleAndSubassemblyDto.getSubMedal());
        assertNotNull(moduleAndSubassemblyDto.getReference());
        assertNotNull(moduleAndSubassemblyDto.getProductionDate());
        assertNotNull(moduleAndSubassemblyDto.getDateEngagement());
        assertNotNull(moduleAndSubassemblyDto.getFactoryCode());
        assertNotNull(moduleAndSubassemblyDto.getUpdateDate());

    }
}
