/*
 * Creation : 19 Feb 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/** class CodeTypeTransDtoTest */
@ContextConfiguration
class CodeTypeTransDtoTest {
    private static final Timestamp now = null;
    /** the CodeTypeTransDto */
    static CodeTypeTransDto codeTypeTransDto;

    /** Sets the code type data */
    @BeforeAll
    static void setCodeTypeTransDto() {
        CodeTypeTransDto codeTypeTransDto = new CodeTypeTransDto();
        codeTypeTransDto.setId(0);
        codeTypeTransDto.setIdCode("FV");
        codeTypeTransDto.setTypCode("CODE_USINE");
        codeTypeTransDto.setLblCode("RFVB");
        codeTypeTransDto.setDateCreation(new Timestamp(new Date().getTime()));
        codeTypeTransDto.setUserCreation("INIT");
        codeTypeTransDto.setDateMaj(new Timestamp(new Date().getTime()));
        codeTypeTransDto.setUserMaj("NULL");
    }

    /** test code type data */
    @Test
    void testCodeTypeTransDto() {
        CodeTypeTransDto codeTypeTransDto = new CodeTypeTransDto();
        codeTypeTransDto.setId(0);
        codeTypeTransDto.setIdCode("FV");
        codeTypeTransDto.setTypCode("CODE_USINE");
        codeTypeTransDto.setLblCode("RFVB");
        codeTypeTransDto.setDateCreation(new Timestamp(new Date().getTime()));
        codeTypeTransDto.setUserCreation("INIT");
        codeTypeTransDto.setDateMaj(new Timestamp(new Date().getTime()));
        codeTypeTransDto.setUserMaj("NULL");
        // assertEquals("FV", codeTypeTransDto.getIdCode());
        assertNotNull(codeTypeTransDto.getId());
        assertNotNull(codeTypeTransDto.getIdCode());
        assertNotNull(codeTypeTransDto.getTypCode());
        assertNotNull(codeTypeTransDto.getLblCode());
        assertNotNull(codeTypeTransDto.getDateCreation());
        assertNotNull(codeTypeTransDto.getUserCreation());
        assertNotNull(codeTypeTransDto.getDateMaj());
        assertNotNull(codeTypeTransDto.getUserMaj());
    }

    /** test code type constructor */
    @Test
    void testCodeTypeTransDtoConstructor() {
        CodeTypeTransDto codeTypeTransDto = new CodeTypeTransDto("FV", "CODE_USINE", "RFVB", now, "INIT", now, "NULL");
        assertNotNull(codeTypeTransDto);
    }

    /** test code type not equals */
    @Test
    void testCodeTypeTransDtoNotEquals() {
        CodeTypeTransDto codeTypeTransDtoOne = new CodeTypeTransDto("FV", "CODE_USINE", "RFVB", now, "INIT", now, "NULL");
        CodeTypeTransDto codeTypeTransDtoTwo = new CodeTypeTransDto("TR", "CODE_SGR", "ASDF", now, "INIT", now, "NULL");
        boolean equal = codeTypeTransDtoOne.equals(codeTypeTransDtoTwo);
        assertFalse(equal);
    }

    /** test toString code type */
    @Test
    void testToStringCodeTypeTransDto() {
        CodeTypeTransDto codeTypeTransDto = new CodeTypeTransDto();
        codeTypeTransDto.setIdCode("FV");
        codeTypeTransDto.setTypCode("CODE_USINE");
        codeTypeTransDto.setLblCode("RFVB");
        codeTypeTransDto.setDateCreation(new Timestamp(new Date().getTime()));
        codeTypeTransDto.setUserCreation("INIT");
        codeTypeTransDto.setDateMaj(new Timestamp(new Date().getTime()));
        codeTypeTransDto.setUserMaj("NULL");

        assertEquals("CodeTypeTransDto [id=0, idCode=FV, typCode=CODE_USINE, lblCode=RFVB, dateCreation=" + codeTypeTransDto.getDateCreation()
                + ", userCreation=INIT, dateMaj=" + codeTypeTransDto.getDateMaj() + ", userMaj=NULL]", (codeTypeTransDto.toString()));

    }

}
