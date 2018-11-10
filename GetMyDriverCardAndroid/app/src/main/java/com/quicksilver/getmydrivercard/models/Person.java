package com.quicksilver.getmydrivercard.models;

import java.io.Serializable;

public class Person implements Serializable{

    public IdentityCard identityCard;
    public DrivingLicense drivingLicense;
    public Long phoneNumber;
    // Can be removed
    public String email;

    public Person() {

    }

    public Person(IdentityCard identityCard, DrivingLicense drivingLicense, Long phoneNumber, String email) {
        this.identityCard = identityCard;
        this.drivingLicense = drivingLicense;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(IdentityCard identityCard) {
        this.identityCard = identityCard;
    }

    public DrivingLicense getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(DrivingLicense drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
