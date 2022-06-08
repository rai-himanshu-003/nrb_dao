/*
 * Creation : 17 Jan 2022
 */
package com.inetpsa.nrb.dto;

import com.inetpsa.nrb.constant.CommonConstant;
import com.inetpsa.nrb.model.MassMvtLine;
import com.inetpsa.nrb.model.MassMvtLinePk;

/**
 * The Class MassMvtLine.
 */

public class MassMvtLineDto {

    /** The id file. */
    private Long idFile;

    /** The id line. */

    private Long idLine;

    /**
     * Gets the id file.
     *
     * @return the id file
     */
    public Long getIdFile() {
        return idFile;
    }

    /**
     * Sets the id file.
     *
     * @param idFile the new id file
     */
    public void setIdFile(Long idFile) {
        this.idFile = idFile;
    }

    /**
     * Gets the id line.
     *
     * @return the id line
     */
    public Long getIdLine() {
        return idLine;
    }

    /**
     * Sets the id line.
     *
     * @param idLine the new id line
     */
    public void setIdLine(Long idLine) {
        this.idLine = idLine;
    }

    /** The action type. */

    private String actionType;

    /** The date creation. */

    private String idData;

    /** The data value. */

    private String dataValue;

    /** The translation status. */

    private String translationStatus;

    /** The type data. */
    private String typeData;

    /** The data group. */
    private String dataGroup;

    /** The field. */
    private String field;

    /** The format. */
    private String format;

    /** The settings. */
    private String settings;

    /** The nb char. */
    private String nbChar;

    /**
     * Instantiates a new mass mvt line dto.
     */
    public MassMvtLineDto() {
        super();
    }

    /**
     * Gets the type data.
     *
     * @return the type data
     */
    public String getTypeData() {
        return typeData;
    }

    /**
     * Sets the type data.
     *
     * @param typeData the new type data
     */
    public void setTypeData(String typeData) {
        this.typeData = typeData;
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
     * Gets the id data.
     *
     * @return the id data
     */
    public String getIdData() {
        return idData;
    }

    /**
     * Sets the id data.
     *
     * @param idData the new id data
     */
    public void setIdData(String idData) {
        this.idData = idData;
    }

    /**
     * Gets the data value.
     *
     * @return the data value
     */
    public String getDataValue() {
        return dataValue;
    }

    /**
     * Sets the data value.
     *
     * @param dataValue the new data value
     */
    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    /**
     * Gets the translation status.
     *
     * @return the translation status
     */
    public String getTranslationStatus() {
        return translationStatus;
    }

    /**
     * Sets the translation status.
     *
     * @param translationStatus the new translation status
     */
    public void setTranslationStatus(String translationStatus) {
        this.translationStatus = translationStatus;
    }

    /**
     * Gets the data group.
     *
     * @return the data group
     */
    public String getDataGroup() {
        return dataGroup;
    }

    /**
     * Sets the data group.
     *
     * @param dataGroup the new data group
     */
    public void setDataGroup(String dataGroup) {
        this.dataGroup = dataGroup;
    }

    /**
     * Gets the field.
     *
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the field.
     *
     * @param field the new field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * Gets the format.
     *
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format.
     *
     * @param format the new format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Gets the settings.
     *
     * @return the settings
     */
    public String getSettings() {
        return settings;
    }

    /**
     * Sets the settings.
     *
     * @param settings the new settings
     */
    public void setSettings(String settings) {
        this.settings = settings;
    }

    /**
     * Gets the nb char.
     *
     * @return the nb char
     */
    public String getNbChar() {
        return nbChar;
    }

    /**
     * Sets the nb char.
     *
     * @param nbChar the new nb char
     */
    public void setNbChar(String nbChar) {
        this.nbChar = nbChar;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MassMvtLineDto [idFile=" + idFile + ", idLine=" + idLine + ", actionType=" + actionType + ", idData=" + idData + ", dataValue="
                + dataValue + ", translationStatus=" + translationStatus + ", typeData=" + typeData + ", dataGroup=" + dataGroup + ", field=" + field
                + ", format=" + format + ", settings=" + settings + ", nbChar=" + nbChar + "]";
    }

    /**
     * Instantiates a new mass mvt line dto.
     *
     * @param object the object
     */
    public MassMvtLineDto(Object[] object) {
        super();
        this.actionType = object[CommonConstant.OBJECTNUMBER0.getConstValueInt()] != null
                ? object[CommonConstant.OBJECTNUMBER0.getConstValueInt()].toString()
                : "";
        this.idData = object[CommonConstant.OBJECTNUMBER1.getConstValueInt()] != null
                ? object[CommonConstant.OBJECTNUMBER1.getConstValueInt()].toString()
                : "";
        this.typeData = object[CommonConstant.OBJECTNUMBER2.getConstValueInt()] != null
                ? object[CommonConstant.OBJECTNUMBER2.getConstValueInt()].toString()
                : "";
        this.dataValue = object[CommonConstant.OBJECTNUMBER3.getConstValueInt()] != null
                ? object[CommonConstant.OBJECTNUMBER3.getConstValueInt()].toString()
                : "";
        this.translationStatus = object[CommonConstant.OBJECTNUMBER5.getConstValueInt()] != null
                ? object[CommonConstant.OBJECTNUMBER5.getConstValueInt()].toString()
                : "";
    }

    /**
     * method for convetToEntity
     * 
     * @param massMvtLine the mass mvt line
     * @return the mass mvt line dto
     */
    public static MassMvtLine convertToEntity(MassMvtLineDto massMvtLine) {
        MassMvtLine entity = new MassMvtLine();
        MassMvtLinePk linePk = new MassMvtLinePk();
        entity.setMassMvtLinePk(linePk);
        if (massMvtLine.getActionType() != null) {
            entity.setActionType(massMvtLine.getActionType());
        }
        if (massMvtLine.getIdData() != null) {
            entity.setIdData(massMvtLine.getIdData());
        }
        if (massMvtLine.getTypeData() != null) {
            entity.setTypeData(massMvtLine.getTypeData());
        }
        if (massMvtLine.getDataValue() != null) {
            entity.setDataValue(massMvtLine.getDataValue());
        }
        if (massMvtLine.getTranslationStatus() != null) {
            entity.setTranslationStatus(massMvtLine.getTranslationStatus());
        }
        if (massMvtLine.getIdFile() != null) {
            entity.getMassMvtLinePk().setIdFile(massMvtLine.getIdFile());
        }
        if (massMvtLine.getIdLine() != null) {
            entity.getMassMvtLinePk().setIdLine(massMvtLine.getIdLine());
        }
        return entity;

    }

}
