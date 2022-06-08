/*
 * Creation : 20 Apr 2022
 */
package com.inetpsa.nrb.util;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.inetpsa.nrb.model.UserInfo;

public class LoggerUserTest {
    /** loggerUser entity */
    static LoggedUser loggedUser;

    UserInfo user;

    private static final ThreadLocal<String> userHolder = new ThreadLocal<>();

    @BeforeAll
    static void setup() {
        userHolder.set("user");
        userHolder.remove();
        LoggedUser.logIn("user");
        LoggedUser.logOut("user");
    }

    @Test
    void testData() {
        assertNull(userHolder.get());

    }

}
