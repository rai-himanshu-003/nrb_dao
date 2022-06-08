/*
 * Creation : 7 Feb 2022
 */
package com.inetpsa.nrb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.inetpsa.nrb.model.TranslationEntity;
import com.inetpsa.nrb.model.TranslationEntityPk;

/**
 * The Interface TranslationRepository.
 */
public interface TranslationRepository extends CrudRepository<TranslationEntity, TranslationEntityPk> {

    /**
     * Gets the translation data.
     *
     * @param idlang  the idlang
     * @param typtrad the typtrad
     * @return the translation data
     */
    @Query("SELECT T FROM TranslationEntity T WHERE translationEntityPk.idlang=:id_lang AND typtrad IN :type_trad order by translationEntityPk.idtrad")
    List<TranslationEntity> getTranslationData(@Param("id_lang") String idlang, @Param("type_trad") String[] typtrad);

    /**
     * Find by id.
     *
     * @param idtrad  the idtrad
     * @param idlang  the idlang
     * @param typtrad the typtrad
     * @return the optional
     */
    @Query("SELECT T FROM TranslationEntity T where translationEntityPk.idlang=:idlang"
            + " and translationEntityPk.idtrad=:idtrad and typtrad=:typtrad")
    Optional<TranslationEntity> findById(@Param("idtrad") String idtrad, @Param("idlang") String idlang, @Param("typtrad") String typtrad);

}
