package com.geo.places.locationsService.api.requests;

import com.geo.places.locationsService.domain.dataTransfer.LocationDTO;
import com.geo.places.locationsService.domain.entities.Location;

import jakarta.validation.constraints.NotBlank;

public record BiomeRequest(  
    @NotBlank String name,
    @NotBlank Location location    
){

    public static Location withValidatedLocation(LocationRequest request, Location location){
        final Location validLocation = LocationDTO.updateLocationFromDTO(request, location) != null ? LocationDTO.updateLocationFromDTO(request, location) : location;
        return validLocation;
    }
}