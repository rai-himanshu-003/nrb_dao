/*
 * Creation : 19 Apr 2022
 */
package com.inetpsa.nrb.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.inetpsa.nrb.dto.BatteryHealthDataDto;
import com.inetpsa.nrb.dto.BatteryModuleHistoryDto;
import com.inetpsa.nrb.dto.ElectronicBatteryDataDto;
import com.inetpsa.nrb.dto.GeneralBatteryDataDto;
import com.inetpsa.nrb.dto.ModuleAndSubassemblyDto;
import com.inetpsa.nrb.model.BmuEntity;
import com.inetpsa.nrb.model.CodeTypeEntity;
import com.inetpsa.nrb.model.CodeTypeEntityPk;
import com.inetpsa.nrb.model.HdataEntity;
import com.inetpsa.nrb.model.HistoryEntity;
import com.inetpsa.nrb.model.Module;
import com.inetpsa.nrb.model.ModuleHistory;
import com.inetpsa.nrb.model.OrganeEntity;
import com.inetpsa.nrb.model.TranslationEntity;
import com.inetpsa.nrb.model.TranslationEntityPk;
import com.inetpsa.nrb.model.Vin;
import com.inetpsa.nrb.repository.BmuRepository;
import com.inetpsa.nrb.repository.CodeTypeRepository;
import com.inetpsa.nrb.repository.HdataRepository;
import com.inetpsa.nrb.repository.HistoryRepository;
import com.inetpsa.nrb.repository.ModuleHistoryRepository;
import com.inetpsa.nrb.repository.ModuleRepository;
import com.inetpsa.nrb.repository.OrganeRepository;
import com.inetpsa.nrb.repository.TranslationRepository;
import com.inetpsa.nrb.repository.VinRepository;

/**
 * The Class BatteryDetailServiceTest.
 */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
class BatteryDetailServiceTest {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(BatteryDetailServiceTest.class);

    /** The date formatter. */
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /** The date formet. */
    static LocalDateTime dateFormet = LocalDateTime.parse("14-02-2020 07:49:45", dateFormatter);

    /** The now. */
    Timestamp now = new Timestamp(new java.util.Date().getTime());

    /** The battery detail service. */
    @Autowired
    BatteryDetailService batteryDetailService;

    /** The organe repository. */
    @Autowired
    OrganeRepository organeRepository;

    /** The bmu repository. */
    @Autowired
    BmuRepository bmuRepository;

    /** The module repository. */
    @Autowired
    ModuleRepository moduleRepository;

    /** The vin repository. */
    @Autowired
    VinRepository vinRepository;

    /** The history repository. */
    @Autowired
    HistoryRepository historyRepository;

    /** The hdata repository. */
    @Autowired
    HdataRepository hdataRepository;

    /** The module history repository. */
    @Autowired
    ModuleHistoryRepository moduleHistoryRepository;

    /** The code type repository. */
    @Autowired
    CodeTypeRepository codeTypeRepository;

    /** The translation repository. */
    @Autowired
    TranslationRepository translationRepository;

    /** The general battery data dto. */
    GeneralBatteryDataDto generalBatteryDataDto;

    /** The electronic battery data dto. */
    ElectronicBatteryDataDto electronicBatteryDataDto;

    /** The electronic battery data dto 2. */
    ElectronicBatteryDataDto electronicBatteryDataDto2;

    /** The battery health data dto. */
    BatteryHealthDataDto batteryHealthDataDto;

    /** The battery module history dto. */
    BatteryModuleHistoryDto batteryModuleHistoryDto;

    /** The module and subassembly dto. */
    ModuleAndSubassemblyDto moduleAndSubassemblyDto;

    /** The organe entity. */
    OrganeEntity organeEntity;

    /** The module. */
    Module module;

    /** The bmu entity. */
    BmuEntity bmuEntity;

    /** The vin. */
    Vin vin;

    /** The hdata entity. */
    HdataEntity hdataEntity;

    /** The module history. */
    ModuleHistory moduleHistory;

    /** The history entity. */
    HistoryEntity historyEntity;

    /** The history entity 2. */
    HistoryEntity historyEntity2;

