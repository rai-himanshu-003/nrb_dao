/*
 * Creation : 7 Feb 2022
 */
package com.inetpsa.nrb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.LanguageTransDto;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.dto.TranslationDto;

/**
 * The Interface TranslationService.
 */
@Service
public interface TranslationService {

    /**
     * Gets the language list.
     *
     * @return the language list
     */
    List<LanguageTransDto> getLanguageList();

    /**
     * Gets the translation data.
     *
     * @param idlang  the idlang
     * @param typtrad the typtrad
     * @return the translation data
     */
    List<TranslationDto> getTranslationData(String idlang, String[] typtrad);

    /**
     * Update translation data.
     *
     * @param translationDto the translation dto
     * @return the response dto
     */
    ResponseDto updateTranslationData(TranslationDto translationDto);

    /**
     * Update translation import.
     *
     * @param translationEntity the translation entity
     * @return true, if successful
     */
    boolean updateTranslationImport(TranslationDto translationEntity);

}
