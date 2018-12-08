package com.example.rfilipchak.gameservice;

import com.example.rfilipchak.datacenterservice.DataCenterService;
import com.example.rfilipchak.datacenterservice.DataCenterServiceImpl;
import com.example.rfilipchak.domain.Address;
import com.example.rfilipchak.domain.GameUser;
import com.example.rfilipchak.regionservice.RegionService;
import com.example.rfilipchak.regionservice.RegionServiceImpl;
import com.example.rfilipchak.testcommon.TestCommon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameServiceImplTest extends TestCommon {

    private GameService gameService;

    @Before
    public void init() {
        RegionService regionService = new RegionServiceImpl();
        DataCenterService dataCenterService = new DataCenterServiceImpl();
        gameService = new GameServiceImpl(dataCenterService, regionService);
        gameModelSetUp();
    }

    @Test
    public void shouldCreateNewUser(){
        GameUser expected = new GameUser("Roman", new Address("vatutina,1", "Kiev"));

        GameUser result = gameService.addNewUser("Roman", getVatutina());

        assertEquals(expected, result);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerForNullUserName(){
        gameService.addNewUser(null, getVatutina());
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerNullAddress(){
        gameService.addNewUser("Roman", null);
    }

    @Test
    public void shouldGetUserDataCenterName() {
        GameUser roman = gameService.addNewUser("Roman", getVatutina());
        GameUser oleg = gameService.addNewUser("Oleg", getKievskaya());

        String expected = "User Roman play in datacenter: dataCenter1";

        String result = gameService.getUserDataCenter(roman, getSlots());

        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldTrowAnExceptionForNotExistingAddress() {
        GameUser roman = gameService.addNewUser("Roman", getNotExistingAddress());

        String result = gameService.getUserDataCenter(roman, getSlots());

        assertEquals("User don't play game", result);
    }
}