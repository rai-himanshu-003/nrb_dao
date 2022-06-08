
/*
 * Creation : 12 Jan 2022
 */
package com.inetpsa.nrb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class TranslationEntity.
 */
@Entity
@DynamicUpdate(value = true)
@Table(name = "NRBQTTRAD")
public class TranslationEntity {

    /** The translation entity pk. */
    @Id
    @EmbeddedId
    public TranslationEntityPk translationEntityPk;

    /** The lbltrad. */
    @Column(name = "LBL_TRAD")
    private String lbltrad;

    /** The typtrad. */
    @Column(name = "TYP_TRAD")
    private String typtrad;

    /** The user creation. */
    @Column(name = "USER_CREATION")
    private String userCreation;

    /** The date creation. */
    @Column(name = "DATE_CREATION")
    private Date dateCreation;

    /** The user maj. */
    @Column(name = "USER_MAJ")
    private String userMaj;

    /** The date maj. */
    @Column(name = "DATE_MAJ")
    private Date dateMaj;

    /**
     * Instantiates a new translation entity.
     */
    public TranslationEntity() {
        super();
    }

    /**
     * Instantiates a new translation entity.
     *
     * @param translationEntityPk the translation entity pk
     * @param typtrad             the typtrad
     */
    public TranslationEntity(TranslationEntityPk translationEntityPk, String typtrad) {
        super();
        this.translationEntityPk = translationEntityPk;
        this.typtrad = typtrad;
    }

    /**
     * Instantiates a new translation entity.
     *
     * @param translationEntityPk the translation entity pk
     * @param lbltrad             the lbltrad
     * @param typtrad             the typtrad
     */
    public TranslationEntity(TranslationEntityPk translationEntityPk, String lbltrad, String typtrad) {
        super();
        this.translationEntityPk = translationEntityPk;
        this.lbltrad = lbltrad;
        this.typtrad = typtrad;
    }

    /**
     * Instantiates a new translation entity.
     *
     * @param translationEntityPk the translation entity pk
     */
    public TranslationEntity(TranslationEntityPk translationEntityPk) {
        super();
        this.translationEntityPk = translationEntityPk;
    }

    /**
     * Gets the translation entity pk.
     *
     * @return the translation entity pk
     */
    public TranslationEntityPk getTranslationEntityPk() {
        return translationEntityPk;
    }

    /**
     * Sets the translation entity pk.
     *
     * @param translationEntityPk the new translation entity pk
     */
    public void setTranslationEntityPk(TranslationEntityPk translationEntityPk) {
        this.translationEntityPk = translationEntityPk;
    }

    /**
     * Gets the lbltrad.
     *
     * @return the lbltrad
     */
    public String getLbltrad() {
        return lbltrad;
    }

    /**
     * Sets the lbltrad.
     *
     * @param lbltrad the new lbltrad
     */
    public void setLbltrad(String lbltrad) {
        this.lbltrad = lbltrad;
    }

    /**
     * Gets the typtrad.
     *
     * @return the typtrad
     */
    public String getTyptrad() {
        return typtrad;
    }

    /**
     * Sets the typtrad.
     *
     * @param typtrad the new typtrad
     */
    public void setTyptrad(String typtrad) {
        this.typtrad = typtrad;
    }

    /**
     * Gets the user creation.
     *
     * @return the user creation
     */
    public String getUserCreation() {
        return userCreation;
    }

    /**
     * Gets the date creation.
     *
     * @return the date creation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Gets the user maj.
     *
     * @return the user maj
     */
    public String getUserMaj() {
        return userMaj;
    }

    /**
     * Gets the date maj.
     *
     * @return the date maj
     */
    public Date getDateMaj() {
        return dateMaj;
    }

    /**
     * Pre persist.
     */
    @PrePersist
    public void prePersist() {
        dateCreation = new Date();
        userCreation = LoggedUser.get();
    }

    /**
     * Pre update.
     */
    @PreUpdate
    public void preUpdate() {
        dateMaj = new Date();
        userMaj = LoggedUser.get();
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TranslationEntity [translationEntityPk=" + translationEntityPk + ", lbltrad=" + lbltrad + ", typtrad=" + typtrad + "]";
    }

}