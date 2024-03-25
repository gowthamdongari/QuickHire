package com.example.quickhirebackend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;
import java.sql.Time;
@Entity
@Table(name = "jobdescription")
public class JobDescription {

    private Integer empid; // Corresponds to "empid" column, auto-incremented
    private String email; // Corresponds to "email" column
    private Date enddate; // Corresponds to "enddate" column
    private Time endtime; // Corresponds to "endtime" column
    private String firstname; // Corresponds to "firstname" column
    private int jobdescriptionid; // Corresponds to "jobdescriptionid" column, auto-incremented
    private int jobid; // Corresponds to "jobid" column
    private String lastname; // Corresponds to "lastname" column
    private String payperhour; // Corresponds to "payperhour" column
    private String phone; // Corresponds to "phone" column
    private String positionname; // Corresponds to "positionname" column
    private Date startdate; // Corresponds to "startdate" column
    private Time starttime; // Corresponds to "starttime" column

    // Getters and setters
    public Integer getEmpId() {
        return empid;
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
        return enddate;
    }

    public void setEndDate(Date endDate) {
        this.enddate = endDate;
    }

    public Time getEndTime() {
        return endtime;
    }

    public void setEndTime(Time endTime) {
        this.endtime = endTime;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getJobdescriptionId() {
        return jobdescriptionid;
    }

    // Typically, no setter for auto-incremented ID
    // public void setJobdescriptionId(int jobdescriptionId) {
    //     this.jobdescriptionId = jobdescriptionId;
    // }

    public int getJobId() {
        return jobid;
    }

    public void setJobId(int jobId) {
        this.jobid = jobId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPayPerHour() {
        return payperhour;
    }

    public void setPayPerHour(String payPerHour) {
        this.payperhour = payPerHour;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPositionName() {
        return positionname;
    }

    public void setPositionName(String positionName) {
        this.positionname = positionName;
    }

    public Date getStartDate() {
        return startdate;
    }

    public void setStartDate(Date startDate) {
        this.startdate = startDate;
    }

    public Time getStartTime() {
        return starttime;
    }

    public void setStartTime(Time startTime) {
        this.starttime = startTime;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "JobDescription{" +
                "empId=" + empid +
                ", email='" + email + '\'' +
                ", endDate=" + enddate +
                ", endTime=" + endtime +
                ", firstname='" + firstname + '\'' +
                ", jobdescriptionId=" + jobdescriptionid +
                ", jobId=" + jobid +
                ", lastname='" + lastname + '\'' +
                ", payPerHour='" + payperhour + '\'' +
                ", phone='" + phone + '\'' +
                ", positionName='" + positionname + '\'' +
                ", startDate=" + startdate +
                ", startTime=" + starttime +
                '}';
    }
}

