## WHAT IS A REPOSITORY?

Repositories are a data-layer implemented in most web applications in order to facilitate transactions and CRUD operations. In the case of Spring/Java, the framework allows you to define and implement a repository in just a few lines of code by creating and `interface` and extending certain conventional spring-made repositories. At the end, in Spring, at least, repositories are made by using semantical markers and annotations, such as the `@Repository` annotation.

## EXPLAINING THE CODE:

- `@Repository`: This will mark the interface as a Spring-Data repository. (remember this, it is important!)
- `ReactiveCrudRepository<Location, Long>`: Provides CRUD operations for Reactive applications. Uses Project Reactor types which are built on top of Reactive Streams.
- `ReactiveQueryByExampleExecutor<Location>`: A querying technique where you provide an example entity with populated fields, and the framework constructs a query based on the non-null properties of this example entity. 


```java
@Repository
public interface LocationRepository extends ReactiveCrudRepository<Location, Long>, ReactiveQueryByExampleExecutor<Location> {

    public LocationRepository findAll(Sort ascending);

}
```

The interface also defines a method `findAll()` that must be later implemented. With this, it's possible to access data/information related to a given Location. 