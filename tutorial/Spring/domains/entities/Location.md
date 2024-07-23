# VOCABULARY:

```java

public record Location(
    @Id Location id, 
    @NotBlank String name, 
    String slug,
    @NotBlank String city,
    @NotBlank String state,
    @CreatedDate LocalDateTime createdAt,
    @LastModifiedDate LocalDateTime updatedAt){...}
  
```


```java
   public Location withSlug(String slug){
        return new Location(id, name, slug, city, state, createdAt, updatedAt);
    }

```