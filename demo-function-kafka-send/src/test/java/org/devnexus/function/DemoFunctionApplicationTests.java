package org.devnexus.function;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootTest
class DemoFunctionApplicationTests {
	
	@Autowired
	private ProducerFactory<String, String> producerFactory;
	
	

	@Test
	void validateOrderProcessing() throws Exception {
		KafkaTemplate template = new KafkaTemplate<>(producerFactory);
		
		Order order = new Order();
		order.setDate(new Date());
		order.setDescription("My amazing order");
		String orderId = UUID.randomUUID().toString();
		order.setId(orderId);
		template.send(MessageBuilder.withPayload(order).build());

//		assertThat(...);
	}

}
