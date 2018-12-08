package com.example.rfilipchak.datacenterservice;

import com.example.rfilipchak.domain.DataCenter;
import com.example.rfilipchak.domain.Region;
import com.example.rfilipchak.servicecommon.Pair;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class DataCenterServiceImpl implements DataCenterService {

    @Override
    public Map<Region, DataCenter> getDataCenterRegions(@NonNull Set<DataCenter> dataCenters) {
        return dataCenters.stream().flatMap(dataCenter -> dataCenter.getRegions().stream().map(region -> new Pair<>(region, dataCenter)))
                          .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
    }
}
