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

import com.inetpsa.nrb.dto.CodeTypeTransDto;

/** The class CodeTypeEntityTest */
@ContextConfiguration
class CodeTypeEntityTest {
    private static final Timestamp now = null;

    /** the CodeTypeEntity */
    static CodeTypeEntity codeTypeEntity;

    /** the CodeTypeEntityPk */
    static CodeTypeEntityPk codeTypeEntityPk;

    /** the codeTypeTransDto */
    static CodeTypeTransDto codeTypeTransDto;

    /** set code type data */
    @BeforeAll
    static void setCodeTypeData() {
        codeTypeEntity = new CodeTypeEntity();
        codeTypeEntityPk = new CodeTypeEntityPk();
        codeTypeEntity.setCodeTypeEntityPk(new CodeTypeEntityPk("FV", "CODE_USINE"));
        codeTypeEntity.setLblCode("RFVB");

    }

    /** Test code type data */
    @Test
    void testCodeTypeData() {
        assertNotNull(codeTypeEntity.getCodeTypeEntityPk().getIdCode());
        assertNotNull(codeTypeEntity.getCodeTypeEntityPk().getTypCode());
        assertNotNull(codeTypeEntity.getLblCode());

    }

    /** test the code type constructor */
    @Test
    void testCodeTypeConstructor() {
        CodeTypeEntity codeTypeEntity = new CodeTypeEntity(new CodeTypeEntityPk("FV", "CODE_USINE"), "RFVB", now, "INIT", now, "NULL");
        assertNotNull(codeTypeEntity);

    }

    /** Test not equals code type */
    @Test
    void testNotEqualCodeType() {
        CodeTypeEntity codeTypeEntityOne = new CodeTypeEntity(new CodeTypeEntityPk("FV", "CODE_USINE"), "RFVB", now, "INIT", now, "NULL");
        CodeTypeEntity codeTypeEntityTwo = new CodeTypeEntity();
        boolean equal = codeTypeEntityOne.equals(codeTypeEntityTwo);
        assertFalse(equal);
    }

    /** test toString for code type */
    @Test
    void testToStringCodeType() {
        assertEquals(
                "CodeTypeEntity [codeTypeEntityPk=CodeTypeEntityPk [idCode=FV, typCode=CODE_USINE], lblCode=RFVB, dateCreation=null, userCreation=null, dateMaj=null, userMaj=null]",
                (codeTypeEntity.toString()));
    }

}
