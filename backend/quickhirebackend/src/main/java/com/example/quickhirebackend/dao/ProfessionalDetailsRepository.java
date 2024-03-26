package com.example.quickhirebackend.dao;

import com.example.quickhirebackend.model.ProfessionalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalDetailsRepository  extends JpaRepository<ProfessionalDetails,Integer> {
//  @Query("SELECT * FROM professionaldetails WHERE username=?")
//    ProfessionalDetails findbyUsername(String user);
}
