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

import com.geo.places.locationsService.api.LocationRequest;
import com.geo.places.locationsService.api.LocationResponse;
import com.geo.places.locationsService.domain.mappers.LocationDTO;
import com.geo.places.locationsService.domain.service.LocationService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/locations")
public class LocationController {
  @Autowired
  private LocationService LocationService;

  @PostMapping
  public ResponseEntity<Mono<LocationResponse>> create(@Valid @RequestBody LocationRequest request) {
    var LocationResponse = LocationService.create(request).map(LocationDTO::toResponse);
    return ResponseEntity.status(HttpStatus.CREATED).body(LocationResponse);
  }

  @PatchMapping("{id}")
  public Mono<LocationResponse> edit(@PathVariable("id") Long id, @RequestBody LocationRequest request) {
    return LocationService.edit(id, request).map(LocationDTO::toResponse);
  }

  @GetMapping("{id}")
  public Mono<ResponseEntity<LocationResponse>> get(@PathVariable("id") Long id) {
    return LocationService.get(id)
        .map(Location -> ResponseEntity.ok(LocationDTO.toResponse(Location)))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @GetMapping
  public Flux<LocationResponse> list(@RequestParam(required = false) String name) {
    return LocationService.list(name).map(LocationDTO::toResponse);
  }

}
