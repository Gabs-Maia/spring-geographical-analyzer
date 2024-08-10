package com.geo.places.locationsService.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.geo.places.locationsService.api.requests.LocationRequest;
import com.geo.places.locationsService.domain.dataTransfer.LocationDTO;
import com.geo.places.locationsService.domain.entities.Location;
import com.geo.places.locationsService.domain.repository.LocationRepository;
import com.geo.places.locationsService.domain.utils.queries.SetQuery;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LocationService{

    @Autowired private final LocationRepository locationRepository;
    
    public LocationService(LocationRepository locationRepository){this.locationRepository = locationRepository;}

    public Mono<Location>  create(LocationRequest request){
        Location Location  = new Location(null, request.name(), request.city(),  request.country(), request.population(), null, null, null);
        return locationRepository.save(Location);
    }

    public Mono<Location> update(Long id, LocationRequest request){
        return locationRepository.findById(id).map(location -> LocationDTO.updateLocationFromDTO(request, location))
                                              .flatMap(locationRepository::save);
    }

    public Mono<Location> read(Long id){
        return locationRepository.findById(id);
    }

    public Flux<Location> list(String name){
        Location location = new Location(null, name, null,null,null,null,null,null);
        Example<Location> query = SetQuery.doLocationQuery(location);

        return locationRepository.findAll(query, Sort.by("name").ascending());
    }

    public Mono<Void> deleteAll(){return locationRepository.deleteAll();}
}