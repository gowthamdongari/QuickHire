package com.example.quickhirebackend.dao;

import com.example.quickhirebackend.model.EmployerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDetailsRepository extends JpaRepository<EmployerDetails, Integer> {
    // Custom query methods can be added here if needed
}
