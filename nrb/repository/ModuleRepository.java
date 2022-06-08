package com.inetpsa.nrb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.Module;

/**
 * The Interface ModuleRepository.
 */
@Repository
public interface ModuleRepository extends CrudRepository<Module, Long> {

}
