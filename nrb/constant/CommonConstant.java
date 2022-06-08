package com.inetpsa.nrb.constant;

/**
 * common constants enum.
 *
 * @author E566559
 */
public enum CommonConstant {

    /** The bin1. */
    BIN1("<BIN1>"),
    /** The bin2. */
    BIN2("<BIN2>"),
    /** The vin. */
    VIN("<VIN>"),
    /** The nrbqtvinvin. */
    NRBQTVINVIN("{NRBQTVIN.VIN}"),
    /** The nrbqtorgstatus. */
    NRBQTORGSTATUS("{NRBQTORG.STATUS}"),

    /** The mass movement max lines. */
    MASS_MOVEMENT_MAX_LINES("MAX_LINE_EXCEL_MM"),

    /** The data. */
    DATA("Data {}"),
    /** The iddata. */
    IDDATA("idData"),

    /** The exception addupdate mmfile. */
    EXCEPTION_ADDUPDATE_MMFILE("Exception in  addUpdateMMLine {}"),

    /** The no result found. */
    NO_RESULT_FOUND("No result found"),

    /** The exception addupdate organe. */
    EXCEPTION_ADDUPDATE_ORGANE("Exception in  addUpdateOrgane {}"),

    /** The typeorgane. */
    TYPEORGANE("typeOrgane"),

    /** The numeroorgane. */
    NUMEROORGANE("numeroOrgane"),

    /** The create new. */
    CREATE_NEW("CID"),

    /** The update. */
    UPDATE("U"),

    /** The ss ens. */
    SS_ENS("SS_ENS"),

    /** The bin. */
    BIN("BIN"),

    /** The bat reference. */
    BAT_REFERENCE("BAT_REFERENCE"),

    /** The vin const. */
    VIN_CONST("VIN"),

    /** The soh. */
    SOH("SOH"),

    /** The soc. */
    SOC("SOC"),

    /** The mac. */
    MAC("MAC"),

    /** The mic. */
    MIC("MIC"),
    /** The rim. */
    RIM("RIM"),

    /** The res. */
    RES("RES"),

    /** The t10. */
    T10("T10"),

    /** The tat. */
    TAT("TAT"),

    /** The bat medaille module. */
    BAT_MEDAILLE_MODULE("BAT_MEDAILLE_MODULE"),

    /** The bat medaille ss ens. */
    BAT_MEDAILLE_SS_ENS("BAT_MEDAILLE_SS_ENS"),

    /** The ss ens reference. */
    SS_ENS_REFERENCE("SS_ENS_REFERENCE"),

    /** The ss ens medaille module. */
    SS_ENS_MEDAILLE_MODULE("SS_ENS_MEDAILLE_MODULE"),

    /** The ss ens date engagement. */
    SS_ENS_DATE_ENGAGEMENT("SS_ENS_DATE_ENGAGEMENT"),

    /** The ss ens medaille module. */
    SS_ENS_DATE_PRODUCTION("SS_ENS_DATE_PRODUCTION"),

    /** The bat medaille module. */
    SS_ENS_CODE_SGR("SS_ENS_CODE_SGR"),

    /** The bat medaille ss ens. */
    SS_ENS_CODE_USINE("SS_ENS_CODE_USINE"),

    /** The ss ens reference. */
    SS_ENS_CODE_ATELIER("SS_ENS_CODE_ATELIER"),

    /** The bat medaille module. */
    BAT_DATE_ENGAGEMENT("BAT_DATE_ENGAGEMENT"),

    /** The bat medaille ss ens. */
    BAT_DATE_PRODUCTION("BAT_DATE_PRODUCTION"),

    /** The ss ens reference. */
    BAT_CODE_SGR("BAT_CODE_SGR"),

    /** The ss ens medaille module. */
    BAT_CODE_USINE("BAT_CODE_USINE"),

    /** The bat code atelier. */
    BAT_CODE_ATELIER("BAT_CODE_ATELIER"),

    /** The bat medaille module. */
    BAT_STATUT("BAT_STATUT"),

    /** The bat medaille ss ens. */
    P48("48P"),

    /** The ss ens reference. */
    P18("18P"),

    /** The ss ens medaille module. */
    P38("38P"),

    /** The bat medaille ss ens. */
    P98("98P"),

    /** The ss ens reference. */
    P68("68P"),

    /** The ss ens medaille module. */
    P58("58P"),

    /** The delete. */
    DELETE("S"),

    /** The lbl waiting. */
    LBL_WAITING("LBL-0114"),

    /** The lbl inprogress. */
    LBL_INPROGRESS("LBL-0052"),

    /** The lbl inprogress. */
    TRANSLATION_DONE("LBL-0078"),

    /** The lbl completed. */
    LBL_COMPLETED("LBL-0046"),

    /** The nb char length. */
    NB_CHAR_LENGTH("LENGTH"),

    /** The lbl error. */
    LBL_ERROR("LBL-0051"),

    /** The batterie haute tension ens. */
    BATTERIE_HAUTE_TENSION_ENS("BATTERIE HAUTE TENSION ENS"),
    /** The sous ensemble modules. */
    SOUS_ENSEMBLE_MODULES("SOUS ENSEMBLE MODULES"),

    /** The objectnumber0. */
    OBJECTNUMBER0(0),

    /** The objectnumber1. */
    OBJECTNUMBER1(1),

    /** The objectnumber2. */
    OBJECTNUMBER2(2),

    /** The objectnumber3. */
    OBJECTNUMBER3(3),

    /** The objectnumber4. */
    OBJECTNUMBER4(4),

    /** The objectnumber5. */
    OBJECTNUMBER5(5),

    /** The objectnumber6. */
    OBJECTNUMBER6(6),

    /** The objectnumber7. */
    OBJECTNUMBER7(7),

    /** The objectnumber8. */
    OBJECTNUMBER8(8),

    /** The objectnumber9. */
    OBJECTNUMBER9(9),

    /** The objectnumber10. */
    OBJECTNUMBER10(10),

    /** The objectnumber11. */
    OBJECTNUMBER11(11),

    /** The objectnumber12. */
    OBJECTNUMBER12(12),

    /** The objectnumber13. */
    OBJECTNUMBER13(13),

    /** The objectnumber14. */
    OBJECTNUMBER14(14);

    /** The const value. */
    String constValue;

    /**
     * Instantiates a new common constant.
     *
     * @param constValueInt the const value int
     */
    CommonConstant(int constValueInt) {
        this.constValueInt = constValueInt;
    }

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
    CommonConstant(String constValue) {
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
