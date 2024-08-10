package com.geo.places.locationsService.domain.utils.queries;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.geo.places.locationsService.domain.entities.Biome;
import com.geo.places.locationsService.domain.entities.Location;

public class SetQuery {
    
    private SetQuery(){
    }

    public static Example<Location> doLocationQuery(Location location){

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreNullValues();
        return Example.of(location, exampleMatcher);
    }

    public static Example<Biome> doBiomeQuery(Biome biome){

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreNullValues();
        return Example.of(biome, exampleMatcher);
    }
}
