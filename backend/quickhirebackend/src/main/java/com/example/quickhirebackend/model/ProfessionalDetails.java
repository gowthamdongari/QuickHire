package com.example.quickhirebackend.model;
import java.time.LocalDateTime;

public class ProfessionalDetails {

    private int professionalId; // auto-incremented primary key
    private Integer profId; // assumed to be a foreign key, nullable
    private String major;
    private String schoolName;
    private LocalDateTime completionTime; // using the modern java.time API

    // Constructors, getters, and setters

    public ProfessionalDetails() {
        // Default constructor
    }

    public int getProfessionalId() {
        return professionalId;
    }

    // No setter for auto-incremented primary key
    // public void setProfessionalId(int professionalId) {
    //     this.professionalId = professionalId;
    // }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    // toString() method for debugging purposes
    @Override
    public String toString() {
        return "ProfessionalDetails{" +
                "professionalId=" + professionalId +
                ", profId=" + profId +
                ", major='" + major + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", completionTime=" + completionTime +
                '}';
    }
}
