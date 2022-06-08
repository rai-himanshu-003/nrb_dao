/*
 * Creation : 18 Apr 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * class HdataEntityTest
 */
@ContextConfiguration
class HdataEntityTest {
    /** class Hdata Entity */
    static HdataEntity hdataEntity;

    /**
     * the loggeduser
     */
    LoggedUser loggedUser;

    /**
     * sets the data
     */
    @BeforeAll
    static void setup() {
        hdataEntity = new HdataEntity();
        hdataEntity.setId(1l);
        hdataEntity.setCurrentValue("Y");
        hdataEntity.setMac("3.524");
        hdataEntity.setMic("3.000");
        hdataEntity.setNumeroOrgane("CBLOT5BAT22");
        hdataEntity.setRinsulation("60000");
        hdataEntity.setRinternal("90");
        hdataEntity.setSoc("21");
        hdataEntity.setSoh("103");
        hdataEntity.setT10("381");
        hdataEntity.setTat("18");
        hdataEntity.setTypeOrgane("34");
        hdataEntity.setVersion(0);

    }

    /**
     * test the data
     */
    @Test
    void testData() {
        LoggedUser.logIn("E566559");
        hdataEntity.prePersist();
        hdataEntity.preUpdate();

        assertNotNull(hdataEntity.getCurrentValue());
        assertNotNull(hdataEntity.getId());
        assertNotNull(hdataEntity.getMac());
        assertNotNull(hdataEntity.getMic());
        assertNotNull(hdataEntity.getNumeroOrgane());
        assertNotNull(hdataEntity.getRinsulation());
        assertNotNull(hdataEntity.getRinternal());
        assertNotNull(hdataEntity.getSoc());
        assertNotNull(hdataEntity.getSoh());
        assertNotNull(hdataEntity.getT10());
        assertNotNull(hdataEntity.getTat());
        assertNotNull(hdataEntity.getTypeOrgane());
        assertNotNull(hdataEntity.getVersion());

        assertNotNull(hdataEntity.getDateCreation());
        assertNotNull(hdataEntity.getUserCreation());
        assertNotNull(hdataEntity.getDateMaj());
        assertNotNull(hdataEntity.getUserMaj());

        hdataEntity.toString();

    }

}
