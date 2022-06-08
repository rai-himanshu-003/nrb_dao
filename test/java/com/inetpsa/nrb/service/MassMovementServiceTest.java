/*
 * Creation : 14 Feb 2022
 */
package com.inetpsa.nrb.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.inetpsa.nrb.JpaConfig;
import com.inetpsa.nrb.dto.MassMvtFileDto;
import com.inetpsa.nrb.dto.MassMvtLineDto;
import com.inetpsa.nrb.dto.MassMvtSetDto;
import com.inetpsa.nrb.model.MassMvtData;
import com.inetpsa.nrb.model.MassMvtFile;
import com.inetpsa.nrb.model.MassMvtLine;
import com.inetpsa.nrb.model.MassMvtLinePk;
import com.inetpsa.nrb.model.MassMvtSet;
import com.inetpsa.nrb.repository.MMDataRepository;
import com.inetpsa.nrb.repository.MMFileRepository;
import com.inetpsa.nrb.repository.MMLineRepository;
import com.inetpsa.nrb.repository.MMSetRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class MassMovementServiceTest.
 */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
class MassMovementServiceTest {
    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(MassMovementServiceTest.class);

//    /** The mm service. */
//
//    MassMovementService mmService;

    /** The mass movement service impl */
    @Autowired
    // MassMovementServiceImpl massMovementServiceImpl;
    MassMovementService massMovementService;

    /** The mm file repository. */
    @Autowired
    MMFileRepository mmFileRepository;

    @Autowired
    MMLineRepository mmLineRepository;

    @Autowired
    MMSetRepository mmSetRepository;

    @Autowired
    MMDataRepository mmDataRepository;

    /** The list. */
    List<MassMvtFileDto> list;

    /** The list. */
    List<MassMvtLineDto> massMvtLineDtolist;
    String id_lang = "EN";

    MassMvtFile massMvtFile;
    MassMvtFileDto dto;
    MassMvtLine massMvtLine;
    MassMvtLinePk massMvtLinePk;
    MassMvtLineDto massMvtLineDto;
    MassMvtData massMvtData;
    MassMvtSet massMvtSet;

    /**
     * Inits the.
     */
    @BeforeEach
    void init() {
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
        mmFileRepository.save(massMvtFile);

        massMvtLine = new MassMvtLine();
        massMvtLinePk = new MassMvtLinePk();
        massMvtLine.setMassMvtLinePk(new MassMvtLinePk((long) 1, (long) 1));
        massMvtLine.setActionType("CID");
        massMvtLine.setDataValue("101");
        massMvtLine.setIdData("34760E0000172");
        massMvtLine.setTranslationStatus("LBL-0052");
        massMvtLine.setTypeData("BIN");
        massMvtData = new MassMvtData();
        massMvtData.setDataGroup((long) 1);
        massMvtData.setField("TABLE_FILED");
        massMvtData.setFormat("STRING");
        massMvtData.setNbChar("=LENGTH");
        massMvtData.setSettings("<>DEFAULT_FORB_CHAR_LIST; BEGIN_BIN");
        massMvtData.setTypeData("BIN");
        mmLineRepository.save(massMvtLine);
        mmDataRepository.save(massMvtData);

        massMvtSet = new MassMvtSet();
        massMvtSet.setIdSetting("MAX_LINE_EXCEL_MM");
        massMvtSet.setLblSetting("Max number of Excel lines file for mass movements");
        massMvtSet.setValueSetting("50");
        mmSetRepository.save(massMvtSet);

    }

    /**
     * Test mass movement line data
     */
    @Test
    void testGetSettingbyId() {

        String id = "MAX_LINE_EXCEL_MM";
        MassMvtSetDto massSetDto = massMovementService.getSettingbyId(id);
        assertNotNull(massSetDto);
        logger.info("test mass movement set getAllSetting in ServiceImpl");

    }

    /**
     * Test mass movement line data
     */
    @Test
    void testGetAllSetting() {
        massMvtSet = new MassMvtSet();
        massMvtSet.setIdSetting("MAX_LINE_EXCEL_MM");
        massMvtSet.setLblSetting("Max number of Excel lines file for mass movements");
        massMvtSet.setValueSetting("50");

        List<MassMvtSetDto> massSetDto = massMovementService.getAllSetting();
        assertNotNull(massSetDto);
        logger.info("test mass movement set getAllSetting in ServiceImpl");

    }

    /**
     * Test addupdate mmfile
     */
    @Test
    void testAddUpdateMMFile() {
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
        mmFileRepository.save(massMvtFile);

        dto = new MassMvtFileDto();
        dto.setIdFile(Long.valueOf("1"));
        dto.setFileName("Test_MM_FILE");
        dto.setDateCreation(new Timestamp(new Date().getTime()));
        dto.setDateStart(new Timestamp(new Date().getTime()));
        dto.setDateEnd(new Timestamp(new Date().getTime()));
        dto.setNumberOk(0);
        dto.setNumberKo(0);
        dto.setTranslationStatus("LBL-0052");
        dto.setUserFile("TEST_USER");

        massMvtFile = massMovementService.addUpdateMMFile(massMvtFile);
        assertNotNull(massMvtFile);

    }

