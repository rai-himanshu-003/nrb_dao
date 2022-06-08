/*
 * Creation : 31 March 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.inetpsa.nrb.model.MassMvtSet;

class MassMvtSetDtoTest {

    /** The mass mvt set dto. */
    static MassMvtSetDto massMvtSetDto;

    /** The mass mvt set. */
    static MassMvtSet massMvtSet;

    /**
     * Setup.
     */
    @BeforeAll
    static void setup() {
        massMvtSetDto = new MassMvtSetDto();
        massMvtSetDto.setIdSetting("MAX_LINE_EXCEL_MM");
        massMvtSetDto.setLblSetting("Max number of Excel lines file for mass movements");
        massMvtSetDto.setValueSetting("50");
    }

    /**
     * Test mass movement set.
     */
    @Test
    void testData() {
        assertNotNull(massMvtSetDto.getIdSetting());
        assertNotNull(massMvtSetDto.getLblSetting());
        assertNotNull(massMvtSetDto.getValueSetting());
    }

    /**
     * test toString data
     */
    @Test
    void testToStringData() {
        assertEquals("MassMvtSetDto [idSetting=MAX_LINE_EXCEL_MM, lblSetting=Max number of Excel lines file for mass movements, valueSetting=50]",
                massMvtSetDto.toString());
    }
}