package org.devnexus.function;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
	

	private final KafkaTemplate<String, String> template;

	/*
	 * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
	 * in the POM to ensure boot plug-in makes the correct entry
	 */
	public static void main(String[] args) {
	}
	
	public KafkaSender(ProducerFactory<String, String> producerFactory) {
		this.template = new KafkaTemplate<>(producerFactory);
	}
	
	public RecordMetadata sendToKafka(String topic, String value) {
		CompletableFuture<SendResult<String, String>> resultFuture = this.template.send(topic, value);
		try {
			SendResult<String, String> sendResult = resultFuture.get(10000, TimeUnit.MILLISECONDS);
			RecordMetadata metadata = sendResult.getRecordMetadata();
			return metadata;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
	}
}

