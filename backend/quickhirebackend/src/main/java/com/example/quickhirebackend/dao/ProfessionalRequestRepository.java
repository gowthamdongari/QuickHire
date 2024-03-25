package com.example.quickhirebackend.dao;

import com.example.quickhirebackend.model.ProfessionalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRequestRepository extends JpaRepository<ProfessionalRequest,Integer> {
    //This will automatically have basic CRUD methods
}
