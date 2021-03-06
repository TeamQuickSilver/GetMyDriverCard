package com.quicksilver.getmydrivercard.models;

import java.io.Serializable;

public class ApplicationImages implements Serializable {

    public byte[] personImage;
    public byte[] previousCardImage;
    public byte[] identityCardImage;
    public byte[] drivingLicenseImage;
    public byte[] euroCardImage;
    public byte[] signatureImage;

    public ApplicationImages() {

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
