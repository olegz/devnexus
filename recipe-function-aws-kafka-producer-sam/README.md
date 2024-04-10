# Day 2: Add Kafka producer functionality

This is a recipe which contains necessary bits to add functionality to send data to Kafka on AWS.

While sending to Kafka functionality provided by this recipe is generic and uses on Spring Kafka project, this recipe contains 
initial configuration and other artifacts to interact with AWS Kafka Cluster (MSK).

### Usage:

```
   spring boot add https://github.com/olegz/devnexus/tree/main/recipe-function-aws-kafka-producer-sam
```

### Contents:
- **template-kafka.yml** - SAM (AWS Serverless Application Model) deployment descriptor which contains necessary 
configuration to connect and send messages to AWS Kafka Cluster. Certain elements would need to change to fit your environment.
Please see the 'Policy' section which you would need to copy to your _template.yml_ file while updating server address, topic and group name.

- **pom.xml** - contains all the necessary dependency and will be merged automatically using Spring CLI

- **KafkaSender.java** - a pre-configured Spring component that uses KafkaTemplate to send messages to Kafka. You would need to inject it into your function;
    
```
    @Bean
    public Function<String, String> uppercase(KafkaSender sender) {
       return value -> {
           value = value.toUpperCase();
           sender.sendToKafka("test-topic", value);
           return value
       };
    }
 ```
 - **application.properties** - contains a initial SASL configuration to connect to secured Kafka Cluster running in AWS.

## TODO:

> **_IMPORTANT:_** Please read and act on additional steps outlined below
> 
- Disable the test that was brought by the earlier additions since the code you are about to modify and configuration point to MSK Cluster in AWS. This is to ensure that you can successfully build/deploy the project. While there are capabilities to have a Docker container with AWS MSK capabilities as well as other approaches, we did not want to introduce this level of complexity with this recipe at the moment.
- Modify the code of the function to inject and use `KafkaSender` as described above
- Copy the *Policy* segment contained in `template-kafka.yml` into your existing SAM template.yaml file's *Policy* section.

### Build/Deploy

```
sam build

sam deploy --guided
```


