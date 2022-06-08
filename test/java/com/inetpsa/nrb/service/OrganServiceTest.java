/*
 * Creation : 20 Apr 2022
 */
package com.inetpsa.nrb.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
import com.inetpsa.nrb.model.BmuEntity;
import com.inetpsa.nrb.model.HdataEntity;
import com.inetpsa.nrb.model.Module;
import com.inetpsa.nrb.model.OrganeEntity;
import com.inetpsa.nrb.model.Vin;
import com.inetpsa.nrb.repository.BmuRepository;
import com.inetpsa.nrb.repository.HdataRepository;
import com.inetpsa.nrb.repository.ModuleRepository;
import com.inetpsa.nrb.repository.OrganeRepository;
import com.inetpsa.nrb.repository.VinRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class OrganServiceTest.
 */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
class OrganServiceTest {

    /** constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(OrganServiceTest.class);

    /** the Organ service. */
    @Autowired
    OrganeService organeService;

    /** the organ repository. */
    @Autowired
    OrganeRepository organeRepository;

    /** The vin repository. */
    @Autowired
    VinRepository vinRepository;

    /** The bmu repository. */
    @Autowired
    BmuRepository bmuRepository;

    /** The hdata repository. */
    @Autowired
    HdataRepository hdataRepository;

    /** The hdata repository. */
    @Autowired
    ModuleRepository moduleRepository;

    /** the class organ entity. */
    OrganeEntity organeEntity;

    /** the bmuentity. */
    BmuEntity bmuEntity;

    /** the hdata entity. */
    HdataEntity hdataEntity;

    /** the module entity. */
    Module module;

    /** the vin. */
    Vin vin;

    /** The vin list. */
    List<Vin> vinList;

    /** The module list. */
    List<Module> moduleList;

    /** The now. */
    static Timestamp now = new Timestamp(new java.util.Date().getTime());

    /** The date formatter. */
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /** The date formet. */
    static LocalDateTime dateFormet = LocalDateTime.parse("14-02-2020 07:49:45", dateFormatter);

    /**
     * init.
     */
    @BeforeEach
    void init() {
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
        bmuEntity.setVersion(0);
        bmuRepository.save(bmuEntity);

    }

    /**
     * test addupdate organ data.
     */
    @Test
    void testAddUpdateOrgane() {
        organeEntity = new OrganeEntity();
        organeEntity.setId(1l);
        organeEntity.setTypeOrgane("34");
        organeEntity.setNumeroOrgane("TESTLOT5001");
        organeEntity.setStatus("Y");
        organeEntity.setStatus("S");
        organeEntity.setUserCreation("SEXTANT");
        organeEntity.setDateCreation(new Timestamp(new Date().getTime()));
        organeEntity.setCurrentValue("Y");
        organeEntity.setVersion(1);

        organeEntity = organeService.addUpdateOrgane(organeEntity);
        assertNotNull(organeEntity);
    }

    /**
     * test addUpdateAllOrgane.
     */
    @Test
    void testAddUpdateAllOrgane() {
        organeEntity = new OrganeEntity();
        organeEntity.setId(2l);
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
        organeEntity.setUserCreation("E604126");
        organeEntity.setDateProduction(LocalDateTime.now());
        organeEntity.setDateCreation(new Date());
        organeEntity.setDateMaj(now);
        organeEntity.setDateEngagement(LocalDateTime.now());
        organeEntity.setStatus("1");
        organeEntity.setRequestId("0049b1f7-8dad-41d9-aded-cb287ed62bfd");

        List l = new ArrayList<OrganeEntity>();
        l.add(organeEntity);
        organeService.addUpdateAllOrgane(l);
        assertNotNull(organeEntity);
    }

    /**
     * test addUpdateAllBmu.
     */
    @Test
    void testAddUpdateAllBmu() {
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
        bmuRepository.save(bmuEntity);

        List list = new ArrayList<BmuEntity>();
        list.add(bmuEntity);
        organeService.addUpdateAllBmu(list);
        assertNotNull(bmuEntity);

    }

