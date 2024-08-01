package com.geo.places.locationsService.domain.dataTransfer;

import org.springframework.util.StringUtils;

import com.geo.places.locationsService.api.LocationRequest;
import com.geo.places.locationsService.api.LocationResponse;
import com.geo.places.locationsService.domain.entities.Location;

public class LocationDTO {
    
    public static Location updateLocationFromDTO( LocationRequest request, Location location){

        final String name = StringUtils.hasText(request.name()) ? request.name() : location.name();
        final String city = StringUtils.hasText(request.city()) ? request.city() : location.city();
        final String country = StringUtils.hasText(request.country()) ? request.country() : location.country();
        
        return new Location(location.id(), name, city, country, location.createdAt(), location.updatedAt());
    }

    public static LocationResponse  toReponse(Location location){ 

        return new LocationResponse(location.name(), location.city(), location.country() , location.createdAt(), location.updatedAt());
    }
}