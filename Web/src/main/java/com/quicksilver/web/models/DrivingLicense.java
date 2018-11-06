package com.quicksilver.web.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "driver_licenses")
public class DrivingLicense {

    @Id
    @Column(name = "id_driver_license")
    private Long idCard;

    @Column(name = "identity_card_number")
    private Long identityCardNumber;

    @Column(name = "issued_on")
    private Date issuedOn;

    @Column(name = "issued_by")
    private String issuedBy;

    public DrivingLicense() {
    }

    public DrivingLicense(Long idCard, Long identityCardNumber, Date issuedOn, String issuedBy) {
        this.setIdCard(idCard);
        this.setIdentityCardNumber(identityCardNumber);
        this.setIssuedOn(issuedOn);
        this.setIssuedBy(issuedBy);
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
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
}
