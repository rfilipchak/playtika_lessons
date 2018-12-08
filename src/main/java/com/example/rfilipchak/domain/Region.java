package com.example.rfilipchak.domain;

import lombok.Value;

import java.util.Set;

@Value
public class Region {
    private String regionName;
    private Set<City> citySet;
}
