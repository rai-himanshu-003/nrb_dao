package com.inetpsa.nrb.dto;

import com.inetpsa.nrb.model.UserInfo;

/**
 * The Class UserInformationDTO.
 */
public class UserInformationDto {

    /** The id. */
    private Long id;

    /** The user id. */
    private String userId;

    /** The type. */
    private String type;

    /** The value. */
    private String value;

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
     * Gets the user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserInformationDTO [id=" + id + ", userId=" + userId + ", type=" + type + ", value=" + value + "]";
    }

    /**
     * Map tomodel.
     *
     * @param userInfo the user info
     * @return the user info
     */
    public UserInfo mapTomodel(UserInfo userInfo) {
        userInfo.setId(this.getId());
        userInfo.setUserId(this.getUserId());
        userInfo.setType(this.getType());
        userInfo.setValue(this.getValue());
        return userInfo;
    }

}
