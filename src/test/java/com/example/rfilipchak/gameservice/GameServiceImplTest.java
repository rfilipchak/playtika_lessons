package com.example.rfilipchak.gameservice;

import com.example.rfilipchak.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class GameServiceImplTest {

    private GameService gameService;

    private Address vatutina = new Address("vatutina,1");
    private Address gagarina = new Address("gagarina,16");

    private Region vinnickiy = new Region("Vinnickiy", new HashSet<>());
    private Region kievskiy = new Region("Kievskiy", new HashSet<>());

    private City kiev = new City("Kiev", new HashSet<>());
    private City vinnica = new City("Vinnica", new HashSet<>());


    private DataCenter dataCenter1 = new DataCenter("dataCentre1", new HashSet<>());
    private DataCenter dataCenter2 = new DataCenter("dataCentre2", new HashSet<>());

    Game slots = new Game(new HashSet<>());

    @Before
    public void init() {
        gameService = new GameServiceImpl();
    }

    @Test
    public void getUserDataCentre() {
        kiev.getAddresses().add(vatutina);
        kiev.getAddresses().add(gagarina);

        kievskiy.getCitySet().add(kiev);
        vinnickiy.getCitySet().add(vinnica);

        dataCenter1.getRegions().add(kievskiy);
        dataCenter2.getRegions().add(vinnickiy);

        slots.getDataCenters().add(dataCenter1);
        slots.getDataCenters().add(dataCenter2);

        String expected = "User Roman play in datacenter dataCentre1";

        GameUser roman = gameService.addNewUser("Roman", vatutina);

        String result = gameService.getUserDataCentre(roman, slots);

        assertEquals(result, expected);
    }

    @Test
    public void shouldDoNotFindDataCenter() {
        slots.getDataCenters().add(dataCenter1);
        slots.getDataCenters().add(dataCenter2);

        GameUser roman = gameService.addNewUser("Roman", vatutina);

        String result = gameService.getUserDataCentre(roman, slots);

        assertEquals(result, "User don't play game");
    }
}