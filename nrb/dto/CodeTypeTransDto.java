/*
 * Creation : 10 Feb 2022
 */
package com.inetpsa.nrb.dto;

import java.sql.Timestamp;

import com.inetpsa.nrb.model.CodeTypeEntity;
import com.inetpsa.nrb.model.CodeTypeEntityPk;

/**
 * The class CodeTypeTransDto.
 */

public class CodeTypeTransDto {

    /** The id. */
    private int id;

    /** the code id. */
    private String idCode;

    /** the type code. */
    private String typCode;

    /** the label code. */
    private String lblCode;

    /** the date creation. */
    private Timestamp dateCreation;

    /** the user creation. */
    private String userCreation;

    /** the date maj. */
    private Timestamp dateMaj;

    /** the user maj. */
    private String userMaj;

    /**
     * Instantiates a new code type trans dto.
     */
    public CodeTypeTransDto() {
        super();
    }

    /**
     * Instantiates new code type trans dto.
     *
     * @param idCode       the idCode
     * @param typCode      the typCode
     * @param lblCode      the lblCode
     * @param dateCreation the dateCreation
     * @param userCreation the userCreation
     * @param dateMaj      the dateMaj
     * @param userMaj      the userMaj
     */
    public CodeTypeTransDto(String idCode, String typCode, String lblCode, Timestamp dateCreation, String userCreation, Timestamp dateMaj,
            String userMaj) {
        super();
        this.idCode = idCode;
        this.typCode = typCode;
        this.lblCode = lblCode;
        this.dateCreation = dateCreation;
        this.userCreation = userCreation;
        this.dateMaj = dateMaj;
        this.userMaj = userMaj;
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
     * Gets the code id.
     *
     * @return the code id
     */
    public String getIdCode() {
        return idCode;
    }

    /**
     * Sets the code id.
     *
     * @param idCode the new id code
     */
    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    /**
     * Gets the type code.
     *
     * @return the type code
     */
    public String getTypCode() {
        return typCode;
    }

    /**
     * Sets the type code.
     *
     * @param typCode the new typ code
     */
    public void setTypCode(String typCode) {
        this.typCode = typCode;
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
        return "CodeTypeTransDto [id=" + id + ", idCode=" + idCode + ", typCode=" + typCode + ", lblCode=" + lblCode + ", dateCreation="
                + dateCreation + ", userCreation=" + userCreation + ", dateMaj=" + dateMaj + ", userMaj=" + userMaj + "]";
    }

    /**
     * Map tomodel.
     *
     * @param codeTypeEntity the code type entity
     * @param idCode         the id code
     * @param typCode        the typ code
     * @return the code type entity
     */
    public CodeTypeEntity mapTomodel(CodeTypeEntity codeTypeEntity, String idCode, String typCode) {

        CodeTypeEntityPk codeTypeEntityPk = new CodeTypeEntityPk();
        codeTypeEntityPk.setIdCode(this.getIdCode());
        codeTypeEntityPk.setTypCode(this.getTypCode());
        codeTypeEntity.setCodeTypeEntityPk(codeTypeEntityPk);
        codeTypeEntity.setLblCode(this.getLblCode());

        return codeTypeEntity;
    }

    /**
     * Map to entity.
     *
     * @param codeTypeEntity the code type entity
     * @return the code type entity
     */
    public CodeTypeEntity mapToEntity(CodeTypeEntity codeTypeEntity) {

        codeTypeEntity.setCodeTypeEntityPk(codeTypeEntity.getCodeTypeEntityPk());
        codeTypeEntity.setLblCode(this.getLblCode());

        return codeTypeEntity;
    }

}
