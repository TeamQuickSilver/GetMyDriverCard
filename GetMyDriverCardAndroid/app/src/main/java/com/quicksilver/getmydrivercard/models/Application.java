package com.quicksilver.getmydrivercard.models;

public class Application {

    private Person person;
    private ApplicationImages applicationImages;

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
}
