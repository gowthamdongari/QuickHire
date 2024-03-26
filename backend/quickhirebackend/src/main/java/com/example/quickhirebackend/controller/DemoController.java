package com.example.quickhirebackend.controller;

import com.example.quickhirebackend.dao.ProfessionalDao;
import com.example.quickhirebackend.dao.ProfessionalRequestDao;
import com.example.quickhirebackend.dao.UserProfileDao;
import com.example.quickhirebackend.dto.EmployerRegistrationRequest;
import com.example.quickhirebackend.dto.JobPostRequest;
import com.example.quickhirebackend.dto.ProfessionalRegistrationRequest;
import com.example.quickhirebackend.model.*;
import com.example.quickhirebackend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
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

    private final JobDescriptionService jobDescriptionService;

    private  final UserService userService;

    private final MatchService matchService;
    @Autowired
    public DemoController(ProfessionalDao professionalDao, UserProfileDao userProfileDao, QualificationService qualificationService, ProfessionalRequestDao professionalRequestDao, EmployerRequestService employerRequestService, ProfessionalDetailsService professionalDetailsService, EmployerDetailsService employerDetailsService, JobDescriptionService jobDescriptionService, UserService userService, MatchService matchService) {
        this.professionalDao = professionalDao;
        this.userProfileDao = userProfileDao;
        this.qualificationService = qualificationService;
        this.professionalRequestDao = professionalRequestDao;
        this.employerRequestService = employerRequestService;
        this.professionalDetailsService = professionalDetailsService;
        this.employerDetailsService = employerDetailsService;
        this.jobDescriptionService = jobDescriptionService;
        this.userService = userService;
        this.matchService = matchService;
    }
    @PostMapping("/registerProfessional")
    public ResponseEntity<String> registerProfessional(@RequestBody ProfessionalRegistrationRequest request) {
        // Extract user profile information from the request
        UserProfile userProfile = new UserProfile();
        userProfile.setAddress(request.getAddress());
        userProfile.setFirstname(request.getFirstname());
        userProfile.setLastname(request.getLastname());
        userProfile.setEmail(request.getEmail());
        userProfile.setPhone(request.getPhone());
        userProfile.setCity(request.getCity());
        userProfile.setState(request.getState());
        userProfile.setPincode(request.getPincode());
        userProfile.setUsername(request.getUsername());
        UserProfile savedUserProfile = userProfileDao.CreateUser(userProfile);

        // Extract qualification information from the request
        Qualification qualification = new Qualification();
        qualification.setProfId(savedUserProfile.getUserprofileid());
        qualification.setType(request.getQualificationType());
        qualification.setKeywords(request.getQualificationKeywords());
        qualificationService.createQualification(qualification);

        // Create a professional request
        ProfessionalRequest professionalRequest = new ProfessionalRequest();
        professionalRequest.setCompletionTime(new Date()); // Consider allowing this to be set via the request as well
        professionalRequest.setRequestType(request.getRequestType());
        professionalRequest.setMajor(request.getMajor());
        professionalRequest.setSchoolName(request.getSchoolName());
        professionalRequest.setProfId(savedUserProfile.getUserprofileid());
        professionalRequestDao.createProfessionalRequest(professionalRequest);

        return ResponseEntity.ok("Professional registered successfully: " + savedUserProfile.toString());
    }

    @PostMapping("/registerEmployer")
    public ResponseEntity<String> registerEmployer(@RequestBody EmployerRegistrationRequest request) {
        // Extract UserProfile information and create it
        UserProfile userProfile = new UserProfile();
        userProfile.setAddress(request.getAddress());
        userProfile.setFirstname(request.getFirstname());
        userProfile.setLastname(request.getLastname());
        userProfile.setEmail(request.getEmail());
        userProfile.setPhone(request.getPhone());
        userProfile.setCity(request.getCity());
        userProfile.setState(request.getState());
        userProfile.setPincode(request.getPincode());
        userProfile.setUsername(request.getUsername() + new Date().getTime()); // Ensuring unique username
        UserProfile savedUserProfile = userProfileDao.CreateUser(userProfile);

        // Create EmployerRequest with the saved UserProfile ID
        EmployerRequest employerRequest = new EmployerRequest();
        employerRequest.setRequestType(request.getRequestType());
        employerRequest.setCompanyName(request.getCompanyName());
        employerRequest.setProfId(savedUserProfile.getUserprofileid());
        employerRequestService.createEmployerRequest(employerRequest);

        // Assuming successful creation
        return ResponseEntity.ok("Employer registered successfully." + savedUserProfile.toString());
    }
