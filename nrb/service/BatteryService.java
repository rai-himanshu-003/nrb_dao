/*
 * Creation : 4 Mar 2022
 */
package com.inetpsa.nrb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.BatteryDto;

/**
 * The Interface BatteryService.
 */
@Service
public interface BatteryService {

    /**
     * Gets the battery list.
     *
     * @param batteryDto                the battery dto
     * @param offsetPositionToStartFrom the offset position to start from
     * @param rowsPerPage               the rows per page
     * @return the battery list
     */
    List<BatteryDto> getBatteryList(BatteryDto batteryDto, int offsetPositionToStartFrom, int rowsPerPage);

    /**
     * Gets the total battery records.
     *
     * @param batteryDto the battery dto
     * @return the total battery records
     */
    long getTotalBatteryRecords(BatteryDto batteryDto);
}
