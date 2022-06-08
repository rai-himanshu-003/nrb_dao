/*
 * Creation : 11 Jan 2022
 */
package com.inetpsa.nrb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.AnomaliesTranslation;
import com.inetpsa.nrb.dto.ResponseDto;

/**
 * The Interface AnomaliesService.
 */
@Service
public interface AnomaliesService {

    /**
     * Gets the anomalies data.
     *
     * @param idlang the idlang
     * @return the anomalies data
     */
    List<AnomaliesTranslation> getAnomaliesData(String idlang);

    /**
     * Delete anomalies data.
     *
     * @param id the id
     * @return the response dto
     */
    ResponseDto deleteAnomaliesData(long id);

}
