
package com.inetpsa.nrb.service;

import org.springframework.stereotype.Service;

import com.inetpsa.nrb.dto.ResponseDto;
import com.inetpsa.nrb.dto.UserInformationDto;

/**
 * The Interface UserInfoService.
 */
@Service
public interface UserInfoService {

    /**
     * Gets the user data by type.
     *
     * @param userId the user id
     * @param type   the type
     * @param lang   the lang
     * @return the user data by type
     */
    UserInformationDto getUserDataByType(String userId, String type, String lang);

    /**
     * Update user info.
     *
     * @param userInformationDTO the user information DTO
     * @return true, if successful
     */
    ResponseDto updateUserInfo(UserInformationDto userInformationDTO);

}
