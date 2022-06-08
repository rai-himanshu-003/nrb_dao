/*
 * Creation : 28 Feb 2022
 */
package com.inetpsa.nrb.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import com.inetpsa.nrb.dto.UserInformationDto;
import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class UserInfoEntityTest.
 */
@ContextConfiguration
class UserInfoEntityTest {

    /** The user info. */
    static UserInfo userInfo;

    /** The user info dto. */
    static UserInformationDto userInfoDto;

    /** the loggerUser entity */
    static LoggedUser loggerUser;

    /** The now. */
    LocalDateTime now = LocalDateTime.now();

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        userInfo = new UserInfo();
        userInfo.setId((long) 12);
        userInfo.setType("LANGUAGE");
        userInfo.setUserId("E604126");
        userInfo.setValue("FR");
        userInfo.setVersion(2);
        userInfo.prePersist();
        userInfo.preUpdate();

    }

    /**
     * Test data.
     */
    @Test
    void testData() {
        assertSame((long) 12, userInfo.getId());
        assertNotNull(userInfo.getType());
        assertNotNull(userInfo.getUserId());
        assertNotNull(userInfo.getValue());
        assertNotNull(userInfo.getVersion());
        assertNotNull(userInfo.getDateCreation());
        assertNotNull(userInfo.getDateModif());
        assertNotNull(userInfo.getUserCreation());
        assertNotNull(userInfo.getUserModif());

    }

    /**
     * Test not equal user info.
     */
    @Test
    void testNotEqualUserInfo() {
        UserInfo user1 = new UserInfo((long) 2, "E604126", "LANGUAGE", "FR", now, "E604126", now, "E604126", 5);
        UserInfo user2 = new UserInfo();
        boolean equal = user1.equals(user2);
        assertFalse(equal);
    }

    /**
     * Test mapto dto.
     */
    @Test
    void testMaptoDto() {
        userInfoDto = userInfo.maptoDto();
        assertNotNull(userInfoDto);

    }
}
