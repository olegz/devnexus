package org.devnexus.function;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.amazonaws.services.lambda.runtime.events.KafkaEvent;
import com.amazonaws.services.lambda.runtime.events.KafkaEvent.KafkaEventRecord;

@Configuration
public class FunctionConfiguration {
	
	private static String bootstrap_server = "boot-hwxpjl7u.c2.kafka-serverless.us-east-2.amazonaws.com:9098";
//	private static String bootstrap_server = "localhost:9092";
	private static String topic_name = "test-topic";
	
	//private KafkaProducer<String, String> producer;
	
	private final KafkaTemplate<String, String> template;

	/*
	 * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
	 * in the POM to ensure boot plug-in makes the correct entry
	 */
	public static void main(String[] args) {
	}
	
//	@Bean
//	public Function<String, String> concat() {
//		return value -> {
//			System.out.println("==> Received value to concatinate " + value);
//			return value + "-" + value;
//		};
//	}
	
	public FunctionConfiguration(ProducerFactory<String, String> producerFactory) {
		this.template = new KafkaTemplate<>(producerFactory);
	}
	
	public Consumer<String> sendToKafka() {
		
	}
	
//	@Bean
//	public Function<String, String> uppercase(ProducerFactory<String, String> producerFactory)  {
//		return value -> {
//			
//			
//			System.out.println("===> Will attempt to send '" + value + "' to Kafka");
//			
//			System.out.println("===> Creating producer record ");
//			//ProducerRecord<String, String> record = new ProducerRecord<String, String>("test-topic", "123", value.toUpperCase());
//
//			//KafkaTemplate<String, String> template = new KafkaTemplate<>(producerFactory);
//			System.out.println("===> Sending producer record ");
//			Message<String> message = MessageBuilder.withPayload(value.toUpperCase())
//				.setHeader(KafkaHeaders.TOPIC, "test-topic")
//				.build();
//				//.setHeader(KafkaHeaders.KEY, "test-topic")
//			CompletableFuture<SendResult<String, String>> sentFuture = template.send(message);
//			try {
//				SendResult<String, String> sendResult = sentFuture.get(10000, TimeUnit.MILLISECONDS);
//				RecordMetadata metadata = sendResult.getRecordMetadata();
//				System.out.println("==> Sent to " + metadata.topic() + "/" + metadata.offset() + "/" + metadata.partition());
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new IllegalStateException(e);
//			}
//			
//
//			return value;
//		};
//	}
	
//	private Map<String, Object> createConsumer() {
//		String callbackHandler = software.amazon.msk.auth.iam.IAMClientCallbackHandler.class.getCanonicalName();
//		String loginModule = software.amazon.msk.auth.iam.IAMLoginModule.class.getCanonicalName();
//		Map<String, Object> consumerProperties = new HashMap<>();
//		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_server);
//		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
//		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//		consumerProperties.put("security.protocol", "SASL_SSL");
//		consumerProperties.put("sasl.mechanism", "AWS_MSK_IAM");
//		consumerProperties.put("sasl.jaas.config", loginModule + " required;");
//		consumerProperties.put("sasl.client.callback.handler.class", callbackHandler);
//
//		return consumerProperties;
//	}
//	
//	private Map<String, Object> producerProperties() {
//		String serializer = org.apache.kafka.common.serialization.StringSerializer.class.getCanonicalName();
//		String kdeserializer = org.apache.kafka.common.serialization.StringDeserializer.class.getCanonicalName();
//		String callbackHandler = software.amazon.msk.auth.iam.IAMClientCallbackHandler.class.getCanonicalName();
//		String loginModule = software.amazon.msk.auth.iam.IAMLoginModule.class.getCanonicalName();
//
//		Map<String, Object> configuration = new HashMap<>();
//		configuration.put("key.serializer", serializer);
//		configuration.put("value.serializer", serializer);
//		configuration.put("bootstrap.servers", bootstrap_server);
//		configuration.put("security.protocol", "SASL_SSL");
//		configuration.put("sasl.mechanism", "AWS_MSK_IAM");
//		configuration.put("sasl.jaas.config", loginModule + " required;");
//		configuration.put("sasl.client.callback.handler.class", callbackHandler);
//		configuration.put("connections.max.idle.ms", "60");
//		configuration.put("reconnect.backoff.ms", "1000");
////		configuration.put("group.id", "test-group");
////		if (producer == null) {
////			System.out.println("===> Connecting to kafka cluster");
////			producer = new KafkaProducer<String, String>(configuration);
////		}
////		return producer;
//		return configuration;
//	}
}

