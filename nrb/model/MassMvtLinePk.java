/*
 * Creation : 17 Jan 2022
 */
package com.inetpsa.nrb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class MassMvtLinePk.
 */
@Embeddable
public class MassMvtLinePk implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** The id file. */
    @Column(name = "ID_FILE")
    private Long idFile;

    /** The id line. */
    @Column(name = "ID_LINE")
    private Long idLine;

    /**
     * Gets the id file.
     *
     * @return the id file
     */
    public Long getIdFile() {
        return idFile;
    }

    /**
     * Sets the id file.
     *
     * @param idFile the new id file
     */
    public void setIdFile(Long idFile) {
        this.idFile = idFile;
    }

    /**
     * Gets the id line.
     *
     * @return the id line
     */
    public Long getIdLine() {
        return idLine;
    }

    /**
     * Sets the id line.
     *
     * @param idLine the new id line
     */
    public void setIdLine(Long idLine) {
        this.idLine = idLine;
    }

    /**
     * Instantiates a new massMvtLinePk
     *
     * @param idFile the idFile
     * @param idLine the idLine
     */
    public MassMvtLinePk(Long idFile, Long idLine) {
        super();
        this.idFile = idFile;
        this.idLine = idLine;
    }

    /**
     * Instantiates a new massMvtLinePk
     */
    public MassMvtLinePk() {
        super();

    }

}
