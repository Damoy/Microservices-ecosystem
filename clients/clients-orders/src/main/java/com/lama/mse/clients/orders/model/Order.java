package com.lama.mse.clients.orders.model;

import java.util.List;

public class Order {
	
	private static int idGenerator = 0;

	private String clientMail;
	private String orderId;
	private String deliveryLocation;
	private List<String> content;
	
	public Order(){
		orderId = null;
	}
	
	public Order(String clientMail, String deliveryLocation, List<String> content) {
		this.clientMail = clientMail;
		this.deliveryLocation = deliveryLocation;
		this.content = content;
		if(clientMail != null) {
			orderId = clientMail + "_" + idGenerator++;
		} else {
			orderId = null;
		}
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public String getClientMail() {
		return clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
		if(clientMail != null && orderId == null) {
			orderId = clientMail + "_" + idGenerator++;
		}
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}
	
}