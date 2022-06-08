/*
 * Creation : 19 Apr 2022
 */
package com.inetpsa.nrb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.ModuleHistory;

/**
 * The Interface ModuleHistoryRepository.
 */
@Repository
public interface ModuleHistoryRepository extends CrudRepository<ModuleHistory, Long> {

}
