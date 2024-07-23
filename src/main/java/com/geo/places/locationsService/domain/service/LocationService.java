package com.geo.places.locationsService.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.geo.places.locationsService.api.LocationRequest;
import com.geo.places.locationsService.domain.entities.Location;
import com.geo.places.locationsService.domain.mappers.LocationDTO;
import com.geo.places.locationsService.domain.repository.LocationRepository;
import com.geo.places.locationsService.domain.utils.queries.SetQuery;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LocationService {

    @Autowired
    private final LocationRepository locationRepository;
    
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
      }
    
    public Mono<Location> create(LocationRequest locationRequest){

        Location location = new Location(
                
            null, locationRequest.name(), locationRequest.city(), locationRequest.country(), null, null);

        return locationRepository.save(location);
    }

    public Mono<Location> edit(Long id, LocationRequest locationRequest){

        return locationRepository.findById(id)  
            .map(location -> LocationDTO.updateLocationFromDTO(locationRequest, location))
            .flatMap(locationRepository::save);
    }

    public Mono<Location> get(Long id){ 

        Mono<Location> location = locationRepository.findById(id); 
        return location;
    }

    public Flux<Location> list(String name){

        Location location = new Location(null, name, null, null, null, null);
        Example<Location> query = SetQuery.doQuery(location);
        Flux<Location> fromRepository = locationRepository.findAll(query, Sort.by("name").ascending());
        
        return fromRepository;
    }
}
