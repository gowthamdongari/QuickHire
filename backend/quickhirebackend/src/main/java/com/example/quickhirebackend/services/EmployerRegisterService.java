package com.example.quickhirebackend.services;

import com.example.quickhirebackend.customExceptions.CustomDuplicateUsernameException;
import com.example.quickhirebackend.dao.UserProfileDao;
import com.example.quickhirebackend.dto.EmployerRegistrationRequest;
import com.example.quickhirebackend.model.EmployerRequest;
import com.example.quickhirebackend.model.UserProfile;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class EmployerRegisterService {

    private  final UserProfileDao userProfileDao;
    private  final  EmployerRequestService employerRequestService;

    public EmployerRegisterService(UserProfileDao userProfileDao, EmployerRequestService employerRequestService) {
        this.userProfileDao = userProfileDao;
        this.employerRequestService = employerRequestService;
    }

    public int newRegistration(EmployerRegistrationRequest employerRegistrationRequest) throws Exception {
         try{
            //creating an userprofile
             UserProfile employerProfile = new UserProfile();
             employerProfile.setAddress(employerRegistrationRequest.getAddress());
             employerProfile.setFirstname(employerRegistrationRequest.getFirstname());
             employerProfile.setLastname(employerRegistrationRequest.getLastname());
             employerProfile.setEmail(employerRegistrationRequest.getEmail());
             employerProfile.setPhone(employerRegistrationRequest.getPhone());
             employerProfile.setCity(employerRegistrationRequest.getCity());
             employerProfile.setState(employerRegistrationRequest.getState());
             employerProfile.setPincode(employerRegistrationRequest.getPincode());
             employerProfile.setUsername(employerRegistrationRequest.getUsername());
             UserProfile savedEmployerProfile = userProfileDao.CreateUser(employerProfile);

             //now creating employer requests form by linking with respective userprofile

             EmployerRequest employerRequest = new EmployerRequest();
             employerRequest.setRequestType(employerRegistrationRequest.getRequestType());
             employerRequest.setCompanyName(employerRegistrationRequest.getCompanyName());
             employerRequest.setProfId(savedEmployerProfile.getUserprofileid());

             return  employerRequestService.createEmployerRequest(employerRequest).getRequestId();


         }
         catch (CustomDuplicateUsernameException e){
             throw  new  CustomDuplicateUsernameException(e.getMessage());
         }
         catch (Exception e){
             throw  new Exception(e.getMessage());
         }
    }

    public String DeleteRequest(Integer userProfileId) throws Exception {
        try{
            EmployerRequest employerRequest = employerRequestService.getEmployerRequestByUserProfileId(userProfileId).stream().findFirst().orElse(null);
            if(employerRequest!=null){
              employerRequest.setRequestType("Delete Requested");
              employerRequestService.updateEmployerRequest(employerRequest);
              return "Delete Requested Successfully!";
            }
            else {
                throw new CustomDuplicateUsernameException("Request failed!");
            }
        }
        catch (Exception e){
             throw new Exception(e.getMessage());
        }
    }
}
