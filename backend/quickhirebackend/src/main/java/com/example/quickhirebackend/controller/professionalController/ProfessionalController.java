package com.example.quickhirebackend.controller.professionalController;

import com.example.quickhirebackend.customExceptions.CustomDuplicateUsernameException;
import com.example.quickhirebackend.customExceptions.CustomMatchException;
import com.example.quickhirebackend.dto.JobMatchRequestRecord;
import com.example.quickhirebackend.dto.ProfessionalRegistrationRequest;
import com.example.quickhirebackend.services.MatchService;
import com.example.quickhirebackend.services.ProfessionalRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessionalController {

     private  final ProfessionalRegisterService professionalRegisterService;
     private  final MatchService matchService;

    public ProfessionalController(ProfessionalRegisterService professionalRegisterService, MatchService matchService) {
        this.professionalRegisterService = professionalRegisterService;
        this.matchService = matchService;
    }

    @PostMapping("/professionalRegister")
    public ResponseEntity<?> professionalRegister(@RequestBody ProfessionalRegistrationRequest registrationData){
        try{
            int profReqId = professionalRegisterService.newProfessionalRegister(registrationData);
            return new ResponseEntity<>("Registration is successfully done! and request id is "+profReqId, HttpStatus.OK);
        }
        catch (CustomDuplicateUsernameException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error occurred while Employer register"+e.getMessage());
        }
    }

    @PostMapping("/professionalJobMatchRequest")
    public  ResponseEntity<?> professionalJobMatch(@RequestBody JobMatchRequestRecord jobMatchData){
        try{
            JobMatchRequestRecord jobMatch = matchService.professionalJobMatch(jobMatchData);
            return new ResponseEntity<>(jobMatch,HttpStatus.OK);
        } catch(CustomMatchException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error occurred while Match Register"+e.getMessage());
        }
    }
}
