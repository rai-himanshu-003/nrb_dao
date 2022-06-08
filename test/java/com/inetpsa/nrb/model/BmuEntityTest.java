/*
 * Creation : 18 Apr 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * class BmuEntityTest
 */
@ContextConfiguration
class BmuEntityTest {
    /** class BmuEntity */
    static BmuEntity bmuEntity;

    /**
     * set the data
     */
    @BeforeAll
    static void setup() {
        bmuEntity = new BmuEntity();
        bmuEntity.setId(102l);
        bmuEntity.setTypeOrgane("34");
        bmuEntity.setNumeroOrgane("CB23TRY");
        bmuEntity.setSerialNumber("SHUYI56F12345HGT29");
        bmuEntity.setRefSoft("E4$FYKLOIUAGAJ8732");
        bmuEntity.setRefHard("NXBGHSY55698SJAKAOAU");
        bmuEntity.setDateProduction(LocalDateTime.now());
        bmuEntity.setSuppliercode("5948UYHSJSKIEY67358");
        bmuEntity.setRefCal("9693678580");
        bmuEntity.setCurrentValue("Y");
        bmuEntity.setVersion(1);
    }

    /**
     * test that data
     */
    @Test
    void testData() {
        assertNotNull(bmuEntity.getId());
        assertNotNull(bmuEntity.getTypeOrgane());
        assertNotNull(bmuEntity.getNumeroOrgane());
        assertNotNull(bmuEntity.getSerialNumber());
        assertNotNull(bmuEntity.getRefSoft());
        assertNotNull(bmuEntity.getRefHard());
        assertNotNull(bmuEntity.getDateProduction());
        assertNotNull(bmuEntity.getSuppliercode());
        assertNotNull(bmuEntity.getRefCal());
        assertNotNull(bmuEntity.getCurrentValue());
        assertNotNull(bmuEntity.getVersion());
    }

    /**
     * Test pre persist method.
     */
    @Test
    void testPrePersistMethod() {
        LoggedUser.logIn("CORVET");
        bmuEntity.prePersist();
        bmuEntity.preUpdate();

        assertNotNull(bmuEntity.getDateCreation());
        assertNotNull(bmuEntity.getUserCreation());

        assertNotNull(bmuEntity.getDateMaj());
        assertNotNull(bmuEntity.getUserMaj());

    }

    /**
     * test toString
     */
    @Test
    void testToStringData() {
        bmuEntity.toString();

    }

}
