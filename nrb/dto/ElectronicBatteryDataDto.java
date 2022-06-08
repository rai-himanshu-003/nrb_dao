/*
 * Creation : 24 Mar 2022
 */
package com.inetpsa.nrb.dto;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * The Class ElectronicBatteryDataDto.
 */
public class ElectronicBatteryDataDto {

    /** The serial number. */
    private String serialNumber;

    /** The ref soft. */
    private String refSoft;

    /** The ref hard. */
    private String refHard;

    /** The date production. */
    private LocalDateTime dateProduction;

    /** The suppliercode. */
    private String suppliercode;

    /** The ref cal. */
    private String refCal;

    /** The user update. */
    private String userUpdate;

    /** The date update. */
    private Date dateUpdate;

    /**
     * Instantiates a new electronic battery data dto.
     */
    public ElectronicBatteryDataDto() {
        super();
    }

    /**
     * Instantiates a new electronic battery data dto.
     *
     * @param electronicBatteryDto the electronic battery dto
     */
    public ElectronicBatteryDataDto(ElectronicBatteryDataDto electronicBatteryDto) {
        this.serialNumber = electronicBatteryDto.serialNumber;
        this.refSoft = electronicBatteryDto.refSoft;
        this.refHard = electronicBatteryDto.refHard;
        this.dateProduction = electronicBatteryDto.dateProduction;
        this.suppliercode = electronicBatteryDto.suppliercode;
        this.refCal = electronicBatteryDto.refCal;
        this.userUpdate = electronicBatteryDto.userUpdate;
        this.dateUpdate = electronicBatteryDto.dateUpdate;
    }

    /**
     * Gets the serial number.
     *
     * @return the serial number
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the serial number.
     *
     * @param serialNumber the new serial number
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Gets the ref soft.
     *
     * @return the ref soft
     */
    public String getRefSoft() {
        return refSoft;
    }

    /**
     * Sets the ref soft.
     *
     * @param refSoft the new ref soft
     */
    public void setRefSoft(String refSoft) {
        this.refSoft = refSoft;
    }

    /**
     * Gets the ref hard.
     *
     * @return the ref hard
     */
    public String getRefHard() {
        return refHard;
    }

    /**
     * Sets the ref hard.
     *
     * @param refHard the new ref hard
     */
    public void setRefHard(String refHard) {
        this.refHard = refHard;
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
     * Gets the suppliercode.
     *
     * @return the suppliercode
     */
    public String getSuppliercode() {
        return suppliercode;
    }

    /**
     * Sets the suppliercode.
     *
     * @param suppliercode the new suppliercode
     */
    public void setSuppliercode(String suppliercode) {
        this.suppliercode = suppliercode;
    }

    /**
     * Gets the ref cal.
     *
     * @return the ref cal
     */
    public String getRefCal() {
        return refCal;
    }

    /**
     * Sets the ref cal.
     *
     * @param refCal the new ref cal
     */
    public void setRefCal(String refCal) {
        this.refCal = refCal;
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
