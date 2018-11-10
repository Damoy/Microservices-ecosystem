package com.lama.mse.clients.orders.model;

import java.util.List;

public class Order {

	private String clientMail;
	private List<String> content;
	
	public Order(){
		
	}
	
	public Order(String clientMail, List<String> content) {
		this.clientMail = clientMail;
		this.content = content;
	}

	public String getClientMail() {
		return clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}
	
}
