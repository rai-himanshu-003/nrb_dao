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
 * class MassMvtValidationDtoTest
 */
@ContextConfiguration
class MassMvtValidationDtoTest {
    /** class MassMvtValidationDto */
    static MassMvtValidationDto massMvtValidationDto;

    /**
     * sets the data
     */
    @BeforeAll
    static void setup() {
        massMvtValidationDto = new MassMvtValidationDto();
        massMvtValidationDto.setModule("26LOT400084");
        massMvtValidationDto.setOrgane("34");
        massMvtValidationDto.setReference("9998856663");
        massMvtValidationDto.setStatus("1");
        massMvtValidationDto.setVin("VR1ATTENTKW039309");
    }

    /**
     * test the data
     */
    @Test
    void testData() {
        assertNotNull(massMvtValidationDto.getModule());
        assertNotNull(massMvtValidationDto.getOrgane());
        assertNotNull(massMvtValidationDto.getReference());
        assertNotNull(massMvtValidationDto.getStatus());
        assertNotNull(massMvtValidationDto.getVin());
    }

    /**
     * test toString data
     */
    @Test
    void testToStringData() {
        assertEquals("MassMvtValidationDto [organe=34, reference=9998856663, status=1, vin=VR1ATTENTKW039309, module=26LOT400084]",
                massMvtValidationDto.toString());
    }

}
