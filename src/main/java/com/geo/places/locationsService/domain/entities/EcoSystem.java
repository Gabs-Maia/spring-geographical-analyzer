package com.geo.places.locationsService.domain.entities;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;

public record EcoSystem(
    @Id Long id,
    @NotBlank String name,
    List<Location> localization,
    List<String> flora,
    List<String> fauna,
    Map<String, Float> climate, // general climate type.
    Float s_temperature, // specific temperature on a given time. 
    Float m_population 
){}