/*
 * Creation : 22 Mar 2022
 */
package com.inetpsa.nrb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.BatteryHealthDataDto;
import com.inetpsa.nrb.dto.BatteryModuleHistoryDto;
import com.inetpsa.nrb.dto.ElectronicBatteryDataDto;
import com.inetpsa.nrb.dto.GeneralBatteryDataDto;
import com.inetpsa.nrb.dto.ModuleAndSubassemblyDto;

/**
 * The Interface BatteryDetailService.
 */
@Service
public interface BatteryDetailService {

    /**
     * Gets the general battery data.
     *
     * @param bin  the bin
     * @param lang the lang
     * @return the general battery data
     */
    List<GeneralBatteryDataDto> getGeneralBatteryData(String bin, String lang);

    /**
     * Gets the general battery history.
     *
     * @param bin the bin
     * @return the general battery history
     */
    List<GeneralBatteryDataDto> getGeneralBatteryHistory(String bin);

    /**
     * Gets the electronic battery data.
     *
     * @param bin the bin
     * @return the electronic battery data
     */
    List<ElectronicBatteryDataDto> getElectronicBatteryData(String bin);

    /**
     * Gets the battery health data.
     *
     * @param bin the bin
     * @return the battery health data
     */
    List<BatteryHealthDataDto> getBatteryHealthData(String bin);

    /**
     * Gets the battery module and assembly data.
     *
     * @param bin           the bin
     * @param componentType the component type
     * @return the battery module and assembly data
     */
    List<ModuleAndSubassemblyDto> getBatteryModuleAndAssemblyData(String bin, String[] componentType);

    /**
     * Find total records.
     *
     * @return the long
     */
    long findTotalRecords();

    /**
     * Gets the battery module history data.
     *
     * @param bin           the bin
     * @param componentType the component type
     * @return the battery module history data
     */
    List<BatteryModuleHistoryDto> getBatteryModuleHistoryData(String bin, String[] componentType);

    /**
     * Gets the electronic battery history data.
     *
     * @param bin the bin
     * @return the electronic battery history data
     */
    List<ElectronicBatteryDataDto> getElectronicBatteryHistoryData(String bin);

    /**
     * Gets the battery health history data.
     *
     * @param bin the bin
     * @return the battery health history data
     */
    List<BatteryHealthDataDto> getBatteryHealthHistoryData(String bin);

}
