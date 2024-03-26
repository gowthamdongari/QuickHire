package com.example.quickhirebackend.dto;
import java.sql.Date;

public class PaymentDTO {
    private Integer profid;
    private String amount;
    private Date startdate;
    private Date enddate;
    private String status;

    // Constructor, getters, and setters

    public PaymentDTO() {
        // Default constructor
    }

    public Integer getProfId() {
        return profid;
    }

    public void setProfId(Integer profId) {
        this.profid = profId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startdate;
    }

    public void setStartDate(Date startDate) {
        this.startdate = startDate;
    }

    public Date getEndDate() {
        return enddate;
    }

    public void setEndDate(Date endDate) {
        this.enddate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
