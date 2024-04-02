# Basic Kafka Consumer that is built using Spring Cloud Stream 

This sample provides the sample project from which you can build a simple Spring Cloud Function app that can print the message from a Kafka topic to console.

## Getting Started
Create the project using the day-one-app recipe by executing the following line from your shell:

```shell
spring boot new my-consumer https://github.com/olegz/main/tree/main/basic-stream-consumer
cd my-consumer
```

### Requirements:

* Java 17 or Above

### Build:
```
mvn clean package
```

### Run:
```
java -jar target/my-consumer-0.0.1-SNAPSHOT.jar
```