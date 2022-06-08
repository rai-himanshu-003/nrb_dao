/*
 * Creation : 30 Mar 2022
 */
package com.inetpsa.nrb.dto;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * The Class ModuleAndSubassemblyDto.
 */
public class ModuleAndSubassemblyDto {

    /** The component type. */
    private String componentType;

    /** The module medal. */
    private String moduleMedal;

    /** The sub medal. */
    private String subMedal;

    /** The reference. */
    private String reference;

    /** The production date. */
    private LocalDateTime productionDate;

    /** The date engagement. */
    private LocalDateTime dateEngagement;

    /** The factory code. */
    private String factoryCode;

    /** The update date. */
    private Date updateDate;

    /**
     * Gets the update date.
     *
     * @return the update date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the update date.
     *
     * @param updateDate the new update date
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Gets the component type.
     *
     * @return the component type
     */
    public String getComponentType() {
        return componentType;
    }

    /**
     * Sets the component type.
     *
     * @param componentType the new component type
     */
    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    /**
     * Gets the module medal.
     *
     * @return the module medal
     */
    public String getModuleMedal() {
        return moduleMedal;
    }

    /**
     * Sets the module medal.
     *
     * @param moduleMedal the new module medal
     */
    public void setModuleMedal(String moduleMedal) {
        this.moduleMedal = moduleMedal;
    }

    /**
     * Gets the sub medal.
     *
     * @return the sub medal
     */
    public String getSubMedal() {
        return subMedal;
    }

    /**
     * Sets the sub medal.
     *
     * @param subMedal the new sub medal
     */
    public void setSubMedal(String subMedal) {
        this.subMedal = subMedal;
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
     * Gets the production date.
     *
     * @return the production date
     */
    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    /**
     * Sets the production date.
     *
     * @param productionDate the new production date
     */
    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
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

}
