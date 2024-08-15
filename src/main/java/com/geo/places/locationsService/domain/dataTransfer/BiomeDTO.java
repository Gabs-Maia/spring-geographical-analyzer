package com.geo.places.locationsService.domain.dataTransfer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.StringUtils;

import com.geo.places.locationsService.api.requests.BiomeRequest;
import com.geo.places.locationsService.api.responses.BiomeResponse;
import com.geo.places.locationsService.domain.entities.Biome;
import com.geo.places.locationsService.domain.entities.EcoSystem;

public class BiomeDTO {
   
    public static Biome updateBiomeFromDTO(BiomeRequest request, Biome biome){
        
        final String name = StringUtils.hasText(request.name()) ? request.name() : biome.name();
        final Map<String, Float> = 
        
        return new Biome(biome.id(), name, biome.lifeForms(), );
    }

    //I need to get ecosystem out of the parameters...
    public Biome updateLifeForms(List<EcoSystem> ecoSystems, Biome biome) {
        List<String> updatedLifeForms = ecoSystems.stream()
            .flatMap(ecoSystem -> Stream.concat(
                ecoSystem.fauna().stream(), 
                ecoSystem.flora().stream()))
            .collect(Collectors.toUnmodifiableList());
        
        return new Biome(biome.id(), biome.name(), updatedLifeForms, biome.climate(), biome.ecoSystems(), biome.localization());
    }

    public static BiomeResponse toResponse(Biome biome){

        return new BiomeResponse(biome.name(), biome.lifeForms(),biome.species(), biome.climate(), biome.location());
      }
}
