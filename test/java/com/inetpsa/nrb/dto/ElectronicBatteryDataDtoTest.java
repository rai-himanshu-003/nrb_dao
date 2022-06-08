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
 * The Class ElectronicBatteryDataDtoTest.
 */
@ContextConfiguration
class ElectronicBatteryDataDtoTest {

    /** The electronic battery data dto. */
    static ElectronicBatteryDataDto electronicBatteryDataDto;

    /** The electronic battery data dto 2. */
    static ElectronicBatteryDataDto electronicBatteryDataDto2;

    /** The date formatter. */
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /** The production date. */
    static LocalDateTime productionDate = LocalDateTime.parse("14-02-2020 07:49:45", dateFormatter);

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        electronicBatteryDataDto = new ElectronicBatteryDataDto();
        electronicBatteryDataDto.setSerialNumber("LRT453");
        electronicBatteryDataDto.setRefSoft("NRI8766");
        electronicBatteryDataDto.setRefHard("ABC");
        electronicBatteryDataDto.setDateProduction(productionDate);
        electronicBatteryDataDto.setSuppliercode("LKDIR4637256290HUY");
        electronicBatteryDataDto.setRefCal("456");
        electronicBatteryDataDto.setUserUpdate("CORVET");
        electronicBatteryDataDto.setDateUpdate(new Date(14 - 02 - 20202));
        electronicBatteryDataDto2 = new ElectronicBatteryDataDto(electronicBatteryDataDto);
    }

    /**
     * Test electronic battery data.
     */
    @Test
    void testElectronicBatteryData() {
        assertNotNull(electronicBatteryDataDto.getSerialNumber());
        assertNotNull(electronicBatteryDataDto.getRefSoft());
        assertNotNull(electronicBatteryDataDto.getRefHard());
        assertNotNull(electronicBatteryDataDto.getDateProduction());
        assertNotNull(electronicBatteryDataDto.getSuppliercode());
        assertNotNull(electronicBatteryDataDto.getRefCal());
        assertNotNull(electronicBatteryDataDto.getUserUpdate());
        assertNotNull(electronicBatteryDataDto.getDateUpdate());
    }

    /**
     * Test copy electronic battery data.
     */
    @Test
    void testCopyElectronicBatteryData() {
        assertNotNull(electronicBatteryDataDto2.getSerialNumber());
        assertNotNull(electronicBatteryDataDto2.getRefSoft());
        assertNotNull(electronicBatteryDataDto2.getRefHard());
        assertNotNull(electronicBatteryDataDto2.getDateProduction());
        assertNotNull(electronicBatteryDataDto2.getSuppliercode());
        assertNotNull(electronicBatteryDataDto2.getRefCal());
        assertNotNull(electronicBatteryDataDto2.getUserUpdate());
        assertNotNull(electronicBatteryDataDto2.getDateUpdate());
    }

}
