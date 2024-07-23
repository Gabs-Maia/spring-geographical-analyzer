package com.geo.places.locationsService.api;

import java.time.LocalDateTime;

public record LocationResponse(
    String name, String city, String country, LocalDateTime createdAt, LocalDateTime updatedAt
) {
}
