package com.geo.places.locationsService.domain.dataTransfer;

import org.springframework.util.StringUtils;

import com.geo.places.locationsService.api.requests.BiomeRequest;
import com.geo.places.locationsService.api.requests.LocationRequest;
import com.geo.places.locationsService.api.responses.BiomeResponse;
import com.geo.places.locationsService.domain.entities.Biome;
import com.geo.places.locationsService.domain.entities.Location;

public class BiomeDTO {

    private static LocationRequest locationRequest;
   
    public static Biome updateBiomeFromDTO(BiomeRequest request, Biome biome){
        
        final String name = StringUtils.hasText(request.name()) ? request.name() : biome.name();
        final Location location = BiomeRequest.withValidatedLocation(locationRequest, biome.location()) != null 
                                ? BiomeRequest.withValidatedLocation(locationRequest, biome.location())
                                : biome.location();

        return new Biome(biome.id(), name, biome.lifeForms(), biome.species(), biome.climate(), location, biome.populationLevel());
    }

    public static BiomeResponse toResponse(Biome biome){

        return new BiomeResponse(biome.name(), biome.lifeForms(),biome.species(), biome.climate(), biome.location());
      }
}
