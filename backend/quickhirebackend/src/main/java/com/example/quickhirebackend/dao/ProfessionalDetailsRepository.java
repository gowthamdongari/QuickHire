package com.example.quickhirebackend.dao;

import com.example.quickhirebackend.model.ProfessionalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalDetailsRepository  extends JpaRepository<ProfessionalDetails,Integer> {

}
