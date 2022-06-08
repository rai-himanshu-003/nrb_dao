/*
 * Creation : 27 Aug 2019
 */
package com.inetpsa.nrb.model;

import java.time.LocalDateTime;
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
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;

import com.inetpsa.nrb.util.LoggedUser;
import com.sun.istack.NotNull;

/**
 * * Entity class for table 'NRBQTBMU'.
 */
@Entity
@DynamicUpdate(value = true)
@NamedQuery(name = "BmuEntity.findByBusinessKey", query = "From BmuEntity b where b.typeOrgane = :typeOrgane AND b.numeroOrgane = :numeroOrgane AND b.currentValue='Y'")
@Table(name = "NRBQTBMU")
public class BmuEntity {

    /** The id. */
    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "NRBQTBMU_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID")
    private Long id;

    /** The type organe. */
    @Column(name = "TYPE_ORGANE")
    private String typeOrgane;

    /** The numero organe. */
    @Column(name = "NUMERO_ORGANE")
    private String numeroOrgane;

    /** The serial number. */
    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    /** The ref soft. */
    @Column(name = "REF_SOFT")
    private String refSoft;

    /** The ref hard. */
    @Column(name = "REF_HARD")
    private String refHard;

    /** The date production. */
    @Column(name = "DATE_PRODUCTION")
    private LocalDateTime dateProduction;

    /** The suppliercode. */
    @Column(name = "SUPPLIER_CODE")
    private String suppliercode;

    /** The ref cal. */
    @Column(name = "REF_CAL")
    private String refCal;

    /** The current value. */
    @Column(name = "CURRENT_VALUE")
    private String currentValue;

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

    /** The version. */
    @Version
    private Integer version;

    /**
     * Instantiates a new BmuEntity entity.
     */
    public BmuEntity() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.seedstack.business.domain.BaseEntity#getId()
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
    public void setTypeOrgane(@NotNull String typeOrgane) {
        this.typeOrgane = typeOrgane;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.seedstack.business.domain.BaseEntity#toString()
     */

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
    public void setNumeroOrgane(@NotNull String numeroOrgane) {
        this.numeroOrgane = numeroOrgane;
    }

    /**
     * Gets the serial number.
     *
     * @return the serial number
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the serial number.
     *
     * @param serialNumber the new serial number
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Gets the ref soft.
     *
     * @return the ref soft
     */
    public String getRefSoft() {
        return refSoft;
    }

    /**
     * Sets the ref soft.
     *
     * @param refSoft the new ref soft
     */
    public void setRefSoft(String refSoft) {
        this.refSoft = refSoft;
    }

    /**
     * Gets the ref hard.
     *
     * @return the ref hard
     */
    public String getRefHard() {
        return refHard;
    }

    /**
     * Sets the ref hard.
     *
     * @param refHard the new ref hard
     */
    public void setRefHard(String refHard) {
        this.refHard = refHard;
    }

    /**
     * Gets the date production.
     *
     * @return the date production
     */
    public LocalDateTime getDateProduction() {
        return dateProduction;
    }

    /**
     * Sets the date production.
     *
     * @param dateProduction the new date production
     */
    public void setDateProduction(LocalDateTime dateProduction) {
        this.dateProduction = dateProduction;
    }

    /**
     * Gets the suppliercode.
     *
     * @return the suppliercode
     */
    public String getSuppliercode() {
        return suppliercode;
    }

    /**
     * Sets the suppliercode.
     *
     * @param suppliercode the new suppliercode
     */
    public void setSuppliercode(String suppliercode) {
        this.suppliercode = suppliercode;
    }

    /**
     * Gets the ref cal.
     *
     * @return the ref cal
     */
    public String getRefCal() {
        return refCal;
    }

    /**
     * Sets the ref cal.
     *
     * @param refCal the new ref cal
     */
    public void setRefCal(String refCal) {
        this.refCal = refCal;
    }

    /**
     * Gets the current value.
     *
     * @return the current value
     */
    public String getCurrentValue() {
        return currentValue;
    }

    /**
     * Sets the current value.
     *
     * @param currentValue the new current value
     */
    public void setCurrentValue(@NotNull String currentValue) {
        this.currentValue = currentValue;
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
     * Gets the date maj.
     *
     * @return the date maj
     */
    public Date getDateMaj() {
        return dateMaj;
    }

    /**
     * Gets the user maj.
     *
     * @return the user maj
     */
    public String getUserMaj() {
        return userMaj;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Pre Persist
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
        return "BmuEntity [id=" + id + ", typeOrgane=" + typeOrgane + ", numeroOrgane=" + numeroOrgane + ", serialNumber=" + serialNumber
                + ", refSoft=" + refSoft + ", refHard=" + refHard + ", dateProduction=" + dateProduction + ", suppliercode=" + suppliercode
                + ", refCal=" + refCal + ", currentValue=" + currentValue + ", userCreation=" + userCreation + ", dateCreation=" + dateCreation
                + ", userMaj=" + userMaj + ", dateMaj=" + dateMaj + ",  version=" + version + "]";
    }

}
