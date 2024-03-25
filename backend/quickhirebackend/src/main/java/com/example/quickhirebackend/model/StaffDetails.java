package com.example.quickhirebackend.model;
public class StaffDetails {

    private int staffId; // auto-incremented primary key
    private Integer staffUserProfileId; // nullable foreign key reference to a user profile

    // Constructors, getters, and setters

    public StaffDetails() {
        // Default constructor
    }

    public int getStaffId() {
        return staffId;
    }

    // No setter for auto-incremented primary key
    // public void setStaffId(int staffId) {
    //     this.staffId = staffId;
    // }

    public Integer getStaffUserProfileId() {
        return staffUserProfileId;
    }

    public void setStaffUserProfileId(Integer staffUserProfileId) {
        this.staffUserProfileId = staffUserProfileId;
    }

    // toString() method for debugging purposes
    @Override
    public String toString() {
        return "StaffDetails{" +
                "staffId=" + staffId +
                ", staffUserProfileId=" + staffUserProfileId +
                '}';
    }
}
