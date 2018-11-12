package com.quicksilver.getmydrivercard.models;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable{
    public Long applicationId;
    public Person person;
    public ApplicationImages applicationImages;
    public String applicationStatus;
    public String applicationReason;
    public Date dateOfSubmission;
    public String placeLost;
    public Date dateLost;
    public Date dateOfExpire;
    public String countryPreviousCard;
    public Long previousCardNumber;
    public String countryDrivingLicense;
    public User user;

    public Application() {

    }

    public Application(Person person, ApplicationImages applicationImages, Date dateOfSubmission) {
        this.person = person;
        this.applicationImages = applicationImages;
        this.dateOfSubmission = dateOfSubmission;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ApplicationImages getApplicationImages() {
        return applicationImages;
    }

    public void setApplicationImages(ApplicationImages applicationImages) {
        this.applicationImages = applicationImages;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason;
    }

    public String getPlaceLost() {
        return placeLost;
    }

    public void setPlaceLost(String placeLost) {
        this.placeLost = placeLost;
    }

    public Date getDateLost() {
        return dateLost;
    }

    public void setDateLost(Date dateLost) {
        this.dateLost = dateLost;
    }

    public Date getDateOfExpire() {
        return dateOfExpire;
    }

    public void setDateOfExpire(Date dateOfExpire) {
        this.dateOfExpire = dateOfExpire;
    }

    public String getCountryPreviousCard() {
        return countryPreviousCard;
    }

    public void setCountryPreviousCard(String countryPreviousCard) {
        this.countryPreviousCard = countryPreviousCard;
    }

    public Long getPreviousCardNumber() {
        return previousCardNumber;
    }

    public void setPreviousCardNumber(Long previousCardNumber) {
        this.previousCardNumber = previousCardNumber;
    }

    public String getCountryDrivingLicense() {
        return countryDrivingLicense;
    }

    public void setCountryDrivingLicense(String countryDrivingLicense) {
        this.countryDrivingLicense = countryDrivingLicense;
    }
}
