/*
 * Creation : 19 Feb 2022
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

/** class LanguageServiceTest */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
class LanguageServiceTest {
    /** constant logger */
    public static final Logger logger = LoggerFactory.getLogger(LanguageServiceTest.class);
    /** the Language service */
    @Autowired
    LanguageService languageService;

    /** the language repository */
    @Autowired
    LanguageRepository languageRepository;

    /** the translation repository */
    @Autowired
    TranslationRepository translationRepository;

    /** the response dto */
    ResponseDto responseDto;

    /** the LanguageTransDto */
    LanguageTransDto languageTransDto;
    LanguageEntity languageEntity;

    /** the translation entity */
    TranslationEntity translationEntity;
    TranslationDto translationDto;

    /**
     * Inits the.
     */
    @BeforeEach
    void init() {
        languageEntity = new LanguageEntity();
        languageEntity.setIdLang("EN");
        languageEntity.setDescr("English");

        languageRepository.save(languageEntity);

    }

    /** test gets the language data list */
    @Test
    void testGetLanguageDataList() {
        List<LanguageTransDto> languageTransDto = languageService.getLanguageData();
        assertNotNull(languageTransDto);
        logger.info("test language list in getLanguageData in ServiceImpl");
    }

    /** test deleted language data */
    @Test
    void testDeleteLanguageData() {
        languageEntity.setIdLang("EN");
        languageEntity.setDescr("English");

        languageRepository.save(languageEntity);
        String lang = languageRepository.findAll().get(0).getIdLang();
        responseDto = languageService.deleteLanguageData(lang);

        assertNotNull(responseDto.getMessage());
        logger.info("test language deleteLanguageData in ServiceImpl");

    }

    /** test updated language data */
    @Test
    void testUpdateLanguageData() {
        languageEntity = new LanguageEntity();
        languageEntity.setIdLang("EN");
        languageEntity.setDescr("English");
        languageRepository.save(languageEntity);
        languageTransDto = new LanguageTransDto();
        languageTransDto.setIdLang("EN");
        languageTransDto.setDescr("English");

        responseDto = languageService.updateLanguageData(languageTransDto);
        assertEquals(true, responseDto.isMsg());
        logger.info("test language updatelanguageData in ServiceImpl");
    }

    /** test updated language data */
    @Test
    void testUpdateLanguageDatas() {
        languageEntity = new LanguageEntity();
        languageEntity.setIdLang("SA");
        languageEntity.setDescr("Sanskrit");

        languageTransDto = new LanguageTransDto();
        languageTransDto.setIdLang("SA");
        languageTransDto.setDescr("Sanskrit");

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

        responseDto = languageService.updateLanguageData(languageTransDto);
        assertEquals(true, responseDto.isMsg());
        logger.info("test language updatelanguageData in ServiceImpl");
    }

}
