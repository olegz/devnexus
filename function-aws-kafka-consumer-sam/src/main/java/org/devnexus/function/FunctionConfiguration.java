package org.devnexus.function;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.lambda.runtime.events.KafkaEvent;
import com.amazonaws.services.lambda.runtime.events.KafkaEvent.KafkaEventRecord;

@Configuration
public class FunctionConfiguration {
	/*
	 * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
	 * in the POM to ensure boot plug-in makes the correct entry
	 */
	public static void main(String[] args) {

	}
	
	@Bean
	public Consumer<KafkaEvent> uppercase()  {
		return value -> {
			System.out.println("====> Received value: " + value);
			Map<String, List<KafkaEventRecord>> records = value.getRecords();
			for (Entry<String, List<KafkaEventRecord>> entry : records.entrySet()) {
				for (KafkaEventRecord record : entry.getValue()) {
					byte[] recordBytes = Base64.getDecoder().decode(record.getValue().getBytes());
					System.out.println("=====> " + new String(recordBytes, StandardCharsets.UTF_8));
				}
			}
		};
	}
}
