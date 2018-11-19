package com.example.rfilipchak.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
public class GameUser {
    private String name;

    private Address address;
}
