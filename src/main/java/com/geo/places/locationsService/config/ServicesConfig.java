package com.geo.places.locationsService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.geo.places.locationsService.domain.repository.BiomeRepository;
import com.geo.places.locationsService.domain.repository.LocationRepository;
import com.geo.places.locationsService.domain.service.BiomeService;
import com.geo.places.locationsService.domain.service.LocationService;

@Configuration
public class ServicesConfig {

    @Bean LocationService locationService(LocationRepository locationRepository){

        return new LocationService(locationRepository);
    }
    
    @Bean BiomeService biomeService(BiomeRepository biomeRepository){

        return new BiomeService(biomeRepository);
    }


}
