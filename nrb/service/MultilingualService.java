/*
 * Creation : 31 Jan 2022
 */
package com.inetpsa.nrb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.TranslationDto;

/**
 * The Interface MultilingualService.
 */
@Service
public interface MultilingualService {

    /**
     * Gets the multilingual data.
     *
     * @param langId the lang id
     * @return the multilingual data
     */
    List<TranslationDto> getMultilingualData(String langId);

}
