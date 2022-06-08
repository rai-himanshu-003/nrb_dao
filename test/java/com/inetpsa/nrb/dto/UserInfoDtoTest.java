/*
 * Creation : 28 Feb 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.model.UserInfo;

@ContextConfiguration
class UserInfoDtoTest {

    static UserInformationDto userInfoDto;
    static UserInfo userInfo;

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        userInfoDto = new UserInformationDto();
        userInfoDto.setId((long) 3);
        userInfoDto.setType("LANGUAGE");
        userInfoDto.setUserId("E604126");
        userInfoDto.setValue("FR");
    }

    @Test
    void testData() {
        assertNotNull(userInfoDto.getId());
        assertNotNull(userInfoDto.getType());
        assertNotNull(userInfoDto.getValue());
        assertNotNull(userInfoDto.getUserId());
        assertSame((long) 3, userInfoDto.getId());
    }

    @Test
    void testToString() {
        assertEquals("UserInformationDTO [id=3, userId=E604126, type=LANGUAGE, value=FR]", userInfoDto.toString());
    }

    @Test
    void testMapToEntity() {
        userInfo = new UserInfo();
        userInfo = userInfoDto.mapTomodel(userInfo);
        assertNotNull(userInfo);
    }
}
