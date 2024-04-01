# Day 1 

Contains starting point for the development but with some code.




## Getting Started
Add the web feature to your existing project by executing the following line from your shell while in your project directory:
```shell
spring boot add --from  https://github.com/olegz/devnexus/tree/main/demo-function-web
```

### Requirements:

* Java 17 or Above

### Build:
```
mvn clean package
```

### Run:
```
java -jar target/demo-function-web-0.0.1-SNAPSHOT.jar
```

#### Send Sample Data
```
curl -X POST  -i -H "Accept: application/json" localhost:8080/placeOrder -d '{"id": "foo","description":"fooproduct","date":"2024-03-03"}'
```