package com.example.kr.repositories;

import com.example.kr.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserRep extends JpaRepository<UserEntity, Integer> {
    @Query(value = "SELECT userId AS user_id, authToken as auth_token, userName as user_name, positionOnStarship as position_on_starship, age,sex,balance,background, publicBackground as public_background, photo, securityBackground as security_background, medicalBackground as medical_background, psychologyBackground as psychology_background,lastAvailable as last_available,  userSettings as user_settings FROM users", nativeQuery = true)
    List<UserEntity> findAllUsers();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (userId, authToken,userName, positionOnStarship, age, sex, balance, background, publicBackground, photo, securityBackground, medicalBackground, psychologyBackground, lastAvailable, userSettings) VALUES (:#{#user.id}, :#{#user.authToken},:#{#user.userName}, :#{#user.positionOnStarship}, :#{#user.age}, :#{#user.sex}, :#{#user.balance}, :#{#user.background}, :#{#user.publicBackground}, :#{#user.photo}, :#{#user.securityBackground}, :#{#user.medicalBackground}, :#{#user.psychologyBackground}, :#{#user.lastAvailable}, :#{#user.userSettings})", nativeQuery = true)
    void addUser(@RequestBody UserEntity user);
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM users WHERE userId = :userId", nativeQuery = true)
    void findByUserId(@Param("userId") int userId);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE  userId = :userId", nativeQuery = true)
    void deleteUserById(@Param("userId") Long userId);
    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET authToken = :authToken, userName = :userName, positionOnStarship = :positionOnStarship, age = :age, sex = :sex, balance = :balance, background = :background, publicBackground = :publicBackground, photo = :photo, securityBackground = :securityBackground, medicalBackground = :medicalBackground, psychologyBackground = :psychologyBackground, lastAvailable = :lastAvailable, userSettings = :userSettings WHERE userId = :userId", nativeQuery = true)
    void updateUserById(@Param("userId") Long userId,
                        @Param("authToken") String authToken,
                        @Param("userName") String userName,
                        @Param("positionOnStarship") String positionOnStarship,
                        @Param("age") Integer age,
                        @Param("sex") String sex,
                        @Param("balance") Integer balance,
                        @Param("background") String background,
                        @Param("publicBackground") String publicBackground,
                        @Param("photo") String photo,
                        @Param("securityBackground") String securityBackground,
                        @Param("medicalBackground") String medicalBackground,
                        @Param("psychologyBackground") String psychologyBackground,
                        @Param("lastAvailable") Integer lastAvailable,
                        @Param("userSettings") Integer userSettings);
}
