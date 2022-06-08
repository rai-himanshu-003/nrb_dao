/*
 * Creation : 9 Feb 2022
 */
package com.inetpsa.nrb.dto;

/**
 * The Class MassMvtValidationDto.
 */
public class MassMvtValidationDto {

    /** The organe. */
    private String organe;

    /** The reference. */
    private String reference;

    /** The status. */
    private String status;

    /** The vin. */
    private String vin;

    private String module;

    /**
     * Gets the organe.
     *
     * @return the organe
     */
    public String getOrgane() {
        return organe;
    }

    /**
     * Sets the organe.
     *
     * @param organe the new organe
     */
    public void setOrgane(String organe) {
        this.organe = organe;
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
     * Gets the vin.
     *
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "MassMvtValidationDto [organe=" + organe + ", reference=" + reference + ", status=" + status + ", vin=" + vin + ", module=" + module
                + "]";
    }

}
