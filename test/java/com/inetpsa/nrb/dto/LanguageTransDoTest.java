/*
 * Creation : 18 Feb 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * class LanguageTransDtoTest
 */
@ContextConfiguration
class LanguageTransDoTest {

    // private static final Timestamp now = null;
    Timestamp now = new Timestamp(new java.util.Date().getTime());
    /** the LanguageTransDto */
    static LanguageTransDto languageTransDto;

    /**
     * sets the language data
     */
    @BeforeAll
    static void setsLanguageData() {
        LanguageTransDto languageTransDto = new LanguageTransDto();
        languageTransDto.setId(0);
        languageTransDto.setIdLang("EN");
        languageTransDto.setDescr("English");
        languageTransDto.setDateCreation(new Timestamp(new java.util.Date().getTime()));
        languageTransDto.setUserCreation("INIT");
        languageTransDto.setDateMaj(new Timestamp(new java.util.Date().getTime()));
        languageTransDto.setUserMaj("NULL");
    }

    /** test the language data */
    @Test
    void testLanguageData() {
        LanguageTransDto languageTransDto = new LanguageTransDto();
        languageTransDto.setId(0);
        languageTransDto.setIdLang("EN");
        languageTransDto.setDescr("English");
        languageTransDto.setDateCreation(new Timestamp(new java.util.Date().getTime()));
        languageTransDto.setUserCreation("INIT");
        languageTransDto.setDateMaj(new Timestamp(new java.util.Date().getTime()));
        languageTransDto.setUserMaj("NULL");

        assertNotNull(languageTransDto.getId());
        assertNotNull(languageTransDto.getIdLang());
        assertNotNull(languageTransDto.getDescr());
        assertNotNull(languageTransDto.getDateCreation());
        assertNotNull(languageTransDto.getUserCreation());
        assertNotNull(languageTransDto.getDateMaj());
        assertNotNull(languageTransDto.getUserMaj());

    }

    /** test language constructor */
    @Test
    void testLanguageTransDtoConstructor() {
        LanguageTransDto languageTransDto = new LanguageTransDto("EN", "English", now, "INIT", now, "NULL");
        assertNotNull(languageTransDto);
    }

    /** test language constructor */
    @Test
    void testLanguageTransDto() {
        LanguageTransDto languageTransDto = new LanguageTransDto("EN", "English");
        assertNotNull(languageTransDto);
    }

    /** test language data not equals */
    @Test
    void testNotEqualsLanguageTrans() {
        LanguageTransDto languageTransDtoOne = new LanguageTransDto("EN", "English", now, "INIT", now, "NULL");
        LanguageTransDto languageTransDtoTwo = new LanguageTransDto("FR", "Francias", now, "INIT", now, "NULL");
        boolean equal = languageTransDtoOne.equals(languageTransDtoTwo);
        assertFalse(equal);
    }

    /** test toString language data */
    @Test
    void testToStringLanguageTransDto() {
        LanguageTransDto languageTransDto = new LanguageTransDto();
        languageTransDto.setIdLang("EN");
        languageTransDto.setDescr("English");
        languageTransDto.setDateCreation(new Timestamp(new java.util.Date().getTime()));
        languageTransDto.setUserCreation("INIT");
        languageTransDto.setDateMaj(new Timestamp(new java.util.Date().getTime()));
        languageTransDto.setUserMaj("NULL");

        assertEquals("LanguageTransDto [id=0, idLang=EN, descr=English, dateCreation=" + languageTransDto.getDateCreation()
                + ", userCreation=INIT, dateMaj=" + languageTransDto.getDateMaj() + ", userMaj=NULL]", (languageTransDto.toString()));

    }

}
