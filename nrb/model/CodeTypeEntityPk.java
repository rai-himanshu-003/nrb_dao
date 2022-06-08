/*
 * Creation : 14 Feb 2022
 */
package com.inetpsa.nrb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class CodeTypeEntityPk.
 */
@Embeddable
public class CodeTypeEntityPk implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** The Code id */
    @Column(name = "ID_CODE")
    private String idCode;

    /** The type code */
    @Column(name = "TYPE_CODE")
    private String typCode;

    /**
     * Gets the code id
     * 
     * @return the code id
     */
    public String getIdCode() {
        return idCode;
    }

    /**
     * Sets the code id
     * 
     * @param code id the new code id
     */
    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    /**
     * Gets the type code
     * 
     * @return the type code
     */
    public String getTypCode() {
        return typCode;
    }

    /**
     * Sets the type code
     * 
     * @param code type the new type code
     */
    public void setTypCode(String typCode) {
        this.typCode = typCode;
    }

    /**
     * Instantiates a new codeTypePk entity.
     */
    public CodeTypeEntityPk() {
        super();
    }

    /**
     * Instantiates a new codetypePk entity
     *
     * @param idCode  the idCode
     * @param typCode the typCode
     */
    public CodeTypeEntityPk(String idCode, String typCode) {
        super();
        this.idCode = idCode;
        this.typCode = typCode;
    }

    @Override
    public String toString() {
        return "CodeTypeEntityPk [idCode=" + idCode + ", typCode=" + typCode + "]";
    }

}
