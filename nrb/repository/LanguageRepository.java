/*
 * Creation : 7 Feb 2022
 */
package com.inetpsa.nrb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetpsa.nrb.model.LanguageEntity;

/**
 * The Interface LanguageRespository.
 */
@Transactional
@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, String> {

    /**
     * Find language list.
     *
     * @return the list
     */
    @Query("Select L from LanguageEntity L")
    List<LanguageEntity> findLanguageList();

    /**
     * Gets the language data.
     *
     * @return the language data
     */
    /*
     * Gets the language data.
     *
     * @return the language data
     */
    @Query("select L from LanguageEntity L ORDER BY id_lang")
    List<LanguageEntity> getLanguageData();

    /**
     * Gets the id lang list.
     *
     * @return the id lang list
     */
    @Query("select L.idLang from LanguageEntity L ")
    List<LanguageEntity> getIdLangList();

}
