package com.quicksilver.getmydrivercard.models;

public class Address {

    private String district;
    private String city;
    private String address;

    public Address() {

    }

    public Address(String district, String city, String address) {
        this.district = district;
        this.city = city;
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
