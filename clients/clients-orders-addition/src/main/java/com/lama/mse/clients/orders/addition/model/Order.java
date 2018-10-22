package com.lama.mse.clients.orders.addition.model;

import java.util.List;

public class Order {

	private int clientId;
	private List<Integer> content;
	
	public Order(){
		
	}
	
	public Order(int clientId, List<Integer> content) {
		this.clientId = clientId;
		this.content = content;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public List<Integer> getContent() {
		return content;
	}

	public void setContent(List<Integer> content) {
		this.content = content;
	}
	
}
