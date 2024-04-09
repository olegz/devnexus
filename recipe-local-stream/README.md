# Day 2 Add Stream Functionality To Your Function

This recipe can be applied to an existing project using Spring CLI to add stream functionality and associated tests to your app.

## Getting Started
Add the stream feature to your existing project by executing the following line from your shell while in your project directory:
```shell
spring boot add --from  https://github.com/olegz/devnexus/tree/main/recipe-local-stream
```

> **_IMPORTANT:_** Please read and act on this following sectioin or you will get `NullPointer Cannot invoke "org.springframework.messaging.Message.getPayload()" because "messageReceived" is null` while executing the test.

## Add ability for uppercase to send message to Kafka topic 
Update the `uppercase` method as follows to use the `StreamBridge` to send the upper cased string to the `test-topic` topic.  
```java
	@Bean
	public Function<String, String> uppercase(StreamBridge streamBridge) {
		return value -> {
			System.out.println("Received value: " + value);
			String uppercased= value.toUpperCase();
			streamBridge.send("test-topic", uppercased);
			return uppercased;
		};
	}
```

### Requirements:

* Java 17 or Above

~/Downloads/kafka_2.13-3.3.1/bin/kafka-console-consumer.sh --topic test-topic --from-beginning --bootstrap-server localhost:9092
