package org.devnexus.function;

public class OrderConfirmation {

	private Order order;
	
	private String confirmationNumber;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}
	
	public String toString() {
		return "Order:" + this.order.getId() + "; Confirmation: " + this.confirmationNumber;
	}
}
