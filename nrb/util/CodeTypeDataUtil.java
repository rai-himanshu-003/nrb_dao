/*
 * Creation : 23 Feb 2022
 */
package com.inetpsa.nrb.util;

import java.util.ArrayList;
import java.util.List;

import com.inetpsa.nrb.dto.CodeTypeTransDto;
import com.inetpsa.nrb.model.CodeTypeEntity;

/**
 * The Class CodeTypeDataUtil.
 */
public final class CodeTypeDataUtil {

    /**
     * Instantiates a new code type data util.
     */
    private CodeTypeDataUtil() {
        super();
    }

    /**
     * Convert entity list to DTO list.
     *
     * @param entityList the entity list
     * @return the list
     */
    public static List<CodeTypeTransDto> convertEntityListToDTOList(List<CodeTypeEntity> entityList) {

        List<CodeTypeTransDto> dtoList = new ArrayList<>();
        for (CodeTypeEntity entityData : entityList) {
            dtoList.add(entityData.mapTomodel());

        }

        return dtoList;
    }

}