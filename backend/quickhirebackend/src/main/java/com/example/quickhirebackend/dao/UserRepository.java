package com.example.quickhirebackend.dao;

import com.example.quickhirebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Define custom query methods if needed
    User findByPassword(String password);
}

