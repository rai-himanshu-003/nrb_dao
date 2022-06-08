/*
 * Creation : 21 Dec 2021
 */
package com.inetpsa.nrb.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.HealthDataDto;
import com.inetpsa.nrb.dto.MassMvtFileDto;
import com.inetpsa.nrb.dto.MassMvtLineDto;
import com.inetpsa.nrb.dto.MassMvtSetDto;
import com.inetpsa.nrb.dto.MassMvtValidationDto;
import com.inetpsa.nrb.model.MassMvtFile;
import com.inetpsa.nrb.model.MassMvtLine;

/**
 * The Interface MassMovementService.
 */
@Service
public interface MassMovementService {

    /**
     * Gets the settingby id.
     *
     * @param id the id
     * @return the settingby id
     */
    MassMvtSetDto getSettingbyId(String id);

    /**
     * Adds the update MM file.
     *
     * @param dto the dto
     * @return the mass mvt file
     */
    MassMvtFile addUpdateMMFile(MassMvtFile dto);

    /**
     * Adds the update MM line.
     *
     * @param mmLine the mm line
     */
    void addUpdateMMLine(List<MassMvtLine> mmLine);

    /**
     * Gets the MM line list.
     *
     * @param fileId the file id
     * @return the MM line list
     */
    List<MassMvtLineDto> getMMLineList(Long fileId);

    /**
     * Gets the all setting.
     *
     * @return the all setting
     */
    List<MassMvtSetDto> getAllSetting();

    /**
     * Gets the battery char list.
     *
     * @param idData the id data
     * @return the battery char list
     */
    MassMvtValidationDto getBatteryCharList(String idData);

    /**
     * Gets the mass movement file data.
     *
     * @param lang the lang
     * @return the mass movement file data
     */
    List<MassMvtFileDto> getMassMovementFileData(String lang);

    /**
     * Gets the MM line list by file id.
     *
     * @param fileId the file id
     * @param idLang the id lang
     * @return the MM line list by file id
     */
    List<MassMvtLineDto> getMMLineListByFileId(Long fileId, String idLang);

    /**
     * Gets the battery vehicle.
     *
     * @param idData the id data
     * @return the battery vehicle
     */
    MassMvtValidationDto getBatteryVehicle(String idData);

    /**
     * Gets the validated MM line list.
     *
     * @return the validated MM line list
     */
    List<MassMvtLineDto> getValidatedMMLineList();

    /**
     * Verify battery.
     *
     * @param idData the id data
     * @return the string
     */
    String verifyBattery(String idData);

    /**
     * Find module sub assembly.
     *
     * @param idData the id data
     * @return the list
     */
    List findModuleSubAssembly(String dataValue);

    /**
     * Purge MM data.
     *
     * @param purgedatadurationindays the purgedatadurationindays
     * @return the boolean
     */
    Boolean purgeMMData(Integer purgedatadurationindays);

    /**
     * Find module sub assembly mod assembled.
     *
     * @param idData the id data
     * @param dataValue the data value
     * @return the mass mvt validation dto
     */
    MassMvtValidationDto findModuleSubAssemblyModAssembled(String idData, String dataValue);

    /**
     * Gets the battery health data.
     *
     * @param idData the id data
     * @return the battery health data
     */
    HealthDataDto getBatteryHealthData(String idData);

    /**
     * Update MM line status.
     *
     * @param status the status
     * @return the int
     */
    int updateMMLineStatus(String status);

    /**
     * Find vin bin mapping.
     *
     * @param dataValue the data value
     * @return the string
     */
    String findVinBinMapping(String dataValue);

    /**
     * Find vin by organe.
     *
     * @param idData the id data
     * @return the string
     */
    String findVinByOrgane(String idData);

    /**
     * Find max size.
     *
     * @param tableName the table name
     * @return the map
     */
    Map<String, Integer> findMaxSize(List<String> tableName);

    /**
     * Gets the serial no count.
     *
     * @param idData the id data
     * @return the serial no count
     */
    Long getSerialNoCount(String idData);

}
