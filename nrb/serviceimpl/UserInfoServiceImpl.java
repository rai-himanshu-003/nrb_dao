/*
 * Creation : 23 Feb 2022
 */
package com.inetpsa.nrb.serviceimpl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.dto.UserInformationDto;
import com.inetpsa.nrb.model.UserInfo;
import com.inetpsa.nrb.repository.UserInfoRepository;
import com.inetpsa.nrb.service.UserInfoService;

/**
 * The Class UserInfoServiceImpl.
 */
@Transactional
@Service
public class UserInfoServiceImpl implements UserInfoService {

    /** The Constant logger. */
    public static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    /** The user info repo. */
    @Autowired
    private UserInfoRepository userInfoRepo;

    /** The entity manager. */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.UserInfoService#getUserDataByType(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public UserInformationDto getUserDataByType(@Param("userId") String userId, @Param("type") String type, @Param("lang") String lang) {
        UserInformationDto userInformationDTO = null;
        Optional<UserInfo> userEntity = userInfoRepo.getUserInfo(userId, type);
        try {
            if (userEntity.isPresent()) {
                userInformationDTO = userEntity.get().maptoDto();
            } else {
                userInformationDTO = new UserInformationDto();
                userInformationDTO.setUserId(userId);
                userInformationDTO.setValue(lang);
                userInformationDTO.setType(type);
                userInformationDTO.setId(userInfoRepo.save(userInformationDTO.mapTomodel(new UserInfo())).getId());
            }
        } catch (Exception e) {
            logger.error("Data not found", e);
        }
        return userInformationDTO;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.inetpsa.nrb.service.UserInfoService#updateUserInfo(com.inetpsa.nrb.dto.UserInformationDto)
     */
    @Override
    public ResponseDto updateUserInfo(UserInformationDto userInformationDTO) {
        ResponseDto responseDto = new ResponseDto();
        try {
            if (userInformationDTO.getId() != null) {
                logger.info("update user under if condn");
                Optional<UserInfo> updateUser = userInfoRepo.findById(userInformationDTO.getId());
                UserInfo userInfoEntity = userInformationDTO.mapTomodel(updateUser.get());
                userInfoRepo.save(userInfoEntity);
                responseDto.setId(userInformationDTO.getUserId());
                responseDto.setMsg(true);
                responseDto.setMessage(" Data updated Successfully");
            } else {
                logger.info("update user under else condn");
                UserInfo userInfoEntity = userInformationDTO.mapTomodel(new UserInfo());
                userInfoRepo.save(userInfoEntity);
                responseDto.setId(userInformationDTO.getUserId());
                responseDto.setMsg(true);
                responseDto.setMessage(" Data added Successfully");
            }

        } catch (Exception e) {
            responseDto.setId(userInformationDTO.getUserId());
            responseDto.setMsg(false);
            responseDto.setMessage(" Data not updated/added successfully");
            logger.error(" Data not updated ", e);

        }
        return responseDto;

    }

}
