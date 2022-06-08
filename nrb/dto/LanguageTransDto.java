/*
 * Creation : 7 Feb 2022
 */
package com.inetpsa.nrb.dto;

import java.sql.Timestamp;

import com.inetpsa.nrb.model.LanguageEntity;

/**
 * The class LanguageTransDto.
 */

public class LanguageTransDto {

    /** The id. */
    private int id;

    /** The language id. */
    private String idLang;

    /** The Description. */
    private String descr;

    /** The Date creation. */
    private Timestamp dateCreation;

    /** The user creation. */
    private String userCreation;

    /** The date maj. */
    private Timestamp dateMaj;

    /** The user maj. */
    private String userMaj;

    /**
     * Instantiates a new language trans dto.
     */
    public LanguageTransDto() {
        super();
    }

    /**
     * Instantiates a new language trans dto.
     *
     * @param idLang       the id lang
     * @param descr        the descr
     * @param dateCreation the date creation
     * @param userCreation the user creation
     * @param dateMaj      the date maj
     * @param userMaj      the user maj
     */
    public LanguageTransDto(String idLang, String descr, Timestamp dateCreation, String userCreation, Timestamp dateMaj, String userMaj) {
        super();
        this.idLang = idLang;
        this.descr = descr;
        this.dateCreation = dateCreation;
        this.userCreation = userCreation;
        this.dateMaj = dateMaj;
        this.userMaj = userMaj;
    }

    /**
     * Instantiates a new language trans dto.
     *
     * @param idLang the id lang
     * @param descr  the descr
     */
    public LanguageTransDto(String idLang, String descr) {
        super();
        this.idLang = idLang;
        this.descr = descr;
    }

    /**
     * Gets the language id.
     *
     * @return the language id
     */
    public String getIdLang() {
        return idLang;
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
     * Sets the language id.
     *
     * @param idLang the new id lang
     */
    public void setIdLang(String idLang) {
        this.idLang = idLang;
    }

    /**
     * Gets the language descr.
     *
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the language descr.
     *
     * @param descr the new descr
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * Gets the dateCreation.
     *
     * @return dateCreation
     */
    public Timestamp getDateCreation() {
        return dateCreation;
    }

    /**
     * Sets the dateCreation.
     *
     * @param dateCreation the new dateCreation
     */
    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Gets the userCreation.
     *
     * @return userCreation
     */
    public String getUserCreation() {
        return userCreation;
    }

    /**
     * Sets the userCreation.
     *
     * @param userCreation the new userCreation
     */
    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    /**
     * Gets the dateMaj.
     *
     * @return dateMaj
     */
    public Timestamp getDateMaj() {
        return dateMaj;
    }

    /**
     * Sets the dateMaj.
     *
     * @param dateMaj the new dateMaj
     */
    public void setDateMaj(Timestamp dateMaj) {
        this.dateMaj = dateMaj;
    }

    /**
     * Gets the usermaj.
     *
     * @return userMaj
     */
    public String getUserMaj() {
        return userMaj;
    }

    /**
     * Sets the userMaj.
     *
     * @param userMaj the new userMaj
     */
    public void setUserMaj(String userMaj) {
        this.userMaj = userMaj;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LanguageTransDto [id=" + id + ", idLang=" + idLang + ", descr=" + descr + ", dateCreation=" + dateCreation + ", userCreation="
                + userCreation + ", dateMaj=" + dateMaj + ", userMaj=" + userMaj + "]";
    }

    /**
     * Map tomodel.
     *
     * @param langData the lang data
     * @return the language entity
     */
    public LanguageEntity mapTomodel(LanguageEntity langData) {
        langData.setIdLang(this.getIdLang());
        langData.setDescr(this.getDescr());
        return langData;
    }
}
