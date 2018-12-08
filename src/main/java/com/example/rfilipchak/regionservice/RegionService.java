package com.example.rfilipchak.regionservice;

import com.example.rfilipchak.domain.Region;

import java.util.Optional;
import java.util.Set;

public interface RegionService {
    Optional<Region> getRegionByCityName(String cityName, Set<Region> regions);
}
