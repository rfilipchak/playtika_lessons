package com.example.rfilipchak.regionservice;

import com.example.rfilipchak.domain.Region;
import com.example.rfilipchak.testcommon.TestCommon;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class RegionServiceImplTest extends TestCommon {

    private RegionService regionService;

    @Before
    public void init() {
        regionService = new RegionServiceImpl();
        gameModelSetUp();
    }

    @Test
    public void getRegionByCityName() {
        String kiev = "Kiev";
        Region expected = new Region("Kievskiy", new HashSet<>());
        expected.getCitySet().add(getKiev());

        Optional<Region> result = regionService.getRegionByCityName(kiev, getRegions());

        assertEquals(Optional.of(expected), result);
    }

    @Test
    public void shouldReturnEmptyRegionIfNotExist(){
        String konotop = "Konotop";

        Optional<Region> result = regionService.getRegionByCityName(konotop, getRegions());

        assertEquals(Optional.empty(), result);
    }

    @Test
    public void shouldReturnEmptyRegionForNull(){
        Optional<Region> result = regionService.getRegionByCityName(null, getRegions());

        assertEquals(Optional.empty(), result);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerForNullRegionSet(){
        regionService.getRegionByCityName("Kiev", null);
    }
}