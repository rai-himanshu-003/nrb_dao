/*
 * Creation : 21 Dec 2021
 */
package com.inetpsa.nrb.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inetpsa.nrb.model.HistoryEntity;
import com.inetpsa.nrb.model.OrganeEntity;
import com.inetpsa.nrb.repository.HistoryRepository;
import com.inetpsa.nrb.service.HistoryService;

/**
 * The Class HistoryServiceImpl.
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(HistoryServiceImpl.class);

    /** The history repository. */
    @Autowired
    private HistoryRepository historyRepository;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.HistoryService#createHistoryRec(java.lang.String, java.lang.String, com.inetpsa.nrb.model.OrganeEntity,
     *      java.lang.String, java.lang.String, java.lang.Long)
     */
    @Override
    public HistoryEntity createHistoryRec(String oldValue, String newValue, OrganeEntity organe, String column, String table, Long id) {
        HistoryEntity history = new HistoryEntity();
        try {
            logger.info("Entering createHistoryRec for table : {}", table);

            String type = null;
            String oldVal = oldValue == null ? null : oldValue;
            String newVal = newValue == null ? null : newValue;
            history.setOldValue(oldVal);
            history.setNewValue(newVal);
            history.setTableName(table);
            history.setTypeOrgane(organe.getTypeOrgane());
            history.setNumeroOrgane(organe.getNumeroOrgane());
            history.setUpdatedColumn(column);
            history.setIdComponent(id);
            if (oldVal == null && newValue != null)
                type = "CREATE";
            else if (oldVal != null && newVal != null && !newVal.isEmpty())
                type = "UPDATE";
            else if (oldVal != null && newVal == null || newVal.isEmpty())
                type = "DELETE";
            history.setTypeUpdate(type);
            historyRepository.save(history);

        } catch (Exception e) {
            logger.error("Exception in creating History record {}", e);
        }
        return history;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.HistoryService#addHistoryList(java.util.List)
     */
    @Override
    public void addHistoryList(List<HistoryEntity> historyList) {

        try {
            logger.info("Entering addHistoryList ");

            historyRepository.saveAll(historyList);

        } catch (Exception e) {
            logger.error("Exception in addHistoryList {}", e);
        }

    }

}
