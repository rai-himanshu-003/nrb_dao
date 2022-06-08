/*
 * Creation : 13 Feb 2022
 */
package com.inetpsa.nrb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.CodeTypeTransDto;
import com.inetpsa.nrb.dto.ResponseDto;

/**
 * The Interface CodeTypeService.
 */
@Service
public interface CodeTypeService {

    /**
     * Gets the list of code type data.
     *
     * @return the code type data
     */
    List<CodeTypeTransDto> getCodeTypeData();

    /**
     * Delete the code type data.
     *
     * @param idCode  the idCode
     * @param typCode the typCode
     * @return the response dto
     */
    ResponseDto deleteCodeTypeData(String idCode, String typCode);

    /**
     * Update code type data.
     *
     * @param codeTypeTransDto the code type trans dto
     * @return the response dto
     */
    ResponseDto updateCodeTypeData(CodeTypeTransDto codeTypeTransDto);

}
