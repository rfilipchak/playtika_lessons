package com.example.rfilipchak.domain;

import lombok.Value;

import java.util.Set;

@Value
public class DataCenter {
    private String datacenterName;
    private Set<Region> regions;
}
