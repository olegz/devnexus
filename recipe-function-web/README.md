# Day 2: Add WEB functionality to your function

This is a recipe which contains necessary bits to add functionality to expose function as an HTTP endpoint

It contains necessary dependencies to use Spring Cloud Function project to expose Function Bean as an HTTP endpoint.
It also contains a sample test case which will test your function as an HTTP endpoint.

While this recipe does not require any additional configuration you can get more information about using Spring Cloud Function web support [here](https://docs.spring.io/spring-cloud-function/docs/current/reference/html/spring-cloud-function.html#_standalone_web_applications).


### Contents:

- **pom.xml** - contains all the necessary dependency and will be merged automatically using Spring CLI

### Usage:
 
```
   spring boot add https://github.com/olegz/devnexus/tree/main/recipe-function-web
   ./mvnw clean install
   java -jar target/my-app-0.0.1-SNAPSHOT.jar
   curl -H  'Content-Type: application/json' -X POST http://localhost:8080/uppercase -d '"hello"'
```
