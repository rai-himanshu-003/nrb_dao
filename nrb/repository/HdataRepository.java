package com.inetpsa.nrb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.HdataEntity;

/**
 * The Interface OrganeRepository.
 */
@Repository
public interface HdataRepository extends CrudRepository<HdataEntity, Long> {

}
