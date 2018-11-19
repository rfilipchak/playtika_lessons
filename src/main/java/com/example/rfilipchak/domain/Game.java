package com.example.rfilipchak.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Game {

    private Map<String, DataCenter> gamesDataCentres = new HashMap<>();

    public void addDataCenter(DataCenter dataCenter) {
        gamesDataCentres.put(dataCenter.getDatacenterName(), dataCenter);
    }

    public Map<String, DataCenter> getDataCentres() {
        return gamesDataCentres;
    }
}
