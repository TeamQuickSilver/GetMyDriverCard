package com.quicksilver.getmydrivercard.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "identity_cards")
public class IdentityCard {
    @Id
    @Column(name = "identity_card_number")
    private Long identityCardNumber;

    @Column(name = "personal_number")
    private Long personalNumber;

    @Column(name = "issued_on")
    private Date issuedOn;

    @Column(name = "issued_by")
    private String issuedBy;

    @Column(name = "first_name_cyrillic")
    private String firstNameCyrillic;

    @Column(name = "fathers_name_cyrillic")
    private String fathersNameCyrillic;

    @Column(name = "last_name_cyrillic")
    private String lastNameCyrillic;

    @Column(name = "first_name_latin")
    private String firstNameLatin;

    @Column(name = "fathers_name_latin")
    private String fathersNameLatin;

    @Column(name = "last_name_latin")
    private String lastNameLatin;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public IdentityCard() {

    }

    public IdentityCard(Long identityCardNumber, Long personalNumber, Date issuedOn, String issuedBy,
                        String firstNameCyrillic, String fathersNameCyrillic, String lastNameCyrillic, String firstNameLatin, String fathersNameLatin, String lastNameLatin, Date dateOfBirth, Address address) {
        this.setIdentityCardNumber(identityCardNumber);
        this.setPersonalNumber(personalNumber);
        this.setIssuedOn(issuedOn);
        this.setIssuedBy(issuedBy);
        this.setFirstNameCyrillic(firstNameCyrillic);
        this.setFathersNameCyrillic(fathersNameCyrillic);
        this.setLastNameCyrillic(lastNameCyrillic);
        this.setFirstNameCyrillic(firstNameLatin);
        this.setFathersNameLatin(fathersNameLatin);
        this.setLastNameLatin(lastNameLatin);
        this.setDateOfBirth(dateOfBirth);
        this.setAddress(address);
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
