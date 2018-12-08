package com.example.rfilipchak.datacenterservice;

import com.example.rfilipchak.domain.DataCenter;
import com.example.rfilipchak.domain.Region;
import com.example.rfilipchak.testcommon.TestCommon;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DataCenterServiceImplTest extends TestCommon {

    private DataCenterService dataCenterService;

    @Before
    public void init() {
        dataCenterService = new DataCenterServiceImpl();
        gameModelSetUp();
    }

    @Test
    public void getDataCenterRegions() {
        Map<Region, DataCenter> expected = new HashMap<>();
        expected.put(getKievskiy(),getDataCenter1());

        Set<DataCenter> dataCenter1 = new HashSet<>();
        dataCenter1.add(getDataCenter1());

        Map<Region, DataCenter> result = dataCenterService.getDataCenterRegions(dataCenter1);

        assertEquals(expected, result);
    }
}