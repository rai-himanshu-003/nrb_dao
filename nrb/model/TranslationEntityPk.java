/*
 * Creation : 14 Feb 2022
 */
package com.inetpsa.nrb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class TranslationEntityPk.
 */
@Embeddable
public class TranslationEntityPk implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The idtrad. */
    @Column(name = "ID_TRAD")
    private String idtrad;

    /** The idlang. */
    @Column(name = "ID_LANG")
    private String idlang;

    /**
     * Instantiates a new translation entity pk.
     *
     * @param idtrad the idtrad
     * @param idlang the idlang
     */
    public TranslationEntityPk(String idtrad, String idlang) {
        super();
        this.idtrad = idtrad;
        this.idlang = idlang;
    }

    /**
     * Instantiates a new translation entity pk.
     */
    public TranslationEntityPk() {
        super();
    }

    /**
     * Gets the idtrad.
     *
     * @return the idtrad
     */
    public String getIdtrad() {
        return idtrad;
    }

    /**
     * Sets the idtrad.
     *
     * @param idtrad the new idtrad
     */
    public void setIdtrad(String idtrad) {
        this.idtrad = idtrad;
    }

    /**
     * Gets the idlang.
     *
     * @return the idlang
     */
    public String getIdlang() {
        return idlang;
    }

    /**
     * Sets the idlang.
     *
     * @param idlang the new idlang
     */
    public void setIdlang(String idlang) {
        this.idlang = idlang;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idlang == null) ? 0 : idlang.hashCode());
        result = prime * result + ((idtrad == null) ? 0 : idtrad.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TranslationEntityPk other = (TranslationEntityPk) obj;
        if (idlang == null) {
            if (other.idlang != null)
                return false;
        } else if (!idlang.equals(other.idlang))
            return false;
        if (idtrad == null) {
            if (other.idtrad != null)
                return false;
        } else if (!idtrad.equals(other.idtrad))
            return false;
        return true;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TranslationEntityPk [idtrad=" + idtrad + ", idlang=" + idlang + "]";
    }

}