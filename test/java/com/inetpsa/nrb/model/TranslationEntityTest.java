/*
 * Creation : 20 Jan 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class TranslationEntityTest.
 */
@ContextConfiguration
class TranslationEntityTest {

    /** The translation entity. */
    static TranslationEntity translationEntity;

    static TranslationEntityPk translationEntityPk;

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {

        translationEntity = new TranslationEntity();
        translationEntityPk = new TranslationEntityPk();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("FR", "Status-6"));
        translationEntity.setLbltrad("Produced");
        translationEntity.setTyptrad("1-Status");
        translationEntityPk.setIdlang("FR");
        translationEntityPk.setIdtrad("Status-6");

    }

    /**
     * Test translation data.
     */
    @Test
    void testTranslationData() {
        LoggedUser.logIn("E566559");
        translationEntity.prePersist();
        translationEntity.preUpdate();

        assertNotNull(translationEntity.getTranslationEntityPk().getIdlang());
        assertNotNull(translationEntity.getTranslationEntityPk().getIdtrad());
        assertNotNull(translationEntity.getLbltrad());
        assertNotNull(translationEntity.getTyptrad());
        assertNotNull(translationEntityPk.getIdlang());
        assertNotNull(translationEntityPk.getIdtrad());

        assertNotNull(translationEntity.getDateCreation());
        assertNotNull(translationEntity.getDateMaj());
        assertNotNull(translationEntity.getUserCreation());
        assertNotNull(translationEntity.getUserMaj());

        translationEntity.toString();

    }

    /**
     * Test translation constructor.
     */
    @Test
    void testTranslationConstructor() {
        TranslationEntity translationEntity = new TranslationEntity(new TranslationEntityPk("FR", "Status-6"), "Produced", "6-Status");
        assertNotNull(translationEntity);
    }

    /**
     * Test not equal translation.
     */
    @Test
    void testNotEqualTranslation() {
        TranslationEntity translationEntityOne = new TranslationEntity(new TranslationEntityPk("FR", "Status-6"), "Produced", "6-Status");
        TranslationEntity translationEntityTwo = new TranslationEntity();
        boolean equal = translationEntityOne.equals(translationEntityTwo);
        assertFalse(equal);
    }

    /**
     * test the constructor
     */
    @Test
    void testConstructorPk() {
        TranslationEntity translationEntity = new TranslationEntity(new TranslationEntityPk("FR", "Status-6"));
        assertNotNull(translationEntity);
    }

    /**
     * test the constructor
     */
    @Test
    void testConstructorsPkData() {
        TranslationEntity translationEntity = new TranslationEntity(new TranslationEntityPk("FR", "Status-6"), "1-Status");
        assertNotNull(translationEntity);
    }

    @Test
    void testequalData() {
        TranslationEntityPk translationEntityPk1 = new TranslationEntityPk("FR", "Status-6");
        TranslationEntityPk translationEntityPk2 = new TranslationEntityPk("FR", "Status-6");
        boolean equal = translationEntityPk1.equals(translationEntityPk2);
        assertTrue(equal);
    }

    @Test
    void testNotequalData() {
        TranslationEntityPk translationEntityPk1 = new TranslationEntityPk("FR", "Status-7");
        TranslationEntityPk translationEntityPk2 = new TranslationEntityPk("FR", "Status-6");
        boolean equal = translationEntityPk1.equals(translationEntityPk2);
        assertFalse(equal);
    }

    /**
     * Test hash code for equal objects.
     */
    @Test
    void testHashCodeForEqualObjects() {
        TranslationEntityPk translationEntityPk1 = new TranslationEntityPk("FR", "Status-6");
        TranslationEntityPk translationEntityPk2 = new TranslationEntityPk("FR", "Status-6");

        int hashCode1 = translationEntityPk1.hashCode();
        int hashCode2 = translationEntityPk2.hashCode();
        assertEquals(hashCode1, hashCode2);
    }

}
