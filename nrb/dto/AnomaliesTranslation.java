
/*
 * Creation : 12 Jan 2022
 */
package com.inetpsa.nrb.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class AnomaliesTranslation.
 */

public class AnomaliesTranslation {

    /** The id. */
    @JsonProperty("Id")
    private long id;

    /** The vin. */
    @JsonProperty("Vin")
    private String vin;

    /** The bin 1. */
    @JsonProperty("Bin1")
    private String bin1;

    /** The bin 2. */
    @JsonProperty("Bin2")
    private String bin2;

    /** The error message. */
    @JsonProperty("ErrorMessage")
    private String errorMessage;

    /** The message value. */
    @JsonProperty("Val_Msg")
    private String messageValue;

    /** The date error. */
    @JsonProperty("Date")
    private Timestamp dateError;

    /** The lbl trad. */
    @JsonProperty("Lbl_trad")
    private String lbltrad;

    /**
     * Instantiates a new anomalies translation.
     */
    public AnomaliesTranslation() {
        super();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Instantiates a new anomalies translation.
     *
     * @param id           the id
     * @param vin          the vin
     * @param bin1         the bin 1
     * @param bin2         the bin 2
     * @param errorMessage the error message
     * @param dateError    the date error
     * @param lbltrad      the lbltrad
     */
    public AnomaliesTranslation(long id, String vin, String bin1, String bin2, String errorMessage, Timestamp dateError, String lbltrad) {
        super();
        this.id = id;
        this.vin = vin;
        this.bin1 = bin1;
        this.bin2 = bin2;
        this.errorMessage = errorMessage;
        this.dateError = dateError;
        this.lbltrad = lbltrad;
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
     * Gets the bin 1.
     *
     * @return the bin 1
     */
    public String getBin1() {
        return bin1;
    }

    /**
     * Sets the bin 1.
     *
     * @param bin1 the new bin 1
     */
    public void setBin1(String bin1) {
        this.bin1 = bin1;
    }

    /**
     * Gets the bin 2.
     *
     * @return the bin 2
     */
    public String getBin2() {
        return bin2;
    }

    /**
     * Sets the bin 2.
     *
     * @param bin2 the new bin 2
     */
    public void setBin2(String bin2) {
        this.bin2 = bin2;
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
     * Gets the lbl trad.
     *
     * @return the lbl trad
     */
    public String getLbltrad() {
        return lbltrad;
    }

    /**
     * Sets the lbl trad.
     *
     * @param lbltrad the new lbltrad
     */
    public void setLbltrad(String lbltrad) {
        this.lbltrad = lbltrad;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AnomaliesTranslation [id=" + id + ", vin=" + vin + ", bin1=" + bin1 + ", bin2=" + bin2 + ", errorMessage=" + errorMessage
                + ", messageValue=" + messageValue + ", dateError=" + dateError + ", lbltrad=" + lbltrad + "]";
    }

}