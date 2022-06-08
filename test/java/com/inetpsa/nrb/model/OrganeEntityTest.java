/*
 * Creation : 10 Mar 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class OrganeEntityTest.
 */
@ContextConfiguration
class OrganeEntityTest {

    /** The organe entity. */
    static OrganeEntity organeEntity;

    /** The now. */
    static Timestamp now = new Timestamp(new java.util.Date().getTime());

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        organeEntity = new OrganeEntity();
        organeEntity.setId(234l);
        organeEntity.setTypeOrgane("35");
        organeEntity.setNumeroOrgane("CB23TRY");
        organeEntity.setReference("987567477");
        organeEntity.setCodeUsing("VR");
        organeEntity.setCodeSgr("QK1");
        organeEntity.setCodeAtelier("XZJ21");
        organeEntity.setCurrentValue("Y");
        organeEntity.setVersion(1);
        organeEntity.setDescription("Battery desc 1");
        organeEntity.setDescription2("Battery desc 2");
        organeEntity.setUserCreation("E604126");
        organeEntity.setUserMaj("E604126");
        organeEntity.setDateProduction(LocalDateTime.now());
        organeEntity.setDateCreation(new Date());
        organeEntity.setDateMaj(now);
        organeEntity.setDateEngagement(LocalDateTime.now());
        organeEntity.setStatus("1");
        organeEntity.setRequestId("0049b1f7-8dad-41d9-aded-cb287ed62bfd");

    }

    /**
     * Test organe data.
     */
    @Test
    void testOrganeData() {
        LoggedUser.logIn("E566559");
        organeEntity.prePersist();
        organeEntity.preUpdate();

        assertNotNull(organeEntity.getId());
        assertNotNull(organeEntity.getCodeAtelier());
        assertNotNull(organeEntity.getCodeSgr());
        assertNotNull(organeEntity.getCodeUsing());
        assertNotNull(organeEntity.getCurrentValue());
        assertNotNull(organeEntity.getDateCreation());
        assertNotNull(organeEntity.getDateMaj());
        assertNotNull(organeEntity.getDateProduction());
        assertNotNull(organeEntity.getDescription());
        assertNotNull(organeEntity.getDescription2());
        assertNotNull(organeEntity.getDateEngagement());
        assertNotNull(organeEntity.getNumeroOrgane());
        assertNotNull(organeEntity.getReference());
        assertNotNull(organeEntity.getStatus());
        assertNotNull(organeEntity.getTypeOrgane());
        assertNotNull(organeEntity.getVersion());
        assertNotNull(organeEntity.getRequestId());
        assertNotNull(organeEntity.getUserCreation());
        assertNotNull(organeEntity.getUserMaj());

    }

}
