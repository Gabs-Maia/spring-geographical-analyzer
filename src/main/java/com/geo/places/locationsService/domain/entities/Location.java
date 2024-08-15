
package com.geo.places.locationsService.domain.entities;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;

public record Location(
    @Id Long id, 
    @NotBlank String name, 
    String city,
    String country,
    @NotBlank String continent,
    @NotBlank String globeRegion, 
    @NotBlank Float population,
    @NotBlank List<String> natLanguages, // for non-human communication.
    List<String> humanLanguages
){}