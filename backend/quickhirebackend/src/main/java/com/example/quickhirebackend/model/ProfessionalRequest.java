package com.example.quickhirebackend.model;

import java.util.Date;

public class ProfessionalRequest {
    private int requestId;
    private String requestType;
    private String schoolName;
    private String major;
    private Date completionTime;
    private int profId;

    // Constructors, getters, and setters

    public ProfessionalRequest() {
        // Default constructor
    }

    // You might use a constructor for all fields or just required fields, based on your application's needs

    // Getters and setters for each field

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }

    // Override toString() if necessary for logging or debugging purposes
    @Override
    public String toString() {
        return "ProfessionalRequest{" +
                "requestId=" + requestId +
                ", requestType='" + requestType + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", major='" + major + '\'' +
                ", completionTime=" + completionTime +
                ", profId=" + profId +
                '}';
    }
}