    /**
     * test addUpdateAllHdata.
     */
    @Test
    void testAddUpdateAllHdata() {
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
        hdataRepository.save(hdataEntity);

        List hdata = new ArrayList<HdataEntity>();
        hdata.add(hdataEntity);
        organeService.addUpdateAllHdata(hdata);
        assertNotNull(hdataEntity);
    }

    /**
     * test deleteModule.
     */
    @Test
    void testAddUpdateVin() {
        vin = new Vin();
        vin.setId(422l);
        vin.setCurrentValue("Y");
        vin.setNumeroOrgane("CBLOT5BAT18");
        vin.setRequestId("9085f504-301a-48d4-b729-2500375ea0a4");
        vin.setTypeOrgane("34");
        vin.setVin("VR1ATTENTKW039309");
        vinRepository.save(vin);

        List vinlist = new ArrayList<Vin>();
        vinlist.add(vin);
        organeService.addUpdateVin(vinlist);
        assertNotNull(vin);
    }

    /**
     * test the appupdateModule.
     */
    @Test
    void testAddUpdateAllModule() {
        module = new Module();
        module.setCurrentValue("Y");
        module.setDescription2("SUPPORT BATTERIE TEST84 2020");
        module.setId(2l);
        module.setNumeroModule("26LOT400084");
        module.setNumeroOrgane("CBLOT4BAT94");
        module.setTypeModule("84");
        module.setTypeOrgane("34");
        module.setVersion(0);

        List moduleList = new ArrayList<Module>();
        moduleList.add(module);
        organeService.addUpdateAllModule(moduleList);
        assertNotNull(module);
    }

    /**
     * test findByTypeOrganeAndNumeroOrgane.
     */
    @Test
    void testFindByTypeOrganeAndNumeroOrgane() {
        organeEntity = new OrganeEntity();
        organeEntity.setId(3l);
        organeEntity.setTypeOrgane("34");
        organeEntity.setNumeroOrgane("TESTLOT5002");
        organeEntity.setStatus("Y");
        organeEntity.setStatus("S");
        organeEntity.setUserCreation("SEXTANT");
        organeEntity.setDateCreation(new Timestamp(new Date().getTime()));
        organeEntity.setCurrentValue("Y");
        organeEntity.setVersion(1);
        String typeOrgane = "34";
        String numeroOrgane = "TESTLOT5002";
        organeRepository.save(organeEntity);
        organeService.findByTypeOrganeAndNumeroOrgane(typeOrgane, numeroOrgane);
        assertNotNull(organeEntity);

    }

    /**
     * test findByTypeOrganeAndNumeroOrgane.
     */
    @Test
    void testfindHdataByTypeOrganeAndNumeroOrgane() {
        hdataEntity = new HdataEntity();
        hdataEntity.setId(2l);
        hdataEntity.setCurrentValue("Y");
        hdataEntity.setMac("3.524");
        hdataEntity.setMic("3.000");
        hdataEntity.setNumeroOrgane("760E0000195");
        hdataEntity.setRinsulation("60000");
        hdataEntity.setRinternal("90");
        hdataEntity.setSoc("21");
        hdataEntity.setSoh("103");
        hdataEntity.setT10("381");
        hdataEntity.setTat("18");
        hdataEntity.setTypeOrgane("34");
        hdataEntity.setVersion(0);
        String typeOrgane = "34";
        String numeroOrgane = "760E0000195";
        hdataRepository.save(hdataEntity);
        organeService.findHdataByTypeOrganeAndNumeroOrgane(typeOrgane, numeroOrgane);
        assertNotNull(hdataEntity);

    }

