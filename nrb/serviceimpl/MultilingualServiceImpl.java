/*
 * Creation : 31 Jan 2022

 */
package com.inetpsa.nrb.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.TranslationDto;
import com.inetpsa.nrb.model.TranslationEntity;
import com.inetpsa.nrb.repository.MultilingualRepository;
import com.inetpsa.nrb.service.MultilingualService;
import com.inetpsa.nrb.util.MultiLingualUtil;

/**
 * The Class MultilingualServiceImpl.
 */
@Service
public class MultilingualServiceImpl implements MultilingualService {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(MultilingualServiceImpl.class);
    /** The multilingual repository. */
    @Autowired
    private MultilingualRepository multilingualRepository;

    /** The entity manager. */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.MultilingualService#getMultilingualData(java.lang.String)
     */
    @Override
    public List<TranslationDto> getMultilingualData(@Param("id_lang") String lang) {
        logger.info("Language id {} ", lang);

        List<TranslationEntity> multiEntity = multilingualRepository.getByLang(lang);

        return MultiLingualUtil.convertEntityListToDTOList(multiEntity);
    }

}
