package com.geo.places.locationsService.domain.repository;


import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.geo.places.locationsService.domain.entities.Location;

@Repository
public interface LocationRepository extends ReactiveCrudRepository<Location, Long>, ReactiveQueryByExampleExecutor<Location> {

    public LocationRepository findAll(Sort ascending);

}