    /**
     * Test addupdate mmline
     */
    @Test
    void testAddUpdateMMLine() {
        massMvtLine = new MassMvtLine();
        massMvtLinePk = new MassMvtLinePk();
        massMvtLine.setMassMvtLinePk(new MassMvtLinePk((long) 1, (long) 1));
        massMvtLine.setActionType("CID");
        massMvtLine.setDataValue("101");
        massMvtLine.setIdData("34760E0000172");
        massMvtLine.setTranslationStatus("LBL-0052");
        massMvtLine.setTypeData("BIN");
        mmLineRepository.save(massMvtLine);
        List l = new ArrayList<MassMvtLine>();
        l.add(massMvtLine);
        massMovementService.addUpdateMMLine(l);
        assertNotNull(massMvtLine);

    }

    /**
     * Test mass movement line data
     */
    @Test
    void testGetMMLineList() {
        massMvtLine = new MassMvtLine();
        massMvtLinePk = new MassMvtLinePk();
        massMvtLine.setMassMvtLinePk(new MassMvtLinePk((long) 1, (long) 1));
        massMvtLine.setActionType("CID");
        massMvtLine.setDataValue("101");
        massMvtLine.setIdData("34760E0000172");
        massMvtLine.setTranslationStatus("LBL-0052");
        massMvtLine.setTypeData("BIN");

        massMvtData = new MassMvtData();
        massMvtData.setDataGroup((long) 1);
        massMvtData.setField("TABLE_FILED");
        massMvtData.setFormat("STRING");
        massMvtData.setNbChar("=LENGTH");
        massMvtData.setSettings("<>DEFAULT_FORB_CHAR_LIST; BEGIN_BIN");

        long fileId = 1;
        List<MassMvtLineDto> massMDto = massMovementService.getMMLineList(fileId);
        assertNotNull(massMDto);
        logger.info("test mass movement  getMassMpvementLineData in ServiceImpl");

    }

    /**
     * Test mass movement validate line data
     */
    @Test
    void testGetValidatedMMLineList() {
        massMvtLine = new MassMvtLine();
        massMvtLinePk = new MassMvtLinePk();
        massMvtLine.setMassMvtLinePk(new MassMvtLinePk((long) 2, (long) 2));
        massMvtLine.setActionType("CID");
        massMvtLine.setDataValue("101");
        massMvtLine.setIdData("34760E0000172");
        massMvtLine.setTranslationStatus("WAR2-%");
        massMvtLine.setTypeData("BIN");
        mmLineRepository.save(massMvtLine);

        List<MassMvtLineDto> masslineDto = massMovementService.getValidatedMMLineList();
        assertNotNull(masslineDto);
        logger.info("test Mass Movement getValidatedMMLineList in ServiceImpl");

    }

    /**
     * Test mass movement File data.
     */
    @Test
    void testmassMovementFileData() {
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
        mmFileRepository.save(massMvtFile);

        String id_lang = "EN";
        List<MassMvtFileDto> massMvtFileDto = massMovementService.getMassMovementFileData(id_lang);
        assertNotNull(massMvtFileDto);
        logger.info("test mass movement getMassMovementFileData in service");
    }

    /**
     * Test mass movement update mm line status.
     */
    @Test
    void testUpdateMMLineStatus() {
        massMvtLine = new MassMvtLine();
        massMvtLinePk = new MassMvtLinePk();
        massMvtLine.setMassMvtLinePk(new MassMvtLinePk((long) 1, (long) 1));
        massMvtLine.setActionType("CID");
        massMvtLine.setDataValue("101");
        massMvtLine.setIdData("34760E0000172");
        massMvtLine.setTranslationStatus("LBL-0052");
        massMvtLine.setTypeData("BIN");

        mmLineRepository.save(massMvtLine);
        String status = "LBL-0052";
        int mMvtLineDto = massMovementService.updateMMLineStatus(status);
        assertNotNull(mMvtLineDto);
        logger.info("test mass movement updateMMLineStatus in service");
    }

    /**
     * Test mass movement Line data by file id.
     */
    @Test
    void testGetMMLineListByFileId() {
        massMvtLine = new MassMvtLine();
        massMvtLine.setMassMvtLinePk(new MassMvtLinePk((long) 1, (long) 1));
        massMvtLine.setActionType("CID");
        massMvtLine.setTypeData("SS_ENS");
        massMvtLine.setIdData("34CBLOT4BAT94");
        massMvtLine.setDataValue("VR3UHZKXZLT067519");
        massMvtLine.setTranslationStatus("ERR2-016");

        long fileId = 1;
        String id_lang = "EN";
        List<MassMvtLineDto> massMvtLileDto = massMovementService.getMMLineListByFileId(fileId, id_lang);
        assertTrue(massMvtLileDto.isEmpty());
    }

    /**
     * Test mass movement File data.
     */
    @Test
    void testGetMMLineListByFileIdNull() {
        massMvtLine = new MassMvtLine();
        massMvtLine.setMassMvtLinePk(new MassMvtLinePk((long) 1, (long) 1));
        massMvtLine.setActionType("CID");
        massMvtLine.setTypeData("SS_ENS");
        massMvtLine.setIdData("34CBLOT4BAT94");
        massMvtLine.setDataValue("VR3UHZKXZLT067519");
        massMvtLine.setTranslationStatus("ERR2-016");

        long fileId = 1;
        String id_lang = "EN";
        List<MassMvtLineDto> massMvtLileDto = massMovementService.getMMLineListByFileId(fileId, id_lang);
        assertNotNull(massMvtLileDto);
    }

}
