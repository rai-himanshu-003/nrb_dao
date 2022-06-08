/*
 * Creation : 23 Feb 2022
 */
package com.inetpsa.nrb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class Vin.
 */
@Entity
@DynamicUpdate(value = true)

@NamedQuery(name = "VIN.findVinForBatteryByBusinessKey", query = "select v.id, v.numeroOrgane, v.vin from Vin v where v.typeOrgane = :typeOrgane AND v.numeroOrgane in :numeroOrgane AND v.currentValue=:currentValue")
@NamedQuery(name = "VIN.findAllVinForBatteryByBusinessKey", query = "select v.vin,v.dateCreation from Vin v where v.typeOrgane = :typeOrgane AND v.numeroOrgane = :numeroOrgane ORDER BY v.dateCreation DESC")
@NamedQuery(name = "VIN.findByBusinessKey", query = "From Vin b where b.typeOrgane = :typeOrgane AND b.numeroOrgane = :numeroOrgane AND b.currentValue='Y'")
@Table(name = "NRBQTVIN")
public class Vin {

    /** The id. */

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "NRBQTVIN_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID")
    private Long id;

    /** The request id. */
    @Column(name = "REQUEST_ID")
    private String requestId;

    /** The type organe. */
    @Column(name = "TYPE_ORGANE")
    private String typeOrgane;

    /** The numero organe. */
    @Column(name = "NUMERO_ORGANE")
    private String numeroOrgane;

    /** The current value. */
    @Column(name = "CURRENT_VALUE")
    private String currentValue;

    /** The vin. */
    @Column(name = "VIN")
    private String vin;

    /** The user creation. */
    @Column(name = "USER_CREATION")
    private String userCreation;

    /** The date creation. */
    @Column(name = "DATE_CREATION")
    private Timestamp dateCreation;

    /** The user maj. */
    @Column(name = "USER_MAJ")
    private String userMaj;

    /** The date maj. */
    @Column(name = "DATE_MAJ")
    private Timestamp dateMaj;

    /** The bmu organe. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NRBQTORG_ID")
    private OrganeEntity vinOrgane;

    /** The version. */
    @Version
    private Integer version;

    /**
     * Instantiates a new vin.
     */
    public Vin() {
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
     * Gets the request id.
     *
     * @return the request id
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the request id.
     *
     * @param requestId the new request id
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
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
    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * Gets the vin.
     *
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * Sets the vin.
     *
     * @param vin the new vin
     */
    public void setVin(String vin) {
        this.vin = vin;
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
    public Timestamp getDateCreation() {
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
    public Timestamp getDateMaj() {
        return dateMaj;
    }

    /**
     * Pre persist.
     */
    @PrePersist
    public void prePersist() {
        dateCreation = new Timestamp(System.currentTimeMillis());
        userCreation = LoggedUser.get();
    }

    /**
     * Pre update.
     */
    @PreUpdate
    public void preUpdate() {

        dateMaj = new Timestamp(System.currentTimeMillis());
        userMaj = LoggedUser.get();

    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Vin [id=" + id + ", requestId=" + requestId + ", typeOrgane=" + typeOrgane + ", numeroOrgane=" + numeroOrgane + ", currentValue="
                + currentValue + ", vin=" + vin + ", userCreation=" + userCreation + ", dateCreation=" + dateCreation + ", userMaj=" + userMaj
                + ", dateMaj=" + dateMaj + ", version=" + version + "]";
    }

}
