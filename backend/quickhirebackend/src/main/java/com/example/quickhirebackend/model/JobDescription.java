package com.example.quickhirebackend.model;
import java.sql.Date;
import java.sql.Time;

public class JobDescription {

    private int empId; // Corresponds to "empid" column, auto-incremented
    private String email; // Corresponds to "email" column
    private Date endDate; // Corresponds to "enddate" column
    private Time endTime; // Corresponds to "endtime" column
    private String firstname; // Corresponds to "firstname" column
    private int jobdescriptionId; // Corresponds to "jobdescriptionid" column, auto-incremented
    private int jobId; // Corresponds to "jobid" column
    private String lastname; // Corresponds to "lastname" column
    private String payPerHour; // Corresponds to "payperhour" column
    private String phone; // Corresponds to "phone" column
    private String positionName; // Corresponds to "positionname" column
    private Date startDate; // Corresponds to "startdate" column
    private Time startTime; // Corresponds to "starttime" column

    // Getters and setters
    public int getEmpId() {
        return empId;
    }

    // Typically, no setter for auto-incremented ID
    // public void setEmpId(int empId) {
    //     this.empId = empId;
    // }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getJobdescriptionId() {
        return jobdescriptionId;
    }

    // Typically, no setter for auto-incremented ID
    // public void setJobdescriptionId(int jobdescriptionId) {
    //     this.jobdescriptionId = jobdescriptionId;
    // }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(String payPerHour) {
        this.payPerHour = payPerHour;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "JobDescription{" +
                "empId=" + empId +
                ", email='" + email + '\'' +
                ", endDate=" + endDate +
                ", endTime=" + endTime +
                ", firstname='" + firstname + '\'' +
                ", jobdescriptionId=" + jobdescriptionId +
                ", jobId=" + jobId +
                ", lastname='" + lastname + '\'' +
                ", payPerHour='" + payPerHour + '\'' +
                ", phone='" + phone + '\'' +
                ", positionName='" + positionName + '\'' +
                ", startDate=" + startDate +
                ", startTime=" + startTime +
                '}';
    }
}

