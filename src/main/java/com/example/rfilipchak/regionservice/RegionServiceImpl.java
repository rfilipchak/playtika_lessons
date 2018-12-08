package com.example.rfilipchak.regionservice;

import com.example.rfilipchak.domain.Region;
import com.example.rfilipchak.servicecommon.Pair;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class RegionServiceImpl implements RegionService {

    @Override
    public Optional<Region> getRegionByCityName( String cityName, @NonNull Set<Region> regions) {

        Map<String, Region> collect = regions.stream()
                                             .flatMap(region -> region.getCitySet()
                                                                      .stream()
                                                                      .map(city -> new Pair<>(city.getCityName(), region)))
                                             .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        if (collect.keySet().contains(cityName)) {
            return Optional.of(collect.get(cityName));
        }
        return Optional.empty();
    }
}
