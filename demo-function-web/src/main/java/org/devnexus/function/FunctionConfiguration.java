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

	@Bean
	public Function<String, String> test() {
		return new Function<String, String>() {
			@Override
			public String apply(String s) {
				return s.toUpperCase();
			}
		};
	}
}
