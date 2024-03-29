package com.example.quickhirebackend.dao;

import com.example.quickhirebackend.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Integer> {
    // Additional query methods can be defined here
}

