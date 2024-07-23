## WHAT DOES THIS CLASS DO?
This `LocationService` class provides methods to create, edit, get, and list `Location` objects using a `LocationRepository ` and a Slugify instance for generating slugs. It uses reactive types (Mono and Flux) for asynchronous operations.

This is a part of the model. It is responsible for the service layer... behavioral aspects of the class. 

The fields in this class are composed by a `Repository` representation (Location, in this case!) and by a `Slugfy` object. 
```java

public class LocationService {
  private LocationRepository LocationRepository;
  private Slugify slg;


```
Class constructor. `Repository`, here, will be the parameter, 
```java


  public LocationService(LocationRepository LocationRepository) {
    this.LocationRepository = LocationRepository;
    this.slg = Slugify.builder().build();
  }


```

### Starting the Crud operation creation:

Here is the first and most important operation of the structure, create. In Java, specially when talking about Services, a method is composed by the model's repository. This is done because it is through the repository that data-management operations are performed. (This is a design pattern of OOP, not the general rule!)
- A instantiation of a `Location` object.
- Saves the object through `Repository` operations.
- Returns a `Mono` object

```java


  public Mono<Location> create(LocationRequest LocationRequest) {
    var Location = new Location(
        null, LocationRequest.name(), slg.slugify(LocationRequest.name()),
        LocationRequest.city(), LocationRequest.state(), null, null);
    return LocationRepository.save(Location);
  }


```
A method created to modify an object (update) that is inside the data-base. It is important to notice that some operations are only being done because of the procedure's natures, which, in this case, in asynchronous. Structure flattning and mappings are widely used. 
<br>
- Return an object found by its id.
- Use a `DTO` and a `.map()`operation in order to modify the object `Location` using the data coming from a request.
- Slugfying data.
- Finally, flat the object for better manipulation. This is way it is a proper `Mono` object.
- Save the object.

```java


  public Mono<Location> edit(Long id, LocationRequest LocationRequest) {
    return LocationRepository.findById(id)
        .map(Location -> LocationMapper.updateLocationFromDTO(LocationRequest, Location))
        .map(Location -> Location.withSlug(slg.slugify(Location.name())))
        .flatMap(LocationRepository::save);
  }


``` 

A method to fetch data from the data-base. (read operation)
- Find an object by its id.
- Returns a `Mono` object.

```java 


  public Mono<Location> get(Long id) {
    return LocationRepository.findById(id);
  }

```

Find all `Location` objects that are present in the data-base. Different from the other methods, this one returns a `Flux` object. (async)
- Construct a `Location` object
- Make a query using the utility `QueryBuilder`
- returns a `Flux` object that contains the objects we want, in ascending order. 
- Because we have multiple objects returned, `Flux` is used. (represents 0 to N recieved elements
)
```java


  public Flux<Location> list(String name) {
    var Location = new Location(null, name, null, null, null, null, null);
    Example<Location> query = QueryBuilder.makeQuery(Location);
    return LocationRepository.findAll(query, Sort.by("name").ascending());
  }
}


```