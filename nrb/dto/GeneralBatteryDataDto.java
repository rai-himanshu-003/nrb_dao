/*
 * Creation : 21 Mar 2022
 */
package com.inetpsa.nrb.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * The Class GeneralBatteryDataDto.
 */
public class GeneralBatteryDataDto {

    /** The id. */
    private Long id;

    /** The reference. */
    private String reference;

    /** The description 2. */
    private String description2;

    /** The vin. */
    private String vin;

    /** The update date. */
    private Timestamp updateDate;

    /** The update user. */
    private String updateUser;

    /** The factory code. */
    private String factoryCode;

    /** The date production. */
    private LocalDateTime dateProduction;

    /** The date engagement. */
    private LocalDateTime dateEngagement;

    /** The status. */
    private String status;

    /** The code sgr. */
    private String codeSgr;

    /** The shed code. */
    private String shedCode;

    /**
     * Instantiates a new general battery data dto.
     *
     * @param generalBatteryData the general battery data
     */
    public GeneralBatteryDataDto(GeneralBatteryDataDto generalBatteryData) {
        this.id = generalBatteryData.id;
        this.reference = generalBatteryData.reference;
        this.description2 = generalBatteryData.description2;
        this.vin = generalBatteryData.vin;
        this.updateDate = generalBatteryData.updateDate;
        this.updateUser = generalBatteryData.updateUser;
        this.factoryCode = generalBatteryData.factoryCode;
        this.dateProduction = generalBatteryData.dateProduction;
        this.dateEngagement = generalBatteryData.dateEngagement;
        this.status = generalBatteryData.status;
        this.codeSgr = generalBatteryData.codeSgr;
        this.shedCode = generalBatteryData.shedCode;

    }

    /**
     * Instantiates a new general battery data dto.
     */
    public GeneralBatteryDataDto() {

    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the reference.
     *
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the reference.
     *
     * @param reference the new reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Gets the description 2.
     *
     * @return the description 2
     */
    public String getDescription2() {
        return description2;
    }

    /**
     * Sets the description 2.
     *
     * @param description2 the new description 2
     */
    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    /**
     * Gets the vin.
     *
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * Sets the vin.
     *
     * @param vin the new vin
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * Gets the factory code.
     *
     * @return the factory code
     */
    public String getFactoryCode() {
        return factoryCode;
    }

    /**
     * Sets the factory code.
     *
     * @param factoryCode the new factory code
     */
    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    /**
     * Gets the date production.
     *
     * @return the date production
     */
    public LocalDateTime getDateProduction() {
        return dateProduction;
    }

    /**
     * Sets the date production.
     *
     * @param dateProduction the new date production
     */
    public void setDateProduction(LocalDateTime dateProduction) {
        this.dateProduction = dateProduction;
    }

    /**
     * Gets the date engagement.
     *
     * @return the date engagement
     */
    public LocalDateTime getDateEngagement() {
        return dateEngagement;
    }

    /**
     * Sets the date engagement.
     *
     * @param dateEngagement the new date engagement
     */
    public void setDateEngagement(LocalDateTime dateEngagement) {
        this.dateEngagement = dateEngagement;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the code sgr.
     *
     * @return the code sgr
     */
    public String getCodeSgr() {
        return codeSgr;
    }

    /**
     * Sets the code sgr.
     *
     * @param codeSgr the new code sgr
     */
    public void setCodeSgr(String codeSgr) {
        this.codeSgr = codeSgr;
    }

    /**
     * Gets the shed code.
     *
     * @return the shed code
     */
    public String getShedCode() {
        return shedCode;
    }

    /**
     * Sets the shed code.
     *
     * @param shedCode the new shed code
     */
    public void setShedCode(String shedCode) {
        this.shedCode = shedCode;
    }

    /**
     * Gets the update date.
     *
     * @return the update date
     */
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the update date.
     *
     * @param updateDate the new update date
     */
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Gets the update user.
     *
     * @return the update user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * Sets the update user.
     *
     * @param updateUser the new update user
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
