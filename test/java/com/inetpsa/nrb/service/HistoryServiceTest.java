/*
 * Creation : 28 Apr 2022
 */
package com.inetpsa.nrb.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.inetpsa.nrb.JpaConfig;
import com.inetpsa.nrb.model.HistoryEntity;
import com.inetpsa.nrb.model.OrganeEntity;
import com.inetpsa.nrb.repository.HistoryRepository;
import com.inetpsa.nrb.repository.OrganeRepository;

/**
 * The Class HistoryServiceTest.
 */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
public class HistoryServiceTest {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(HistoryServiceTest.class);

    /** The date formatter. */
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /** The date formet. */
    static LocalDateTime dateFormet = LocalDateTime.parse("14-02-2020 07:49:45", dateFormatter);

    /** The now. */
    Timestamp now = new Timestamp(new java.util.Date().getTime());

    /** The history service. */
    @Autowired
    HistoryService historyService;

    /** The history repository. */
    @Autowired
    private HistoryRepository historyRepository;

    /** The organe repository. */
    @Autowired
    OrganeRepository organeRepository;

    /** The history entity. */
    HistoryEntity historyEntity;

    /** The organe entity. */
    OrganeEntity organeEntity;

    /** The history list. */
    List<HistoryEntity> historyList;

    /**
     * Inits the.
     */
    @BeforeEach
    void init() {
        historyList = new ArrayList<HistoryEntity>();
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
        historyList.add(historyEntity);

    }

    /**
     * Testcreate history rec update.
     */
    @Test
    void testcreateHistoryRecUpdate() {
        organeEntity = new OrganeEntity();
        organeEntity.setId(1l);
        organeEntity.setTypeOrgane("34");
        organeEntity.setNumeroOrgane("CBLOT5BAT22");
        organeEntity.setUserCreation("SEXTANT");
        organeEntity.setDateCreation(new Date(02 - 02 - 2020));
        organeEntity.setCurrentValue("Y");
        organeEntity.setVersion(2);
        organeEntity.setCodeAtelier("XZJ21");
        organeEntity.setCodeSgr("QK1");
        organeEntity.setCodeUsing("VR");
        organeEntity.setCurrentValue("Y");
        organeEntity.setDateEngagement(dateFormet);
        organeEntity.setDateMaj(new Date(02 - 02 - 2020));
        organeEntity.setDateProduction(dateFormet);
        organeEntity.setDescription("Battery desc 1");
        organeEntity.setDescription2("Battery desc 2");
        organeEntity.setReference("987567477");
        organeEntity.setRequestId("0049b1f7-8dad-41d9-aded-cb287ed62bfd");
        organeEntity.setStatus("1");
        organeEntity.setUserMaj("SC46266");
        organeRepository.save(organeEntity);

        HistoryEntity historyEntity = historyService.createHistoryRec("5e", "6e", organeEntity, "CODE_ATELIER", "NRBQTORG", 7l);
        assertNotNull(historyEntity);
        logger.info("test testcreateHistoryRecUpdate for update type");
    }

    /**
     * Testcreate history rec create.
     */
    @Test
    void testcreateHistoryRecCreate() {
        organeEntity = new OrganeEntity();
        organeEntity.setId(1l);
        organeEntity.setTypeOrgane("34");
        organeEntity.setNumeroOrgane("CBLOT5BAT22");
        organeEntity.setUserCreation("SEXTANT");
        organeEntity.setDateCreation(new Date(02 - 02 - 2020));
        organeEntity.setCurrentValue("Y");
        organeEntity.setVersion(1);
        organeEntity.setCodeAtelier("XZJ21");
        organeEntity.setCodeSgr("QK1");
        organeEntity.setCodeUsing("VR");
        organeEntity.setCurrentValue("Y");
        organeEntity.setDateEngagement(dateFormet);
        organeEntity.setDateMaj(new Date(02 - 02 - 2020));
        organeEntity.setDateProduction(dateFormet);
        organeEntity.setDescription("Battery desc 1");
        organeEntity.setDescription2("Battery desc 2");
        organeEntity.setReference("987567477");
        organeEntity.setRequestId("0049b1f7-8dad-41d9-aded-cb287ed62bfd");
        organeEntity.setStatus("1");
        organeEntity.setUserMaj("SC46266");
        organeRepository.save(organeEntity);

        HistoryEntity historyEntity = historyService.createHistoryRec(null, "6e", organeEntity, "REFERENCE", "NRBQTORG", 2l);
        assertNotNull(historyEntity);
        logger.info("test testcreateHistoryRecUpdate for create type");
    }

    /**
     * Testcreate history rec delete.
     */
    @Test
    void testcreateHistoryRecDelete() {
        organeEntity = new OrganeEntity();
        organeEntity.setId(1l);
        organeEntity.setTypeOrgane("34");
        organeEntity.setNumeroOrgane("CBLOT5BAT22");
        organeEntity.setUserCreation("SEXTANT");
        organeEntity.setDateCreation(new Date(02 - 02 - 2020));
        organeEntity.setCurrentValue("Y");
        organeEntity.setVersion(1);
        organeEntity.setCodeAtelier("XZJ21");
        organeEntity.setCodeSgr("QK1");
        organeEntity.setCodeUsing("VR");
        organeEntity.setCurrentValue("Y");
        organeEntity.setDateEngagement(dateFormet);
        organeEntity.setDateMaj(new Date(02 - 02 - 2020));
        organeEntity.setDateProduction(dateFormet);
        organeEntity.setDescription("Battery desc 1");
        organeEntity.setDescription2("Battery desc 2");
        organeEntity.setReference("987567477");
        organeEntity.setRequestId("0049b1f7-8dad-41d9-aded-cb287ed62bfd");
        organeEntity.setStatus("1");
        organeEntity.setUserMaj("SC46266");
        organeRepository.save(organeEntity);

        HistoryEntity historyEntity = historyService.createHistoryRec("5e", null, organeEntity, "REFERENCE", "NRBQTORG", 3l);
        assertNotNull(historyEntity);
        logger.info("test testcreateHistoryRecUpdate for delete type");
    }

    /**
     * Testadd history list.
     */
    @Test
    void testaddHistoryList() {
        historyService.addHistoryList(historyList);
        assertNotNull(historyEntity);
    }

    /**
     * Testcreate history rec exception.
     */
    @Test
    void testcreateHistoryRecException() {
        HistoryEntity historyEntity = historyService.createHistoryRec("5e", null, null, "REFERENCE", "NRBQTORG", 3l);
        assertNotNull(historyEntity);

    }

    /**
     * Testadd history list exception.
     */
    @Test
    void testaddHistoryListException() {
        List<HistoryEntity> list = null;
        historyService.addHistoryList(list);
        assertNotNull(historyRepository.findAll());

    }
}
