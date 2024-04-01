package org.devnexus.function;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;

@Configuration
public class FunctionConfiguration {
	

	private final KafkaTemplate<String, String> template;

	/*
	 * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
	 * in the POM to ensure boot plug-in makes the correct entry
	 */
	public static void main(String[] args) {
	}
	
	public FunctionConfiguration(ProducerFactory<String, String> producerFactory) {
		this.template = new KafkaTemplate<>(producerFactory);
	}
	
	public RecordMetadata sendToKafka(String value) {
		CompletableFuture<SendResult<String, String>> resultFuture = this.template.send("test-topic", value);
		try {
			SendResult<String, String> sendResult = resultFuture.get(10000, TimeUnit.MILLISECONDS);
			RecordMetadata metadata = sendResult.getRecordMetadata();
			return metadata;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
	
//	@Bean
//	public Function<String, String> uppercase()  {
//		return value -> {
//			System.out.println("===> Will attempt to send '" + value + "' to Kafka");
//			value = value.toUpperCase();
//			this.sendToKafka(value);
//			return value;
//		};
//	}
}

