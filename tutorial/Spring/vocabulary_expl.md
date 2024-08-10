
-`Mono<>` : An implementations of the `Publisher` interface. Part of the Reactive library of Spring.
It allows you to represents single values, but also no values, making it useful for scenarios where you'd need a value or nothing at all. 

-`Flux<>` : Also an implementation of the `Publishe`interface. Allows you to generate values from (0 to N) possible values. It suits really well, contexts that deals with multiple responses but in an asynchronous procedure. It resembles a stream of values. 

-`.map()` : In the context of Streams, the .map() method is used to convert each individual element into the desired product. In the case of Mono and Flux, .map() can be heavily used.

Flating a data-structure means that a multi-dimension data-strcuture is made into a single-structure, single dimension, new, data-structure. This is used in order to make data-strcuture manipulation easier. 

- `.flatMap()` : In te context of Streams and Reactive programming this method does lamost the same as the stated above. It turns stream variables into single-structures, flatten, data. It converts each element of the stream, it flats it, chain everything together, flattening the structure in the process. 

### WHAT IS REACTIVE PROGRAMMING AND SYSTEMS.

Reactive programming is a programming paradigm where the focus is on developing asynchronous and non-blocking components. The core of reactive programming is a data stream that we can observe and react to, and even apply back pressure to as well. This leads to non-blocking execution, and better scalability with fewer threads of execution.

### WHAT ARE REACTIVE TYPES IN THIS CONTEXT?

In the context of Java/Spring, reactive types are data-types that allows and follows the patterns of Reactive Programming, allowing for asynchronous non-blocking procedures. 

org.springframework.beans.factory.support.BeanDefinitionOverrideException
define the same types everywhere!!!!