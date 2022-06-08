/*
 * Creation : 31 Jan 2022
 */
package com.inetpsa.nrb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inetpsa.nrb.model.TranslationEntity;

/**
 * The Class TranslationDto.
 */
public class TranslationDto {

    /** The id. */
    @JsonProperty("ID")
    private int id;

    /** The trad id. */
    @JsonProperty("Trad_ID")
    private String tradId;

    /** The lang. */
    @JsonProperty("Lang_Id")
    private String lang;

    /** The label. */
    @JsonProperty("Trad_Label")
    private String label;

    /** The type. */
    @JsonProperty("Type_trad")
    private String type;

    /**
     * Instantiates a new translation dto.
     *
     * @param tradId the trad id
     * @param lang   the lang
     * @param label  the label
     * @param type   the type
     */
    public TranslationDto(String tradId, String lang, String label, String type) {
        super();
        this.tradId = tradId;
        this.lang = lang;
        this.label = label;
        this.type = type;
    }

    /**
     * Instantiates a new multilingual dto.
     */
    public TranslationDto() {
        super();

    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the trad id.
     *
     * @return the trad id
     */
    public String getTradId() {
        return tradId;
    }

    /**
     * Sets the trad id.
     *
     * @param tradId the new trad id
     */
    public void setTradId(String tradId) {
        this.tradId = tradId;
    }

    /**
     * Gets the lang.
     *
     * @return the lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the lang.
     *
     * @param lang the new lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label.
     *
     * @param label the new label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Map tomodel.
     *
     * @param translationEntity the translation entity
     * @return the translation entity
     */
    public TranslationEntity mapTomodel(TranslationEntity translationEntity) {
        translationEntity.setLbltrad(this.label);
        return translationEntity;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "TranslationDto [tradId=" + tradId + ", lang=" + lang + ", label=" + label + ", type=" + type + "]";
    }

}
