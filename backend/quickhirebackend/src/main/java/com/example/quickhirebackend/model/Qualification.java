package com.example.quickhirebackend.model;

public class Qualification {

    private int qualificationId;
    private String type;
    private String keywords;
    private int profId;
    private int jobId;

    // Getters and setters

    public int getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(int qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "Qualification{" +
                "qualificationId=" + qualificationId +
                ", type='" + type + '\'' +
                ", keywords='" + keywords + '\'' +
                ", profId=" + profId +
                ", jobId=" + jobId +
                '}';
    }
}

