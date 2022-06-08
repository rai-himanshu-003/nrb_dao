/*
 * Creation : 18 Apr 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * class HistoryEntityTest
 */
@ContextConfiguration
class HistoryEntityTest {
    /** class HistoryEntity */
    static HistoryEntity historyEntity;

    /** the LoggerdUser */
    LoggedUser loggedUser;

    private static final Timestamp now = null;

    /**
     * sets the data
     */
    @BeforeAll
    static void setup() {
        historyEntity = new HistoryEntity();
        historyEntity.setId(122l);
        historyEntity.setIdComponent(1584l);
        historyEntity.setNewValue("FV9");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("ER1");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("DATE_ENGAGEMENT");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");

    }

    /**
     * test the data
     */
    @Test
    void testData() {
        LoggedUser.logIn("E566559");
        historyEntity.PrePersist();
        historyEntity.preUpdate();

        assertNotNull(historyEntity.getId());
        assertNotNull(historyEntity.getIdComponent());
        assertNotNull(historyEntity.getNewValue());
        assertNotNull(historyEntity.getNumeroOrgane());
        assertNotNull(historyEntity.getOldValue());
        assertNotNull(historyEntity.getTypeUpdate());
        assertNotNull(historyEntity.getUpdatedColumn());
        assertNotNull(historyEntity.getTypeOrgane());
        assertNotNull(historyEntity.getTableName());

        assertNotNull(historyEntity.getDateUpdate());
        assertNotNull(historyEntity.getUserUpdate());

        historyEntity.toString();
    }

}
