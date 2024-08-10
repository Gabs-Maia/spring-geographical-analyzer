package com.geo.places.locationsService.domain.dataTransfer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.geo.places.locationsService.api.requests.LocationRequest;
import com.geo.places.locationsService.api.responses.LocationResponse;
import com.geo.places.locationsService.domain.entities.Location;

public class LocationDTO {
    
    public static Location updateLocationFromDTO( LocationRequest request, Location location){

        final String name = StringUtils.hasText(request.name()) ? request.name() : location.name();
        final String city = StringUtils.hasText(request.city()) ? request.city() : location.city();
        final String country = StringUtils.hasText(request.country()) ? request.country() : location.country();
        final List<String> listLanguages = Arrays.asList(request.languages()).stream()
                                            .map(lang -> StringUtils.hasText(lang) ? lang : "langNull")
                                            .collect(Collectors.toList());
        
        return new Location(location.id(), name, city, country, location.population(), listLanguages , location.createdAt(), location.updatedAt());
    }

    public static LocationResponse  toReponse(Location location){ 

        return new LocationResponse(location.name(), location.city(), location.country() ,location.population(), location.languages(), location.createdAt(), location.updatedAt());
    }
}