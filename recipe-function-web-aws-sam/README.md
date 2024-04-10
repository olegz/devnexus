# Day 2 Add Web Functionality To Your Function 

This is a module that can be added to the existing project using Spring CLI to add web functionality to your spring-cloud-function based project for AWS Lambda.

### Requirements:

* Java 17 or Above
  
## Getting Started
Add the web feature to your existing project by executing the following line from your shell while in your project directory:
```shell
spring boot add --from  https://github.com/olegz/devnexus/tree/main/recipe-function-web-aws-sam

sam build

sam deploy --guided

```

You can test it with a somple `curl`. Make sure you enter a propper URL for your AWS instance

```
curl -X POST -H "Content-Type: application/json" -i https://XXXXXXXXX.execute-api.us-east-2.amazonaws.com/uppercase -d 'hello devnexus'
```
