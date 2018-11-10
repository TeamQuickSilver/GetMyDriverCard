package com.quicksilver.getmydrivercard.models;

import java.io.Serializable;
import java.util.Date;

public class DrivingLicense implements Serializable {

    public Long drivingLicenseNumber;
    public Date issuedOn;
    public String issuedBy;
    public String motorVehiclesCategories;

    public DrivingLicense() {

    }

    public DrivingLicense(Long drivingLicenseNumber, Date issuedOn, String issuedBy, String motorVehiclesCategories) {
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.issuedOn = issuedOn;
        this.issuedBy = issuedBy;
        this.motorVehiclesCategories = motorVehiclesCategories;
    }

    public Long getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(Long drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
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
