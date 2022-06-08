/*
 * Creation : 10 Feb 2022
 */
package com.inetpsa.nrb.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.inetpsa.nrb.dto.CodeTypeTransDto;
import com.inetpsa.nrb.util.LoggedUser;

/**
 * Class CodeTypeEntity.
 */
@Entity
@DynamicUpdate(value = true)
@Table(name = "NRBQTCODE")
public class CodeTypeEntity {

    /** the id code pk. */
    @Id
    @EmbeddedId
    private CodeTypeEntityPk codeTypeEntityPk;

    /** the label code in code entity. */
    @Column(name = "LBL_CODE")
    private String lblCode;

    /** the date creation in code entity. */
    @Column(name = "DATE_CREATION")
    private Timestamp dateCreation;

    /** the user creation in code entity. */
    @Column(name = "USER_CREATION")
    private String userCreation;

    /** the date maj in code entity. */
    @Column(name = "DATE_MAJ")
    private Timestamp dateMaj;

    /** the user maj in code entity. */
    @Column(name = "USER_MAJ")
    private String userMaj;

    /**
     * Instantiates a new language entity.
     */
    public CodeTypeEntity() {
        super();
    }

    /**
     * Instantiates new code type entity //* @param idCode the idCode //* @param typCode the typCode.
     *
     * @param codeTypeEntityPk the code type entity pk
     * @param lblCode          the lblCode
     * @param dateCreation     the dateCreation
     * @param userCreation     the userCreation
     * @param dateMaj          the dateMaj
     * @param userMaj          the userMaj
     */

    public CodeTypeEntity(CodeTypeEntityPk codeTypeEntityPk, String lblCode, Timestamp dateCreation, String userCreation, Timestamp dateMaj,
            String userMaj) {
        super();
        this.codeTypeEntityPk = codeTypeEntityPk;
        this.lblCode = lblCode;
        this.dateCreation = dateCreation;
        this.userCreation = userCreation;
        this.dateMaj = dateMaj;
        this.userMaj = userMaj;
    }

    /**
     * Gets the code type entity pk.
     *
     * @return the code type entity pk
     */
    public CodeTypeEntityPk getCodeTypeEntityPk() {
        return codeTypeEntityPk;
    }

    /**
     * Sets the code type entity pk.
     *
     * @param codeTypeEntityPk the new code type entity pk
     */
    public void setCodeTypeEntityPk(CodeTypeEntityPk codeTypeEntityPk) {
        this.codeTypeEntityPk = codeTypeEntityPk;
    }

    /**
     * Gets the label code.
     *
     * @return the label code
     */
    public String getLblCode() {
        return lblCode;
    }

    /**
     * Sets the label code.
     *
     * @param lblCode the new lbl code
     */
    public void setLblCode(String lblCode) {
        this.lblCode = lblCode;
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
        return "CodeTypeEntity [codeTypeEntityPk=" + codeTypeEntityPk + ", lblCode=" + lblCode + ", dateCreation=" + dateCreation + ", userCreation="
                + userCreation + ", dateMaj=" + dateMaj + ", userMaj=" + userMaj + "]";
    }

    /**
     * Map tomodel.
     *
     * @return the code type trans dto
     */
    public CodeTypeTransDto mapTomodel() {

        CodeTypeTransDto codeTypeTransDto = new CodeTypeTransDto();
        codeTypeTransDto.setIdCode(this.getCodeTypeEntityPk().getIdCode());
        codeTypeTransDto.setTypCode(this.getCodeTypeEntityPk().getTypCode());
        codeTypeTransDto.setLblCode(this.getLblCode());
        codeTypeTransDto.setDateCreation(this.getDateCreation());
        codeTypeTransDto.setUserCreation(this.getUserCreation());
        codeTypeTransDto.setDateMaj(this.getDateMaj());
        codeTypeTransDto.setUserMaj(this.getUserMaj());
        return codeTypeTransDto;

    }

}
