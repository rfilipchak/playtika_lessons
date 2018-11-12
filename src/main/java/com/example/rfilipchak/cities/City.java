package com.example.rfilipchak.cities;

import com.example.rfilipchak.regions.Region;

public class City {
    private Region region;
    private String cityName;

    public City(Region region, String cityName) {
        this.region = region;
        this.cityName = cityName;
    }
}
