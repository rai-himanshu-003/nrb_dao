/*
 * Creation : 17 Jan 2022
 */
package com.inetpsa.nrb.dto;

import com.inetpsa.nrb.model.MassMvtSet;

/**
 * The Class MassMvtSetDto.
 */

public class MassMvtSetDto {

    private String idSetting;

    private String lblSetting;

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

    /**
     * method for convetToDto
     * 
     * @param massMvtSet the mass mvt set
     * @return the mass mvt line dto
     */
    public MassMvtSetDto convertToDto(MassMvtSet massMvtSet) {
        this.idSetting = massMvtSet.getIdSetting();
        this.lblSetting = massMvtSet.getLblSetting();
        this.valueSetting = massMvtSet.getValueSetting();
        return this;
    }

    @Override
    public String toString() {
        return "MassMvtSetDto [idSetting=" + idSetting + ", lblSetting=" + lblSetting + ", valueSetting=" + valueSetting + "]";
    }

}
