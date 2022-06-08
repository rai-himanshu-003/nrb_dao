/*
 * Creation : 3 Apr 2022
 */
package com.inetpsa.nrb.dto;

import java.util.Date;

/**
 * The Class BatteryModuleHistoryDto.
 */
public class BatteryModuleHistoryDto {

    /** The action type. */
    private String actionType;

    /** The category. */
    private String category;

    /** The sub assembly id. */
    private String subAssemblyId;

    /** The old value. */
    private String oldValue;

    /** The new value. */
    private String newValue;

    /** The update date. */
    private Date updateDate;

    /** The update user. */
    private String updateUser;

    /**
     * Instantiates a new battery module history dto.
     */
    public BatteryModuleHistoryDto() {
        super();
    }

    /**
     * Gets the action type.
     *
     * @return the action type
     */
    public String getActionType() {
        return actionType;
    }

    /**
     * Sets the action type.
     *
     * @param actionType the new action type
     */
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    /**
     * Gets the category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category.
     *
     * @param category the new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the sub assembly id.
     *
     * @return the sub assembly id
     */
    public String getSubAssemblyId() {
        return subAssemblyId;
    }

    /**
     * Sets the sub assembly id.
     *
     * @param subAssemblyId the new sub assembly id
     */
    public void setSubAssemblyId(String subAssemblyId) {
        this.subAssemblyId = subAssemblyId;
    }

    /**
     * Gets the old value.
     *
     * @return the old value
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * Sets the old value.
     *
     * @param oldValue the new old value
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * Gets the new value.
     *
     * @return the new value
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * Sets the new value.
     *
     * @param newValue the new new value
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

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
