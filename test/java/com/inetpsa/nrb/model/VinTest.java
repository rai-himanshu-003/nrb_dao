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
 * class BmuEntityTest
 */
@ContextConfiguration
class VinTest {
    /** class vin */
    static Vin vin;

    /**
     * sets the data
     */
    @BeforeAll
    static void setup() {
        vin = new Vin();
        vin.setId(422l);
        vin.setCurrentValue("Y");
        vin.setNumeroOrgane("CBLOT5BAT18");
        vin.setRequestId("9085f504-301a-48d4-b729-2500375ea0a4");
        vin.setTypeOrgane("34");
        vin.setVin("VR1ATTENTKW039309");

    }

    /**
     * test the data
     */
    @Test
    void testData() {
        LoggedUser.logIn("E566559");
        vin.prePersist();
        vin.preUpdate();

        assertNotNull(vin.getId());
        assertNotNull(vin.getCurrentValue());
        assertNotNull(vin.getNumeroOrgane());
        assertNotNull(vin.getRequestId());
        assertNotNull(vin.getTypeOrgane());
        assertNotNull(vin.getVin());
        assertNotNull(vin.getDateCreation());
        assertNotNull(vin.getUserCreation());
        assertNotNull(vin.getDateMaj());
        assertNotNull(vin.getUserMaj());

        vin.toString();
    }

}
