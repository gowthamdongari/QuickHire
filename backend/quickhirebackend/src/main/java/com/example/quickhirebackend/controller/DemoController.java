package com.example.quickhirebackend.controller;

import com.example.quickhirebackend.dao.ProfessionalDao;
import com.example.quickhirebackend.dao.ProfessionalRequestDao;
import com.example.quickhirebackend.dao.UserProfileDao;
import com.example.quickhirebackend.model.*;
import com.example.quickhirebackend.services.*;
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

    private  final ProfessionalDetailsService professionalDetailsService;

    private  final EmployerDetailsService employerDetailsService;



    private  final UserService userService;
    @Autowired
    public DemoController(ProfessionalDao professionalDao, UserProfileDao userProfileDao, QualificationService qualificationService, ProfessionalRequestDao professionalRequestDao, EmployerRequestService employerRequestService, ProfessionalDetailsService professionalDetailsService, EmployerDetailsService employerDetailsService, UserService userService) {
        this.professionalDao = professionalDao;
        this.userProfileDao = userProfileDao;
        this.qualificationService = qualificationService;
        this.professionalRequestDao = professionalRequestDao;
        this.employerRequestService = employerRequestService;
        this.professionalDetailsService = professionalDetailsService;
        this.employerDetailsService = employerDetailsService;
        this.userService = userService;
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

    @GetMapping("/3")

    public  String demo3(){
        //retieve the prof details
        ProfessionalDetails profdetails = professionalDetailsService.getProfessionalDetailsById(1).stream().findFirst().orElse(null);
        profdetails.setSchoolName("Harvard");
        professionalDetailsService.updateEmployerRequest(profdetails);
        return "udpated successfully";
    }

    @GetMapping("/4")
    public  String  demo4(){
        //retrieve the emp details
        EmployerDetails employerDetails = employerDetailsService.getEmployerDetailsById(1).stream().findFirst().orElse(null);

        employerDetails.setCompanyName("myseflf");
        employerDetailsService.updateEmployerDetails(employerDetails.getEmployerId(),employerDetails);
        return "Emp details updated successfully";
    }


    @GetMapping("/16")
    public String demo16(){
        //retrieve the profesiional request
        ProfessionalRequest profreqdetails = professionalRequestDao.getProfessionalRequestById(4).stream().findFirst().orElse(null);
        profreqdetails.setRequestType("account accepted");
        professionalRequestDao.updateProfessionalRequest(profreqdetails);
        UserProfile userProfile = userProfileDao.getUserById(profreqdetails.getProfId()).stream().findFirst().orElse(null);
        userProfile.setStatus("active");
        userProfileDao.updateUser(userProfile);

        ProfessionalDetails profdetails = new ProfessionalDetails();
        profdetails.setProfId(userProfile.getUserprofileid());
        profdetails.setCompletionTime(profreqdetails.getCompletionTime());
        profdetails.setMajor(profreqdetails.getMajor());
        profdetails.setSchoolName(profreqdetails.getSchoolName());
        professionalDetailsService.createProfessionalDetails(profdetails);

        User accpeted = new User();
        accpeted.setUsername(userProfile.getUsername());
        accpeted.setPassword("ahja7&aaa");
        accpeted.setProfId(userProfile.getUserprofileid());
        accpeted.setUserType("professional");
        accpeted.setStatus("active");
        accpeted.setIsPasswordChanged("no");
        userService.saveUser(accpeted);

        return  "saved succeffully";
    }
    @GetMapping("/15")
    public  String demo15(){
        //retrieve the emp request
        EmployerRequest empreq = employerRequestService.getEmployerRequestById(2).stream().findFirst().orElse(null);
        empreq.setRequestType("account accepted");
        EmployerRequest updatempreq = employerRequestService.updateEmployerRequest(empreq);
        UserProfile emuserprof = userProfileDao.getUserById(updatempreq.getProfId()).stream().findFirst().orElse(null);
        emuserprof.setStatus("active");
        userProfileDao.updateUser(emuserprof);

        EmployerDetails newempdetails = new EmployerDetails();
        newempdetails.setCompanyName(updatempreq.getCompanyName());
        newempdetails.setProfId(emuserprof.getUserprofileid());
        employerDetailsService.createEmployerDetails(newempdetails);
        User accpeted = new User();
        accpeted.setUsername(emuserprof.getUsername());
        accpeted.setPassword("ahja7&aaa");
        accpeted.setProfId(emuserprof.getUserprofileid());
        accpeted.setUserType("employer");
        accpeted.setStatus("active");
        accpeted.setIsPasswordChanged("no");
        userService.saveUser(accpeted);


        return "saved succeffully";
    }

    @GetMapping("/19")
    public String demo19(){

        UserProfile staffProfile = new UserProfile();
        staffProfile.setAddress("university Blvd");
        staffProfile.setFirstname("Staff");
        staffProfile.setLastname("Account");
        staffProfile.setEmail("staff@gmail.com");
        staffProfile.setPhone("9867543210");
        staffProfile.setCity("Dallas");
        staffProfile.setState("Texas");
        staffProfile.setPincode("75206");
        staffProfile.setUsername("staff"+new Date().getTime());
        UserProfile savedProfuserprofile= userProfileDao.CreateUser(staffProfile);

        User staffUser = new User();
        staffUser.setUsername(savedProfuserprofile.getUsername());
        staffUser.setPassword("Staff@77");
        staffUser.setUserType("staff");
        staffUser.setProfId(savedProfuserprofile.getUserprofileid());
        staffUser.setIsPasswordChanged("No");

        User savedStaffUser = userService.saveUser(staffUser);

        return  savedStaffUser.toString();
    }


}
