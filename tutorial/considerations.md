
This API is a simple exercise on some concepts introduced in Java 17 onwards in addition to some old features.

- Streams
- Funcational interface
- Lambda expressions
- Records and Sealed classes/interfaces
- More ways to excercise immutability

This is very important to understand. The power we have over state can heavily influence the way our applications are built. 

With less code i'm able to express this API the way it is intended to be, a data-carrier for informations that do not change that often. Ecological systems, geographic locations and biomes do change, but in a time scale so different than ours that allows for this change to be disregarded and treated as immutable. 

In this context, Records are a very powerful tool. It allows for automatic accessors creation, constructors, compact-constructors and utility tools, such as `equals()` and `hashCode()`. 

Streams are used because I planned this API to be Reactive and Asynchronous. I still do not have the skills to build a async parallel API, but soon this won't be the case and this project will be fully updated.

## BEGINNER MISTAKES:

Because I lack the proper understanding of how Java works, some errors were made. I would like to adress them.

- I don't need to create multiple files for different bean-configurations.

    yes! you only need one class where each bean will be configured as a method. Simple...

- Groovy is awesome when you understand it. But the ecosystem died years ago, so I would need even more time to learn it. A bigger ecosystem can powerstart your learnign more than you think.

- 

- Some annotations, obviously, can only appear once. R2Dbc audit annotation, for example, can only be defined once.

    I still don't understand why this happens. I need to check it's implementation. And the docs, of course...

