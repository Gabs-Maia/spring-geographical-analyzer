package com.geo.places.locationsService.api.responses;
import java.util.List;

public record LocationResponse(
    String name,
    String city, 
    String country,
    Float population, 
    List<String> languages
    ){}