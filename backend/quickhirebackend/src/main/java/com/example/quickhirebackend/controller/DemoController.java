package com.example.quickhirebackend.controller;

import com.example.quickhirebackend.dao.ProfessionalDao;
import com.example.quickhirebackend.dao.ProfessionalRequestDao;
import com.example.quickhirebackend.dao.UserProfileDao;
import com.example.quickhirebackend.model.*;
import com.example.quickhirebackend.services.EmployerRequestService;
import com.example.quickhirebackend.services.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DemoController {
    private final ProfessionalDao professionalDao;
    private  final UserProfileDao userProfileDao;
    private  final QualificationService qualificationService;
    private  final ProfessionalRequestDao professionalRequestDao;

    private  final  EmployerRequestService employerRequestService;
    @Autowired
    public DemoController(ProfessionalDao professionalDao, UserProfileDao userProfileDao, QualificationService qualificationService, ProfessionalRequestDao professionalRequestDao, EmployerRequestService employerRequestService) {
        this.professionalDao = professionalDao;
        this.userProfileDao = userProfileDao;
        this.qualificationService = qualificationService;
        this.professionalRequestDao = professionalRequestDao;
        this.employerRequestService = employerRequestService;
    }
    @GetMapping("/1")
    public String demo1(){

         UserProfile profUserprofile = new UserProfile();
         profUserprofile.setAddress("Mcfarlin 349");
         profUserprofile.setFirstname("Ram");
         profUserprofile.setLastname("Aruva");
         profUserprofile.setEmail("ram@gmail.com");
         profUserprofile.setPhone("9900900090");
         profUserprofile.setCity("Dallas");
         profUserprofile.setState("Texas");
         profUserprofile.setPincode("3244555");
         profUserprofile.setUsername("ram"+new Date().getTime());
         UserProfile savedProfuserprofile= userProfileDao.CreateUser(profUserprofile);

        Qualification profqualification = new Qualification();
        profqualification.setProfId(profUserprofile.getUserprofileid());
        profqualification.setType("skills");
        profqualification.setKeywords("java");
       // profqualification.setJobId(0);
        qualificationService.createQualification(profqualification);

        ProfessionalRequest professionalRequest = new ProfessionalRequest();

        professionalRequest.setCompletionTime(new Date());
        professionalRequest.setRequestType("new account");
        professionalRequest.setMajor("Grad");
        professionalRequest.setSchoolName("Smu");
        professionalRequest.setProfId(savedProfuserprofile.getUserprofileid());
      //professionalRequestDao.createProfessionalRequest(professionalRequest);

       return savedProfuserprofile.toString()+ professionalRequestDao.createProfessionalRequest(professionalRequest).toString();
        //Userprof dem;

    }

    @GetMapping("/2")
    public String demo2(){

        UserProfile empProfile = new UserProfile();
        empProfile.setAddress("Mcfarlin 349");
        empProfile.setFirstname("Ram");
        empProfile.setLastname("Aruva");
        empProfile.setEmail("ram@gmail.com");
        empProfile.setPhone("9900900090");
        empProfile.setCity("Dallas");
        empProfile.setState("Texas");
        empProfile.setPincode("3244555");
        empProfile.setUsername("ram"+new Date().getTime());
        UserProfile savedProfuserprofile= userProfileDao.CreateUser(empProfile);

        EmployerRequest inEmployerRequest = new EmployerRequest();
         inEmployerRequest.setRequestType("new Account");
         inEmployerRequest.setCompanyName("google");
         inEmployerRequest.setProfId(savedProfuserprofile.getUserprofileid());

        employerRequestService.createEmployerRequest(inEmployerRequest);

       return  savedProfuserprofile.toString();
        //Userprof dem;

    }

    public String demo15(){
      //retrieve the profesiional request
       ProfessionalRequest profreqdetails = professionalRequestDao.getProfessionalRequestById(2).stream().findFirst().orElse(null);
       profreqdetails.setRequestType("account accepted");
       professionalRequestDao.updateProfessionalRequest(profreqdetails);
       UserProfile userProfile = userProfileDao.getUserById(profreqdetails.getProfId()).stream().findFirst().orElse(null);
       userProfile.setStatus("active");
       userProfileDao.updateUser(userProfile);

        ProfessionalDetails profdetails = new ProfessionalDetails();
        profdetails.setProfId(userProfile.getUserprofileid());
        profdetails.setCompletionTime(profreqdetails.getCompletionTime());

       return  "";
    }


}