//    @PostMapping("/updateProfessionalProfile")
//    public ResponseEntity<String> updateProfessionalProfile(@RequestBody ProfessionalRegistrationRequest request) {
//        // Assume you have methods in your services to find and update the profile and related entities
//        UserProfile userProfile = userProfileDao.getUserById(request.getUserProfileId()).orElse(null);
//        professionalDetailsService.dlldld(request.getUsername());
//        if (userProfile == null) {
//            return ResponseEntity.badRequest().body("User profile not found.");
//        }
//
//        // Update fields except username
//        userProfile.setAddress(request.getAddress());
//        userProfile.setFirstname(request.getFirstname());
//        userProfile.setLastname(request.getLastname());
//        userProfile.setEmail(request.getEmail());
//        userProfile.setPhone(request.getPhone());
//        userProfile.setCity(request.getCity());
//        userProfile.setState(request.getState());
//        userProfile.setPincode(request.getPincode());
//        UserProfile savedUserProfile =userProfileDao.updateUser(userProfile); // Assuming an update method exists
//
//        // Update Qualification
//        Qualification qualification = qualificationService.findByProfId(userProfile.getUserprofileid());
//        if (qualification != null) {
//            qualification.setType(request.getQualificationType());
//            qualification.setKeywords(request.getQualificationKeywords());
//            qualificationService.update(qualification); // Assuming an update method exists
//        } else {
//            return ResponseEntity.badRequest().body("Qualification not found.");
//        }
//
//        // Update ProfessionalRequest
//        ProfessionalRequest professionalRequest = professionalRequestDao.findByProfId(userProfile.getUserprofileid());
//        if (professionalRequest != null) {
//            professionalRequest.setRequestType(request.getRequestType());
//            professionalRequest.setMajor(request.getMajor());
//            professionalRequest.setSchoolName(request.getSchoolName());
//            professionalRequest.setCompletionTime(request.getCompletionTime()); // Update this as per the new field
//            professionalRequestDao.update(professionalRequest); // Assuming an update method exists
//        } else {
//            return ResponseEntity.badRequest().body("Professional request not found.");
//        }
//
//        return ResponseEntity.ok("Profile updated successfully." + savedUserProfile.toString());
//    }

    @GetMapping("/4")
    public  String  demo4(){
        //retrieve the emp details
        EmployerDetails employerDetails = employerDetailsService.getEmployerDetailsById(1).stream().findFirst().orElse(null);

        employerDetails.setCompanyName("Google");
        employerDetailsService.updateEmployerDetails(employerDetails.getEmployerId(),employerDetails);
        return "Emp details updated successfully";
    }

    @GetMapping("/5")
    public String demo5(){
        Matches MatchData = new Matches();
        MatchData.setMatchPercentage("70%");
        MatchData.setProfessionalId(1);
        MatchData.setJobId(1);

       Matches savedmatch = matchService.saveMatch(MatchData);

        return savedmatch.toString();
    }

    @PostMapping("/postJob")
    public String postJob(@RequestBody JobPostRequest jobRequest){
        JobDescription empPostJob = new JobDescription();
        empPostJob.setJobId(jobRequest.getJobId());
        empPostJob.setPositionName(jobRequest.getPositionName());
        empPostJob.setFirstname(jobRequest.getFirstname());
        empPostJob.setLastname(jobRequest.getLastname());
        empPostJob.setEmail(jobRequest.getEmail());
        empPostJob.setPhone(jobRequest.getPhone());
        empPostJob.setStartDate(jobRequest.getStartDate());
        empPostJob.setEndDate(jobRequest.getEndDate());
        empPostJob.setPayPerHour(jobRequest.getPayPerHour());
        empPostJob.setStartTime(jobRequest.getStartTime());
        empPostJob.setEndTime(jobRequest.getEndTime());
        empPostJob.setEmpid(jobRequest.getEmpid());

        JobDescription savedJob = jobDescriptionService.createJobDescription(empPostJob);

        Qualification qualification = new Qualification();
        qualification.setType(jobRequest.getQualificationType());
        qualification.setKeywords(jobRequest.getQualificationKeywords());
        qualification.setJobId(savedJob.getJobdescriptionId()); // Assuming getJobdescriptionId() returns the identifier of the job

        qualificationService.createQualification(qualification);

        return savedJob.toString(); // It's better to return a structured object
    }


    @PostMapping("/staffEmployerApproval/{employerRequestId}")
    public  ResponseEntity<String> demo15(@PathVariable("employerRequestId") int employerRequestId){
        //retrieve the emp request
        EmployerRequest employerRequestedData = employerRequestService.getEmployerRequestById(employerRequestId).stream().findFirst().orElse(null);
        assert employerRequestedData != null;
        employerRequestedData.setRequestType("account accepted");
        EmployerRequest updatedEmployerRequest = employerRequestService.updateEmployerRequest(employerRequestedData);
        UserProfile employerUserprofile = userProfileDao.getUserById(updatedEmployerRequest.getProfId()).stream().findFirst().orElse(null);
        assert employerUserprofile != null;
        employerUserprofile.setStatus("active");
        userProfileDao.updateUser(employerUserprofile);

        EmployerDetails newemployerDetails = new EmployerDetails();
        newemployerDetails.setCompanyName(updatedEmployerRequest.getCompanyName());
        newemployerDetails.setProfId(employerUserprofile.getUserprofileid());
        EmployerDetails savedemployerdetails =employerDetailsService.createEmployerDetails(newemployerDetails);
        User employerNewUser = new User();
        employerNewUser.setUsername(employerUserprofile.getUsername());
        employerNewUser.setPassword("ahja7&aaa");
        employerNewUser.setProfId(employerUserprofile.getUserprofileid());
        employerNewUser.setUserType("employer");
        employerNewUser.setStatus("active");
        employerNewUser.setIsPasswordChanged("no");
        userService.saveUser(employerNewUser);


        return ResponseEntity.ok("Employer as been added to users"+savedemployerdetails.toString());
    }

    @PostMapping("/professionalApproval/{professionalRequestId}")
    public ResponseEntity<String> demo16(@PathVariable("professionalRequestId") int professionalRequestId){
        //retrieve the profesiional request
        ProfessionalRequest professionalRequestDetails = professionalRequestDao.getProfessionalRequestById(professionalRequestId).stream().findFirst().orElse(null);
        assert professionalRequestDetails != null;
        professionalRequestDetails.setRequestType("account accepted");
        professionalRequestDao.updateProfessionalRequest(professionalRequestDetails);
        UserProfile userProfile = userProfileDao.getUserById(professionalRequestDetails.getProfId()).stream().findFirst().orElse(null);
        assert userProfile != null;
        userProfile.setStatus("active");
        userProfileDao.updateUser(userProfile);

        ProfessionalDetails professionalDetails = new ProfessionalDetails();
        professionalDetails.setProfId(userProfile.getUserprofileid());
        professionalDetails.setCompletionTime(professionalRequestDetails.getCompletionTime());
        professionalDetails.setMajor(professionalRequestDetails.getMajor());
        professionalDetails.setSchoolName(professionalRequestDetails.getSchoolName());
        ProfessionalDetails savedProfessionalDetails = professionalDetailsService.createProfessionalDetails(professionalDetails);

        User professionalNewUser = new User();
        professionalNewUser.setUsername(userProfile.getUsername());
        professionalNewUser.setPassword("ahja7&aaa");
        professionalNewUser.setProfId(userProfile.getUserprofileid());
        professionalNewUser.setUserType("professional");
        professionalNewUser.setStatus("active");
        professionalNewUser.setIsPasswordChanged("no");
        userService.saveUser(professionalNewUser);

        return  ResponseEntity.ok("Professional Details saved"+savedProfessionalDetails.toString());
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
