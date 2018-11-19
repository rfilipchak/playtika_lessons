package com.example.rfilipchak.gameservice;

import com.example.rfilipchak.domain.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameServiceImpl implements GameService {

    Set<Region> regions = new HashSet<>();
    Set<City> cities = new HashSet<>();
    Set<DataCenter> dataCenters = new HashSet<>();
    Map<String,GameUser> gameUsers = new HashMap<>();


    Region vinnickiy = new Region("Vinnickiy");
    Region kievskiy = new Region("Kievskiy");

    City kiev = new City(kievskiy, "Kiev");
    City vinnica = new City(vinnickiy, "Vinnica");


    DataCenter dataCenter1 = new DataCenter("dataCentre1", kiev);
    DataCenter dataCenter2 = new DataCenter("dataCentre2", vinnica);


    @Override
    public GameUser addNewUser(String userName, String region, City city) {

            GameUser newUser = new GameUser(userName, new Address(cityToContains(city)));
            gameUsers.put(newUser.getName(), newUser);
            return newUser;
    }

    @Override
    public String getUserDataCentre(GameUser gameUser) {
        return null;
    }

    private City cityToContains(City city) {
        if (cities.contains(city)) {
            return city;
        } else {
            cities.add(city);
            return city;
        }
    }
}
