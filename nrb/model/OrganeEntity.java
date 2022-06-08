/*
 * Creation : 22 Jul 2019
 */
package com.inetpsa.nrb.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class OrganeEntity.
 */
/*
 * * Entity class for table 'NRBQTORG'.
 *
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Organe.findByBusinessKey", query = "From OrganeEntity o where o.typeOrgane = :typeOrgane AND o.numeroOrgane = :numeroOrgane AND o.currentValue = 'Y' ") })
@Table(name = "NRBQTORG", uniqueConstraints = @UniqueConstraint(columnNames = { "TYPE_ORGANE", "NUMERO_ORGANE" }))
public class OrganeEntity {

    /** The id. */
    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "NRBQTORG_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID")
    private Long id;

    /** The type organe. */
    @Column(name = "TYPE_ORGANE")
    private String typeOrgane;

    /** The numero organe. */
    @Column(name = "NUMERO_ORGANE")
    private String numeroOrgane;

    /** The request id. */
    @Column(name = "REQUEST_ID")
    private String requestId;

    /** The date production. */
    @Column(name = "DATE_PRODUCTION")
    private LocalDateTime dateProduction;

    /** The date engagement. */
    @Column(name = "DATE_ENGAGEMENT")
    private LocalDateTime dateEngagement;

    /** The reference. */
    @Column(name = "REFERENCE")
    private String reference;

    /** The description. */
    @Column(name = "DESCRIPTION")
    private String description;

    /** The description 2. */
    @Column(name = "DESCRIPTION_2")
    private String description2;

    /** The code using. */
    @Column(name = "CODE_USINE")
    private String codeUsing;

    /** The code sgr. */
    @Column(name = "CODE_SGR")
    private String codeSgr;

    /** The code atelier. */
    @Column(name = "CODE_ATELIER")
    private String codeAtelier;

    /** The status. */
    @Column(name = "STATUS")
    private String status;

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

    /** The current value. */
    @Column(name = "CURRENT_VALUE")
    private String currentValue;

    /** The version. */
    @Version
    private Integer version;

    /**
     * Instantiates a new organe entity.
     */
    public OrganeEntity() {
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
     * Gets the date engagement.
     *
     * @return the date engagement
     */
    public LocalDateTime getDateEngagement() {
        return dateEngagement;
    }

    /**
     * Sets the date engagement.
     *
     * @param dateEngagement the new date engagement
     */
    public void setDateEngagement(LocalDateTime dateEngagement) {
        this.dateEngagement = dateEngagement;
    }

    /**
     * Gets the reference.
     *
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the reference.
     *
     * @param reference the new reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Gets the code using.
     *
     * @return the code using
     */
    public String getCodeUsing() {
        return codeUsing;
    }

    /**
     * Sets the code using.
     *
     * @param codeUsing the new code using
     */
    public void setCodeUsing(String codeUsing) {
        this.codeUsing = codeUsing;
    }

    /**
     * Gets the code sgr.
     *
     * @return the code sgr
     */
    public String getCodeSgr() {
        return codeSgr;
    }

    /**
     * Sets the code sgr.
     *
     * @param codeSgr the new code sgr
     */
    public void setCodeSgr(String codeSgr) {
        this.codeSgr = codeSgr;
    }

    /**
     * Gets the code atelier.
     *
     * @return the code atelier
     */
    public String getCodeAtelier() {
        return codeAtelier;
    }

    /**
     * Sets the code atelier.
     *
     * @param codeAtelier the new code atelier
     */
    public void setCodeAtelier(String codeAtelier) {
        this.codeAtelier = codeAtelier;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
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
     * Sets the user creation.
     *
     * @param userCreation the new user creation
     */
    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
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
     * Sets the date creation.
     *
     * @param dateCreation the new date creation
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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
     * Sets the user maj.
     *
     * @param userMaj the new user maj
     */
    public void setUserMaj(String userMaj) {
        this.userMaj = userMaj;
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
     * Sets the date maj.
     *
     * @param dateMaj the new date maj
     */
    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
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

}
