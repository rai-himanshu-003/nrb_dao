package com.inetpsa.nrb.constant;

/**
 * error constants enum.
 *
 * @author E566559
 */
public enum ErrorConstant {

    /** The error 3. */
    ERROR_3("ERR2-003"),

    /** The error 4. */
    ERROR_4("ERR2-004"),

    /** The error 6. */
    ERROR_6("ERR2-006"),

    /** The error 16. */
    ERROR_16("ERR2-016"),

    /** The error 7. */
    ERROR_7("ERR2-007"),

    /** The error 17. */
    ERROR_17("ERR2-017"),

    /** The error 9. */
    ERROR_9("ERR2-009"),

    /** The error 10. */
    ERROR_10("ERR2-010"),

    /** The error 11. */
    ERROR_11("ERR2-011"),

    /** The error 15. */
    ERROR_15("ERR2-015"),

    /** The error 13. */
    ERROR_13("ERR2-013"),

    /** The error 14. */
    ERROR_14("ERR2-014"),

    /** The error 19. */
    ERROR_19("ERR2-019"),

    /** The error 18. */
    ERROR_18("ERR2-018"),

    /** The error 8. */
    ERROR_8("ERR2-008"),

    ERROR_5("ERR2-005"),

    /** The warning 12. */
    WARNING_12("WAR2-012"),

    /** The error 2. */
    ERROR_2("ERR2-002");

    /** The const value. */
    String constValue;

    /** The const value int. */
    int constValueInt;

    /**
     * Gets the const value int.
     *
     * @return the const value int
     */
    public int getConstValueInt() {
        return constValueInt;
    }

    /**
     * Instantiates a new common constant.
     *
     * @param constValue the const value
     */
    ErrorConstant(String constValue) {
        this.constValue = constValue;
    }

    /**
     * Gets the const value.
     *
     * @return the const value
     */
    public String getConstValue() {
        return constValue;
    }

}
