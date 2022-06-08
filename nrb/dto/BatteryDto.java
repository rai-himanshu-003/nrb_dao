/*
 * Creation : 4 Mar 2022
 */
package com.inetpsa.nrb.dto;

import java.util.Date;

/**
 * The Class BatteryDto.
 */
public class BatteryDto {

    /** The id. */
    private String id;

    /** The bin. */
    private String bin;

    /** The factory code. */
    private String factoryCode;

    /** The prod date. */
    private String prodDate;

    /** The refrence. */
    private String refrence;

    /** The status. */
    private String status;

    /** The ext from date. */
    private Date extFromDate;

    /** The ext to date. */
    private Date extToDate;

    /** The lang. */
    private String lang;

    /** The bin order. */
    private String binOrder;

    /** The factory code order. */
    private String factoryCodeOrder;

    /** The refrence order. */
    private String refrenceOrder;

    /** The state order. */
    private String statusOrder;

    /** The prod date order. */
    private String prodDateOrder;

    /**
     * Instantiates a new battery dto.
     */
    public BatteryDto() {
        super();

    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param obj the new id
     */
    public void setId(String obj) {
        this.id = obj;
    }

    /**
     * Gets the bin.
     *
     * @return the bin
     */
    public String getBin() {
        return bin;
    }

    /**
     * Sets the bin.
     *
     * @param bin the new bin
     */
    public void setBin(String bin) {
        this.bin = bin;
    }

    /**
     * Gets the factory code.
     *
     * @return the factory code
     */
    public String getFactoryCode() {
        return factoryCode;
    }

    /**
     * Sets the factory code.
     *
     * @param factoryCode the new factory code
     */
    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    /**
     * Gets the prod date.
     *
     * @return the prod date
     */
    public String getProdDate() {
        return prodDate;
    }

    /**
     * Sets the prod date.
     *
     * @param prodDate the new prod date
     */
    public void setProdDate(String prodDate) {
        this.prodDate = prodDate;
    }

    /**
     * Gets the refrence.
     *
     * @return the refrence
     */
    public String getRefrence() {
        return refrence;
    }

    /**
     * Sets the refrence.
     *
     * @param refrence the new refrence
     */
    public void setRefrence(String refrence) {
        this.refrence = refrence;
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
     * Gets the ext from date.
     *
     * @return the ext from date
     */
    public Date getExtFromDate() {
        return extFromDate;
    }

    /**
     * Sets the ext from date.
     *
     * @param extFromDate the new ext from date
     */
    public void setExtFromDate(Date extFromDate) {
        this.extFromDate = extFromDate;
    }

    /**
     * Gets the ext to date.
     *
     * @return the ext to date
     */
    public Date getExtToDate() {
        return extToDate;
    }

    /**
     * Sets the ext to date.
     *
     * @param extToDate the new ext to date
     */
    public void setExtToDate(Date extToDate) {
        this.extToDate = extToDate;
    }

    /**
     * Gets the lang.
     *
     * @return the lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the lang.
     *
     * @param lang the new lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * Gets the bin order.
     *
     * @return the bin order
     */
    public String getBinOrder() {
        return binOrder;
    }

    /**
     * Sets the bin order.
     *
     * @param binOrder the new bin order
     */
    public void setBinOrder(String binOrder) {
        this.binOrder = binOrder;
    }

    /**
     * Gets the factory code order.
     *
     * @return the factory code order
     */
    public String getFactoryCodeOrder() {
        return factoryCodeOrder;
    }

    /**
     * Sets the factory code order.
     *
     * @param factoryCodeOrder the new factory code order
     */
    public void setFactoryCodeOrder(String factoryCodeOrder) {
        this.factoryCodeOrder = factoryCodeOrder;
    }

    /**
     * Gets the refrence order.
     *
     * @return the refrence order
     */
    public String getRefrenceOrder() {
        return refrenceOrder;
    }

    /**
     * Sets the refrence order.
     *
     * @param refrenceOrder the new refrence order
     */
    public void setRefrenceOrder(String refrenceOrder) {
        this.refrenceOrder = refrenceOrder;
    }

    /**
     * Gets the state order.
     *
     * @return the state order
     */
    public String getStatusOrder() {
        return statusOrder;
    }

    /**
     * Sets the state order.
     *
     * @param statusOrder the new status order
     */
    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    /**
     * Gets the prod date order.
     *
     * @return the prod date order
     */
    public String getProdDateOrder() {
        return prodDateOrder;
    }

    /**
     * Sets the prod date order.
     *
     * @param prodDateOrder the new prod date order
     */
    public void setProdDateOrder(String prodDateOrder) {
        this.prodDateOrder = prodDateOrder;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BatteryDto [id=" + id + ", bin=" + bin + ", factoryCode=" + factoryCode + ", prodDate=" + prodDate + ", refrence=" + refrence
                + ", status=" + status + ", extFromDate=" + extFromDate + ", extToDate=" + extToDate + "]";
    }

}
