/*
 * Creation : 17 Jan 2022
 */
package com.inetpsa.nrb.dto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.inetpsa.nrb.model.MassMvtFile;

/**
 * The Class MassMvtFile.
 */

public class MassMvtFileDto {

    /** The id file. */
    private Long idFile;

    /** The file name. */
    private String fileName;

    /** The date creation. */

    private Date dateCreation;

    /** The date start. */

    private Date dateStart;

    /** The date end. */

    private Date dateEnd;

    /** The number ok. */

    private Integer numberOk;

    /** The number ko. */
    private Integer numberKo;

    /** The number of lines. */
    private Integer numberOfLines;

    /** The user file. */

    private String userFile;

    /** The translation status. */

    private String translationStatus;

    /** The proccessing time. */
    private String proccessingTime;

    /** The time unit. */
    // Create a TimeUnit object
    TimeUnit timeUnit = TimeUnit.SECONDS;

    /**
     * Instantiates a new MassMvtFileDto.
     */
    public MassMvtFileDto() {
        super();
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
     * Getter proccessingTime.
     *
     * @return the proccessingTime
     */
    public String getProccessingTime() {
        return proccessingTime;
    }

    /**
     * Setter proccessingTime.
     *
     * @param proccessingTime the proccessingTime to set
     */
    public void setProccessingTime(String proccessingTime) {
        this.proccessingTime = proccessingTime;
    }

    /**
     * Gets the number of lines.
     *
     * @return the number of lines
     */
    public Integer getNumberOfLines() {
        return numberOfLines;
    }

    /**
     * Sets the number of lines.
     *
     * @param numberOfLines the new number of lines
     */
    public void setNumberOfLines(Integer numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MassMvtFileDto [idFile=" + idFile + ", fileName=" + fileName + ", dateCreation=" + dateCreation + ", dateStart=" + dateStart
                + ", dateEnd=" + dateEnd + ", numberOk=" + numberOk + ", numberKo=" + numberKo + ", userFile=" + userFile + ", translationStatus="
                + translationStatus + ", proccessingTime=" + proccessingTime + "]";
    }

    /**
     * Instantiates a new mass mvt file dto.
     *
     * @param massMvtFile the mass mvt file
     */
    public MassMvtFileDto(MassMvtFile massMvtFile) {
        this.idFile = massMvtFile.getIdFile();
        this.fileName = massMvtFile.getFileName();
        this.dateCreation = massMvtFile.getDateCreation();
        this.dateStart = massMvtFile.getDateStart();
        this.dateEnd = massMvtFile.getDateEnd();
        this.numberOk = massMvtFile.getNumberOk();
        this.numberKo = massMvtFile.getNumberKo();
        this.numberOfLines = massMvtFile.getNumberOk() + massMvtFile.getNumberKo();
        this.userFile = massMvtFile.getUserFile();
        this.translationStatus = massMvtFile.getTranslationStatus();
        this.proccessingTime = getFileProceesingTime(this.dateStart, this.dateEnd);

    }

    /**
     * Gets the file proceesing time.
     *
     * @param dateStart the date start
     * @param dateEnd   the date end
     * @return the file proceesing time
     */
    public String getFileProceesingTime(Date dateStart, Date dateEnd) {
        String proceesingTime = null;
        if (dateEnd != null && dateStart != null) {
            long diffInMillies = dateEnd.getTime() - dateStart.getTime();

            Long seconds = timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);

            LocalTime lt = LocalTime.MIN.plusSeconds(seconds);

            DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
            proceesingTime = lt.format(f);

        }
        return proceesingTime;

    }
}
