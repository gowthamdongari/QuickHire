package com.example.quickhirebackend.services;

import com.example.quickhirebackend.dao.*;
import com.example.quickhirebackend.dto.ReviewRecord;
import com.example.quickhirebackend.model.*;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private final EmployerRequestRepository employerRequestRepository;
    private final EmployerDetailsRepository employerDetailsRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;
    private final ProfessionalRequestRepository professionalRequestRepository;
    private final ProfessionalDetailsRepository professionalDetailsRepository;
    private  final  LoginService loginService;
    private  final  EmailService emailService;

    public RequestService(EmployerRequestRepository employerRequestRepository, EmployerDetailsRepository employerDetailsRepository, UserProfileRepository userProfileRepository, UserRepository userRepository, ProfessionalRequestRepository professionalRequestRepository, ProfessionalDetailsRepository professionalDetailsRepository, LoginService loginService, EmailService emailService) {
        this.employerRequestRepository = employerRequestRepository;
        this.employerDetailsRepository = employerDetailsRepository;
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
        this.professionalRequestRepository = professionalRequestRepository;
        this.professionalDetailsRepository = professionalDetailsRepository;
        this.loginService = loginService;
        this.emailService = emailService;
    }

    public String employerRequest(ReviewRecord employerRequest) throws Exception {
        try{
       EmployerRequest employerRequestData = employerRequestRepository.findById(employerRequest.id()).stream().findFirst().orElse(null);
       UserProfile userProfile = userProfileRepository.findById(employerRequestData.getProfId()).stream().findFirst().orElse(null);
       if (employerRequest.requestType() == "Rejected"){
        return "";
       }else {
           // change request type
           assert employerRequestData != null;
           employerRequestData.setRequestType(employerRequest.requestType());
           employerRequestRepository.save(employerRequestData);

           //set company name
           EmployerDetails newEmloyerDetails = new EmployerDetails();
           newEmloyerDetails.setCompanyName(employerRequestData.getCompanyName());
           newEmloyerDetails.setProfId(employerRequestData.getProfId());
           employerDetailsRepository.save(newEmloyerDetails);

           // set status to active

           assert userProfile != null;
           userProfile.setStatus("Active");
           userProfileRepository.save(userProfile);

           // update user table
           createNewUser(employerRequestData.getProfId(),"Employer","Active",userProfile.getUsername(),userProfile.getEmail());

           return "Employer has been Succesfully Accepted";
       }}
        catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    public String professionalRequest(ReviewRecord professionalRequest) throws Exception {
        try{
            LoginService loginService = new LoginService();
           ProfessionalRequest professionalRequestData = professionalRequestRepository.findById(professionalRequest.id()).stream().findFirst().orElse(null);
           UserProfile userProfile = userProfileRepository.findById(professionalRequestData.getProfId()).stream().findFirst().orElse(new UserProfile());
        if (professionalRequest.requestType() == "Rejected"){
            return "";
        }else {
            // change the status
            professionalRequestData.setRequestType(professionalRequest.requestType());
            professionalRequestRepository.save(professionalRequestData);

            // set schoolname, major completiontime profid
            ProfessionalDetails professionalDetails = new ProfessionalDetails();
            professionalDetails.setSchoolName(professionalRequestData.getSchoolName());
            professionalDetails.setMajor(professionalRequestData.getMajor());
            professionalDetails.setCompletionTime(professionalRequestData.getCompletionTime());
            professionalDetails.setProfId(professionalRequestData.getProfId());
            professionalDetailsRepository.save(professionalDetails);

            // set status in user profile

            userProfile.setStatus("Active");
            userProfileRepository.save(userProfile);

            // create  username password usertype status profid ispasswordchanges
            createNewUser(userProfile.getUserprofileid(),"Professional","Active",userProfile.getUsername(),userProfile.getEmail());

            return "Professional account has been Created!";
        }
    }catch (Exception e){
        throw  new Exception(e.getMessage());
    }
    }

    public void createNewUser(Integer profId, String userType, String status, String userName, String email){
        User user = new User();
        user.setProfId(profId);
        user.setUserType(userType);
        user.setStatus(status);
        user.setIsPasswordChanged("No");
        user.setUsername(userName);
        String randomPassword = loginService.passwordGenerator();
        String hashedPassword = loginService.passwordHasher(randomPassword);
        user.setPassword(hashedPassword);
        userRepository.save(user);
        String subject = "QuickHire Account Accepted";
        String body="We are happy to share you that your account has been Activated, and this is your credentials  to login username:"+userName+"password:"+randomPassword+"/n"+"Best"+"/n"+"Team QuickHire";
        emailService.sendMail(email,subject,body);

    }

}
