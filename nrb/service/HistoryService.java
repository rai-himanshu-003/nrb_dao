/*
 * Creation : 21 Dec 2021
 */
package com.inetpsa.nrb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.model.HistoryEntity;
import com.inetpsa.nrb.model.OrganeEntity;

/**
 * The Interface HistoryService.
 */
@Service
public interface HistoryService {

    /**
     * Creates the history rec.
     *
     * @param oldValue the old value
     * @param newValue the new value
     * @param organe the organe
     * @param column the column
     * @param table the table
     * @param id the id
     * @return the history entity
     */
    HistoryEntity createHistoryRec(String oldValue, String newValue, OrganeEntity organe, String column, String table, Long id);

    /**
     * Adds the history list.
     *
     * @param historyList the history list
     */
    void addHistoryList(List<HistoryEntity> historyList);

}