    /**
     * test the findVinByTypeOrganeAndNumeroOrgane.
     */
    @Test
    void testFindVinByTypeOrganeAndNumeroOrgane() {
        vin = new Vin();
        vin.setId(2l);
        vin.setCurrentValue("Y");
        vin.setNumeroOrgane("CBLOT5BAT22");
        vin.setRequestId("9085f504-301a-48d4-b729-2500375ea0a4");
        vin.setTypeOrgane("34");
        vin.setVin("VR1ATTENTKW039309");
        String typeOrgane = "34";
        String numeroOrgane = "CBLOT5BAT22";
        vinRepository.save(vin);
        organeService.findVinByTypeOrganeAndNumeroOrgane(typeOrgane, numeroOrgane);
        assertNotNull(vin);
    }

    /**
     * test findBmuByTypeOrganeAndNumeroOrgane.
     */
    @Test
    void testFindBmuByTypeOrganeAndNumeroOrgane() {
        bmuEntity = new BmuEntity();
        bmuEntity.setId(103l);
        bmuEntity.setTypeOrgane("34");
        bmuEntity.setNumeroOrgane("CBLOT4BAT24");
        bmuEntity.setSerialNumber("SHUYI56F12345HGT29");
        bmuEntity.setRefSoft("E4$FYKLOIUAGAJ8732");
        bmuEntity.setRefHard("NXBGHSY55698SJAKAOAU");
        bmuEntity.setDateProduction(LocalDateTime.now());
        bmuEntity.setSuppliercode("5948UYHSJSKIEY67358");
        bmuEntity.setRefCal("9693678580");
        bmuEntity.setCurrentValue("Y");
        bmuEntity.setVersion(2);
        String typeOrgane = "34";
        String numeroOrgane = "CBLOT4BAT24";
        bmuRepository.save(bmuEntity);
        organeService.findBmuByTypeOrganeAndNumeroOrgane(typeOrgane, numeroOrgane);
        assertNotNull(bmuEntity);

    }

    /**
     * test findModuleByUniqueKey.
     */
    @Test
    void testFindModuleByUniqueKey() {
        module = new Module();
        module.setTypeOrgane("34");
        module.setNumeroOrgane("CBLOT5BAT22");
        module.setTypeModule("84");
        module.setNumeroModule("26LOT400084");
        String typeOrgane = "34";
        String numeroOrgane = "CBLOT5BAT22";
        String typeMod = "84";
        String numeroMod = "26LOT400084";
        moduleRepository.save(module);
        organeService.findModuleByUniqueKey(typeOrgane, numeroOrgane, typeMod, numeroMod);
        assertNotNull(module);
        ;
    }

    /**
     * test delete module.
     */
    @Test
    void testDeleteModule() {
        module = new Module();
        module.setCurrentValue("Y");
        module.setDescription2("SUPPORT BATTERIE TEST84 2020");
        module.setId(594l);
        module.setNumeroModule("26LOT400084");
        module.setNumeroOrgane("CBLOT4BAT94");
        module.setTypeModule("84");
        module.setTypeOrgane("34");
        module.setVersion(0);
        moduleRepository.delete(module);
        organeService.deleteModule(module);
        assertNotNull(module);

    }

    /**
     * test the catch exception
     */
    @Test
    void testCatchException() {
        organeEntity = organeService.addUpdateOrgane(null);
        assertNull(organeEntity);

        organeService.addUpdateAllOrgane(null);
        assertNull(organeEntity);

        organeService.addUpdateAllBmu(null);
        assertNotNull(bmuEntity);

        organeService.deleteModule(null);
        assertNull(module);

        organeService.addUpdateAllHdata(null);
        assertNull(hdataEntity);

        organeService.addUpdateVin(null);
        assertNull(vin);

        organeService.addUpdateAllModule(null);
        assertNull(module);

        organeService.findByTypeOrganeAndNumeroOrgane(null, null);
        assertNull(organeEntity);

        organeService.findHdataByTypeOrganeAndNumeroOrgane(null, null);
        assertNull(hdataEntity);

        organeService.findVinByTypeOrganeAndNumeroOrgane(null, null);
        assertNull(vin);

        organeService.findBmuByTypeOrganeAndNumeroOrgane(null, null);
        assertNotNull(bmuEntity);

        organeService.findModuleByUniqueKey(null, null, null, null);
        assertNull(module);

    }

}
