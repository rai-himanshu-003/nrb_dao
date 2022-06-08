/*
 * Creation : 17 Jan 2022
 */
package com.inetpsa.nrb.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.inetpsa.nrb.dto.MassMvtLineDto;

/**
 * The Class MassMvtLine.
 */
@Entity
@Table(name = "NRBQTMMLINE")
public class MassMvtLine {

    /** The vehicle history pk. */
    @Id
    @EmbeddedId
    private MassMvtLinePk massMvtLinePk;

    /** The action type. */
    @Column(name = "ACTION_TYPE")
    private String actionType;

    /** The type data. */
    @Column(name = "TYPE_DATA")
    private String typeData;

    /** The date creation. */
    @Column(name = "ID_DATA")
    private String idData;

    /** The data value. */
    @Column(name = "DATA_VALUE")
    private String dataValue;

    /** The translation status. */
    @Column(name = "CR_ID_TRANSLATION")
    private String translationStatus;

    /**
     * Gets the mass mvt line pk.
     *
     * @return the mass mvt line pk
     */
    public MassMvtLinePk getMassMvtLinePk() {
        return massMvtLinePk;
    }

    /**
     * Sets the mass mvt line pk.
     *
     * @param massMvtLinePk the new mass mvt line pk
     */
    public void setMassMvtLinePk(MassMvtLinePk massMvtLinePk) {
        this.massMvtLinePk = massMvtLinePk;
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
     * Instantiates a new mass mvt line.
     */
    public MassMvtLine() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MassMvtLine [massMvtLinePk=" + massMvtLinePk + ", actionType=" + actionType + ", typeData=" + typeData + ", idData=" + idData
                + ", dataValue=" + dataValue + ", translationStatus=" + translationStatus + "]";
    }

    /**
     * Convert to entity.
     *
     * @param massMvtLine the mass mvt line
     * @return the mass mvt line dto
     */
    public MassMvtLineDto convertToEntity(MassMvtLine massMvtLine) {
        MassMvtLineDto entity = new MassMvtLineDto();
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
        if (massMvtLine.getMassMvtLinePk().getIdFile() != null) {
            entity.setIdFile(massMvtLine.getMassMvtLinePk().getIdFile());
        }
        if (massMvtLine.getMassMvtLinePk().getIdLine() != null) {
            entity.setIdLine(massMvtLine.getMassMvtLinePk().getIdLine());
        }
        return entity;

    }
}