package com.inetpsa.nrb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.MassMvtLine;

/**
 * The Interface MMLineRepository.
 */
@Repository
public interface MMLineRepository extends CrudRepository<MassMvtLine, Long> {

}
