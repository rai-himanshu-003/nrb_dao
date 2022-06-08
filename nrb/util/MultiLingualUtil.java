/*
 * Creation : 1 Feb 2022
 */
package com.inetpsa.nrb.util;

import java.util.ArrayList;
import java.util.List;

import com.inetpsa.nrb.dto.TranslationDto;
import com.inetpsa.nrb.model.TranslationEntity;

/**
 * The Class MultiLingualUtil.
 */
public class MultiLingualUtil {

    /**
     * Instantiates a new multi lingual util.
     */
    private MultiLingualUtil() {
    }

    /**
     * Convert entity to DTO.
     *
     * @param multiEntity the multi entity
     * @return the translation dto
     */
    public static TranslationDto convertEntityToDTO(TranslationEntity multiEntity) {
        return new TranslationDto(multiEntity.getTranslationEntityPk().getIdtrad(), multiEntity.getTranslationEntityPk().getIdlang(),
                multiEntity.getLbltrad(), multiEntity.getTyptrad());
    }

    /**
     * Convert entity list to DTO list.
     *
     * @param entityList the entity list
     * @return the list
     */
    public static List<TranslationDto> convertEntityListToDTOList(List<TranslationEntity> entityList) {

        List<TranslationDto> dtoList = new ArrayList<>();
        for (TranslationEntity entityData : entityList) {
            dtoList.add(convertEntityToDTO(entityData));
        }

        return dtoList;
    }
}
