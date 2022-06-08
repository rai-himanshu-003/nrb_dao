/*
 * Creation : 6 Apr 2022
 */
package com.inetpsa.nrb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.MassMvtData;

/**
 * The Interface MMDataRepository
 */
@Repository
public interface MMDataRepository extends CrudRepository<MassMvtData, String> {

}
