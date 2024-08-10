package com.geo.places.locationsService.api.requests;

import jakarta.validation.constraints.NotBlank;

public record LocationRequest(
    @NotBlank String name,
    @NotBlank String city,
    @NotBlank String country,
    Float population,
    @NotBlank String[] languages
) {
}
