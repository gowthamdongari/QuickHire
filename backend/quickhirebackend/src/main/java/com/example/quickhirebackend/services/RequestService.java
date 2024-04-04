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
    public RequestService(EmployerRequestRepository employerRequestRepository, EmployerDetailsRepository employerDetailsRepository, UserProfileRepository userProfileRepository, UserRepository userRepository, ProfessionalRequestRepository professionalRequestRepository, ProfessionalDetailsRepository professionalDetailsRepository) {
        this.employerRequestRepository = employerRequestRepository;
        this.employerDetailsRepository = employerDetailsRepository;
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
        this.professionalRequestRepository = professionalRequestRepository;
        this.professionalDetailsRepository = professionalDetailsRepository;
    }

    public String employerRequest(ReviewRecord employerRequest) throws Exception {
        try{
       EmployerRequest employerRequestData = employerRequestRepository.findById(employerRequest.id()).stream().findFirst().orElse(null);
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
           UserProfile userProfile = userProfileRepository.findById(employerRequestData.getProfId()).stream().findFirst().orElse(null);
           assert userProfile != null;
           userProfile.setStatus("Active");
           userProfileRepository.save(userProfile);

           // update user table
           User user = new User();
           user.setProfId(employerRequestData.getProfId());
           user.setPassword("QuickHire1234");
           user.setUserType("Employer");
           user.setStatus("Active");
           user.setIsPasswordChanged("No");
           user.setUsername(userProfile.getUsername());
           userRepository.save(user);

           return "Employer has been Succesfully Accepted";
       }}
        catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    public String professionalRequest(ReviewRecord professionalRequest) throws Exception { try{
        ProfessionalRequest professionalRequestData = professionalRequestRepository.findById(professionalRequest.id()).stream().findFirst().orElse(null);
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
            UserProfile userProfile = userProfileRepository.findById(professionalRequestData.getProfId()).stream().findFirst().orElse(new UserProfile());
            userProfile.setStatus("Active");
            userProfileRepository.save(userProfile);

            // create  username password usertype status profid ispasswordchanges
            User user = new User();
            user.setUsername(userProfile.getUsername());
            user.setPassword("Quickhire1234");
            user.setStatus("Active");
            user.setUserType("Professional");
            user.setProfId(userProfile.getUserprofileid());
            user.setIsPasswordChanged("No");
            userRepository.save(user);

            return "Professional account has been Created!";
        }
    }catch (Exception e){
        throw  new Exception(e.getMessage());
    }
    }
}
