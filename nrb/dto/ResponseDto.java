
/*
 * Creation : 13 Jan 2022
 */
package com.inetpsa.nrb.dto;

/**
 * The Class AnomaliesResponseDto.
 */
public class ResponseDto {

    /** The id. */
    private String id;

    /** The message. */
    private boolean msg;

    /** The message. */
    private String message;

    /**
     * Checks if is message.
     *
     * @return true, if is message
     */
    public boolean isMsg() {
        return msg;
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
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the message.
     *
     * @param msg the new message
     */
    public void setMsg(boolean msg) {
        this.msg = msg;
    }

    /**
     * Getter message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter message.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
