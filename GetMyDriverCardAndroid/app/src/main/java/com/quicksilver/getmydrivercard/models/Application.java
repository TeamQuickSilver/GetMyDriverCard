package com.quicksilver.getmydrivercard.models;

public class Application {
    private Long applicationId;
    private Person person;
    private ApplicationImages applicationImages;
    private ApplicationStatus applicationStatus;

    public Application() {

    }

    public Application(Person person, ApplicationImages applicationImages) {
        this.person = person;
        this.applicationImages = applicationImages;
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
}
