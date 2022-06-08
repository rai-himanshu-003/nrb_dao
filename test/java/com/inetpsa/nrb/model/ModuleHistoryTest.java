/*
 * Creation : 22 Apr 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * The Class ModuleHistoryTest.
 */
class ModuleHistoryTest {

    /** The module history. */
    static ModuleHistory moduleHistory;

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        moduleHistory = new ModuleHistory();
        moduleHistory.setId(1l);
        moduleHistory.setModId(1l);
        moduleHistory.setTypeOrgane("34");
        moduleHistory.setNumeroOrgane("CBLOT5BAT24");
        moduleHistory.setTypeModule("34");
        moduleHistory.setNumeroModule("CBLOT5BAT23");
        moduleHistory.setDescription2("bin");
        moduleHistory.setTypeUpdate("c");
        moduleHistory.preUpdate();
        moduleHistory.setUserUpdate("E604125");

    }

    /**
     * Test module history data.
     */
    @Test
    void testModuleHistoryData() {
        assertNotNull(moduleHistory.getId());
        assertNotNull(moduleHistory.getModId());
        assertNotNull(moduleHistory.getTypeOrgane());
        assertNotNull(moduleHistory.getNumeroOrgane());
        assertNotNull(moduleHistory.getTypeModule());
        assertNotNull(moduleHistory.getNumeroModule());
        assertNotNull(moduleHistory.getDescription2());
        assertNotNull(moduleHistory.getTypeUpdate());
        assertNotNull(moduleHistory.getDateUpdate());
        assertNotNull(moduleHistory.getUserUpdate());

        moduleHistory.toString();

    }

}
