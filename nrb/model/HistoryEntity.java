/*
 * Creation : 22 Mar 2022
 */
package com.inetpsa.nrb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class HistoryEntity.
 */
@Entity
@Table(name = "NRBQTHIS")
public class HistoryEntity {

    /** The id. */
    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "NRBQTHIS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID_HISTORY")
    private Long id;

    /** The table name. */
    @Column(name = "TABLE_NAME")
    private String tableName;

    /** The id component. */
    @Column(name = "ID_COMPONENT")
    private Long idComponent;

    /** The updated column. */
    @Column(name = "UPDATED_COLUMN")
    private String updatedColumn;

    /** The old value. */
    @Column(name = "OLD_VALUE")
    private String oldValue;

    /** The new value. */
    @Column(name = "NEW_VALUE")
    private String newValue;

    /** The user update. */
    @Column(name = "USER_UPDATE")
    private String userUpdate;

    /** The type update. */
    @Column(name = "TYPE_UPDATE")
    private String typeUpdate;

    /** The type organe. */
    @Column(name = "TYPE_ORGANE")
    private String typeOrgane;

    /** The numero organe. */
    @Column(name = "NUMERO_ORGANE")
    private String numeroOrgane;

    /** The date update. */
    @Column(name = "DATE_UPDATE")
    private Date dateUpdate;

    /**
     * Instantiates a new history entity.
     */
    public HistoryEntity() {
        super();
    }

  

    /**

     * Pre update.
     */
    @PreUpdate
    public void preUpdate() {
        dateUpdate = new Date();
        userUpdate = LoggedUser.get();
    }

    /**
     * Pre persist.
     */
    @PrePersist
    public void PrePersist() {
        dateUpdate = new Date();
        userUpdate = LoggedUser.get();
    }

    /**
     * Gets the table name.
     *
     * @return the table name
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the table name.
     *
     * @param tableName the new table name
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(Long idComponent) {
        this.idComponent = idComponent;
    }

    /**
     * Gets the updated column.
     *
     * @return the updated column
     */
    public String getUpdatedColumn() {
        return updatedColumn;
    }

    /**
     * Sets the updated column.
     *
     * @param updatedColumn the new updated column
     */
    public void setUpdatedColumn(String updatedColumn) {
        this.updatedColumn = updatedColumn;
    }

    /**
     * Gets the old value.
     *
     * @return the old value
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * Sets the old value.
     *
     * @param oldValue the new old value
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * Gets the new value.
     *
     * @return the new value
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * Sets the new value.
     *
     * @param newValue the new new value
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    /**
     * Gets the user update.
     *
     * @return the user update
     */
    public String getUserUpdate() {
        return userUpdate;
    }

    /**
     * Gets the type update.
     *
     * @return the type update
     */
    public String getTypeUpdate() {
        return typeUpdate;
    }

    /**
     * Sets the type update.
     *
     * @param typeUpdate the new type update
     */
    public void setTypeUpdate(String typeUpdate) {
        this.typeUpdate = typeUpdate;
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
     * Gets the date update.
     *
     * @return the date update
     */
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HistoryEntity [id=" + id + ", tableName=" + tableName + ", idComponent=" + idComponent + ", updatedColumn=" + updatedColumn
                + ", oldValue=" + oldValue + ", newValue=" + newValue + ", userUpdate=" + userUpdate + ", typeUpdate=" + typeUpdate + ", typeOrgane="
                + typeOrgane + ", numeroOrgane=" + numeroOrgane + ", dateUpdate=" + dateUpdate + "]";
    }

}
