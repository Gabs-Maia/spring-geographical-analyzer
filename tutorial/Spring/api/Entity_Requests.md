## Why do i need to represent the handling of API Requests and Responses ?

One of the primary functions of an API is to handle both requests and responses. In this context, we aim to represent the requests that a user can make. This object will serve as a parameter for various processes, particularly when editing data.

This simple yet crucial abstraction aids in managing requests effectively. By providing a tangible representation of a request it is possible to use some of its features in transactional procedures, such as the definition of a Data Transfer Objects (DTOs), for example.

Have explained the core idea behind this decision, we'll define requests representations for each entity.

Different from most projects a class won't be used for this task.

```java
public record BiomeRequest(  
    @NotBlank String name,
    @NotBlank Location location    
){

    public static Location withValidatedLocation(LocationRequest request, Location location){
        final Location validLocation = LocationDTO.updateLocationFromDTO(request, location) != null ? LocationDTO.updateLocationFromDTO(request, location) : location;
        return validLocation;
    }
}
``` 

Introduced in Java 14, `records` are immutable data carriers that automatically generate boilerplate code like constructors, getters, `equals()`, `hashCode()`, and `toString()` methods.

The method defined in the record is used to validate user data. This can help prevent null objects and improper data.