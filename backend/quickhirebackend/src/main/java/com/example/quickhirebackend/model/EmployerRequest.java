package com.example.quickhirebackend.model;

public class EmployerRequest {

    private int requestId; // Corresponds to the "erequestid" column which is auto-incremented
    private String companyName; // Corresponds to the "companyname" column
    private Integer profId; // Corresponds to the "profid" column, Nullable
    private String requestType; // Corresponds to the "requesttype" column

    // Getters and setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    // toString for debugging
    @Override
    public String toString() {
        return "EmployerRequest{" +
                "requestId=" + requestId +
                ", companyName='" + companyName + '\'' +
                ", profId=" + profId +
                ", requestType='" + requestType + '\'' +
                '}';
    }
}
