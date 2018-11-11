package com.quicksilver.getmydrivercard.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "driver_licenses")
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_driver_license")
    private Long id_card;

//    @Column(name = "identity_card_number")
//    private Long identityCardNumber;

    @Column(name = "issued_on")
    private Date issuedOn;

    @Column(name = "issued_by")
    private String issuedBy;

    public DrivingLicense() {
    }

    public DrivingLicense(Long id_card, Long identityCardNumber, Date issuedOn, String issuedBy) {
        this.setId_card(id_card);
//        this.setIdentityCardNumber(identityCardNumber);
        this.setIssuedOn(issuedOn);
        this.setIssuedBy(issuedBy);
    }

    public Long getId_card() {
        return id_card;
    }

    public void setId_card(Long id_card) {
        this.id_card = id_card;
    }

//    public Long getIdentityCardNumber() {
//        return identityCardNumber;
//    }
//
//    public void setIdentityCardNumber(Long identityCardNumber) {
//        this.identityCardNumber = identityCardNumber;
//    }

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
}
