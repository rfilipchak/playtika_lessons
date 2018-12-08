package com.example.rfilipchak.domain;

import lombok.Value;

import java.util.Set;

@Value
public class DataCenter {
    private String dataCenterName;
    private Set<Region> regions;
}
