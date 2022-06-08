/*
 * Creation : 18 Apr 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * The Class GeneralBatteryDataDtoTest.
 */
@ContextConfiguration
class GeneralBatteryDataDtoTest {

    /** The general battery data dto. */
    static GeneralBatteryDataDto generalBatteryDataDto;

    /** The general battery data dto 2. */
    static GeneralBatteryDataDto generalBatteryDataDto2;

    /** The date formatter. */
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        generalBatteryDataDto = new GeneralBatteryDataDto();

        generalBatteryDataDto.setId(23L);
        generalBatteryDataDto.setReference("9840599380");
        generalBatteryDataDto.setDescription2("BATTERIE EP2JO VC65MF");
        generalBatteryDataDto.setVin("123456789101");
        generalBatteryDataDto.setUpdateDate(new Timestamp(new java.util.Date().getTime()));
        generalBatteryDataDto.setUpdateUser("CORVET");
        generalBatteryDataDto.setFactoryCode("VF-");

        LocalDateTime productionDate = LocalDateTime.parse("14-02-2020 07:49:45", dateFormatter);
        generalBatteryDataDto.setDateProduction(productionDate);
        LocalDateTime engagementDate = LocalDateTime.parse("14-02-2020 07:49:45", dateFormatter);
        generalBatteryDataDto.setDateEngagement(engagementDate);
        generalBatteryDataDto.setStatus("4-To refurbish");
        generalBatteryDataDto.setCodeSgr("FV9-");
        generalBatteryDataDto.setShedCode("PKBA1");
        generalBatteryDataDto2 = new GeneralBatteryDataDto(generalBatteryDataDto);
    }

    /**
     * Test general battery data.
     */
    @Test
    void testGeneralBatteryData() {
        assertNotNull(generalBatteryDataDto.getId());
        assertNotNull(generalBatteryDataDto.getReference());
        assertNotNull(generalBatteryDataDto.getDescription2());
        assertNotNull(generalBatteryDataDto.getVin());
        assertNotNull(generalBatteryDataDto.getUpdateDate());
        assertNotNull(generalBatteryDataDto.getUpdateUser());
        assertNotNull(generalBatteryDataDto.getFactoryCode());
        assertNotNull(generalBatteryDataDto.getDateProduction());
        assertNotNull(generalBatteryDataDto.getDateEngagement());
        assertNotNull(generalBatteryDataDto.getStatus());
        assertNotNull(generalBatteryDataDto.getCodeSgr());
        assertNotNull(generalBatteryDataDto.getShedCode());

    }

    /**
     * Test copy general battery data.
     */
    @Test
    void testCopyGeneralBatteryData() {
        assertNotNull(generalBatteryDataDto2.getId());
        assertNotNull(generalBatteryDataDto2.getReference());
        assertNotNull(generalBatteryDataDto2.getDescription2());
        assertNotNull(generalBatteryDataDto2.getVin());
        assertNotNull(generalBatteryDataDto2.getUpdateDate());
        assertNotNull(generalBatteryDataDto2.getUpdateUser());
        assertNotNull(generalBatteryDataDto2.getFactoryCode());
        assertNotNull(generalBatteryDataDto2.getDateProduction());
        assertNotNull(generalBatteryDataDto2.getDateEngagement());
        assertNotNull(generalBatteryDataDto2.getStatus());
        assertNotNull(generalBatteryDataDto2.getCodeSgr());
        assertNotNull(generalBatteryDataDto2.getShedCode());

    }

}
