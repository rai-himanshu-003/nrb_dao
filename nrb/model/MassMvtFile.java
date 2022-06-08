/*
 * Creation : 17 Jan 2022
 */
package com.inetpsa.nrb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.inetpsa.nrb.dto.MassMvtFileDto;

/**
 * The Class MassMvtFile.
 */
@Entity
@Table(name = "NRBQTMMFILE")
public class MassMvtFile {

    /** The id file. */
    @Id
    @SequenceGenerator(name = "NRBQTMMFILE_SEQ", sequenceName = "NRBQTMMFILE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NRBQTMMFILE_SEQ")
    @Column(name = "ID_FILE")
    private Long idFile;

    /** The file name. */
    @Column(name = "FILE_NAME")
    private String fileName;

    /** The date creation. */
    @Column(name = "DATE_CREATION")
    private Date dateCreation;

    /** The date start. */
    @Column(name = "DATE_START")
    private Date dateStart;

    /** The date end. */
    @Column(name = "DATE_END")
    private Date dateEnd;

    /** The number ok. */
    @Column(name = "NUMBER_OK")
    private Integer numberOk;

    /** The number ko. */
    @Column(name = "NUMBER_KO")
    private Integer numberKo;

    /** The user file. */
    @Column(name = "USER_FILE")
    private String userFile;

    /** The translation status. */
    @Column(name = "STATUS_ID_TRANSLATION")
    private String translationStatus;

    /**
     * Pre persist.
     */
    @PrePersist
    public void prePersist() {
        dateCreation = new Date();
        userFile = "E566559";
    }

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
     * Gets the file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name.
     *
     * @param fileName the new file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the date creation.
     *
     * @return the date creation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Sets the date creation.
     *
     * @param dateCreation the new date creation
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Gets the date start.
     *
     * @return the date start
     */
    public Date getDateStart() {
        return dateStart;
    }

    /**
     * Sets the date start.
     *
     * @param dateStart the new date start
     */
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * Gets the date end.
     *
     * @return the date end
     */
    public Date getDateEnd() {
        return dateEnd;
    }

    /**
     * Sets the date end.
     *
     * @param dateEnd the new date end
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * Gets the number ok.
     *
     * @return the number ok
     */
    public Integer getNumberOk() {
        return numberOk;
    }

    /**
     * Sets the number ok.
     *
     * @param numberOk the new number ok
     */
    public void setNumberOk(Integer numberOk) {
        this.numberOk = numberOk;
    }

    /**
     * Gets the number ko.
     *
     * @return the number ko
     */
    public Integer getNumberKo() {
        return numberKo;
    }

    /**
     * Sets the number ko.
     *
     * @param numberKo the new number ko
     */
    public void setNumberKo(Integer numberKo) {
        this.numberKo = numberKo;
    }

    /**
     * Gets the user file.
     *
     * @return the user file
     */
    public String getUserFile() {
        return userFile;
    }

    /**
     * Sets the user file.
     *
     * @param userFile the new user file
     */
    public void setUserFile(String userFile) {
        this.userFile = userFile;
    }

    /**
     * Gets the translation status.
     *
     * @return the translation status
     */
    public String getTranslationStatus() {
        return translationStatus;
    }

    /**
     * Sets the translation status.
     *
     * @param translationStatus the new translation status
     */
    public void setTranslationStatus(String translationStatus) {
        this.translationStatus = translationStatus;
    }

    /**
     * Convert to entity.
     *
     * @param dto the dto
     * @return the mass mvt file
     */
    public MassMvtFile convertToEntity(MassMvtFileDto dto) {
        if (dto.getIdFile() != null)
            this.idFile = dto.getIdFile();

        if (dto.getTranslationStatus() != null)
            this.translationStatus = dto.getTranslationStatus();

        if (dto.getUserFile() != null)
            this.userFile = dto.getUserFile();

        if (dto.getDateCreation() != null)
            this.dateCreation = dto.getDateCreation();

        if (dto.getDateEnd() != null)
            this.dateEnd = dto.getDateEnd();

        if (dto.getDateStart() != null)
            this.dateStart = dto.getDateStart();

        if (dto.getFileName() != null)
            this.fileName = dto.getFileName();

        if (dto.getNumberKo() != null)
            this.numberKo = dto.getNumberKo();

        if (dto.getNumberOk() != null)
            this.numberOk = dto.getNumberOk();

        return this;
    }

}
