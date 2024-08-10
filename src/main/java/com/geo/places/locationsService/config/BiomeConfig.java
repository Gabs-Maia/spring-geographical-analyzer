package com.geo.places.locationsService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import com.geo.places.locationsService.domain.repository.BiomeRepository;
import com.geo.places.locationsService.domain.service.BiomeService;

@Configuration
@EnableR2dbcAuditing
public class BiomeConfig {
    
    @Bean BiomeService biomeService(BiomeRepository biomeRepository){

        return new BiomeService(biomeRepository);
    }
}
