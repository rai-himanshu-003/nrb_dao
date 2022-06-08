/*
 * Creation : 19 Apr 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * class ModuleTest
 */
@ContextConfiguration
class ModuleTest {
    /** class Module */
    static Module module;

    /** class LoggerUser */
    LoggedUser loggedUser;

    /**
     * sets the data
     */
    @BeforeAll
    static void setup() {
        module = new Module();
        module.setCurrentValue("Y");
        module.setDescription2("SUPPORT BATTERIE TEST84 2020");
        module.setId(594l);
        module.setNumeroModule("26LOT400084");
        module.setNumeroOrgane("CBLOT4BAT94");
        module.setTypeModule("84");
        module.setTypeOrgane("34");
        module.setVersion(0);

    }

    /**
     * test the data
     */
    @Test
    void testData() {
        LoggedUser.logIn("E566559");
        module.prePersist();
        module.preUpdate();

        assertNotNull(module.getCurrentValue());
        assertNotNull(module.getDescription2());
        assertNotNull(module.getId());
        assertNotNull(module.getNumeroModule());
        assertNotNull(module.getNumeroOrgane());
        assertNotNull(module.getTypeModule());
        assertNotNull(module.getTypeOrgane());
        assertNotNull(module.getVersion());
        assertNotNull(module.getDateCreation());
        assertNotNull(module.getDateMaj());
        assertNotNull(module.getUserCreation());
        assertNotNull(module.getUserMaj());

        module.toString();
    }

}
