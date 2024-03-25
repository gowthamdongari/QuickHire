package com.example.quickhirebackend.model;
public class Matches {

    private int jobId; // Presumably a foreign key, nullable
    private int matchId; // Primary key, auto-incremented
    private String matchPercentage;
    private Integer professionalId; // Nullable foreign key
    private Integer staffId; // Nullable foreign key

    // Constructors, getters, and setters

    public Matches() {
    }

    // Getters and setters
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getMatchId() {
        return matchId;
    }

    // No setter for auto-incremented primary key
    // public void setMatchId(int matchId) {
    //     this.matchId = matchId;
    // }

    public String getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(String matchPercentage) {
        this.matchPercentage = matchPercentage;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    // toString() method for debugging purposes
    @Override
    public String toString() {
        return "Matches{" +
                "jobId=" + jobId +
                ", matchId=" + matchId +
                ", matchPercentage='" + matchPercentage + '\'' +
                ", professionalId=" + professionalId +
                ", staffId=" + staffId +
                '}';
    }
}
