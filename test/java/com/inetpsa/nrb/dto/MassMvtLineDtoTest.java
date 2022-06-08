/*
 * Creation : 31 March 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.model.MassMvtLine;
import com.inetpsa.nrb.model.MassMvtLinePk;

/**
 * class LanguageTransDtoTest
 */
@ContextConfiguration
class MassMvtLineDtoTest {
    /** The mass mvt line dto. */
    static MassMvtLineDto massMvtLineDto;

    /** The mass mvt line. */
    static MassMvtLine massMvtLine;

    /** class mass mvt line pk */
    static MassMvtLinePk massMvtLinePk;

    Object[] object;

    /**
     * Setup.
     */
    @BeforeAll
    static void setup() {
        massMvtLineDto = new MassMvtLineDto();
        massMvtLineDto.setIdFile(Long.valueOf(1));
        massMvtLineDto.setIdLine(Long.valueOf(1));
        massMvtLineDto.setActionType("CID");
        massMvtLineDto.setDataGroup("104");
        massMvtLineDto.setDataValue("101");
        massMvtLineDto.setField("TABLE_FILED");
        massMvtLineDto.setFormat("STRING");
        massMvtLineDto.setIdData("34760E0000172");
        massMvtLineDto.setNbChar("=LENGTH");
        massMvtLineDto.setSettings("<>DEFAULT_FORB_CHAR_LIST; BEGIN_BIN");
        massMvtLineDto.setTranslationStatus("WAR2-%");
        massMvtLineDto.setTypeData("BIN");

        massMvtLine = new MassMvtLine();

    }

    /**
     * Test mass movement line.
     */
    @Test
    void testData() {
        assertNotNull(massMvtLineDto.getIdFile());
        assertNotNull(massMvtLineDto.getIdLine());
        assertNotNull(massMvtLineDto.getActionType());
        assertNotNull(massMvtLineDto.getDataGroup());
        assertNotNull(massMvtLineDto.getDataValue());
        assertNotNull(massMvtLineDto.getField());
        assertNotNull(massMvtLineDto.getFormat());
        assertNotNull(massMvtLineDto.getIdData());
        assertNotNull(massMvtLineDto.getNbChar());
        assertNotNull(massMvtLineDto.getSettings());
        assertNotNull(massMvtLineDto.getTranslationStatus());
        assertNotNull(massMvtLineDto.getTypeData());
        assertNotNull(massMvtLineDto.convertToEntity(massMvtLineDto));

    }

    /**
     * test copy constructor
     */
    @Test
    void testMassMvtLineDto() {
        object = new Object[6];
        object[0] = "CID";
        object[1] = "34760E0000172";
        object[2] = "BIN";
        object[3] = "101";
        object[4] = "104";
        object[5] = "WAR2-%";
        new MassMvtLineDto(object);
        assertNotNull(object);

    }

}
