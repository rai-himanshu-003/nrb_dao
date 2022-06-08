package com.inetpsa.nrb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.BmuEntity;

/**
 * The Interface OrganeRepository.
 */
@Repository
public interface BmuRepository extends CrudRepository<BmuEntity, Long> {

}
