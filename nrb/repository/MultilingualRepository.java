/*
 * Creation : 31 Jan 2022
 */
package com.inetpsa.nrb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.TranslationEntity;

/**
 * The Interface MultilingualRepository.
 */
@Repository
public interface MultilingualRepository extends JpaRepository<TranslationEntity, String> {

    /**
     * Gets the by lang.
     *
     * @param lang the lang
     * @return the by lang
     */
    @Query("select M from TranslationEntity M where translationEntityPk.idlang=:id_lang")
    List<TranslationEntity> getByLang(@Param("id_lang") String lang);

}
