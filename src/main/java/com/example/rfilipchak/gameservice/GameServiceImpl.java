package com.example.rfilipchak.gameservice;

import com.example.rfilipchak.domain.Address;
import com.example.rfilipchak.domain.Game;
import com.example.rfilipchak.domain.GameUser;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class GameServiceImpl implements GameService {

    Set<GameUser> gameUsers = new HashSet<>();

    @Override
    public GameUser addNewUser(String userName, Address address) {
        GameUser newUser = new GameUser(userName, address);
        gameUsers.add(newUser);
        return newUser;
    }

    @Override
    public String getUserDataCentre(GameUser gameUser, Game game) {

        Map<Address, String> addressToDatacenterName = game.getDataCenters()
                                                           .stream()
                                                           .flatMap(dc -> dc.getRegions()
                                                                            .stream()
                                                                            .flatMap(region1 -> region1.getCitySet()
                                                                                                       .stream()
                                                                                                       .flatMap(
                                                                                                               city1 -> city1.getAddresses()
                                                                                                                             .stream()
                                                                                                                             .map(address -> new Pair<>(
                                                                                                                                     address,
                                                                                                                                     dc.getDatacenterName())))))
                                                           .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        for (Address a : addressToDatacenterName.keySet()) {
            if (gameUser.getAddress().equals(a)) {
            }
            return String.format("User %s play in datacenter %s",
                                 gameUser.getName(),
                                 addressToDatacenterName.get(a));
        }
        return "User don't play game";
    }

    @Value
    public static class Pair<K, V> {
        private K key;
        private V value;
    }
}
