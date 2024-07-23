package com.geo.places.locationsService.api;

import jakarta.validation.constraints.NotBlank;

public record LocationRequest(
    @NotBlank String name,
    @NotBlank String city,
    @NotBlank String country
) {
}
