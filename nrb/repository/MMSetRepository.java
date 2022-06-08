package com.inetpsa.nrb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.MassMvtSet;

/**
 * The Interface MMSetRepository.
 */
@Repository
public interface MMSetRepository extends CrudRepository<MassMvtSet, String> {

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
     */
    Optional<MassMvtSet> findById(String id);

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.data.repository.CrudRepository#findAll()
     */
    List<MassMvtSet> findAll();

}
