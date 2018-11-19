package com.example.rfilipchak.domain;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private DataCenter dataCenter;

    private Set<DataCenter> dataCenters = new HashSet<>();

    public Game(DataCenter dataCenters) {
        this.dataCenter = dataCenter;
    }

    public void addDataCenter(DataCenter dataCenter){
        dataCenters.add(dataCenter);
    }
    public DataCenter getDataCenter(DataCenter dataCenter){
        return dataCenters.stream().filter(dataCenter::equals).findAny().orElse(null);
    }
}
