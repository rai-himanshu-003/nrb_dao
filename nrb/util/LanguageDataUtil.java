/*
 * Creation : 17 Feb 2022
 */
package com.inetpsa.nrb.util;

import java.util.ArrayList;
import java.util.List;

import com.inetpsa.nrb.dto.LanguageTransDto;
import com.inetpsa.nrb.model.LanguageEntity;

/**
 * The Class LanguageDataUtil.
 */
public final class LanguageDataUtil {

    private LanguageDataUtil() {
        super();
    }

    /**
     * Convert entity to DTO.
     *
     * @param langEntity the lang entity
     * @return the language trans dto
     */
    public static LanguageTransDto convertEntityToDTO(LanguageEntity langEntity) {
        return new LanguageTransDto(langEntity.getIdLang(), langEntity.getDescr(), langEntity.getDateCreation(), langEntity.getUserCreation(),
                langEntity.getDateMaj(), langEntity.getUserMaj());
    }

    /**
     * Convert entity list to DTO list.
     *
     * @param entityList the entity list
     * @return the list
     */
    public static List<LanguageTransDto> convertEntityListToDTOList(List<LanguageEntity> entityList) {

        List<LanguageTransDto> dtoList = new ArrayList<>();
        for (LanguageEntity entityData : entityList) {
            dtoList.add(convertEntityToDTO(entityData));
        }

        return dtoList;
    }

}
