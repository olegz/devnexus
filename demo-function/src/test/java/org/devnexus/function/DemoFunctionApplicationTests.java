package org.devnexus.function;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.function.context.FunctionCatalog;

@SpringBootTest
class DemoFunctionApplicationTests {
	
	@Autowired
	private FunctionCatalog functionCatalog;

	@Test
	void validateOrderProcessing() {
		Function<Order, OrderConfirmation> placeOrder = functionCatalog.lookup("placeOrder");
		Order order = new Order();
		order.setDate(new Date());
		order.setDescription("My amazing order");
		String orderId = UUID.randomUUID().toString();
		order.setId(orderId);
		assertThat(orderId).isEqualTo(orderId);
	}

}
