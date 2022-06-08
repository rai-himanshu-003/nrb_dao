/*
 * Creation : 4 Mar 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.util.MultiLingualUtil;

@ContextConfiguration
class TranslationDtoTest {

    static TranslationDto translationDto;

    static MultiLingualUtil mulutil;

    @BeforeAll
    static void setData() {
        translationDto = new TranslationDto();
        translationDto.setId(0);
        translationDto.setTradId("LBL-0001");
        translationDto.setLang("FR");
        translationDto.setType("4-LABEL");
        translationDto.setLabel("18P – référence matériel BMU");

    }

    /**
     * Test anomalies data.
     */
    @Test
    void testTranslationData() {
        assertNotNull(translationDto.getId());
        assertEquals("FR", translationDto.getLang());
        assertNotNull(translationDto.getTradId());
        assertNotNull(translationDto.getType());
        assertNotNull(translationDto.getLabel());

    }

    /**
     * Test anomalies translation constructor.
     */
    @Test
    void testTranslationConstructor() {
        TranslationDto translationDto = new TranslationDto("LBL-0001", "FR", "18P – référence matériel BMU", "4-LABEL");
        assertNotNull(translationDto);
    }

    /**
     * Test not equal anomalies translation.
     */
    @Test
    void testNotEqualTranslation() {
        TranslationDto translationDtoOne = new TranslationDto("LBL-0001", "FR", "18P – référence matériel BMU", "4-LABEL");
        TranslationDto translationDtoTwo = new TranslationDto("LBL-0002", "FR", "18P – référence matériel BMU", "4-LABEL");

        boolean equal = translationDtoOne.equals(translationDtoTwo);
        assertFalse(equal);
    }

    /**
     * Test to string anomalies translation.
     */
    @Test
    void testToStringAnomaliesTranslation() {
        assertEquals("TranslationDto [tradId=LBL-0001, lang=FR, label=18P – référence matériel BMU, type=4-LABEL]", (translationDto.toString()));
    }

}
