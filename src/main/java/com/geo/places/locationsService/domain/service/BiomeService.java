package com.geo.places.locationsService.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.geo.places.locationsService.api.requests.BiomeRequest;
import com.geo.places.locationsService.domain.dataTransfer.BiomeDTO;
import com.geo.places.locationsService.domain.entities.Biome;
import com.geo.places.locationsService.domain.entities.EcoSystem;
import com.geo.places.locationsService.domain.repository.BiomeRepository;
import com.geo.places.locationsService.domain.utils.queries.SetQuery;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BiomeService {
    
    @Autowired private final BiomeRepository biomeRepository;

    public BiomeService(BiomeRepository biomeRepository){ this.biomeRepository = biomeRepository;}

    public Mono<Biome> create(BiomeRequest request){
        Biome Biome = new Biome(null, request.name(),null,null,null,null);
        return biomeRepository.save(Biome);
    }
    
    public Mono<Biome> update(Long id, BiomeRequest request){

        return biomeRepository.findById(id)
                .map(biome -> BiomeDTO.updateBiomeFromDTO(request, biome))
                .flatMap(biomeRepository::save);
    }

    public Mono<Biome> read(Long id){return biomeRepository.findById(id);}
    public Flux<EcoSystem> listByLifeForms(String name){
        biomeRepository.findAll()
                       .filter(biome -> biome.);
    }
    
    public Flux<Biome> list(String name){
        Biome biome = new Biome(null, name, null, null,null,null);
        Example<Biome> query = SetQuery.doBiomeQuery(biome);
        return biomeRepository.findAll(query, Sort.by("name").ascending());
    }

    public Mono<Void> deleteAll(){return biomeRepository.deleteAll();}
}
