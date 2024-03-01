package org.devnexus.function;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FunctionConfiguration {

	@Bean
	public Function<Order, OrderConfirmation> placeOrder() {
		return new OrderFunction();
	}
}
