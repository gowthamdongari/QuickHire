package com.example.quickhirebackend.services;
import com.example.quickhirebackend.dao.JobDescriptionRepository;
import com.example.quickhirebackend.model.JobDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JobDescriptionService {

    private final JobDescriptionRepository jobDescriptionRepository;

    @Autowired
    public JobDescriptionService(JobDescriptionRepository jobDescriptionRepository) {
        this.jobDescriptionRepository = jobDescriptionRepository;
    }

    @Transactional
    public JobDescription createJobDescription(JobDescription jobDescription) {
        // Here you can add any additional business logic before saving the job description
        return jobDescriptionRepository.save(jobDescription);
    }

    @Transactional(readOnly = true)
    public List<JobDescription> findAllJobDescriptions() {
        return jobDescriptionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<JobDescription> findJobDescriptionById(int jobDescriptionId) {
        return jobDescriptionRepository.findById(jobDescriptionId);
    }

    @Transactional
    public JobDescription updateJobDescription(int jobDescriptionId, JobDescription jobDescription) {
        return jobDescriptionRepository.findById(jobDescriptionId)
                .map(existingJobDescription -> {
                    // Update the properties of the existing job description
                    existingJobDescription.setJobId(jobDescription.getJobId());
                    existingJobDescription.setPositionName(jobDescription.getPositionName());
                    existingJobDescription.setFirstname(jobDescription.getFirstname());
                    existingJobDescription.setLastname(jobDescription.getLastname());
                    existingJobDescription.setEmail(jobDescription.getEmail());
                    existingJobDescription.setPhone(jobDescription.getPhone());
                    existingJobDescription.setStartDate(jobDescription.getStartDate());
                    existingJobDescription.setEndDate(jobDescription.getEndDate());
                    existingJobDescription.setPayPerHour(jobDescription.getPayPerHour());
                    existingJobDescription.setStartTime(jobDescription.getStartTime());
                    existingJobDescription.setEndTime(jobDescription.getEndTime());
                    existingJobDescription.setEmpid(jobDescription.getEmpId());
                    // More fields can be set here if necessary

                    // Save the updated job description
                    return jobDescriptionRepository.save(existingJobDescription);
                })
                .orElseThrow(() -> new RuntimeException("JobDescription not found with id " + jobDescriptionId));
    }

    @Transactional
    public void deleteJobDescription(int jobDescriptionId) {
        jobDescriptionRepository.deleteById(jobDescriptionId);
    }
}

