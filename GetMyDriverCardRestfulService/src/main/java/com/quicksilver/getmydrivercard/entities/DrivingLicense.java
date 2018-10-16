package com.quicksilver.getmydrivercard.entities;

import javax.persistence.*;
import java.util.Date;

public class DrivingLicense {

    @Id
    @Column(name = "id_driver_license")
    private Long id_card;

    @Column(name = "identity_card_number")
    private Long identityCardNumber;

    @Column(name = "issued_on")
    private Date issuedOn;

    @Column(name = "issued_by")
    private String issuedBy;

    @Column(name = "motor_vehicles_categories")
    private String motorVehiclesCategories;

    public DrivingLicense() {
    }

    public DrivingLicense(Long id_card, Long identityCardNumber, Date issuedOn, String issuedBy, String motorVehiclesCategories) {
        this.setId_card(id_card);
        this.setIdentityCardNumber(identityCardNumber);
        this.setIssuedOn(issuedOn);
        this.setIssuedBy(issuedBy);
        this.setMotorVehiclesCategories(motorVehiclesCategories);
    }

    public Long getId_card() {
        return id_card;
    }

    public void setId_card(Long id_card) {
        this.id_card = id_card;
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
