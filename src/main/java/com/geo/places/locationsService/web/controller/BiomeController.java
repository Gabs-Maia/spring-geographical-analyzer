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

import com.geo.places.locationsService.api.requests.BiomeRequest;
import com.geo.places.locationsService.api.responses.BiomeResponse;
import com.geo.places.locationsService.domain.dataTransfer.BiomeDTO;
import com.geo.places.locationsService.domain.service.BiomeService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/biomes")
public class BiomeController {
    
    @Autowired public BiomeService biomeService;

    @PostMapping public ResponseEntity<Mono<BiomeResponse>> create(@Valid @RequestBody BiomeRequest request){
        Mono<BiomeResponse> biomeResponse = biomeService.create(request).map(biome -> BiomeDTO.toResponse(biome));
        return ResponseEntity.status(HttpStatus.CREATED).body(biomeResponse);
    }

    @PatchMapping("{id}") public Mono<BiomeResponse> update(@PathVariable("id") Long id, @RequestBody BiomeRequest request){
        return biomeService.update(id, request).map(BiomeDTO::toResponse);
    }

    @GetMapping("{id}") public Mono<ResponseEntity<BiomeResponse>> read(@PathVariable("id") Long id){
        return biomeService.read(id).map(biome -> ResponseEntity.ok(BiomeDTO.toResponse(biome)))
        .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping public Flux<BiomeResponse> list(@RequestParam(required=false) String name){
        return biomeService.list(name).map(BiomeDTO::toResponse);
    }
}
