package com.geo.places.locationsService.api.responses;

import java.time.LocalDateTime;
import java.util.List;

public record LocationResponse(
    String name, String city, String country,Float population, List<String> languages,LocalDateTime createdAt, LocalDateTime updatedAt
) {
}
