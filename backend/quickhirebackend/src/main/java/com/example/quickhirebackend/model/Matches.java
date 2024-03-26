package com.example.quickhirebackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Matches {

    private int jobid; // Presumably a foreign key, nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchid; // Primary key, auto-incremented
    private String matchpercentage;
    private Integer professionalid; // Nullable foreign key
    private Integer staffid; // Nullable foreign key

    // Constructors, getters, and setters

    public Matches() {
    }

    // Getters and setters
    public int getJobId() {
        return jobid;
    }

    public void setJobId(int jobId) {
        this.jobid = jobId;
    }

    public int getMatchId() {
        return matchid;
    }

    // No setter for auto-incremented primary key
    // public void setMatchId(int matchId) {
    //     this.matchId = matchId;
    // }

    public String getMatchPercentage() {
        return matchpercentage;
    }

    public void setMatchPercentage(String matchPercentage) {
        this.matchpercentage = matchPercentage;
    }

    public Integer getProfessionalId() {
        return professionalid;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalid = professionalId;
    }

    public Integer getStaffId() {
        return staffid;
    }

    public void setStaffId(Integer staffId) {
        this.staffid = staffId;
    }

    // toString() method for debugging purposes
    @Override
    public String toString() {
        return "Matches{" +
                "jobId=" + jobid +
                ", matchId=" + matchid +
                ", matchPercentage='" + matchpercentage + '\'' +
                ", professionalId=" + professionalid +
                ", staffId=" + staffid +
                '}';
    }
}
