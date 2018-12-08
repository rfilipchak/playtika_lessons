package com.example.rfilipchak.datacenterservice;

import com.example.rfilipchak.domain.DataCenter;
import com.example.rfilipchak.domain.Region;

import java.util.Map;
import java.util.Set;

public interface DataCenterService {
    Map<Region, DataCenter > getDataCenterRegions(Set<DataCenter> dataCenters);
}
