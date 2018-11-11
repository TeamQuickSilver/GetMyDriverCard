package com.quicksilver.getmydrivercard.entities;

import javax.persistence.*;

@Entity
@Table(name = "applications_images")
public class ApplicationImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_images_id")
    private Long applicationImagesId;

    @Column(name = "person_image", columnDefinition = "LONGBLOB")
    private byte[] personImage;

    @Column(name = "previous_card_image", columnDefinition = "LONGBLOB")
    private byte[] previousCardImage;

    @Column(name = "identity_card_image", columnDefinition = "LONGBLOB")
    private byte[] identityCardImage;

    @Column(name = "driving_license_image", columnDefinition = "LONGBLOB")
    private byte[] drivingLicenseImage;

    @Column(name = "euro_card_image", columnDefinition = "LONGBLOB")
    private byte[] euroCardImage;

    @Column(name = "signature_image", columnDefinition = "LONGBLOB")
    private byte[] signatureImage;

    public ApplicationImages() {

    }

    public Long getApplicationImagesId() {
        return applicationImagesId;
    }

    public void setApplicationImagesId(Long applicationImagesId) {
        this.applicationImagesId = applicationImagesId;
    }

    public byte[] getPersonImage() {
        return personImage;
    }

    public void setPersonImage(byte[] personImage) {
        this.personImage = personImage;
    }

    public byte[] getPreviousCardImage() {
        return previousCardImage;
    }

    public void setPreviousCardImage(byte[] previousCardImage) {
        this.previousCardImage = previousCardImage;
    }

    public byte[] getIdentityCardImage() {
        return identityCardImage;
    }

    public void setIdentityCardImage(byte[] identityCardImage) {
        this.identityCardImage = identityCardImage;
    }

    public byte[] getDrivingLicenseImage() {
        return drivingLicenseImage;
    }

    public void setDrivingLicenseImage(byte[] drivingLicenseImage) {
        this.drivingLicenseImage = drivingLicenseImage;
    }

    public byte[] getEuroCardImage() {
        return euroCardImage;
    }

    public void setEuroCardImage(byte[] euroCardImage) {
        this.euroCardImage = euroCardImage;
    }

    public byte[] getSignatureImage() {
        return signatureImage;
    }

    public void setSignatureImage(byte[] signatureImage) {
        this.signatureImage = signatureImage;
    }
}
