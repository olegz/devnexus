# Day 2 Add Web Functionality To Your Function

This is a recipe that can be added to an existing project using Spring CLI to add web functionality to your app.

. . .
## Getting Started
Add the web feature to your existing project by executing the following line from your shell while in your project directory:
```shell
spring boot add --from  https://github.com/olegz/devnexus/tree/main/recipe-local-web

mvn clean package
java -jar target/my-app-0.0.1-SNAPSHOT.jar
 curl -X POST  -i localhost:8080/uppercase -d 'hello devnexus'

```

### Requirements:

* Java 17 or Above
