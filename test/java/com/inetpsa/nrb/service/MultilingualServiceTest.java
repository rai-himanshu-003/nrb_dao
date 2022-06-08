/*
 * Creation : 15 Mar 2022
 */
package com.inetpsa.nrb.service;

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
import com.inetpsa.nrb.dto.TranslationDto;
import com.inetpsa.nrb.model.TranslationEntity;
import com.inetpsa.nrb.model.TranslationEntityPk;
import com.inetpsa.nrb.repository.MultilingualRepository;

/**
 * The Class MultilingualServiceTest.
 */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
class MultilingualServiceTest {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(MultilingualServiceTest.class);

    /** The translation service. */
    @Autowired
    MultilingualService multiService;

    /** The translation repository. */
    @Autowired
    MultilingualRepository multilingualRepository;

    /** The translation entity. */
    TranslationEntity translationEntity;

    /** The translation dto. */
    TranslationDto translationDto;

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
        multilingualRepository.save(translationEntity);

    }

    /**
     * Test translation data.
     */
    @Test
    void testTranslationData() {

        List<TranslationDto> translationData = multiService.getMultilingualData("EN");
        assertNotNull(translationData);

    }

}
