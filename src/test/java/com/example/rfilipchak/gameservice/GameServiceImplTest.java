package com.example.rfilipchak.gameservice;

import com.example.rfilipchak.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class GameServiceImplTest {

    private GameService gameService;

    Region vinnickiy = new Region("Vinnickiy");
    Region kievskiy = new Region("Kievskiy");

    private City kiev = new City(kievskiy, "Kiev");
    private City vinnica = new City(vinnickiy, "Vinnica");


    private DataCenter dataCenter1 = new DataCenter("dataCentre1", kiev);
    private DataCenter dataCenter2 = new DataCenter("dataCentre2", vinnica);

    Game slots = new Game();

    @Before
    public void init() {
        gameService = new GameServiceImpl();
    }

    @Test
    public void getUserDataCentre() {
        slots.addDataCenter(dataCenter1);
        slots.addDataCenter(dataCenter2);
        String expected = "User Roman play in datacenter dataCentre1";

        GameUser roman = gameService.addNewUser("Roman", "Kievskiy", kiev);

        String result = gameService.getUserDataCentre(roman, slots);

        assertEquals(result, expected);
    }

    @Test
    public void shouldDoNotFindDataCenter(){
        slots.addDataCenter(dataCenter1);
        slots.addDataCenter(dataCenter2);
        GameUser roman  = new GameUser("Roman",new Address(new City(new Region("Gmerinka"),"Gitomir")));

        String result = gameService.getUserDataCentre(roman, slots);

        assertEquals(result, "User don't play game");
    }
}