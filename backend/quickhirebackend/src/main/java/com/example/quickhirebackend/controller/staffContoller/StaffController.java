package com.example.quickhirebackend.controller.staffContoller;


import com.example.quickhirebackend.dto.ReviewRecord;
import com.example.quickhirebackend.services.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
    private final RequestService requestService;

    public StaffController(RequestService requestService) {
        this.requestService = requestService;
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
}
