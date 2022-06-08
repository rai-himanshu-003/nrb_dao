package com.inetpsa.nrb.util;

/***
 * Class contains logged in user details.
 * 
 * @author E570706
 */
public class LoggedUser {

    /**
     * Instantiates a new logged user.
     */
    private LoggedUser() {
    }

    /** The Constant userHolder. */
    private static final ThreadLocal<String> userHolder = new ThreadLocal<>();

    /**
     * Log in.
     *
     * @param user the user
     */
    public static void logIn(String user) {
        userHolder.set(user);
    }

    /**
     * Log out.
     *
     * @param user the user
     */
    public static void logOut(String user) {
        userHolder.remove();
    }

    /**
     * Gets the.
     *
     * @return the user
     */
    public static String get() {
        return userHolder.get();
    }
}