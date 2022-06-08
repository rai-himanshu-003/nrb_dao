/*
 * Creation : 11 Jan 2022
 */
package com.inetpsa.nrb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.AnomaliesEntity;

/**
 * The Interface AnomaliesRepository.
 */
@Repository
public interface AnomaliesRepository extends JpaRepository<AnomaliesEntity, Long> {

}
