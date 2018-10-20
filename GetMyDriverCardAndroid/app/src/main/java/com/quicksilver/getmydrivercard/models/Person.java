package com.quicksilver.getmydrivercard.models;

public class Person {

    private IdentityCard identityCard;
    private DrivingLicense drivingLicense;
    private Long phoneNumber;
    private String email;

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
