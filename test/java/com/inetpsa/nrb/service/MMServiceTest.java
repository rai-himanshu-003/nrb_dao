
/*
 * Creation : 1 Feb 2022
 */
package com.inetpsa.nrb.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
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
import com.inetpsa.nrb.dto.MassMvtValidationDto;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.model.HdataEntity;
import com.inetpsa.nrb.model.MassMvtFile;
import com.inetpsa.nrb.model.MassMvtLine;
import com.inetpsa.nrb.model.MassMvtLinePk;
import com.inetpsa.nrb.model.Module;
import com.inetpsa.nrb.model.OrganeEntity;
import com.inetpsa.nrb.model.Vin;
import com.inetpsa.nrb.repository.HdataRepository;
import com.inetpsa.nrb.repository.MMFileRepository;
import com.inetpsa.nrb.repository.MMLineRepository;
import com.inetpsa.nrb.repository.ModuleRepository;
import com.inetpsa.nrb.repository.OrganeRepository;
import com.inetpsa.nrb.repository.VinRepository;
import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class MMServiceTest.
 */

@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
public class MMServiceTest {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(MMServiceTest.class);
    /** The anomalies service impl. */
    @Autowired
    MassMovementService massMovementService;

    @Autowired
    MMFileRepository fileRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    OrganeRepository organeRepository;

    @Autowired
    MMLineRepository lineRepository;

    @Autowired
    VinRepository vinRepository;

    @Autowired
    HdataRepository hdataRepository;

    /** The response dto. */
    ResponseDto responseDto;

    /** The anomalies translation. */
    MassMvtFile massMvtFile;
    MassMvtLine massMvtLine;
    MassMvtLinePk mmLinePk;
    Module module;
    OrganeEntity organe;
    Vin vin;

    /**
     * Inits the.
     */
    @BeforeEach
    void init() {
        massMvtFile = new MassMvtFile();
        massMvtFile.setIdFile(1l);
        massMvtFile.setFileName("MM1.xlsx");
        massMvtFile.setTranslationStatus("IN_PROGRESS");
        massMvtFile.setDateEnd(new Date());

        fileRepository.save(massMvtFile);

        massMvtLine = new MassMvtLine();
        mmLinePk = new MassMvtLinePk();
        mmLinePk.setIdFile(1l);
        mmLinePk.setIdLine(1l);
        massMvtLine.setMassMvtLinePk(mmLinePk);
        massMvtLine.setIdData("1");
        massMvtLine.setTypeData("BIN");
        massMvtLine.setActionType("CID");
        lineRepository.save(massMvtLine);

        LoggedUser.logIn("E566559");

        organe = new OrganeEntity();
        organe.setId(1l);
        organe.setTypeOrgane("34");
        organe.setNumeroOrgane("TESTLOT5001");
        organe.setStatus("Y");
        organe.setStatus("S");
        organe.setUserCreation("SEXTANT");
        organe.setDateCreation(new Timestamp(new Date().getTime()));
        organe.setCurrentValue("Y");
        organe.setVersion(1);
        organeRepository.save(organe);

        module = new Module();
        module.setId(1l);
        module.setTypeOrgane("34");
        module.setNumeroOrgane("TESTLOT5001");
        module.setNumeroModule("TESTLOT5001");
        module.setTypeModule("RA");
        module.setCurrentValue("Y");
        module.setVersion(1);

        module.setDescription2("REFROIDISSEUR CENTRAL BATTERIE_UPDATE");

        moduleRepository.save(module);

        HdataEntity entity = new HdataEntity();
        entity.setId(1l);
        entity.setTypeOrgane("34");
        entity.setNumeroOrgane("TESTLOT5001");
        entity.setSoc("100");
        entity.setSoh("100");
        entity.setMac("mac");
        entity.setMic("mic");
        entity.setRinsulation("RIN");
        entity.setRinternal("RIL");
        entity.setT10("t10");
        entity.setTat("Tat");
        entity.setCurrentValue("Y");
        entity.setVersion(1);
        hdataRepository.save(entity);

    }

    @Test
    public void TestPurgeData() {
        Boolean result = massMovementService.purgeMMData(45);
        assertTrue(result);
    }

    @Test
    public void TestFindModuleSubAssemblyModAssembled() {
        List<String> tableList = new ArrayList<>();
        tableList.add("NRBQTORG");
        vin = new Vin();
        vin.setId(1l);
        vin.setNumeroOrgane("TESTLOT5001");
        vin.setTypeOrgane("34");
        vin.setVin("VIN123");
        vinRepository.save(vin);
        MassMvtValidationDto vdto = massMovementService.findModuleSubAssemblyModAssembled("34CBLOT4BAT01", "RA41LOT400051");
        massMovementService.getBatteryCharList("34TESTLOT5001");
        massMovementService.getBatteryVehicle("34TESTLOT5001");
        massMovementService.verifyBattery("34TESTLOT5001");
        massMovementService.findModuleSubAssembly("34TESTLOT5001");
        massMovementService.findVinBinMapping("VIN123");
        massMovementService.findVinBinMapping("VIN1234");
        massMovementService.findVinByOrgane("34TESTLOT5001");
        massMovementService.getBatteryHealthData("34TESTLOT5001");

        assertNotNull(vdto);
    }

}
