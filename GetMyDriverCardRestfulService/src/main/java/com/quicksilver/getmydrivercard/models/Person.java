package com.quicksilver.getmydrivercard.models;

public class Person {
    private IdentityCard identityCard;

    private Long phoneNumber;

    private String email;

    private Address address;

    public Person() {

    }

    public Person(IdentityCard identityCard, Long phoneNumber, String email, Address address) {
        this.setIdentityCard(identityCard);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        this.setAddress(address);
    }

    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(IdentityCard identityCard) {
        this.identityCard = identityCard;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
