
/*
 * Creation : 11 Jan 2022
 */
package com.inetpsa.nrb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class AnomaliesEntity.
 */
@Entity
@Table(name = "NRBQTERR")
public class AnomaliesEntity {

    /** The id. */
    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "NRBQTERR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID_ERR")
    private Long id;

    /** The vin. */
    @Column(name = "VIN")
    private String vin;

    /** The bin 1 type. */
    @Column(name = "BIN1_TYPE")
    private String bin1Type;

    /** The bin 1 numero. */
    @Column(name = "BIN1_NUMERO")
    private String bin1Numero;

    /** The bin 2 type. */
    @Column(name = "BIN2_TYPE")
    private String bin2Type;

    /** The bin 2 numero. */
    @Column(name = "BIN2_NUMERO")
    private String bin2Numero;

    /** The error message. */
    @Column(name = "MSG_ERR")
    private String errorMessage;

    /** The message value. */
    @Column(name = "VAL_MSG")
    private String messageValue;

    /** The date error. */
    @Column(name = "DATE_ERR")
    private Timestamp dateError;

    /**
     * Instantiates a new anomalies entity.
     */
    public AnomaliesEntity() {
        super();
    }

    /**
     * Instantiates a new anomalies entity.
     *
     * @param id           the id
     * @param vin          the vin
     * @param bin1Type     the bin 1 type
     * @param bin1Numero   the bin 1 numero
     * @param bin2Type     the bin 2 type
     * @param bin2Numero   the bin 2 numero
     * @param errorMessage the error message
     * @param messageValue the message value
     * @param dateError    the date error
     */
    public AnomaliesEntity(Long id, String vin, String bin1Type, String bin2Type, String errorMessage, String messageValue, Timestamp dateError) {
        super();
        this.id = id;
        this.vin = vin;
        this.bin1Type = bin1Type;
        this.bin2Type = bin2Type;
        this.errorMessage = errorMessage;
        this.messageValue = messageValue;
        this.dateError = dateError;
    }

    /**
     * Gets the id.
     *
     * @return the id
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
     * Gets the bin 1 type.
     *
     * @return the bin 1 type
     */
    public String getBin1Type() {
        return bin1Type;
    }

    /**
     * Sets the bin 1 type.
     *
     * @param bin1Type the new bin 1 type
     */
    public void setBin1Type(String bin1Type) {
        this.bin1Type = bin1Type;
    }

    /**
     * Gets the bin 1 numero.
     *
     * @return the bin 1 numero
     */
    public String getBin1Numero() {
        return bin1Numero;
    }

    /**
     * Sets the bin 1 numero.
     *
     * @param bin1Numero the new bin 1 numero
     */
    public void setBin1Numero(String bin1Numero) {
        this.bin1Numero = bin1Numero;
    }

    /**
     * Gets the bin 2 type.
     *
     * @return the bin 2 type
     */
    public String getBin2Type() {
        return bin2Type;
    }

    /**
     * Sets the bin 2 type.
     *
     * @param bin2Type the new bin 2 type
     */
    public void setBin2Type(String bin2Type) {
        this.bin2Type = bin2Type;
    }

    /**
     * Gets the bin 2 numero.
     *
     * @return the bin 2 numero
     */
    public String getBin2Numero() {
        return bin2Numero;
    }

    /**
     * Sets the bin 2 numero.
     *
     * @param bin2Numero the new bin 2 numero
     */
    public void setBin2Numero(String bin2Numero) {
        this.bin2Numero = bin2Numero;
    }

    /**
     * Gets the error message.
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message.
     *
     * @param errorMessage the new error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Gets the message value.
     *
     * @return the message value
     */
    public String getMessageValue() {
        return messageValue;
    }

    /**
     * Sets the message value.
     *
     * @param messageValue the new message value
     */
    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }

    /**
     * Gets the date error.
     *
     * @return the date error
     */
    public Timestamp getDateError() {
        return dateError;
    }

    /**
     * Sets the date error.
     *
     * @param dateError the new date error
     */
    public void setDateError(Timestamp dateError) {
        this.dateError = dateError;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Anomalies [id=" + id + ", vin=" + vin + ", bin1Type=" + bin1Type + ", bin1Numero=" + bin1Numero + ", bin2Type=" + bin2Type
                + ", bin2Numero=" + bin2Numero + ", errorMessage=" + errorMessage + ", messageValue=" + messageValue + ", dateError=" + dateError
                + "]";
    }

}