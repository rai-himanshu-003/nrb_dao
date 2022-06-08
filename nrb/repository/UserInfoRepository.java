package com.inetpsa.nrb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inetpsa.nrb.model.UserInfo;

/**
 * The Interface TechnicalParameterRepository.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    /**
     * Gets the user info.
     *
     * @param userId the user id
     * @param type   the type
     * @return the user info
     */

    @Query("select U from UserInfo U where U.userId=:userId and U.type =:type")
    Optional<UserInfo> getUserInfo(@Param("userId") String userId, @Param("type") String type);

}
