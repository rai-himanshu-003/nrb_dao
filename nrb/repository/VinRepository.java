package com.inetpsa.nrb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.Vin;

/**
 * The Interface VinRepository.
 */
@Repository
public interface VinRepository extends CrudRepository<Vin, Long> {

}
