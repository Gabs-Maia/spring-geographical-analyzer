package com.geo.places.locationsService.domain.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;

public record Biome(
    @Id Long id,
    @NotBlank String name,
    List<String> lifeForms,
    List<String>  species, 
    String climate,  
    @NotBlank Location location,
    Float populationLevel
){}
