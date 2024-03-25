package com.example.quickhirebackend.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Arrays;

@Entity
@Table(name = "user")
public class User {


    private Integer profid; // Corresponds to the "profid" column
    private String password; // Corresponds to the "password" column stored as varbinary
    @Id
    @Column(name = "username", length = 30)
    private String username; // Corresponds to the "username" column
    private String usertype; // Corresponds to the "usertype" column
    private String status; // Corresponds to the "status" column, nullable

    private  String ispasswordchanged;

    // Constructors, getters, and setters

    public User() {
        // Default constructor
    }

    public int getProfId() {
        return profid;
    }

    public void setProfId(int profId) {
        this.profid = profId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return usertype;
    }

    public void setUserType(String userType) {
        this.usertype = userType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  void  setIsPasswordChanged(String isPasswordChanged){this.ispasswordchanged=isPasswordChanged;}

    public  String getIsPasswordChanged(){return  ispasswordchanged;}


    // Override equals and hashCode if needed

    // toString() method for debugging purposes, don't include the password field to avoid security risks
    @Override
    public String toString() {
        return "User{" +
                "profId=" + profid +
                ", username='" + username + '\'' +
                ", userType='" + usertype + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
