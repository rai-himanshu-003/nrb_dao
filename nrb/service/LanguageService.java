package com.inetpsa.nrb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.LanguageTransDto;
import com.inetpsa.nrb.dto.ResponseDto;

/**
 * The Interface LanguageService.
 */
@Service
public interface LanguageService {

    /**
     * Gets the list of Language data.
     *
     * @return the language data
     */
    List<LanguageTransDto> getLanguageData();

    /**
     * Delete language data.
     *
     * @param idLang the id lang
     * @return the response dto
     */
    ResponseDto deleteLanguageData(String idLang);

    /**
     * Update language data.
     *
     * @param langDTO the lang DTO
     * @return the response dto
     */
    ResponseDto updateLanguageData(LanguageTransDto langDTO);

}