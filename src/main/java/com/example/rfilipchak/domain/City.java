package com.example.rfilipchak.domain;

import lombok.Value;

import java.util.Set;

@Value
public class City {
    private String cityName;
    private Set<Address> addresses;
}

