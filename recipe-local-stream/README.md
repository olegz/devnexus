# Day 2 Add Stream Functionality To Your Function

This recipe can be applied to an existing project using Spring CLI to add stream functionality to your app.

. . .
## Getting Started
Add the stream feature to your existing project by executing the following line from your shell while in your project directory:
```shell
spring boot add --from  https://github.com/olegz/devnexus/tree/main/recipe-local-stream
```

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
