## EXPLANATION OF THINGS:

As you probably already know at this point, a controller is, basically, a coordinator of resquests/response that "stands" between the model and the view layers of the application. This is how you map certain actions into certain URIs patterns. 

- `@RestController`: This annotation is a combination of `@Controller` and `@RespopnseBody`. It allows you to recieve data directly in the HTPP response body. You also do not need to state `@ResponseBody` for every method.
- `@RequestMapping`: This will map web requests to a specific handler. Any other url declared by `@GetMapping("/pages")`, for example, will be a sub-string of it. (ex: locations/pages) 
- `@Autowired`: This is part of the Spring's dependency injection frame-work. Allows for automatic injection. 

```java
@RestController
@RequestMapping("/locations")
public class LocationController {

  @Autowired
  private LocationService LocationService;
```

## UNDERSTANDING CONTROLLER METHODS:

In here we'll use the service layer to implement all needed functionalities. The controllet will wrap the model's service logic with a 'client-server' logic; it will construct a way of handling requests/responses regardign the structure of the model's data. 

- `@PostMapping`: It indicates to Spring that this method will be similar to a 'POST' HTTP verb. 
- `@Valid` and `@RequestBody`: Validates and binds the request body to a LocationRequest object.

- Construct data by using information from a request then maps the result to a LocationResponse.

Returns a HTTP status code (200) and the `reponse` body.

```java


  @PostMapping
  public ResponseEntity<Mono<LocationResponse>> create(@Valid @RequestBody LocationRequest request) {
    var LocationResponse = LocationService.create(request).map(LocationDTO::toResponse);
    return ResponseEntity.status(HttpStatus.CREATED).body(LocationResponse);
  }

```

- `@PatchMapping`: defined the method as smthg similar to a HTPP "patch" verb. 
- `@PathVariable`: 

```java

  @PatchMapping("{id}")
  public Mono<LocationResponse> edit(@PathVariable("id") Long id, @RequestBody LocationRequest request) {
    return LocationService.edit(id, request).map(LocationDTO::toResponse);
  }

```


```java
 @GetMapping("{id}")
  public Mono<ResponseEntity<LocationResponse>> get(@PathVariable("id") Long id) {
    return LocationService.get(id)
        .map(Location -> ResponseEntity.ok(LocationDTO.toResponse(Location)))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
```


```java
 @GetMapping
  public Flux<LocationResponse> list(@RequestParam(required = false) String name) {
    return LocationService.list(name).map(LocationDTO::toResponse);
  }

}
```