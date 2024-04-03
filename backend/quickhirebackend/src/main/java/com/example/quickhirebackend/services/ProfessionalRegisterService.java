package com.example.quickhirebackend.services;

import com.example.quickhirebackend.customExceptions.CustomDuplicateUsernameException;
import com.example.quickhirebackend.dao.ProfessionalRequestRepository;
import com.example.quickhirebackend.dao.QualificationRepository;
import com.example.quickhirebackend.dao.UserProfileRepository;
import com.example.quickhirebackend.dto.ProfessionalRegistrationRequest;
import com.example.quickhirebackend.dto.QualificationRecord;
import com.example.quickhirebackend.model.ProfessionalRequest;
import com.example.quickhirebackend.model.Qualification;
import com.example.quickhirebackend.model.User;
import com.example.quickhirebackend.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalRegisterService {

    private  final UserProfileRepository userProfileRepository;
    private  final QualificationRepository qualificationRepository;
    private  final ProfessionalRequestRepository professionalRequestRepository;

    public ProfessionalRegisterService(UserProfileRepository userProfileRepository, QualificationRepository qualificationRepository, ProfessionalRequestRepository professionalRequestRepository) {
        this.userProfileRepository = userProfileRepository;
        this.qualificationRepository = qualificationRepository;
        this.professionalRequestRepository = professionalRequestRepository;
    }

    public int newProfessionalRegister(ProfessionalRegistrationRequest registrationRequest) throws Exception {
       try{
           // first need to create an userprofile
           UserProfile professionalUserProfile = new UserProfile();
           professionalUserProfile.setAddress(registrationRequest.getAddress());
           professionalUserProfile.setFirstname(registrationRequest.getFirstname());
           professionalUserProfile.setLastname(registrationRequest.getLastname());
           professionalUserProfile.setEmail(registrationRequest.getEmail());
           professionalUserProfile.setPhone(registrationRequest.getPhone());
           professionalUserProfile.setCity(registrationRequest.getCity());
           professionalUserProfile.setState(registrationRequest.getState());
           professionalUserProfile.setPincode(registrationRequest.getPincode());
           professionalUserProfile.setUsername(registrationRequest.getUsername());
            UserProfile savedUserProfile = userProfileRepository.save(professionalUserProfile);

           //create qualification table
           for(QualificationRecord qualificationRecord:registrationRequest.getQualifications()){
               Qualification qualification = new Qualification();
               qualification.setType(qualificationRecord.type());
               qualification.setKeywords(qualificationRecord.keywords());
               qualification.setProfId(savedUserProfile.getUserprofileid());
               qualificationRepository.save(qualification);
           }

           //creating professional request
           ProfessionalRequest professionalRequest = new ProfessionalRequest();
           professionalRequest.setRequestType(registrationRequest.getRequestType());
           professionalRequest.setMajor(registrationRequest.getMajor());
           professionalRequest.setSchoolName(registrationRequest.getSchoolName());
           professionalRequest.setProfId(savedUserProfile.getUserprofileid());
           professionalRequest.setCompletionTime(registrationRequest.getCompletiontime());

           return  professionalRequestRepository.save(professionalRequest).getRequestId();

       }
       catch (DataIntegrityViolationException e){
           throw  new CustomDuplicateUsernameException("Hey Professional This Username is already taken!");
       }
       catch (Exception e){
           throw  new Exception(e.getMessage());
       }
    }
}
