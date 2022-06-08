/*
 * Creation : 13 Feb 2022
 */
package com.inetpsa.nrb.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetpsa.nrb.dto.CodeTypeTransDto;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.model.CodeTypeEntity;
import com.inetpsa.nrb.model.CodeTypeEntityPk;
import com.inetpsa.nrb.repository.CodeTypeRepository;
import com.inetpsa.nrb.service.CodeTypeService;
import com.inetpsa.nrb.util.CodeTypeDataUtil;

/** The Class CodeTypeServiceImpl */
@Transactional
@Service
public class CodeTypeServiceImpl implements CodeTypeService {
    private static final Logger logger = LoggerFactory.getLogger(CodeTypeServiceImpl.class);

    /** The Code type repository */
    @Autowired
    private CodeTypeRepository codeTypeRepository;

    /** The entity manager */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.CodeTypeService#getCodeTypeData(java.lang.String)
     */
    @Override
    public List<CodeTypeTransDto> getCodeTypeData() {
        List<CodeTypeEntity> codeTypeEntity = codeTypeRepository.getCodeTypeData();
        List<CodeTypeTransDto> data = CodeTypeDataUtil.convertEntityListToDTOList(codeTypeEntity);
        Random random = new Random();
        for (CodeTypeTransDto dtoLists : data) {
            dtoLists.setId(random.nextInt());
        }
        return data;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.CodeTypeService#deleteCodeTypeData(String)
     */
    @Override
    public ResponseDto deleteCodeTypeData(@Param("idCode") String idCode, @Param("typCode") String typCode) {
        ResponseDto responseDto = new ResponseDto();

        try {
            CodeTypeEntityPk codeTypeEntityPk = new CodeTypeEntityPk();
            codeTypeEntityPk.setIdCode(idCode);
            codeTypeEntityPk.setTypCode(typCode);
            codeTypeRepository.deleteById(codeTypeEntityPk);
            responseDto.setId(idCode);
            responseDto.setMsg(true);
            responseDto.setMessage("Data deleted scuccessfully");
            logger.info("Code type data is deleted");
        } catch (Exception e) {
            responseDto.setMsg(false);
            responseDto.setMessage("Data deleted Unsccessfully");
            logger.error("Code type Data is deleted Unsccessfully {} ", e.getMessage());
        }

        return responseDto;

    }

    @Override
    public ResponseDto updateCodeTypeData(CodeTypeTransDto codeTypeTransDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            logger.info("data updates {}", codeTypeTransDto);
            CodeTypeEntityPk codeTypeEntityPk = new CodeTypeEntityPk();
            codeTypeEntityPk.setIdCode(codeTypeTransDto.getIdCode());
            codeTypeEntityPk.setTypCode(codeTypeTransDto.getTypCode());
            Optional<CodeTypeEntity> object = codeTypeRepository
                    .findById(new CodeTypeEntityPk(codeTypeTransDto.getIdCode(), codeTypeTransDto.getTypCode()));
            if (object.isPresent()) {
                CodeTypeEntity codeTypeObject = codeTypeTransDto.mapToEntity(object.get());
                codeTypeRepository.save(codeTypeObject);
                responseDto.setId(codeTypeTransDto.getIdCode());
                responseDto.setMsg(true);
                responseDto.setMessage(" Code type Data Updated successfully");
            } else {
                CodeTypeEntity codeTypeObject = codeTypeTransDto.mapTomodel(new CodeTypeEntity(), codeTypeTransDto.getIdCode(),
                        codeTypeTransDto.getTypCode());
                codeTypeRepository.save(codeTypeObject);
                responseDto.setMsg(true);
                responseDto.setMessage(" Code type Data added successfully");
            }
        } catch (Exception e) {
            responseDto.setMsg(false);
            responseDto.setMessage("Data updated unsccessfully");
            logger.error("Code Type data is updated Unsccessfully {}", e.getMessage());
        }

        return responseDto;

    }
}
