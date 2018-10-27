package com.quicksilver.getmydrivercard.models;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable{
    private Long applicationId;
    private Person person;
    private ApplicationImages applicationImages;
    private ApplicationStatus applicationStatus;
    private Date dateOfSubmission;

    public Application() {

    }

    public Application(Person person, ApplicationImages applicationImages, Date dateOfSubmission) {
        this.person = person;
        this.applicationImages = applicationImages;
        this.dateOfSubmission = dateOfSubmission;
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

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
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
}
