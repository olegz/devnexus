package org.devnexus.function;

import java.util.UUID;
import java.util.function.Function;

public class OrderFunction implements Function<Order, OrderConfirmation>{

	@Override
	public OrderConfirmation apply(Order order) {
		OrderConfirmation confirmation = new OrderConfirmation();
		confirmation.setOrder(order);
		confirmation.setConfirmationNumber(UUID.randomUUID().toString());
		return confirmation;
	}

}
