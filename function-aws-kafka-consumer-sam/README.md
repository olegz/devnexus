# Sample of Kafka consumer as AWS Lambda 

This ready to depliy example represents a simple Kafka consumer setup to be triggered by a messages sent to AWS MSK Cluster topic.

The intention of this is demostrate:
- How to create a consumer integrated with AWS MSK cluster
- Testing of messages arriving to AWS MSK topic

### Requirements

* Java 17 or Above
  
### Usage: (using Spring CLI)

While you can create a new project from this module using `spring boot new ....`, you can also simply build and deploy it as is providing you have AWS and AWS SAM environment setup.

```
sam build

sam deploy --guided

```
