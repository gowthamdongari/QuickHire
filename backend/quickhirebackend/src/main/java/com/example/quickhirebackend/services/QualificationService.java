package com.example.quickhirebackend.services;
import com.example.quickhirebackend.dao.QualificationRepository;
import com.example.quickhirebackend.model.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;

    public Qualification createQualification(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }

    public List<Qualification> getAllQualifications() {
        return qualificationRepository.findAll();
    }

    public Optional<Qualification> getQualificationById(Integer id) {
        return qualificationRepository.findById(id);
    }

    public Qualification updateQualification(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }

    public void deleteQualification(Integer id) {
        qualificationRepository.deleteById(id);
    }

    public Optional<Qualification> getQualificationByUserProfile(Integer id){
        return  qualificationRepository.findFirstByProfid(id);
    }

    public Qualification getQualificationbyJobid(Integer id){
        return  qualificationRepository.findByJobid(id).stream().findFirst().orElse(null);
    }

}

