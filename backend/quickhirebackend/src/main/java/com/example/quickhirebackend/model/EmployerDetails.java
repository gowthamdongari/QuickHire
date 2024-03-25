package com.example.quickhirebackend.model;

public class EmployerDetails {

        private int employerId; // Corresponds to the "employerid" column which is auto-incremented
        private String companyName; // Corresponds to the "companyname" column
        private int profId; // Corresponds to the "profid" column which seems like a foreign key

        // Getters and setters
        public int getEmployerId() {
            return employerId;
        }

        public void setEmployerId(int employerId) {
            this.employerId = employerId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public int getProfId() {
            return profId;
        }

        public void setProfId(int profId) {
            this.profId = profId;
        }

        // toString for debugging
        @Override
        public String toString() {
            return "Employment{" +
                    "employerId=" + employerId +
                    ", companyName='" + companyName + '\'' +
                    ", profId=" + profId +
                    '}';
        }
    }
