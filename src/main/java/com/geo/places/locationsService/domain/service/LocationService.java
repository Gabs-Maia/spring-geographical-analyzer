import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.geo.places.locationsService.api.LocationRequest;
import com.geo.places.locationsService.domain.dataTransfer.LocationDTO;
import com.geo.places.locationsService.domain.entities.Location;
import com.geo.places.locationsService.domain.repository.LocationRepository;
import com.geo.places.locationsService.domain.utils.queries.SetQuery;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class LocationService{

    private final LocationRepository repository;
    
    public LocationService(LocationRepository repository){
        this.repository = repository;
    }

    public Mono<Location> create( LocationRequest request){
        Location location = new Location(
            null, request.name(), request.city(), request.country(), null, null
            );

            return repository.save(location);
    }

    public Mono<Location> edit(Long id, LocationRequest request){

        return repository.findById(id)
            .map(location -> LocationDTO.updateLocationFromDTO(request, location))
            .flatMap(repository::save);
    }

    public Mono<Location> get(Long id){
        return repository.findById(id);
    } 

    public Flux<Location> list(String name){
        Location location = new Location(null, name, null, null, null, null);
        Example<Location> query = SetQuery.doQuery(location);
    
        return repository.findAll(query, Sort.by("name").ascending());
    }
}