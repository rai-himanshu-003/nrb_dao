/*
 * Creation : 7 Feb 2022
 */
package com.inetpsa.nrb.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.LanguageTransDto;
import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.dto.TranslationDto;
import com.inetpsa.nrb.model.LanguageEntity;
import com.inetpsa.nrb.model.TranslationEntity;
import com.inetpsa.nrb.model.TranslationEntityPk;
import com.inetpsa.nrb.repository.LanguageRepository;
import com.inetpsa.nrb.repository.TranslationRepository;
import com.inetpsa.nrb.service.TranslationService;

/**
 * The Class TranslationServiceImpl.
 */
@Service
public class TranslationServiceImpl implements TranslationService {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(TranslationServiceImpl.class);

    /** The translation repository. */
    @Autowired
    private TranslationRepository translationRepository;

    /** The language repository. */
    @Autowired
    private LanguageRepository languageRepository;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.TranslationService#getLanguageList()
     */
    public List<LanguageTransDto> getLanguageList() {
        logger.info("Entering getLanguageList of TranslationServiceImpl ");
        try {
            List<LanguageTransDto> list = new ArrayList<>();
            List<LanguageEntity> languageList = languageRepository.findLanguageList();
            if (!languageList.isEmpty()) {
                for (LanguageEntity languages : languageList) {
                    LanguageTransDto languageTransDto = new LanguageTransDto();
                    languageTransDto.setIdLang(languages.getIdLang());
                    languageTransDto.setDescr(languages.getDescr());
                    list.add(languageTransDto);
                }
            }
            return list;
        } catch (Exception e) {
            logger.error("Exception in fetching getLanguageList", e);

        }
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.TranslationService#getTranslationData(java.lang.String, java.lang.String[])
     */
    public List<TranslationDto> getTranslationData(String idlang, String[] typtrad) {
        logger.info("Entering getTranslationData of TranslationServiceImpl ");
        try {
            List<TranslationDto> list = new ArrayList<>();
            List<TranslationEntity> translationList = translationRepository.getTranslationData(idlang, typtrad);
            logger.info("translationList Find from database{}", translationList);
            Random random = new Random();
            logger.info("random data id{}", random);
            if (!translationList.isEmpty()) {
                for (TranslationEntity translation : translationList) {
                    logger.info("Entering translationEntiy forLoop");
                    TranslationDto translationDto = new TranslationDto();
                    translationDto.setTradId(translation.getTranslationEntityPk().getIdtrad());
                    translationDto.setLang(translation.getTranslationEntityPk().getIdlang());
                    translationDto.setLabel(translation.getLbltrad());
                    translationDto.setType(translation.getTyptrad());
                    list.add(translationDto);
                    logger.info("Exiting TranslationEntity forloop");

                }
                logger.info("list Data{}", list);
                logger.info("Exiting TranslationEntity after setting data to dto");
            }
            for (TranslationDto setTranslationId : list) {
                setTranslationId.setId(random.nextInt());
            }

            logger.info("Exit from getTranslationData");
            return list;

        } catch (Exception e) {
            logger.error("Exception in fetching getTranslationData", e);

        }
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.TranslationService#updateTranslationData(com.inetpsa.nrb.dto.TranslationDto)
     */
    public ResponseDto updateTranslationData(TranslationDto translationDto) {
        ResponseDto responseDto = new ResponseDto();
        logger.info("Entering updateTranslationData of TranslationServiceImpl ");
        try {
            if (translationDto.getTradId() != null) {
                Optional<TranslationEntity> translationEntity = translationRepository
                        .findById(new TranslationEntityPk(translationDto.getTradId(), translationDto.getLang()));
                TranslationEntity translationObj = translationDto.mapTomodel(translationEntity.get());
                translationRepository.save(translationObj);
                responseDto.setId(translationDto.getTradId());
                responseDto.setMsg(true);
                responseDto.setMessage(" Translation Data Updated successfully");

            }

        } catch (Exception e) {
            logger.error("Error occurred in update translation data {}", e.getMessage());
            responseDto.setMsg(false);
            responseDto.setMessage(" Translation Data Updated Unsuccessfully");

        }
        return responseDto;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.TranslationService#updateTranslationImport(com.inetpsa.nrb.dto.TranslationDto)
     */
    @Override
    public boolean updateTranslationImport(TranslationDto translationEntity) {
        boolean result = false;
        try {
            logger.info("Entering updateTranslationImport of TranslationServiceImpl ");
            if (translationEntity.getTradId() != null && translationEntity.getLang() != null && translationEntity.getLabel() != null
                    && translationEntity.getType() != null) {
                Optional<TranslationEntity> translationEntitydata = translationRepository.findById(translationEntity.getTradId(),
                        translationEntity.getLang(), translationEntity.getType());
                if (translationEntitydata.isPresent()) {
                    TranslationEntity translation = translationEntitydata.get();
                    translation.setLbltrad(translationEntity.getLabel());
                    translationRepository.save(translation);
                    result = true;
                }
            }
            return result;
        } catch (Exception e) {
            logger.error("Error occurred in update import translation data {}", e.getMessage());
        }
        return result;

    }

}