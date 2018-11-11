package com.quicksilver.getmydrivercard.entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long address_id;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    public Address() {

    }

    public Address(String district, String city, String address) {
        this.setDistrict(district);
        this.setCity(city);
        this.setAddress(address);
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
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
