package com.inetpsa.nrb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.OrganeEntity;

/**
 * The Interface OrganeRepository.
 */

@Repository
public interface OrganeRepository extends CrudRepository<OrganeEntity, Long> {

}
