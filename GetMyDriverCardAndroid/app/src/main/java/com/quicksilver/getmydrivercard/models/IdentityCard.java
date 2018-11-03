package com.quicksilver.getmydrivercard.models;

import java.io.Serializable;
import java.util.Date;

public class IdentityCard implements Serializable {

    private Long identityCardNumber;
    private Long personalNumber;
    private Date issuedOn;
    private String issuedBy;
    private String firstName;
    private String fathersName;
    private String lastName;
    private Date dateOfBirth;
    private Address address;

    public IdentityCard() {

    }

    public IdentityCard(Long identityCardNumber, Long personalNumber, Date issuedOn, String issuedBy, String firstName, String fathersName, String lastName, Date dateOfBirth, Address address) {
        this.identityCardNumber = identityCardNumber;
        this.personalNumber = personalNumber;
        this.issuedOn = issuedOn;
        this.issuedBy = issuedBy;
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Long getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(Long identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public Long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Long personalNumber) {
        this.personalNumber = personalNumber;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
