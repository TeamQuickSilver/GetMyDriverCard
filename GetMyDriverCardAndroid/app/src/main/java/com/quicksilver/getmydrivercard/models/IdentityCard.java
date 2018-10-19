package com.quicksilver.getmydrivercard.models;

import java.util.Date;

public class IdentityCard {

    private Long identityCardNumber;
    private Long personalNumber;
    private Date issuedOn;
    private String issuedBy;
    private String firstNameCyrillic;
    private String fathersNameCyrillic;
    private String lastNameCyrillic;
    private String firstNameLatin;
    private String fathersNameLatin;
    private String lastNameLatin;
    private Date dateOfBirth;
    private Address address;

    public IdentityCard() {

    }

    public IdentityCard(Long identityCardNumber, Long personalNumber, Date issuedOn, String issuedBy, String firstNameCyrillic, String fathersNameCyrillic, String lastNameCyrillic, String firstNameLatin, String fathersNameLatin, String lastNameLatin, Date dateOfBirth, Address address) {
        this.identityCardNumber = identityCardNumber;
        this.personalNumber = personalNumber;
        this.issuedOn = issuedOn;
        this.issuedBy = issuedBy;
        this.firstNameCyrillic = firstNameCyrillic;
        this.fathersNameCyrillic = fathersNameCyrillic;
        this.lastNameCyrillic = lastNameCyrillic;
        this.firstNameLatin = firstNameLatin;
        this.fathersNameLatin = fathersNameLatin;
        this.lastNameLatin = lastNameLatin;
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

    public String getFirstNameCyrillic() {
        return firstNameCyrillic;
    }

    public void setFirstNameCyrillic(String firstNameCyrillic) {
        this.firstNameCyrillic = firstNameCyrillic;
    }

    public String getFathersNameCyrillic() {
        return fathersNameCyrillic;
    }

    public void setFathersNameCyrillic(String fathersNameCyrillic) {
        this.fathersNameCyrillic = fathersNameCyrillic;
    }

    public String getLastNameCyrillic() {
        return lastNameCyrillic;
    }

    public void setLastNameCyrillic(String lastNameCyrillic) {
        this.lastNameCyrillic = lastNameCyrillic;
    }

    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    public void setFirstNameLatin(String firstNameLatin) {
        this.firstNameLatin = firstNameLatin;
    }

    public String getFathersNameLatin() {
        return fathersNameLatin;
    }

    public void setFathersNameLatin(String fathersNameLatin) {
        this.fathersNameLatin = fathersNameLatin;
    }

    public String getLastNameLatin() {
        return lastNameLatin;
    }

    public void setLastNameLatin(String lastNameLatin) {
        this.lastNameLatin = lastNameLatin;
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
