package com.example.quickhirebackend.dao;

import com.example.quickhirebackend.dto.UserActiveInfo;
import com.example.quickhirebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Define custom query methods if needed
    User findByPassword(String password);

   @Query("SELECT u.password FROM User u WHERE u.username = :username")
    String findPasswordByUsername(@Param("username") String username);

   @Query("SELECT new com.example.quickhirebackend.dto.UserActiveInfo("+"u.username,u.usertype,u.status,u.profid,u.ispasswordchanged)"+"FROM User u WHERE u.username = :username AND u.status = 'active'")
    Optional<UserActiveInfo> findActiveUserWithoutPassword(@Param("username") String username);

   @Transactional
   @Modifying
   @Query("UPDATE User u SET u.password = :password WHERE u.username = :username")
   int updatePasswordByUsername(@Param("username") String username, @Param("password") String password);
}

