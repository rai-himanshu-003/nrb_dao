/*
 * Creation : 14 Mar 2022
 */
package com.inetpsa.nrb.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
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
import com.inetpsa.nrb.dto.BatteryDto;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.model.OrganeEntity;
import com.inetpsa.nrb.repository.OrganeRepository;

/**
 * The Class BatteryServiceTest.
 */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
class BatteryServiceTest {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(BatteryServiceTest.class);

    /** The battery service. */
    @Autowired
    BatteryService batteryService;

    /** The organe repository. */
    @Autowired
    OrganeRepository organeRepository;

    /** The response dto. */
    ResponseDto responseDto;

    /** The battery dto. */
    BatteryDto batteryDto;

    /** The battery entity. */
    OrganeEntity batteryEntity;

    /**
     * Inits the.
     *
     * @throws ParseException the parse exception
     */
    @BeforeEach
    void init() throws ParseException {

    }

    /**
     * Test get list.
     */
    @Test
    void TestGetList1() {
        batteryEntity = new OrganeEntity();
        batteryEntity.setId(24l);
        batteryEntity.setCodeUsing("BJ");
        batteryEntity.setNumeroOrgane("CBLOT4BAT93");
        batteryEntity.setTypeOrgane("34");
        batteryEntity.setStatus("1");
        batteryEntity.setReference("9998856663");
        batteryEntity.setCurrentValue("Y");
        batteryEntity.setVersion(2);
        organeRepository.save(batteryEntity);

        batteryDto = new BatteryDto();
        batteryDto.setRefrence("9998856663");
        batteryDto.setLang("FR");
        List<BatteryDto> batteryDtoList = batteryService.getBatteryList(batteryDto, 0, 10);
        assertNotNull(batteryDtoList);

    }

    /**
     * Test get list 2.
     */
    @Test
    void TestGetList2() {
        batteryEntity = new OrganeEntity();
        batteryEntity.setCodeUsing("BH");
        batteryEntity.setId(23l);
        batteryEntity.setNumeroOrgane("CBLOT4T93");
        batteryEntity.setTypeOrgane("36");
        batteryEntity.setStatus("1");
        batteryEntity.setReference("9998856678");
        batteryEntity.setCurrentValue("Y");
        batteryEntity.setVersion(2);
        organeRepository.save(batteryEntity);

        batteryDto = new BatteryDto();
        batteryDto.setRefrence("9998856678");
        batteryDto.setRefrenceOrder("desc");
        batteryDto.setLang("FR");
        List<BatteryDto> batteryDtoList = batteryService.getBatteryList(batteryDto, 10, 10);
        assertNotNull(batteryDtoList);

    }

    /**
     * Test get list 3.
     */
    @Test
    void TestGetList3() {
        batteryEntity = new OrganeEntity();
        batteryEntity.setCodeUsing("HT");
        batteryEntity.setId(28l);
        batteryEntity.setNumeroOrgane("CBLOT4BAT91");
        batteryEntity.setTypeOrgane("36");
        batteryEntity.setStatus("1");
        batteryEntity.setReference("99856678");
        batteryEntity.setCurrentValue("Y");
        batteryEntity.setVersion(2);
        organeRepository.save(batteryEntity);

        batteryDto = new BatteryDto();
        batteryDto.setStatus("1");
        batteryDto.setStatusOrder("desc");
        batteryDto.setLang("FR");
        List<BatteryDto> batteryDtoList = batteryService.getBatteryList(batteryDto, 0, 10);
        assertNotNull(batteryDtoList);

    }

    /**
     * Test get list 4.
     */
    @Test
    void TestGetList4() {
        batteryEntity = new OrganeEntity();
        batteryEntity.setCodeUsing("KT");
        batteryEntity.setId(86l);
        batteryEntity.setNumeroOrgane("CBLOT4T91");
        batteryEntity.setTypeOrgane("36");
        batteryEntity.setStatus("1");
        batteryEntity.setReference("9985667878");
        batteryEntity.setCurrentValue("Y");
        batteryEntity.setVersion(2);
        organeRepository.save(batteryEntity);

        batteryDto = new BatteryDto();
        batteryDto.setStatus("1");
        batteryDto.setBin("36CBLOT4T91");
        batteryDto.setFactoryCodeOrder("desc");
        batteryDto.setLang("FR");
        List<BatteryDto> batteryDtoList = batteryService.getBatteryList(batteryDto, 0, 10);
        assertNotNull(batteryDtoList);

    }

    /**
     * Test get list 5.
     */
    @Test
    void TestGetList5() {
        batteryEntity = new OrganeEntity();
        batteryEntity.setCodeUsing("TS");
        batteryEntity.setId(76l);
        batteryEntity.setNumeroOrgane("CBLOT4T99");
        batteryEntity.setTypeOrgane("36");
        batteryEntity.setStatus("1");
        batteryEntity.setReference("9985667878");
        batteryEntity.setCurrentValue("Y");
        batteryEntity.setVersion(2);
        organeRepository.save(batteryEntity);

        batteryDto = new BatteryDto();
        batteryDto.setStatus("1");
        batteryDto.setBin("36CBLOT4T99");
        batteryDto.setFactoryCode("TS");
        batteryDto.setProdDateOrder("desc");
        batteryDto.setLang("FR");
        List<BatteryDto> batteryDtoList = batteryService.getBatteryList(batteryDto, 0, 10);
        assertNotNull(batteryDtoList);

    }

    /**
     * Test get list 6.
     */
    @Test
    void TestGetList6() {
        batteryEntity = new OrganeEntity();
        batteryEntity.setCodeUsing("GT");
        batteryEntity.setId(76l);
        batteryEntity.setNumeroOrgane("CBLOT4T100");
        batteryEntity.setTypeOrgane("34");
        batteryEntity.setStatus("2");
        batteryEntity.setReference("99856678");
        batteryEntity.setCurrentValue("Y");
        batteryEntity.setVersion(2);
        organeRepository.save(batteryEntity);

        batteryDto = new BatteryDto();
        batteryDto.setStatus("2");
        batteryDto.setExtFromDate(new Date());
        batteryDto.setExtToDate(new Date());
        batteryDto.setBinOrder("desc");
        batteryDto.setLang("FR");
        List<BatteryDto> batteryDtoList = batteryService.getBatteryList(batteryDto, 0, 10);
        assertNotNull(batteryDtoList);

    }
}
