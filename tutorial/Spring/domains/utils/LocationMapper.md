 ## WHAT DOES THE CODE DO?

`LocationMapper` ->> A utility class for mapping between different data representations (`LocationRequest`, `Location`, and `LocationResponse`).
- `updateLocationFromDTO` ->> Updates a `Location` object with data from a `LocationRequest`, ensuring non-empty fields are used.
- `toResponse` ->> Converts a `Location` object into a `LocationResponse` for API responses.
<br><br>
- It imports `StringUtils` from Spring Framework and two custom classes, `LocationRequest` and `LocationResponse`. <br> <br>

> Class: `LocationMapper`
This class contains static methods to map data between `LocationRequest`, `Location`, and `LocationResponse` objects.<br>
<br>

```java
//JAVA


public static Location updateLocationFromDTO(LocationRequest LocationRequest, Location Location) {
    final String name = StringUtils.hasText(LocationRequest.name()) ? LocationRequest.name() : Location.name();
    final String city = StringUtils.hasText(LocationRequest.city()) ? LocationRequest.city() : Location.city();
    final String state = StringUtils.hasText(LocationRequest.state()) ? LocationRequest.state() : Location.state();
    return new Location(Location.id(), name, Location.slug(), city, state, Location.createdAt(), Location.updatedAt());
}


```

This method will update a `Location` object using data from a `LocationRequest` object.<br>
>  It checks if the `name`, `city`, and `state` fields in `LocationRequest` are non-empty using `StringUtils.hasText()`.

- If a field in `LocationRequest` is non-empty, it uses that value; otherwise, it retains the existing value from the `Location` object.
- It returns a new `Location` object with the updated values.


```java
//JAVA

public static LocationResponse toResponse(Location Location) {
    return new LocationResponse(Location.name(), Location.slug(), Location.city(), Location.state(), Location.createdAt(), Location.updatedAt());
}


```
- This will convert a `Location` object into a `LocationResponse` object.

- It creates and returns a new `LocationResponse` object using the values from the `Location` object.



