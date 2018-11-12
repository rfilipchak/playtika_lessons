package com.example.rfilipchak.address;

import com.example.rfilipchak.cities.City;

public class Address {
    private String street;
    private City city;

    public Address(String street, City city) {
        this.street = street;
        this.city = city;
    }
}
