
package com.inetpsa.nrb.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;

import com.inetpsa.nrb.dto.UserInformationDto;
import com.inetpsa.nrb.util.LoggedUser;

/**
 * The Class UserInfo.
 */
@Entity
@Table(name = "NRBQTUSRINF")
@DynamicUpdate(value = true)
public class UserInfo {
    /** The id. */

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "NRBQTUSR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "ID")
    private Long id;

    /** The user id. */
    @Column(name = "USERID")
    private String userId;

    /** The type. */
    @Column(name = "TYPE")
    private String type;

    /** The value. */
    @Column(name = "VALUE")
    private String value;

    /** The date creation. */
    @Column(name = "DATE_CREATION")
    private LocalDateTime dateCreation;

    /** The user creation. */
    @Column(name = "USER_CREATION")
    private String userCreation;

    /** The date modif. */
    @Column(name = "DATE_MODIF")
    private LocalDateTime dateModif;

    /** The user modif. */
    @Column(name = "USER_MODIF")
    private String userModif;

    /** The version. */
    @Version
    @Column(name = "VERSION")
    private Integer version;

    /**
     * Instantiates a new user info.
     */
    public UserInfo() {
        super();

    }

    /**
     * Instantiates a new user info.
     *
     * @param id           the id
     * @param userId       the user id
     * @param type         the type
     * @param value        the value
     * @param dateCreation the date creation
     * @param userCreation the user creation
     * @param dateModif    the date modif
     * @param userModif    the user modif
     * @param version      the version
     */
    public UserInfo(Long id, String userId, String type, String value, LocalDateTime dateCreation, String userCreation, LocalDateTime dateModif,
            String userModif, Integer version) {
        super();
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.value = value;
        this.dateCreation = dateCreation;
        this.userCreation = userCreation;
        this.dateModif = dateModif;
        this.userModif = userModif;
        this.version = version;
    }

    /**
     * Pre persist.
     */
    @PrePersist
    public void prePersist() {
        dateCreation = LocalDateTime.now();
        userCreation = LoggedUser.get();
        dateModif = LocalDateTime.now();
        userModif = LoggedUser.get();
    }

    /**
     * Pre update.
     */
    @PreUpdate
    public void preUpdate() {
        dateModif = LocalDateTime.now();
        userModif = LoggedUser.get();

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.seedstack.business.domain.BaseEntity#getId()
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
     * Gets the date creation.
     *
     * @return the date creation
     */
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    /**
     * Gets the user creation.
     *
     * @return the user creation
     */
    public String getUserCreation() {
        return userCreation;
    }

    /**
     * Gets the date modif.
     *
     * @return the date modif
     */
    public LocalDateTime getDateModif() {
        return dateModif;
    }

    /**
     * Gets the user modif.
     *
     * @return the user modif
     */
    public String getUserModif() {
        return userModif;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Mapto dto.
     *
     * @return the user information dto
     */
    public UserInformationDto maptoDto() {

        UserInformationDto userInformationDTO = new UserInformationDto();
        userInformationDTO.setId(this.getId());
        userInformationDTO.setType(this.getType());
        userInformationDTO.setUserId(this.getUserId());
        userInformationDTO.setValue(this.getValue());

        return userInformationDTO;
    }

}
