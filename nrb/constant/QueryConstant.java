/*
 * Creation : 18 Feb 2022
 */
package com.inetpsa.nrb.constant;

/**
 * The Enum QueryConstant.
 */
public enum QueryConstant {

    /** The query select mmfile data. */
    QUERY_SELECT_MMFILE_DATA(
            "SELECT NRBQTMMFILE.ID_FILE,NRBQTMMFILE.FILE_NAME,NRBQTMMFILE.DATE_CREATION,NRBQTMMFILE.DATE_START,NRBQTMMFILE.DATE_END,NRBQTMMFILE.NUMBER_OK,NRBQTMMFILE.NUMBER_KO,NRBQTMMFILE.USER_FILE,\n"
                    + "NRBQTTRAD.LBL_TRAD FROM NRBQTMMFILE, NRBQTTRAD \n" + "WHERE NRBQTMMFILE.STATUS_ID_TRANSLATION=NRBQTTRAD.ID_TRAD\n"
                    + "AND NRBQTTRAD.ID_LANG =? ORDER BY NRBQTMMFILE.DATE_CREATION DESC"),

    /** The query select mmline data. */
    QUERY_SELECT_MMLINE_DATA(
            "SELECT NRBQTMMLINE.ACTION_TYPE, NRBQTMMLINE.ID_DATA, NRBQTMMLINE.TYPE_DATA, NRBQTMMLINE.DATA_VALUE, NRBQTMMLINE.CR_ID_TRANSLATION,NRBQTTRAD.LBL_TRAD FROM NRBQTMMLINE LEFT JOIN NRBQTTRAD ON NRBQTMMLINE.CR_ID_TRANSLATION = NRBQTTRAD.ID_TRAD WHERE NRBQTTRAD.ID_LANG =? AND  NRBQTMMLINE.ID_FILE =? ORDER BY NRBQTMMLINE.ID_LINE");

    /** The query. */
    private String query;

    /**
     * Instantiates a new query constant.
     *
     * @param query the query
     */
    QueryConstant(String query) {
        this.query = query;
    }

    /**
     * Gets the query.
     *
     * @return the query
     */
    public String getQuery() {
        return query;
    }

}
