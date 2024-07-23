package com.geo.places.locationsService.domain.mappers;

import org.springframework.util.StringUtils;

import com.geo.places.locationsService.api.LocationRequest;
import com.geo.places.locationsService.api.LocationResponse;
import com.geo.places.locationsService.domain.entities.Location;

public class LocationDTO {
    
    public static Location updateLocationFromDTO(LocationRequest placeRequest, Location location) {
        String name = getValueOrDefault(placeRequest.name(), location.name());
        String city = getValueOrDefault(placeRequest.city(), location.city());
        String country = getValueOrDefault(placeRequest.country(), location.country());
        return new Location(location.id(), name, city, country, location.createdAt(), location.updatedAt());
    }

    private static String getValueOrDefault(String newValue, String defaultValue) {
        return StringUtils.hasText(newValue) ? newValue : defaultValue;
    }

    public static LocationResponse toResponse(Location location) {
        return new LocationResponse(
            location.name(), 
            location.city(), 
            location.country(), 
            location.createdAt(), 
            location.updatedAt()
        );
    }
}
