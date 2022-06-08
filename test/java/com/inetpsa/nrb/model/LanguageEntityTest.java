/*
 * Creation : 18 Feb 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/** The class LanguageEntityTest */
@ContextConfiguration
class LanguageEntityTest {
    private static final Timestamp now = null;
    /** the Language entity */
    static LanguageEntity languageEntity;

    /** Sets the language data */
    @BeforeAll
    static void setData() {
        languageEntity = new LanguageEntity();
        languageEntity.setIdLang("EN");
        languageEntity.setDescr("English");

    }

    /**
     * test the language data
     */
    @Test
    void testLanguageData() {
        assertNotNull(languageEntity.getIdLang());
        assertNotNull(languageEntity.getDescr());

    }

    /** test the constructor */
    @Test
    void languageConstructor() {
        LanguageEntity languageEntity = new LanguageEntity("EN", "English", now, "INIT", now, "NULL");
        assertNotNull(languageEntity);
    }

    /** test the constructor */
    @Test
    void langConstructor() {
        LanguageEntity languageEntity = new LanguageEntity("EN", "English");
        assertNotNull(languageEntity);
    }

    /** test language not equals */
    @Test
    void testNotEqualsLanguage() {
        LanguageEntity languageEntityOne = new LanguageEntity("EN", "English", now, "INIT", now, "NULL");
        LanguageEntity languageEntityTwo = new LanguageEntity();
        boolean equal = languageEntityOne.equals(languageEntityTwo);
        assertFalse(equal);
    }

    /** test toString for language */
    @Test
    void testToStringLanguage() {
        assertEquals("LanguageEntity [idLang=EN, descr=English, dateCreation=null, userCreation=null, dateMaj=null, userMaj=null]",
                (languageEntity.toString()));

    }

}
