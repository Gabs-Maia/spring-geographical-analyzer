package com.geo.places.locationsService.api.requests;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record BiomeRequest(  
    @NotBlank String name,
    List<String> lifeForms

){}