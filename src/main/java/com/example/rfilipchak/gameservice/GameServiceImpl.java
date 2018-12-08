package com.example.rfilipchak.gameservice;

import com.example.rfilipchak.datacenterservice.DataCenterService;
import com.example.rfilipchak.domain.*;
import com.example.rfilipchak.regionservice.RegionService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final DataCenterService dataCenterService;
    private final RegionService regionService;

    Set<GameUser> gameUsers = new HashSet<>();

    @Override
    public GameUser addNewUser(@NonNull String userName, @NonNull Address address) {
        GameUser newUser = new GameUser(userName, address);
        gameUsers.add(newUser);
        return newUser;
    }

    @Override
    public String getUserDataCenter(GameUser gameUser, Game game) {
        Map<Region, DataCenter> dataCenterInfo = dataCenterService.getDataCenterRegions(game.getDataCenters());

        String cityName = gameUser.getAddress().getCityName();

        Region region = regionService.getRegionByCityName(cityName, dataCenterInfo.keySet())
                                     .orElseThrow(() -> new IllegalArgumentException("User don't play game"));

        return String.format("User %s play in datacenter: %s",
                             gameUser.getName(),
                             dataCenterInfo.get(region).getDataCenterName());
    }
}
