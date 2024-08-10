package com.geo.places.locationsService.api.responses;

import java.util.List;

import com.geo.places.locationsService.domain.entities.Location;

public record BiomeResponse(
    String name,
    List<String> lifeForms,
    List<String> species, 
    String climate,  
    Location location
){}