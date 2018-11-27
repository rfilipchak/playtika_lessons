package com.example.rfilipchak.domain;

import lombok.Value;

import java.util.Set;

@Value
public class Game {
    private Set<DataCenter> dataCenters;
}
