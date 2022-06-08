package com.inetpsa.nrb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.MassMvtFile;

/**
 * The Interface MMFileRepository.
 */
@Repository
public interface MMFileRepository extends CrudRepository<MassMvtFile, Long> {

    /**
     * Find by id.
     *
     * @param id the id
     * @return the mass mvt file
     */
    MassMvtFile findById(long id);

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.data.repository.CrudRepository#findAll()
     */
    List<MassMvtFile> findAll();
}
