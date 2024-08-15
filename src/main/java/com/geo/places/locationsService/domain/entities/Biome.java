package com.geo.places.locationsService.domain.entities;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;

public record Biome(
    @Id Long id,
    @NotBlank String name,
    List<String> lifeForms,
    Map<String, Float> climate,  
    List<EcoSystem> ecoSystems, // Known ecosystems in the biome.
    @NotBlank List<String> localization //Deriving the total area from all ecosystems.
){}
