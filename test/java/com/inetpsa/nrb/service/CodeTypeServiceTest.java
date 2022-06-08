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
import com.inetpsa.nrb.dto.CodeTypeTransDto;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.model.CodeTypeEntity;
import com.inetpsa.nrb.model.CodeTypeEntityPk;
import com.inetpsa.nrb.repository.CodeTypeRepository;

/** class CodeTypeServiceTest */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
class CodeTypeServiceTest {
    /** constant logger */
    public static final Logger logger = LoggerFactory.getLogger(CodeTypeService.class);

    /** the CodeType service implementation */
    @Autowired
    CodeTypeService codeTypeService;

    /** the codeTypeRespository */
    @Autowired
    CodeTypeRepository codeTypeRepository;

    /** the responseDto */
    ResponseDto responseDto;

    /** the CodeTypeTransDto */
    CodeTypeTransDto codeTypeTransDto;
    CodeTypeEntity codeTypeEntity;
    CodeTypeEntityPk CodeTypeEntityPk;

    /**
     * Inits the.
     */
    @BeforeEach
    void init() {
        codeTypeEntity = new CodeTypeEntity();
        codeTypeEntity.setCodeTypeEntityPk(new CodeTypeEntityPk("FV", "CODE_USINE"));
        codeTypeEntity.setLblCode("RFVB");

        codeTypeRepository.save(codeTypeEntity);
    }

    /** Gets the code type data list */
    @Test
    void testGetCodeTypeData() {
        List<CodeTypeTransDto> codeTypeTransDto = codeTypeService.getCodeTypeData();
        assertNotNull(codeTypeTransDto);
        logger.info("test code type list in getCodeTypeData in ServiceImpl");
    }

    /** test deleted code type data */
    @Test
    void testDeleteCodeTypeData() {
        codeTypeEntity = new CodeTypeEntity();
        codeTypeEntity.setCodeTypeEntityPk(new CodeTypeEntityPk("FV", "CODE_USINE"));
        codeTypeEntity.setLblCode("RFVB");

        String idCode = codeTypeRepository.findAll().get(0).getCodeTypeEntityPk().getIdCode();
        String typCode = codeTypeRepository.findAll().get(0).getCodeTypeEntityPk().getTypCode();

        codeTypeRepository.save(codeTypeEntity);
        responseDto = codeTypeService.deleteCodeTypeData(idCode, typCode);

        assertNotNull(responseDto.getMessage());
        logger.info("test Code type deleteCodeTypeData in ServiceImpl");

    }

    /** test updated code type data */
    @Test
    void testUpdateCodeTypeData() {
        codeTypeEntity = new CodeTypeEntity();
        codeTypeEntity.setCodeTypeEntityPk(new CodeTypeEntityPk("FV", "CODE_USINE"));
        codeTypeEntity.setLblCode("RFVB");
        codeTypeRepository.save(codeTypeEntity);
        codeTypeTransDto = new CodeTypeTransDto();
        codeTypeTransDto.setIdCode("FV");
        codeTypeTransDto.setTypCode("CODE_USINE");
        codeTypeTransDto.setLblCode("RFVB");

        responseDto = codeTypeService.updateCodeTypeData(codeTypeTransDto);
        assertEquals(true, responseDto.isMsg());
        logger.info("test code type updateCodeTypeData in ServiceImpl");
    }

    /** test updated code type data */
    @Test
    void testUpdateCodeTypeDatas() {
        codeTypeEntity = new CodeTypeEntity();
        codeTypeEntity.setCodeTypeEntityPk(new CodeTypeEntityPk("PT", "CODE_USINE"));
        codeTypeEntity.setLblCode("TEST");
        codeTypeTransDto = new CodeTypeTransDto();
        codeTypeTransDto.setIdCode("PT");
        codeTypeTransDto.setTypCode("CODE_USINE");
        codeTypeTransDto.setLblCode("TEST");

        responseDto = codeTypeService.updateCodeTypeData(codeTypeTransDto);
        assertEquals(true, responseDto.isMsg());
        logger.info("test code type updateCodeTypeData in ServiceImpl");
    }

}
