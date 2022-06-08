/*
 * Creation : 24 Mar 2022
 */
package com.inetpsa.nrb.dto;

import java.util.Date;

/**
 * The Class BatteryHealthDataDto.
 */
public class BatteryHealthDataDto {

    /** The soh. */
    private String soh;

    /** The soc. */
    private String soc;

    /** The mic. */
    private String mic;

    /** The mac. */
    private String mac;

    /** The rinsulation. */
    private String rinsulation;

    /** The rinternal. */
    private String rinternal;

    /** The t 10. */
    private String t10;

    /** The tat. */
    private String tat;

    /** The user update. */
    private String userUpdate;

    /** The date update. */
    private Date dateUpdate;

    /**
     * Instantiates a new battery health data dto.
     */
    public BatteryHealthDataDto() {
        super();
    }

    /**
     * Instantiates a new battery health data dto.
     *
     * @param batteryHealthDataDto the battery health data dto
     */
    public BatteryHealthDataDto(BatteryHealthDataDto batteryHealthDataDto) {
        this.soh = batteryHealthDataDto.soh;
        this.soc = batteryHealthDataDto.soc;
        this.mic = batteryHealthDataDto.mic;
        this.mac = batteryHealthDataDto.mac;
        this.rinsulation = batteryHealthDataDto.rinsulation;
        this.rinternal = batteryHealthDataDto.rinternal;
        this.t10 = batteryHealthDataDto.t10;
        this.tat = batteryHealthDataDto.tat;
        this.userUpdate = batteryHealthDataDto.userUpdate;
        this.dateUpdate = batteryHealthDataDto.dateUpdate;

    }

    /**
     * Gets the soh.
     *
     * @return the soh
     */
    public String getSoh() {
        return soh;
    }

    /**
     * Sets the soh.
     *
     * @param soh the new soh
     */
    public void setSoh(String soh) {
        this.soh = soh;
    }

    /**
     * Gets the soc.
     *
     * @return the soc
     */
    public String getSoc() {
        return soc;
    }

    /**
     * Sets the soc.
     *
     * @param soc the new soc
     */
    public void setSoc(String soc) {
        this.soc = soc;
    }

    /**
     * Gets the mic.
     *
     * @return the mic
     */
    public String getMic() {
        return mic;
    }

    /**
     * Sets the mic.
     *
     * @param mic the new mic
     */
    public void setMic(String mic) {
        this.mic = mic;
    }

    /**
     * Gets the mac.
     *
     * @return the mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * Sets the mac.
     *
     * @param mac the new mac
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * Gets the rinsulation.
     *
     * @return the rinsulation
     */
    public String getRinsulation() {
        return rinsulation;
    }

    /**
     * Sets the rinsulation.
     *
     * @param rinsulation the new rinsulation
     */
    public void setRinsulation(String rinsulation) {
        this.rinsulation = rinsulation;
    }

    /**
     * Gets the rinternal.
     *
     * @return the rinternal
     */
    public String getRinternal() {
        return rinternal;
    }

    /**
     * Sets the rinternal.
     *
     * @param rinternal the new rinternal
     */
    public void setRinternal(String rinternal) {
        this.rinternal = rinternal;
    }

    /**
     * Gets the t10.
     *
     * @return the t10
     */
    public String getT10() {
        return t10;
    }

    /**
     * Sets the t10.
     *
     * @param t10 the new t10
     */
    public void setT10(String t10) {
        this.t10 = t10;
    }

    /**
     * Gets the tat.
     *
     * @return the tat
     */
    public String getTat() {
        return tat;
    }

    /**
     * Sets the tat.
     *
     * @param tat the new tat
     */
    public void setTat(String tat) {
        this.tat = tat;
    }

    /**
     * Gets the user update.
     *
     * @return the user update
     */
    public String getUserUpdate() {
        return userUpdate;
    }

    /**
     * Sets the user update.
     *
     * @param userUpdate the new user update
     */
    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }

    /**
     * Gets the date update.
     *
     * @return the date update
     */
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * Sets the date update.
     *
     * @param dateUpdate the new date update
     */
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

}
