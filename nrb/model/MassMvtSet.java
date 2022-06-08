/*
 * Creation : 17 Jan 2022
 */
package com.inetpsa.nrb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class MassMvtSet.
 */
@Entity
@Table(name = "NRBQTMMSET")
public class MassMvtSet {

    /** The id setting. */
    @Id
    @Column(name = "ID_SETTING")
    private String idSetting;

    /** The date creation. */
    @Column(name = "LBL_SETTING")
    private String lblSetting;

    /** The value setting. */
    @Column(name = "VALUE_SETTING")
    private String valueSetting;

    /**
     * Gets the id setting.
     *
     * @return the id setting
     */
    public String getIdSetting() {
        return idSetting;
    }

    /**
     * Sets the id setting.
     *
     * @param idSetting the new id setting
     */
    public void setIdSetting(String idSetting) {
        this.idSetting = idSetting;
    }

    /**
     * Gets the lbl setting.
     *
     * @return the lbl setting
     */
    public String getLblSetting() {
        return lblSetting;
    }

    /**
     * Sets the lbl setting.
     *
     * @param lblSetting the new lbl setting
     */
    public void setLblSetting(String lblSetting) {
        this.lblSetting = lblSetting;
    }

    /**
     * Gets the value setting.
     *
     * @return the value setting
     */
    public String getValueSetting() {
        return valueSetting;
    }

    /**
     * Sets the value setting.
     *
     * @param valueSetting the new value setting
     */
    public void setValueSetting(String valueSetting) {
        this.valueSetting = valueSetting;
    }

}
