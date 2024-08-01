package com.geo.places.locationsService.domain.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.validation.constraints.NotBlank;

public record Location(
    @Id Long id, 
    @NotBlank String name, 
    @NotBlank String city,
    @NotBlank String country,
    @CreatedDate LocalDateTime createdAt,
    @LastModifiedDate LocalDateTime updatedAt){
  
        
    public Location withSlug(String slug){
        
        return new Location(id, name, city, country, createdAt, updatedAt);
    }
}
