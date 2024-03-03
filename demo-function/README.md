# Create Our Function and Create a Bean For It

This sample provides the sample project from which you can build a simple Spring Cloud Function app that can process orders. 

## Getting Started
This is where you begin.
You have two options:

1. Create new project using Spring Initializr and add spring-cloud-function as dependency
   2. Now add the Order function to your project
```shell
spring boot add --from  https://github.com/olegz/devnexus/tree/main/demo-function
```
2. Use Spring CLI to create a new project from it which would already have sample code, test and README.
   1. Run the following commands from your shell
      1. Create the project and add the Order function to your project.
```shell
spring boot new --package-name io.spring --name order
cd order
spring boot add --from  https://github.com/olegz/devnexus/tree/main/demo-function
```

### Requirements:

* Java 17 or Above

### Build:
```
mvn clean package
```

### Run:
```
java -jar target/demo-function-0.0.1-SNAPSHOT.jar
```
