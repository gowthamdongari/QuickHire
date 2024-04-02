package com.example.quickhirebackend.controller.employerController;

import com.example.quickhirebackend.customExceptions.CustomDuplicateUsernameException;
import com.example.quickhirebackend.dto.EmployerRegistrationRequest;
import com.example.quickhirebackend.services.EmployerRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployerController {

    private final EmployerRegisterService employerRegisterService;

    public EmployerController(EmployerRegisterService employerRegisterService) {
        this.employerRegisterService = employerRegisterService;
    }

    @PostMapping("/employerRegister")
    public ResponseEntity<?> employerRegister(@RequestBody EmployerRegistrationRequest employerRegistrationRequest){
        try{
            int profileID = employerRegisterService.newRegistration(employerRegistrationRequest);
            return new ResponseEntity<>("Registration is successfully done! and request id is "+profileID, HttpStatus.OK);
        }
        catch (CustomDuplicateUsernameException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error occurred while Employer register"+e.getMessage());
        }
    }
}
