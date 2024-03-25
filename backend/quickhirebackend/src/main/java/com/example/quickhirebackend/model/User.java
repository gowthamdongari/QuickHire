package com.example.quickhirebackend.model;
import java.util.Arrays;

public class User {

    private int profId; // Corresponds to the "profid" column
    private byte[] password; // Corresponds to the "password" column stored as varbinary
    private String username; // Corresponds to the "username" column
    private String userType; // Corresponds to the "usertype" column
    private String status; // Corresponds to the "status" column, nullable

    // Constructors, getters, and setters

    public User() {
        // Default constructor
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override equals and hashCode if needed

    // toString() method for debugging purposes, don't include the password field to avoid security risks
    @Override
    public String toString() {
        return "User{" +
                "profId=" + profId +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
