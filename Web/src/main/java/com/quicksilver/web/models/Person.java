package com.quicksilver.web.models;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long person_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identity_card_number")
    private IdentityCard identityCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_driver_license")
    private DrivingLicense drivingLicense;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "email")
    private String email;

    public Person() {

    }

    public Person(IdentityCard identityCard, Long phoneNumber, String email, DrivingLicense drivingLicense) {
        this.setIdentityCard(identityCard);
        this.setDrivingLicense(drivingLicense);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
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
