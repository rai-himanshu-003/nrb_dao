/*
 * Creation : 28 Feb 2022
 */
package com.inetpsa.nrb.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.inetpsa.nrb.JpaConfig;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.dto.UserInformationDto;
import com.inetpsa.nrb.model.UserInfo;
import com.inetpsa.nrb.repository.UserInfoRepository;

/**
 * The Class UserInfoServiceTest.
 */
@SpringBootTest
@ContextConfiguration(classes = { JpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@DirtiesContext
@Transactional
class UserInfoServiceTest {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

    /** The user info service. */
    @Autowired
    UserInfoService userInfoService;

    /** The user repository. */
    @Autowired
    UserInfoRepository userRepository;

    /** The user dto. */
    UserInformationDto userDto;

    /** The response dto. */
    ResponseDto responseDto;

    /** The user info. */
    UserInfo userInfo;

    /**
     * User info service.
     */
    @Test
    public void UserInfoService() {

        userInfo = new UserInfo();

        userInfo.setUserId("E123");
        userInfo.setType("LAN");
        userInfo.setValue("EN");
        userRepository.save(userInfo);

        UserInformationDto userInformationDTO = new UserInformationDto();
        userInformationDTO.setUserId("E123");
        userInformationDTO.setType("LAN");
        userInformationDTO.setValue("EN");

        Assertions.assertThat(userInfoService.updateUserInfo(userInformationDTO)).isNotNull();
        userInformationDTO.setId(1l);
        Assertions.assertThat(userInfoService.updateUserInfo(userInformationDTO)).isNotNull();

    }

}
