package com.example.quickhirebackend.controller;

import com.example.quickhirebackend.dao.ProfessionalDao;
import com.example.quickhirebackend.dao.ProfessionalRequestDao;
import com.example.quickhirebackend.dao.UserProfileDao;
import com.example.quickhirebackend.dto.*;
import com.example.quickhirebackend.model.*;
import com.example.quickhirebackend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    private  final  PaymentService paymentService;

    private  final  StaffDetailsService staffDetailsService;
    @Autowired
    public DemoController(ProfessionalDao professionalDao, UserProfileDao userProfileDao, QualificationService qualificationService, ProfessionalRequestDao professionalRequestDao, EmployerRequestService employerRequestService, ProfessionalDetailsService professionalDetailsService, EmployerDetailsService employerDetailsService, JobDescriptionService jobDescriptionService, UserService userService, MatchService matchService, PaymentService paymentService, StaffDetailsService staffDetailsService) {
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
        this.paymentService = paymentService;
        this.staffDetailsService = staffDetailsService;
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
    @PostMapping("/updateProfessionalProfile")
    public ResponseEntity<String> updateProfessionalProfile(@RequestBody ProfessionalRegistrationRequest request) {
        // Assume you have methods in your services to find and update the profile and related entities
        UserProfile userProfile = userProfileDao.getUserById(request.getUserprofileid()).stream().findFirst().orElse(null);


        // Update fields except username
        assert userProfile != null;
        userProfile.setAddress(request.getAddress());
        userProfile.setFirstname(request.getFirstname());
        userProfile.setLastname(request.getLastname());
        userProfile.setEmail(request.getEmail());
        userProfile.setPhone(request.getPhone());
        userProfile.setCity(request.getCity());
        userProfile.setState(request.getState());
        userProfile.setPincode(request.getPincode());
        userProfile.setUserprofileid(request.getUserprofileid());
        UserProfile savedUserProfile =userProfileDao.updateUser(userProfile); // Assuming an update method exists

        // Update Qualification
        Qualification qualification = qualificationService.getQualificationByUserProfile(userProfile.getUserprofileid()).stream().findFirst().orElse(null);

        if (qualification != null) {
            qualification.setType(request.getQualificationType());
            qualification.setKeywords(request.getQualificationKeywords());
            qualification.setQualificationId(qualification.getQualificationId());
            qualificationService.updateQualification(qualification); // Assuming an update method exists
        } else {
            return ResponseEntity.badRequest().body("Qualification not found.");
        }

        // Update ProfessionalRequest
       ProfessionalDetails professionalDetails = professionalDetailsService.getProfessionalDetailsByUserProfileId(savedUserProfile.getUserprofileid()).stream().findFirst().orElse(null);

        if(professionalDetails==null){
            return ResponseEntity.badRequest().body("professionaldetails not found"+savedUserProfile.getUserprofileid());
        }
        professionalDetails.setSchoolName(request.getSchoolName());
        professionalDetails.setMajor(request.getMajor());
        professionalDetails.setProfessionalId(professionalDetails.getProfessionalId());
        professionalDetails.setCompletionTime(professionalDetails.getCompletionTime());
        professionalDetails.setProfId(savedUserProfile.getUserprofileid());

        professionalDetailsService.updateProfessionalDetails(professionalDetails);

        return ResponseEntity.ok("Profile updated successfully." + savedUserProfile.toString());
    }

    @GetMapping("/4")
    public  String  demo4(){
        //retrieve the emp details
        EmployerDetails employerDetails = employerDetailsService.getEmployerDetailsById(1).stream().findFirst().orElse(null);

        employerDetails.setCompanyName("Google");
        employerDetailsService.updateEmployerDetails(employerDetails.getEmployerId(),employerDetails);
        return "Emp details updated successfully";
    }

    @GetMapping("/jobMatchRequest")
    public ResponseEntity<String> demo5(@RequestParam("jobId") int jobId ,@RequestParam("professionalId") int professionalId){
        Matches MatchData = new Matches();
        MatchData.setMatchPercentage("70%");
        MatchData.setProfessionalId(professionalId);
        MatchData.setJobId(jobId);

       Matches savedMatch = matchService.saveMatch(MatchData);

        return ResponseEntity.ok("Saved job match"+savedMatch.toString());
    }

    @PostMapping("/payments")
    public ResponseEntity<String> processPayment(@RequestBody PaymentDTO paymentDTO) {
        Payments payment = new Payments();
        payment.setProfId(paymentDTO.getProfId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setStatus(paymentDTO.getStatus());
        payment.setStartDate(paymentDTO.getStartDate());
        payment.setEndDate(paymentDTO.getEndDate());

        Payments savedPayment;
        try {
            savedPayment = paymentService.createPayment(payment);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the payment: " + e.getMessage());
        }

        return ResponseEntity.ok("Payment saved successfully: " + savedPayment.toString());
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

    @PostMapping("/createStaff")
    public ResponseEntity<String> createStaffAccount(@RequestBody StaffAccountCreationDTO creationDTO) {
        UserProfile staffProfile = new UserProfile();
        staffProfile.setFirstname(creationDTO.getFirstname());
        staffProfile.setLastname(creationDTO.getLastname());
        staffProfile.setEmail(creationDTO.getEmail());
        staffProfile.setPhone(creationDTO.getPhone());
        staffProfile.setAddress(creationDTO.getAddress());
        staffProfile.setCity(creationDTO.getCity());
        staffProfile.setState(creationDTO.getState());
        staffProfile.setPincode(creationDTO.getPincode());
        staffProfile.setUsername(creationDTO.getUsername());
        UserProfile savedUserProfile = userProfileDao.CreateUser(staffProfile);

        StaffDetails staffDetails = new StaffDetails();
        staffDetails.setStaffUserProfileId(savedUserProfile.getUserprofileid());
       StaffDetails savedStaffDetails= staffDetailsService.saveStaffDetails(staffDetails);

        User staffUser = new User();
        staffUser.setUsername(savedUserProfile.getUsername());
        staffUser.setPassword(creationDTO.getPassword()); // Password should be encrypted
        staffUser.setUserType("STAFF");
        staffUser.setProfId(savedUserProfile.getUserprofileid());
        staffUser.setIsPasswordChanged("No");
        User savedUser = userService.saveUser(staffUser);

        // ... update the staff table with the userProfileId as before

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Staff account created successfully for: " + savedUser.getUsername()+savedStaffDetails.toString());
    }


}
