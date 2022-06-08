package com.inetpsa.nrb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.HistoryEntity;

/**
 * The Interface OrganeRepository.
 */
@Repository
public interface HistoryRepository extends CrudRepository<HistoryEntity, Long> {

}
