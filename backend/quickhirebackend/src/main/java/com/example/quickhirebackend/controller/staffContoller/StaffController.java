package com.example.quickhirebackend.controller.staffContoller;


import com.example.quickhirebackend.customExceptions.CustomDuplicateUsernameException;
import com.example.quickhirebackend.dto.JobMatchRequestRecord;
import com.example.quickhirebackend.dto.ReviewRecord;
import com.example.quickhirebackend.dto.StaffAccountCreationDTO;
import com.example.quickhirebackend.services.MatchService;
import com.example.quickhirebackend.services.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
    private final RequestService requestService;
    private final MatchService matchService;

    public StaffController(RequestService requestService, MatchService matchService) {
        this.requestService = requestService;
        this.matchService = matchService;
    }

    @PostMapping("/employerRequestReview")
    public ResponseEntity<?> employerRequestReview(@RequestBody ReviewRecord employerRequest){
    try{
        String employerReviewMessage = requestService.employerRequest(employerRequest);
        return new ResponseEntity<>(employerReviewMessage, HttpStatus.OK);
    }
    catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error occurred while Accepting Employer Review Request"+e.getMessage());
    }
    }

    @PostMapping("/professionalRequestReview")
    public ResponseEntity<?> professionalRequestReview(@RequestBody ReviewRecord professionalRequest){
    try{
        String professionalReviewMessage = requestService.professionalRequest(professionalRequest);
        return new ResponseEntity<>(professionalReviewMessage, HttpStatus.OK);
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error occurred while Accepting Professional Review Request"+e.getMessage());
    }

    }

    record DeleteRequestID(Integer requestId){};
    @PutMapping("/professionalDeleteAccept")
    public ResponseEntity<?> professionalDeleteRequest(@RequestBody DeleteRequestID deleteID){
        try{
           return ResponseEntity.ok(requestService.professionalDeleteRequest(deleteID.requestId()));
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/employerDeleteAccept")
    public ResponseEntity<?> employerDeleteRequest(@RequestBody DeleteRequestID deleteId){
        try{
            return ResponseEntity.ok(requestService.employerDeleteRequest(deleteId.requestId()));
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @PostMapping("/staffJobMatch")
    public ResponseEntity<?> staffJobMatch(@RequestBody JobMatchRequestRecord jobMatchRequestRecord){
       try{
           JobMatchRequestRecord jobMatchResponse = matchService.professionalJobMatch(jobMatchRequestRecord);
           return  ResponseEntity.ok(jobMatchResponse);
       } catch (Exception e) {
           return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
       }
    }

    @PostMapping("/createStaff")
    public  ResponseEntity<?>  staffAccountCreation(@RequestBody StaffAccountCreationDTO staffAccountDetails){
        try{
            String msg = requestService.staffAccountCreation(staffAccountDetails);
            return  ResponseEntity.ok(msg);
        }
        catch (CustomDuplicateUsernameException e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
