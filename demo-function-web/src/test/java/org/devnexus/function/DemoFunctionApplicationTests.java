package org.devnexus.function;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = "spring.main.web-application-type=servlet")
class DemoFunctionApplicationTests {
	
	@Autowired
	private TestRestTemplate resetTemplate;

	@Test
	void validateOrderProcessingWeb() throws Exception {
		Order order = new Order();
		order.setDate(new Date());
		order.setDescription("My amazing order");
		String orderId = UUID.randomUUID().toString();
		order.setId(orderId);
		ResponseEntity<OrderConfirmation> result = this.resetTemplate.exchange(
				RequestEntity.post(new URI("/placeOrder")).body(order), OrderConfirmation.class);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		System.out.println(result.getBody());
		assertThat(result.getBody().getOrder().getId()).isEqualTo(orderId);
	}

}
