/*
 * Creation : 3 Apr 2022
 */
package com.inetpsa.nrb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class ModuleHistory.
 */
@Entity
@Table(name = "NRBQTHISMOD")
public class ModuleHistory {

    /** The id. */
    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "NRBQTHISMOD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID_HISTORY")
    private Long id;

    /** The mod id. */
    @Column(name = "ID_MOD")
    private Long modId;

    /** The type organe. */
    @Column(name = "TYPE_ORGANE")
    private String typeOrgane;

    /** The numero organe. */
    @Column(name = "NUMERO_ORGANE")
    private String numeroOrgane;

    /** The type module. */
    @Column(name = "TYPE_MODULE")
    private String typeModule;

    /** The numero module. */
    @Column(name = "NUMERO_MODULE")
    private String numeroModule;

    /** The description 2. */
    @Column(name = "DESCRIPTION_2")
    private String description2;

    /** The date update. */
    @Column(name = "DATE_UPDATE")
    private Date dateUpdate;

    /** The user update. */
    @Column(name = "USER_UPDATE")
    private String userUpdate;

    /** The type update. */
    @Column(name = "TYPE_UPDATE")
    private String typeUpdate;

    /**
     * Instantiates a new module history.
     */
    public ModuleHistory() {
        super();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the mod id.
     *
     * @return the mod id
     */
    public Long getModId() {
        return modId;
    }

    /**
     * Sets the mod id.
     *
     * @param modId the new mod id
     */
    public void setModId(Long modId) {
        this.modId = modId;
    }

    /**
     * Gets the type organe.
     *
     * @return the type organe
     */
    public String getTypeOrgane() {
        return typeOrgane;
    }

    /**
     * Sets the type organe.
     *
     * @param typeOrgane the new type organe
     */
    public void setTypeOrgane(String typeOrgane) {
        this.typeOrgane = typeOrgane;
    }

    /**
     * Gets the numero organe.
     *
     * @return the numero organe
     */
    public String getNumeroOrgane() {
        return numeroOrgane;
    }

    /**
     * Sets the numero organe.
     *
     * @param numeroOrgane the new numero organe
     */
    public void setNumeroOrgane(String numeroOrgane) {
        this.numeroOrgane = numeroOrgane;
    }

    /**
     * Gets the type module.
     *
     * @return the type module
     */
    public String getTypeModule() {
        return typeModule;
    }

    /**
     * Sets the type module.
     *
     * @param typeModule the new type module
     */
    public void setTypeModule(String typeModule) {
        this.typeModule = typeModule;
    }

    /**
     * Gets the numero module.
     *
     * @return the numero module
     */
    public String getNumeroModule() {
        return numeroModule;
    }

    /**
     * Sets the numero module.
     *
     * @param numeroModule the new numero module
     */
    public void setNumeroModule(String numeroModule) {
        this.numeroModule = numeroModule;
    }

    /**
     * Gets the description 2.
     *
     * @return the description 2
     */
    public String getDescription2() {
        return description2;
    }

    /**
     * Sets the description 2.
     *
     * @param description2 the new description 2
     */
    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    /**
     * Gets the date update.
     *
     * @return the date update
     */
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * Sets the user update.
     *
     * @param userUpdate the new user update
     */
    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }

    /**
     * Gets the user update.
     *
     * @return the user update
     */
    public String getUserUpdate() {
        return userUpdate;
    }

    /**
     * Pre update.
     */
    @PreUpdate
    public void preUpdate() {
        dateUpdate = new Date();
        userUpdate = LoggedUser.get();
    }

    /**
     * Gets the type update.
     *
     * @return the type update
     */
    public String getTypeUpdate() {
        return typeUpdate;
    }

    /**
     * Sets the type update.
     *
     * @param typeUpdate the new type update
     */
    public void setTypeUpdate(String typeUpdate) {
        this.typeUpdate = typeUpdate;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ModuleHistory [id=" + id + ", modId=" + modId + ", typeOrgane=" + typeOrgane + ", numeroOrgane=" + numeroOrgane + ", typeModule="
                + typeModule + ", numeroModule=" + numeroModule + ", description2=" + description2 + ", dateUpdate=" + dateUpdate + ", userUpdate="
                + userUpdate + ", typeUpdate=" + typeUpdate + "]";
    }

}
