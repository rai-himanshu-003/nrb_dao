/*
 * Creation : 14 Feb 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.dto.MassMvtFileDto;
import com.inetpsa.nrb.dto.MassMvtLineDto;
import com.inetpsa.nrb.dto.MassMvtSetDto;

// TODO: Auto-generated Javadoc
/**
 * The Class MassMvtFileEntityTest.
 */
@ContextConfiguration
class MassMvtFileEntityTest {

    /** The mass mvt file. */
    static MassMvtFile massMvtFile;

    /** The mass mvt line. */
    static MassMvtLine massMvtLine;

    static MassMvtLinePk massMvtLinePk;

    /** The mass mvt data. */
    static MassMvtData massMvtData;

    /** The mass mvt set. */
    static MassMvtSet massMvtSet;

    /** The mass mvt file dto. */
    static MassMvtFileDto massMvtFileDto;

    /** the mass mvt line dto. */
    static MassMvtLineDto massMvtLineDto;

    /** the mass mvt set dto. */
    static MassMvtSetDto massMvtSetDto;

    /** The now. */
    // Timestamp now = new Timestamp(new java.util.Date().getTime());
    private static final Timestamp now = null;

    /**
     * Setup.
     */
    @BeforeAll
    static void setup() {
        massMvtFile = new MassMvtFile();
        massMvtFile.setIdFile(Long.valueOf("1"));
        massMvtFile.setFileName("Test_MM_FILE");
        massMvtFile.setDateCreation(new Timestamp(new Date().getTime()));
        massMvtFile.setDateStart(new Timestamp(new Date().getTime()));
        massMvtFile.setDateEnd(new Timestamp(new Date().getTime()));
        massMvtFile.setNumberOk(0);
        massMvtFile.setNumberKo(0);
        massMvtFile.setTranslationStatus("LBL-0052");
        massMvtFile.setUserFile("TEST_USER");

        massMvtLine = new MassMvtLine();
        massMvtLinePk = new MassMvtLinePk();
        massMvtLine.setMassMvtLinePk(new MassMvtLinePk((long) 1, (long) 1));
        massMvtLine.setActionType("CID");
        massMvtLine.setDataValue("101");
        massMvtLine.setIdData("34760E0000172");
        massMvtLine.setTranslationStatus("LBL-0052");
        massMvtLine.setTypeData("BIN");
        massMvtLinePk.setIdFile((long) 1);
        massMvtLinePk.setIdLine((long) 1);

        massMvtData = new MassMvtData();
        massMvtData.setDataGroup((long) 1);
        massMvtData.setField("TABLE_FILED");
        massMvtData.setFormat("STRING");
        massMvtData.setNbChar("=LENGTH");
        massMvtData.setSettings("<>DEFAULT_FORB_CHAR_LIST; BEGIN_BIN");

        massMvtSet = new MassMvtSet();
        massMvtSet.setIdSetting("MAX_LINE_EXCEL_MM");
        massMvtSet.setLblSetting("Max number of Excel lines file for mass movements");
        massMvtSet.setValueSetting("50");

        // dto value set
        massMvtSetDto = new MassMvtSetDto();
        massMvtSetDto.setIdSetting("MAX_LINE_EXCEL_MM");
        massMvtSetDto.setLblSetting("Max number of Excel lines file for mass movements");
        massMvtSetDto.setValueSetting("50");

        massMvtFileDto = new MassMvtFileDto();
        massMvtFileDto.setIdFile(Long.valueOf("1"));
        massMvtFileDto.setFileName("Test_MM_FILE");
        massMvtFileDto.setDateCreation(new Timestamp(new Date().getTime()));
        massMvtFileDto.setDateStart(new Timestamp(new Date().getTime()));
        massMvtFileDto.setDateEnd(new Timestamp(new Date().getTime()));
        massMvtFileDto.setNumberKo(0);
        massMvtFileDto.setNumberOk(0);
        massMvtFileDto.setNumberOfLines(123);
        // massMvtFileDto.setProccessingTime("");
        massMvtFileDto.setUserFile("TEST_USER");
        massMvtFileDto.setTranslationStatus("LBL-0052");
    }

    /**
     * Test data.
     */
    @Test
    void testData() {
        assertNotNull(massMvtFile.getIdFile());
        assertNotNull(massMvtFile.getFileName());
        assertNotNull(massMvtFile.getDateCreation());
        assertNotNull(massMvtFile.getDateStart());
        assertNotNull(massMvtFile.getDateEnd());
        assertNotNull(massMvtFile.getNumberOk());
        assertNotNull(massMvtFile.getNumberOk());
        assertNotNull(massMvtFile.getTranslationStatus());
        assertNotNull(massMvtFile.getUserFile());

        assertNotNull(massMvtLine.getMassMvtLinePk().getIdFile());
        assertNotNull(massMvtLine.getMassMvtLinePk().getIdLine());
        assertNotNull(massMvtLine.getActionType());
        assertNotNull(massMvtLine.getDataValue());
        assertNotNull(massMvtLine.getIdData());
        assertNotNull(massMvtLine.getTranslationStatus());
        assertNotNull(massMvtLine.getTypeData());
        assertNotNull(massMvtLine.convertToEntity(massMvtLine));

        assertNotNull(massMvtData.getDataGroup());
        assertNotNull(massMvtData.getField());
        assertNotNull(massMvtData.getFormat());
        assertNotNull(massMvtData.getNbChar());
        assertNotNull(massMvtData.getSettings());
        // assertNotNull(massMvtData.getTypeData());
        assertNotNull(massMvtSet.getIdSetting());
        assertNotNull(massMvtSet.getLblSetting());
        assertNotNull(massMvtSet.getValueSetting());

    }

    /**
     * Testconvert to entity.
     */
    @Test
    void testconvertToEntity() {
        MassMvtFileDto dto = new MassMvtFileDto(massMvtFile.convertToEntity(massMvtFileDto));
        massMvtLine.toString();
        assertNotNull(dto);
    }

}
