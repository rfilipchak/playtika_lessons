package com.example.rfilipchak.gameservice;

import com.example.rfilipchak.domain.City;
import com.example.rfilipchak.domain.GameUser;

public interface GameService {
    GameUser addNewUser(String userName, String region, City city);

    String getUserDataCentre(GameUser gameUser);
}
