package com.example.quickhirebackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class LoginService {



    public String passwordHasher(String password){
       String salt= BCrypt.gensalt(12);
        return BCrypt.hashpw(password,salt);
    }

    public  boolean checkPassword(String password,String hashedPassword){
        return BCrypt.checkpw(password,hashedPassword);
    }



}



