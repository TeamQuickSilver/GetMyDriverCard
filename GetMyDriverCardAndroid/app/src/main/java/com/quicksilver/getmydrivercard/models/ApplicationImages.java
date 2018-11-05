package com.quicksilver.getmydrivercard.models;

import java.io.Serializable;

public class ApplicationImages implements Serializable {

    private byte[] personImage;
    private byte[] previousCardImage;
    private byte[] identityCardImage;
    private byte[] drivingLicenseImage;
    private byte[] euroCardImage;
    private byte[] signatureImage;

    public ApplicationImages() {

    }

    public ApplicationImages(byte[] personImage, byte[] previousCardImage, byte[] identityCardImage, byte[] drivingLicenseImage, byte[] euroCardImage, byte[] signatureImage) {
        this.personImage = personImage;
        this.previousCardImage = previousCardImage;
        this.identityCardImage = identityCardImage;
        this.drivingLicenseImage = drivingLicenseImage;
        this.euroCardImage = euroCardImage;
        this.signatureImage = signatureImage;
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
