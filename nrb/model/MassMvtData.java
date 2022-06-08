
/*
 * Creation : 17 Jan 2022
 */
package com.inetpsa.nrb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class MassMvtData.
 */
@Entity
@Table(name = "NRBQTMMTDATA")
public class MassMvtData {

    /** The data group. */
    @Column(name = "DATA_GROUP")
    private Long dataGroup;

    /** The type data. */
    @Id
    @Column(name = "TYPE_DATA")
    private String typeData;

    /** The field. */
    @Column(name = "FIELD")
    private String field;

    /** The format. */
    @Column(name = "FORMAT")
    private String format;

    /** The settings. */
    @Column(name = "SETTINGS")
    private String settings;

    /** The nb char. */
    @Column(name = "NB_CHAR")
    private String nbChar;

    /**
     * Gets the data group.
     *
     * @return the data group
     */
    public Long getDataGroup() {
        return dataGroup;
    }

    /**
     * Sets the data group.
     *
     * @param dataGroup the new data group
     */
    public void setDataGroup(Long dataGroup) {
        this.dataGroup = dataGroup;
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

}