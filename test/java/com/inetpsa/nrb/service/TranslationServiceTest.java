/*
 * Creation : 4 Mar 2022
 */
package com.inetpsa.nrb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import com.inetpsa.nrb.dto.LanguageTransDto;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.dto.TranslationDto;
import com.inetpsa.nrb.model.LanguageEntity;
import com.inetpsa.nrb.model.TranslationEntity;
import com.inetpsa.nrb.model.TranslationEntityPk;
import com.inetpsa.nrb.repository.LanguageRepository;
import com.inetpsa.nrb.repository.TranslationRepository;

/**
 * The Class TranslationServiceTest.
 */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
class TranslationServiceTest {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(TranslationServiceTest.class);

    /** The translation service. */
    @Autowired
    TranslationService translationService;

    /** The translation repository. */
    @Autowired
    TranslationRepository translationRepository;

    /** The language repository. */
    @Autowired
    LanguageRepository languageRepository;

    /** The response dto. */
    ResponseDto responseDto;

    /** The translation entity. */
    TranslationEntity translationEntity;

    /** The translation dto. */
    TranslationDto translationDto;

    /** The language trans dto. */
    LanguageTransDto languageTransDto;

    /** The language entity. */
    LanguageEntity languageEntity;

    /** The translation entity pk. */
    TranslationEntityPk translationEntityPk;

    /**
     * Inits the.
     */
    @BeforeEach
    void init() {

        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("LBL-0097", "EN"));
        translationEntity.setLbltrad("Status");
        translationEntity.setTyptrad("4-LABEL");

        languageEntity = new LanguageEntity();
        languageEntity.setIdLang("EN");
        languageEntity.setDescr("English");
        translationRepository.save(translationEntity);
        languageRepository.save(languageEntity);

    }

    /**
     * Test language list.
     */
    @Test
    void testLanguageList() {
        List<LanguageTransDto> languageList = translationService.getLanguageList();
        assertNotNull(languageList);
        logger.info("test Translation getLanguageList in ServiceImpl");

    }

    /**
     * Test translation data.
     */
    @Test
    void testTranslationData() {
        List<TranslationDto> translationData = translationService.getTranslationData("EN", new String[] { "4-LABEL" });
        assertNotNull(translationData);
        logger.info("test Translation getTranslationData in ServiceImpl");

    }

    /**
     * Test update translation data.
     */
    @Test
    void testUpdateTranslationData() {

        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("LBL-0098", "EN"));
        translationEntity.setLbltrad("Sub-a medal");
        translationEntity.setTyptrad("4-LABEL");
        translationRepository.save(translationEntity);
        translationDto = new TranslationDto();
        translationDto.setLang("EN");
        translationDto.setType("4-LABEL");
        translationDto.setTradId("LBL-0098");
        translationDto.setLabel("Sub-a medall");
        responseDto = translationService.updateTranslationData(translationDto);
        assertEquals(true, responseDto.isMsg());
        logger.info("test Translation updateTranslationData in ServiceImpl");

    }

    /**
     * Testupdate translation import.
     */
    @Test
    void testupdateTranslationImport() {
        translationEntity = new TranslationEntity();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("LBL-0098", "EN"));
        translationEntity.setLbltrad("Sub-a medal");
        translationEntity.setTyptrad("4-LABEL");
        translationRepository.save(translationEntity);

        translationDto = new TranslationDto();
        translationDto.setLang("EN");
        translationDto.setType("4-LABEL");
        translationDto.setTradId("LBL-0098");
        translationDto.setLabel("Sub-a medall");

        boolean response = translationService.updateTranslationImport(translationDto);
        assertEquals(true, response);
        logger.info("test Translation updateTranslationImport in ServiceImpl");

    }
}
