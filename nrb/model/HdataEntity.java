/*
 * Creation : 27 Aug 2019
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
 * * Entity class for table 'NRBQTHDATA'.
 *
 * @author E566559
 */
@Entity
@DynamicUpdate(value = true)
@NamedQuery(name = "HdataEntity.findByBusinessKey", query = "From HdataEntity h where h.typeOrgane = :typeOrgane AND h.numeroOrgane = :numeroOrgane AND h.currentValue='Y'")
@Table(name = "NRBQTHDATA", uniqueConstraints = @UniqueConstraint(columnNames = { "TYPE_ORGANE", "NUMERO_ORGANE" }))
public class HdataEntity {

    /** The id. */
    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "NRBQTHDATA_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID")
    private Long id;

    /** The type organe. */
    @Column(name = "TYPE_ORGANE")
    private String typeOrgane;

    /** The numero organe. */
    @Column(name = "NUMERO_ORGANE")
    private String numeroOrgane;

    /** The soc. */
    @Column(name = "SOC")
    private String soc;

    /** The soh. */
    @Column(name = "SOH")
    private String soh;

    /** The rinsulation. */
    @Column(name = "RINSULATION")
    private String rinsulation;

    /** The rinternal. */
    @Column(name = "RINTERNAL")
    private String rinternal;

    /** The mic. */
    @Column(name = "MIC")
    private String mic;

    /** The mac. */
    @Column(name = "MAC")
    private String mac;

    /** The t 10. */
    @Column(name = "T10")
    private String t10;

    /** The tat. */
    @Column(name = "TAT")
    private String tat;

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
     * Instantiates a new HdataEntity enity.
     */
    public HdataEntity() {
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
     * Gets the soc.
     *
     * @return the soc
     */
    public String getSoc() {
        return soc;
    }

    /**
     * Sets the soc.
     *
     * @param soc the new soc
     */
    public void setSoc(String soc) {
        this.soc = soc;
    }

    /**
     * Gets the soh.
     *
     * @return the soh
     */
    public String getSoh() {
        return soh;
    }

    /**
     * Sets the soh.
     *
     * @param soh the new soh
     */
    public void setSoh(String soh) {
        this.soh = soh;
    }

    /**
     * Gets the rinsulation.
     *
     * @return the rinsulation
     */
    public String getRinsulation() {
        return rinsulation;
    }

    /**
     * Sets the rinsulation.
     *
     * @param rinsulation the new rinsulation
     */
    public void setRinsulation(String rinsulation) {
        this.rinsulation = rinsulation;
    }

    /**
     * Gets the rinternal.
     *
     * @return the rinternal
     */
    public String getRinternal() {
        return rinternal;
    }

    /**
     * Sets the rinternal.
     *
     * @param rinternal the new rinternal
     */
    public void setRinternal(String rinternal) {
        this.rinternal = rinternal;
    }

    /**
     * Gets the mic.
     *
     * @return the mic
     */
    public String getMic() {
        return mic;
    }

    /**
     * Sets the mic.
     *
     * @param mic the new mic
     */
    public void setMic(String mic) {
        this.mic = mic;
    }

    /**
     * Gets the mac.
     *
     * @return the mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * Sets the mac.
     *
     * @param mac the new mac
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * Gets the t10.
     *
     * @return the t10
     */
    public String getT10() {
        return t10;
    }

    /**
     * Sets the t10.
     *
     * @param t10 the new t10
     */
    public void setT10(String t10) {
        this.t10 = t10;
    }

    /**
     * Gets the tat.
     *
     * @return the tat
     */
    public String getTat() {
        return tat;
    }

    /**
     * Sets the tat.
     *
     * @param tat the new tat
     */
    public void setTat(String tat) {
        this.tat = tat;
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
     * Gets the user creation.
     *
     * @return the user creation
     */
    public String getUserCreation() {
        return userCreation;
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
     * Gets the version.
     *
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    public void setVersion(Integer version) {
        this.version = version;
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
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HdataEntity [id=" + id + ", typeOrgane=" + typeOrgane + ", numeroOrgane=" + numeroOrgane + ", soc=" + soc + ", soh=" + soh
                + ", rinsulation=" + rinsulation + ", rinternal=" + rinternal + ", mic=" + mic + ", mac=" + mac + ", t10=" + t10 + ", tat=" + tat
                + ", currentValue=" + currentValue + ", userCreation=" + userCreation + ", dateCreation=" + dateCreation + ", userMaj=" + userMaj
                + ", dateMaj=" + dateMaj + ", version=" + version + "]";
    }
}