    /** The code type entity. */
    CodeTypeEntity codeTypeEntity;

    /** The code type entity pk. */
    CodeTypeEntityPk codeTypeEntityPk;

    /** The translation entity. */
    TranslationEntity translationEntity;

    /** The translation entity pk. */
    TranslationEntityPk translationEntityPk;

    /** The component type. */
    String[] componentType = { "MODULE", "SUB-ASSEMBLY", "MODULE OD SUB-ASSEMBLY" };

    /**
     * Inits the.
     */
    @BeforeEach
    void init() {
        bmuEntity = new BmuEntity();
        bmuEntity.setId(102l);
        bmuEntity.setTypeOrgane("34");
        bmuEntity.setNumeroOrgane("CBLOT5BAT20");
        bmuEntity.setSerialNumber("SHUYI56F12345HGT29");
        bmuEntity.setRefSoft("E4$FYKLOIUAGAJ8732");
        bmuEntity.setRefHard("NXBGHSY55698SJAKAOAU");
        bmuEntity.setDateProduction(LocalDateTime.now());
        bmuEntity.setSuppliercode("5948UYHSJSKIEY67358");
        bmuEntity.setRefCal("9693678580");
        bmuEntity.setCurrentValue("Y");
        bmuEntity.setVersion(1);
        bmuRepository.save(bmuEntity);

        vin = new Vin();
        vin.setId(11l);
        vin.setCurrentValue("Y");
        vin.setNumeroOrgane("CBLOT5BAT22");
        vin.setRequestId("9085f504-301a-48d4-b729-2500375ea0a4");
        vin.setTypeOrgane("34");
        vin.setVin("VR1ATTENTKW039309");
        vinRepository.save(vin);

        codeTypeEntity = new CodeTypeEntity();
        codeTypeEntityPk = new CodeTypeEntityPk();
        codeTypeEntity.setCodeTypeEntityPk(new CodeTypeEntityPk("VR", "CODE_USINE"));
        codeTypeEntity.setLblCode("RFVB");
        codeTypeEntity.prePersist();
        codeTypeEntity.preUpdate();
        codeTypeRepository.save(codeTypeEntity);

        codeTypeEntity = new CodeTypeEntity();
        codeTypeEntityPk = new CodeTypeEntityPk();
        codeTypeEntity.setCodeTypeEntityPk(new CodeTypeEntityPk("QK1", "CODE_SGR"));
        codeTypeEntity.setLblCode("RFVB");
        codeTypeEntity.prePersist();
        codeTypeEntity.preUpdate();
        codeTypeRepository.save(codeTypeEntity);

        translationEntity = new TranslationEntity();
        translationEntityPk = new TranslationEntityPk();
        translationEntity.setTranslationEntityPk(new TranslationEntityPk("EN", "Status-1"));
        translationEntity.setLbltrad("");
        translationEntity.setTyptrad("1-STATUS");
        translationEntityPk.setIdlang("EN");
        translationEntityPk.setIdtrad("Status-1");
        translationRepository.save(translationEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PKBA5");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("REF_SOFT");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTBMU");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PKBA5");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("REF_HARD");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTBMU");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PKBA5");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("SERIAL_NUMBER");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTBMU");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("02-02-2020 11:11:11");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("DATE_PRODUCTION");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTBMU");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue(null);
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("DATE_PRODUCTION");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTBMU");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("123");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("SUPPLIER_CODE");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTBMU");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("REF_CAL");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTBMU");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT18");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("SOC");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTHDATA");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT18");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("SOH");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTHDATA");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT18");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("RINSULATION");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTHDATA");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT18");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("RINTERNAL");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTHDATA");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT18");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("MIC");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTHDATA");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT18");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("MAC");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTHDATA");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT18");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("T10");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTHDATA");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT18");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("TAT");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTHDATA");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("REFERENCE");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("DESCRIPTION_2");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("VIN");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("CODE_USINE");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("02-02-2022 02:02:02");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("02-02-2020 02:02:02");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("DATE_PRODUCTION");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue(null);
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setUpdatedColumn("DATE_PRODUCTION");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("02-02-2023 02:02:02");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("02-02-2020 02:02:02");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("DATE_ENGAGEMENT");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue(null);
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("02-02-2020 02:02:02");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("DATE_ENGAGEMENT");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("STATUS");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("CODE_SGR");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

        historyEntity = new HistoryEntity();
        historyEntity.setNewValue("PK01");
        historyEntity.setNumeroOrgane("CBLOT5BAT22");
        historyEntity.setOldValue("PK");
        historyEntity.setTypeUpdate("UPDATE");
        historyEntity.setUpdatedColumn("CODE_ATELIER");
        historyEntity.setTypeOrgane("34");
        historyEntity.setTableName("NRBQTORG");
        historyEntity.preUpdate();
        historyRepository.save(historyEntity);

    }

    /**
     * Test general battery data.
     */
    @Test

    void testGeneralBatteryData() {
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

        List<GeneralBatteryDataDto> generalBatteryDataDto = batteryDetailService.getGeneralBatteryData("34CBLOT5BAT22", "EN");
        assertNotNull(generalBatteryDataDto);
        logger.info("test GeneralBatteryData in BatteryServiceImpl");

    }

    /**
     * Test general battery data two.
     */
    @Test

    void testGeneralBatteryDataTwo() {
        organeEntity = new OrganeEntity();
        organeEntity.setId(1l);
        organeEntity.setTypeOrgane("34");
        organeEntity.setNumeroOrgane("CBLOT5BAT22");
        organeEntity.setUserCreation("SEXTANT");
        organeEntity.setDateCreation(new Date(02 - 02 - 2020));
        organeEntity.setCurrentValue("Y");
        organeEntity.setVersion(1);
        organeEntity.setCodeAtelier(null);
        organeEntity.setCodeSgr(null);
        organeEntity.setCodeUsing(null);
        organeEntity.setCurrentValue("Y");
        organeEntity.setDateEngagement(null);
        organeEntity.setDateMaj(new Date(02 - 02 - 2020));
        organeEntity.setDateProduction(null);
        organeEntity.setDescription("Battery desc 1");
        organeEntity.setDescription2(null);
        organeEntity.setReference(null);
        organeEntity.setRequestId("0049b1f7-8dad-41d9-aded-cb287ed62bfd");
        organeEntity.setStatus(null);
        organeEntity.setUserMaj("SC46266");
        organeRepository.save(organeEntity);

        List<GeneralBatteryDataDto> generalBatteryDataDto = batteryDetailService.getGeneralBatteryData("34CBLOT5BAT22", "EN");
        assertNotNull(generalBatteryDataDto);
        logger.info("test GeneralBatteryData in BatteryServiceImpl");

    }

    /**
     * Test general battery history data.
     */
    @Test
    void testGeneralBatteryHistoryData() {
        List<GeneralBatteryDataDto> generalBatteryDataDto = batteryDetailService.getGeneralBatteryHistory("34CBLOT5BAT22");
        assertNotNull(generalBatteryDataDto);
        logger.info("test GeneralBatteryHistoryData in BatteryServiceImpl");

    }

    /**
     * Testget electronic battery data.
     */
    @Test
    void testgetElectronicBatteryData() {
        List<ElectronicBatteryDataDto> electronicBatteryDataDto = batteryDetailService.getElectronicBatteryData("34CBLOT5BAT20");
        assertNotNull(electronicBatteryDataDto);
        logger.info("test getElectronicBatteryData in BatteryServiceImpl");

    }

    /**
     * Testget electronic battery history data.
     */
    @Test
    void testgetElectronicBatteryHistoryData() {
        List<ElectronicBatteryDataDto> electronicBateryatteryDataDto = batteryDetailService.getElectronicBatteryHistoryData("34CBLOT5BAT22");
        assertNotNull(electronicBateryatteryDataDto);
        logger.info("test getElectronicBatteryHistoryData in BatteryServiceImpl");

    }

    /**
     * Testget battery health data.
     */
    @Test
    void testgetBatteryHealthData() {
        hdataEntity = new HdataEntity();
        hdataEntity.setId(1l);
        hdataEntity.setCurrentValue("Y");
        hdataEntity.setMac("3.524");
        hdataEntity.setMic("3.000");
        hdataEntity.setNumeroOrgane("CBLOT5BAT18");
        hdataEntity.setRinsulation("60000");
        hdataEntity.setRinternal("90");
        hdataEntity.setSoc("21");
        hdataEntity.setSoh("103");
        hdataEntity.setT10("381");
        hdataEntity.setTat("18");
        hdataEntity.setTypeOrgane("34");
        hdataEntity.setVersion(0);
        hdataRepository.save(hdataEntity);

        List<BatteryHealthDataDto> batteryHealthDataDto = batteryDetailService.getBatteryHealthData("34CBLOT5BAT18");
        assertNotNull(batteryHealthDataDto);
        logger.info("test getBatteryHealthData in BatteryServiceImpl");

    }

    /**
     * Testget battery health history data.
     */
    @Test
    void testgetBatteryHealthHistoryData() {
        List<BatteryHealthDataDto> batteryHealthDataDto = batteryDetailService.getBatteryHealthHistoryData("34CBLOT5BAT18");
        assertNotNull(batteryHealthDataDto);
        logger.info("test getBatteryHealthHistoryData in BatteryServiceImpl");

    }

    /**
     * Test module and sub assembly data.
     */
    @Test
    void testModuleAndSubAssemblyData() {

        module = new Module();
        module.setCurrentValue("Y");
        module.setDescription2("SUPPORT BATTERIE TEST84 2020");
        module.setId(594l);
        module.setNumeroModule("CBLOT5BAT22");
        module.setNumeroOrgane("CBLOT5BAT22");
        module.setTypeModule("34");
        module.setTypeOrgane("34");
        module.setVersion(0);
        moduleRepository.save(module);

        module = new Module();
        module.setCurrentValue("Y");
        module.setDescription2("SUPPORT BATTERIE TEST84 2020");
        module.setId(594l);
        module.setNumeroModule("CBLOT5BAT32");
        module.setNumeroOrgane("CBLOT5BAT22");
        module.setTypeModule("34");
        module.setTypeOrgane("34");
        module.setVersion(0);
        moduleRepository.save(module);

        moduleHistory = new ModuleHistory();
        moduleHistory.setId(1l);
        moduleHistory.setModId(1l);
        moduleHistory.setTypeOrgane("34");
        moduleHistory.setNumeroOrgane("CBLOT5BAT22");
        moduleHistory.setTypeModule("34");
        moduleHistory.setTypeModule("CBLOT5BAT22");
        moduleHistory.setDescription2("abc");
        moduleHistory.preUpdate();
        moduleHistory.setUserUpdate("CORVET");
        moduleHistory.setTypeUpdate("CREATE");
        moduleHistoryRepository.save(moduleHistory);

        List<ModuleAndSubassemblyDto> batteryHealthDataDto = batteryDetailService.getBatteryModuleAndAssemblyData("34CBLOT5BAT22", componentType);
        assertNotNull(batteryHealthDataDto);
        long totalRecord = batteryDetailService.findTotalRecords();
        assertNotNull(totalRecord);
        logger.info("test ModuleAndSubAssemblyData in BatteryServiceImpl");

    }

    /**
     * Test module history data.
     */
    @Test
    void testModuleHistoryData() {

        moduleHistory = new ModuleHistory();
        moduleHistory.setId(1l);
        moduleHistory.setModId(1l);
        moduleHistory.setTypeOrgane("34");
        moduleHistory.setNumeroOrgane("CBLOT5BAT22");
        moduleHistory.setTypeModule("34");
        moduleHistory.setNumeroModule("CBLOT5BAT22");
        moduleHistory.setDescription2("abc");
        moduleHistory.preUpdate();
        moduleHistory.setUserUpdate("CORVET");
        moduleHistory.setTypeUpdate("CREATE");
        moduleHistoryRepository.save(moduleHistory);

        List<BatteryModuleHistoryDto> batteryModuleHistoryDto = batteryDetailService.getBatteryModuleHistoryData("34CBLOT5BAT22", componentType);
        assertNotNull(batteryModuleHistoryDto);
        logger.info("test ModuleHistoryData in BatteryServiceImpl");

    }

}