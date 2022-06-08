/*
 * Creation : 10 Feb 2022
 */
package com.inetpsa.nrb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetpsa.nrb.model.CodeTypeEntity;
import com.inetpsa.nrb.model.CodeTypeEntityPk;

/**
 * The Interface CodeTypeRepository.
 */
@Transactional
@Repository
public interface CodeTypeRepository extends JpaRepository<CodeTypeEntity, CodeTypeEntityPk> {
    @Query("select C from CodeTypeEntity C ORDER BY type_code, id_code")
    List<CodeTypeEntity> getCodeTypeData();

}
