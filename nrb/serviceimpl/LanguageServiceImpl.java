package com.inetpsa.nrb.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetpsa.nrb.dto.LanguageTransDto;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.model.LanguageEntity;
import com.inetpsa.nrb.model.TranslationEntity;
import com.inetpsa.nrb.repository.LanguageRepository;
import com.inetpsa.nrb.repository.TranslationRepository;
import com.inetpsa.nrb.service.LanguageService;
import com.inetpsa.nrb.util.LanguageDataUtil;

/** The class LanguageServiceImpl */
@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

    private static final Logger logger = LoggerFactory.getLogger(LanguageServiceImpl.class);

    /** The Language repository. */
    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private TranslationRepository translationrepo;

    @Autowired
    private TranslationRepository translationRepository;

    /** The entity manager */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.LanguageService#getLanguageData()
     */
    @Override
    public List<LanguageTransDto> getLanguageData() {

        List<LanguageEntity> langEntity = languageRepository.getLanguageData();
        List<LanguageTransDto> dto = LanguageDataUtil.convertEntityListToDTOList(langEntity);
        Random random = new Random();

        for (LanguageTransDto dtoList : dto) {
            dtoList.setId(random.nextInt());
        }

        return dto;

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.LanguageService#deleteLanguageData(String)
     */
    @Override
    public ResponseDto deleteLanguageData(@Param("idLang") String lang) {
        logger.info("TranslationEntity delete part {}", lang);
        ResponseDto responseDto = new ResponseDto();
        try {
            // Optional<TranslationEntity> transEntity = translationrepo.findById(lang)
            Query query = entityManager.createQuery("delete from TranslationEntity T where translationEntityPk.idlang=:idLang");
            query.setParameter("idLang", lang);
            query.executeUpdate();
            logger.info("TranslationEntity deleted {}");

            Optional<LanguageEntity> langdel = languageRepository.findById(lang);
            if (langdel.isPresent()) {
                logger.info("TranslationEntity delete part {}", langdel);
                languageRepository.deleteById(lang);
                responseDto.setId(lang);
                responseDto.setMsg(true);
                responseDto.setMessage("Language Data deleted Successfully");
                logger.info("Language Data is deleted Successfully");
            }

        } catch (Exception e) {
            responseDto.setMsg(false);
            responseDto.setMessage("Data deleted Unsccessfully");
            logger.error("Language Data is deleted Unsccessfully {} ", e.getMessage());
        }

        return responseDto;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.LanguageService#updateLanguageData(String)
     */
    @Override
    public ResponseDto updateLanguageData(LanguageTransDto languageTransDto) {
        ResponseDto responseDto = new ResponseDto();
        logger.info("updated language data {}", languageTransDto);
        try {
            Optional<LanguageEntity> updatelang = languageRepository.findById(languageTransDto.getIdLang());
            if (updatelang.isPresent()) {
                logger.info("updated language data under if condition {} ", updatelang);
                LanguageEntity langEntity = languageTransDto.mapTomodel(updatelang.get());
                languageRepository.save(langEntity);
                responseDto.setId(languageTransDto.getIdLang());
                responseDto.setMsg(true);
                responseDto.setMessage(" Data updated Successfully");
                logger.info("Language Data is updated Successfully ");

            } else {
                LanguageEntity langEntity = languageTransDto.mapTomodel(new LanguageEntity());
                languageRepository.save(langEntity);
                String langId = languageTransDto.getIdLang();

                Query query = entityManager.createQuery(" FROM  TranslationEntity WHERE translationEntityPk.idlang = 'EN'");

                List<TranslationEntity> lists = (query.getResultList());

                translationrepo.saveAll(lists);

                logger.info("translation entity list to be added");

                responseDto.setMsg(true);
                responseDto.setMessage(" Data added Successfully");
            }

        } catch (Exception e) {
            responseDto.setMsg(false);
            responseDto.setMessage("Data is not updated");
            logger.error("Language Data is updated Unsccessfully {} ", e.getMessage());
        }
        return responseDto;
    }
}