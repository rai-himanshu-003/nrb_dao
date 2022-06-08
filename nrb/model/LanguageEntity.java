/*
 * Creation : 7 Feb 2022
 */
package com.inetpsa.nrb.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * The class LanguageEntity.
 */
@Entity
@DynamicUpdate(value = true)
@Table(name = "NRBQTLANG")
public class LanguageEntity {

    /** The language id. */
    @Id
    @Column(name = "ID_LANG")
    private String idLang;

    /**
     * Instantiates a new language entity.
     *
     * @param idLang the id lang
     * @param descr  the descr
     */
    public LanguageEntity(String idLang, String descr) {
        this.idLang = idLang;
        this.descr = descr;
    }

    /** The Description of language. */
    @Column(name = "DESCR_LANG")
    private String descr;

    /** The date creation in language. */
    @Column(name = "DATE_CREATION")
    private Timestamp dateCreation;

    /** The user creation in language. */
    @Column(name = "USER_CREATION")
    private String userCreation;

    /** The date maj in language. */
    @Column(name = "DATE_MAJ")
    private Timestamp dateMaj;

    /** The user maj in language. */
    @Column(name = "USER_MAJ")
    private String userMaj;

    /**
     * Instantiates new language entity.
     */
    public LanguageEntity() {
        super();
    }

    /**
     * Instantiates new language entity.
     *
     * @param idLang       the idLang
     * @param descr        the descr
     * @param dateCreation the dateCreation
     * @param userCreation the userCreation
     * @param dateMaj      the dateMaj
     * @param userMaj      the userMaj
     */

    public LanguageEntity(String idLang, String descr, Timestamp dateCreation, String userCreation, Timestamp dateMaj, String userMaj) {
        super();
        this.idLang = idLang;
        this.descr = descr;
        this.dateCreation = dateCreation;
        this.userCreation = userCreation;
        this.dateMaj = dateMaj;
        this.userMaj = userMaj;
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
     * Gets the userCreation.
     *
     * @return userCreation
     */
    public String getUserCreation() {
        return userCreation;
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
     * Gets the usermaj.
     *
     * @return userMaj
     */
    public String getUserMaj() {
        return userMaj;
    }

    /**
     * Pre persist.
     */
    @PrePersist
    public void prePersist() {
        dateCreation = new Timestamp(new Date().getTime());
        userCreation = LoggedUser.get();
    }

    /**
     * Pre update.
     */
    @PreUpdate
    public void preUpdate() {
        dateMaj = new Timestamp(new Date().getTime());
        userMaj = LoggedUser.get();
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LanguageEntity [idLang=" + idLang + ", descr=" + descr + ", dateCreation=" + dateCreation + ", userCreation=" + userCreation
                + ", dateMaj=" + dateMaj + ", userMaj=" + userMaj + "]";
    }

}
