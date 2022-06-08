/*
 * Creation : 14 Feb 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.inetpsa.nrb.model.MassMvtFile;

// TODO: Auto-generated Javadoc
/**
 * The Class MassMvtFileDtoTest.
 */
class MassMvtFileDtoTest {

    /** The mass mvt file dto. */
    static MassMvtFileDto massMvtFileDto;

    /** The mass mvt file. */
    static MassMvtFile massMvtFile;

    /**
     * Setup.
     */
    @BeforeAll
    static void setup() {
        massMvtFileDto = new MassMvtFileDto();
        massMvtFileDto.setIdFile(Long.valueOf("1"));
        massMvtFileDto.setFileName("Test_MM_FILE");
        massMvtFileDto.setDateCreation(new Timestamp(new Date().getTime()));
        massMvtFileDto.setDateStart(new Timestamp(new Date().getTime()));
        massMvtFileDto.setDateEnd(new Timestamp(new Date().getTime()));
        massMvtFileDto.setNumberOk(0);
        massMvtFileDto.setNumberKo(0);
        massMvtFileDto.setTranslationStatus("LBL-0052");
        massMvtFileDto.setUserFile("TEST_USER");
        massMvtFileDto.setProccessingTime("11");
        massMvtFileDto.setNumberOfLines(111);
        massMvtFile = new MassMvtFile();
    }

    /**
     * Test data.
     */
    @Test
    void testData() {
        assertNotNull(massMvtFileDto.getIdFile());
        assertNotNull(massMvtFileDto.getFileName());
        assertNotNull(massMvtFileDto.getDateCreation());
        assertNotNull(massMvtFileDto.getDateStart());
        assertNotNull(massMvtFileDto.getDateEnd());
        assertNotNull(massMvtFileDto.getNumberOk());
        assertNotNull(massMvtFileDto.getNumberOk());
        assertNotNull(massMvtFileDto.getTranslationStatus());
        assertNotNull(massMvtFileDto.getUserFile());
        assertNotNull(massMvtFileDto.getProccessingTime());
        assertNotNull(massMvtFileDto.getNumberOfLines());

    }

    /**
     * Test mass movement data.
     */
    @Test
    void testMassMovementData() {
        MassMvtFileDto dto = new MassMvtFileDto(massMvtFile.convertToEntity(massMvtFileDto));
        assertNotNull(dto);
    }

    /**
     * test toString data
     */
    @Test
    void testToStringData() {
        assertEquals("MassMvtFileDto [idFile=1, fileName=Test_MM_FILE, dateCreation=" + massMvtFileDto.getDateCreation() + ", dateStart="
                + massMvtFileDto.getDateStart() + ", dateEnd=" + massMvtFileDto.getDateEnd()
                + ", numberOk=0, numberKo=0, userFile=TEST_USER, translationStatus=LBL-0052, proccessingTime=11]", massMvtFileDto.toString());

    }

}
