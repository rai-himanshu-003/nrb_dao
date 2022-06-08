/*
 * Creation : 21 Dec 2021
 */
package com.inetpsa.nrb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class Module.
 */
@Entity
@DynamicUpdate(value = true)
@NamedQuery(name = "Module.findByBusinessKey", query = "from Module m where m.typeOrgane = :typeOrgane AND m.numeroOrgane = :numeroOrgane AND m.typeModule = :typeModule AND m.numeroModule = :numeroModule")
@Table(name = "NRBQTMOD", uniqueConstraints = @UniqueConstraint(columnNames = { "TYPE_ORGANE", "NUMERO_ORGANE", "TYPE_MODULE", "NUMERO_MODULE" }))
public class Module {
    /** The id. */

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "NRBQTMOD_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID")
    private Long id;

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

    @Column(name = "CURRENT_VALUE")
    private String currentValue;

    @Version
    private Integer version;

    /**
     * Instantiates a new module entity.
     */
    public Module() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
     * pre persist
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

    @Override
    public String toString() {
        return "ModuleEntity [id=" + id + ", typeOrgane=" + typeOrgane + ", numeroOrgane=" + numeroOrgane + ", typeModule=" + typeModule
                + ", numeroModule=" + numeroModule + ", description2=" + description2 + ", userCreation=" + userCreation + ", dateCreation="
                + dateCreation + ", userMaj=" + userMaj + ", dateMaj=" + dateMaj + "]";
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public String getUserMaj() {
        return userMaj;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

}
