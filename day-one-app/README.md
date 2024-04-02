# Day 1: Getting Started

This is a recipe which contains starting point for the development of a Spring Boot application.
It contains only initial Spring Boot dependencies and initial code developed as `java.util.Function` as well as the initial test.

The intention of this recipe is to help you get started with developing and testing functionality of your use case without 
worrying about how this functionality will be invoked (triggered).

The initial code is structured based on the best practices of developing Spring Boot application.

### Contents:
- **Application.java** - The main application class which only contains main method and `@SpringBootApplication` annotation.

- **FunctionConfiguration.java** - the `@Configuration` class containing Spring components (i.e., `@Bean`)  

### Usage: (using Spring CLI)

```
   spring boot new my-app https://github.com/olegz/devnexus/tree/main/day-one-app
   cd my-app
   ./mvnw clean install
```



* Java 17 or Above

### Build:
```
mvn clean package
```

### Run:
```
java -jar target/my-app-0.0.1-SNAPSHOT.jar
```

You can now import the project into your IDE and begin development
