package com.example.rfilipchak.persons;

import com.example.rfilipchak.address.Address;

public class Person {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
