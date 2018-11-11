package com.lama.mse.coursiers.orders.model;

public class Order {

	private String coursierMail;
	private String orderId;
	private EnumOrderStatus status;

	public Order() {

	}

	public String getCoursierMail() {
		return coursierMail;
	}

	public void setCoursierMail(String coursierMail) {
		this.coursierMail = coursierMail;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public EnumOrderStatus getStatus() {
		return status;
	}

	public void setStatus(EnumOrderStatus status) {
		this.status = status;
	}
	
}