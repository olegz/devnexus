# Day 2 Add Kafka producer functionality

This is a recipe which contains necessary bits to add functionality to send data to Kafka

While sending to Kafka functionality provided by this recipe is generic and uses on Spring Kafka project, this recipe contains 
initial configuration and other artifacts to interact with AWS Kafka Cluster (MSK)

### Contents:
- **template-kafka.yml** - SAM (AWS Serverless Application Model) deployment descriptor which contains necessary 
configuration to connect and send messages to AWS Kafka Cluster. Certain elements would need to change to fit your environment.
Please see the 'Policy' section which you would need to copy to your _template.yml_ file while updating server address, topic and group name.

- **pom.xml** - contains all the necessary dependency and will be merged automatically using Spring CLI (i.e., `spring boot add ...`) 

- **KafkaSender.java** - a pre-configured Spring component that uses KafkaTemplate to send messages to Kafka. You would need to inject it into your function;
    
 
    public Function<String, String> uppercase(KafkaSender sender) {
       return value -> {
           value = value.toUpperCase();
           sender.sendToKafka("test-topic", value);
           return value
       };
    }
 
 - **application.properties** - contains a initial SASL configuration to connect to secured Kafka Cluster running in AWS. 
