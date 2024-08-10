package com.geo.places.locationsService.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geo.places.locationsService.api.requests.LocationRequest;
import com.geo.places.locationsService.api.responses.LocationResponse;
import com.geo.places.locationsService.domain.dataTransfer.LocationDTO;
import com.geo.places.locationsService.domain.service.LocationService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/locations")
public class LocationController{

    @Autowired private LocationService locationService;

    @PostMapping public ResponseEntity<Mono<LocationResponse>> create(@Valid @RequestBody LocationRequest request){
        
        Mono<LocationResponse> locationResponse = locationService.create(request).map(LocationDTO::toReponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(locationResponse);
    }

    @PatchMapping("{id}") public Mono<LocationResponse> edit(@PathVariable("id") Long id, @RequestBody LocationRequest request){
           return locationService.update(id, request).map(LocationDTO::toReponse);
    }

    @GetMapping("{id}") public Mono<ResponseEntity<LocationResponse>> read(@PathVariable("id") Long id){
        return locationService.read(id).map(l -> ResponseEntity.ok(LocationDTO.toReponse(l)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping public Flux<LocationResponse> list(@RequestParam(required = false) String name){
        return locationService.list(name).map(LocationDTO::toReponse);
    }

}