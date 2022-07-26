# Store Square Shape
Pupil Coding Test for Backend Java Engineer

In this coding test, we would like you to create a RESTful API service for a simple shape repository. 
UI is not required.

A shape consists of a Type, a Name and a Geometry Descriptor.

For the sake of simplicity, we only require you to implement the ability to store a SquareShape. 
A Square is axis-aligned, not rotated.

The result of this activity should:
- expose an endpoint to store a new shape    
- expose an endpoint to retrieve all stored shapes

The repository should enforce that:
- all shapes have unique names    
- no stored shape overlaps any other stored shapes

 We are looking for:
- clear and concise code layout    
- consistent api responses    
- good test coverage

You can store the data into any type of database you wish, but it should not require anactual database server instance running in the target machine.

 If you would like to use a project dependency management tool(e.g. Gradle, Maven), theapplication should run without it installed in the target machine.

* The project should contain all resources to run the application.

* Please use at least Java 8 or Kotlin

# Running Spring Boot Application
We can run the spring boot application using the following maven command:

'mvn spring-boot:run'

We configured the H2 Web Console to be accessible via the /console path. 
When accessing the console via :

http://localhost:8080/console.
















































































































































































































































































































































