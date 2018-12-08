package com.example.rfilipchak.gameservice;

import com.example.rfilipchak.domain.Address;
import com.example.rfilipchak.domain.Game;
import com.example.rfilipchak.domain.GameUser;

public interface GameService {
    GameUser addNewUser(String userName, Address address);

    String getUserDataCenter(GameUser gameUser, Game game);
}
