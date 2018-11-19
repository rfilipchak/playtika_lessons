package com.example.rfilipchak.gameservice;

import com.example.rfilipchak.domain.*;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
public class GameServiceImpl implements GameService {

    Set<City> cities = new HashSet<>();
    Map<String, GameUser> gameUsers = new HashMap<>();

    @Override
    public GameUser addNewUser(String userName, String region, City city) {
        GameUser newUser = new GameUser(userName, new Address(cityToContains(city)));
        gameUsers.put(newUser.getName(), newUser);
        return newUser;
    }

    @Override
    public String getUserDataCentre(GameUser gameUser, Game game) {

        for (DataCenter dataCenter : game.getDataCentres().values()) {
            if (gameUser.getAddress().getCity().equals(dataCenter.getCity())) {

                return String.format("User %s play in datacenter %s",
                                     gameUser.getName(),
                                     game.getDataCentres().get(dataCenter.getDatacenterName()).getDatacenterName());
            }
        }
        return "User don't play game";
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
