package com.quicksilver.getmydrivercard.models;

import java.util.Date;

public class DrivingLicense {

    private Long identityCardNumber;
    private Date issuedOn;
    private String issuedBy;
    private String motorVehiclesCategories;

    public DrivingLicense() {

    }

    public DrivingLicense(Long identityCardNumber, Date issuedOn, String issuedBy, String motorVehiclesCategories) {
        this.identityCardNumber = identityCardNumber;
        this.issuedOn = issuedOn;
        this.issuedBy = issuedBy;
        this.motorVehiclesCategories = motorVehiclesCategories;
    }

    public Long getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(Long identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public Date getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(Date issuedOn) {
        this.issuedOn = issuedOn;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getMotorVehiclesCategories() {
        return motorVehiclesCategories;
    }

    public void setMotorVehiclesCategories(String motorVehiclesCategories) {
        this.motorVehiclesCategories = motorVehiclesCategories;
    }
}
