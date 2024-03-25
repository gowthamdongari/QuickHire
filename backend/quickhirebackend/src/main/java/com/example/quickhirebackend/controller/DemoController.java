package com.example.quickhirebackend.controller;

import com.example.quickhirebackend.dao.ProfessionalDao;
import com.example.quickhirebackend.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DemoController {
    private final ProfessionalDao professionalDao;

    @Autowired
    public DemoController(ProfessionalDao professionalDao) {
        this.professionalDao = professionalDao;
    }
    @GetMapping("/1")
    public String demo1(){

        UserProfile sam = new UserProfile();
        sam.setAddress("1234 area");
        sam.setCity("dallas");
        sam.setEmail("ram@gmail.com");
        sam.setFirstname("ram");
        sam.setLastname("aruva");
        sam.setPhone("999909999");
        sam.setPincode("75205");
        sam.setState("Texas");
        sam.setStatus("new");
        sam.setUsername("ramaruva"+new Date());

        UserProfile gow = new UserProfile();


        return professionalDao.demo(sam).toString();
        //Userprof dem;

    }


}
