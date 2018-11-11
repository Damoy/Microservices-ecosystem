package com.lama.mse.clients.orders.model;

import java.util.List;

public class Order {
	
	private static int idGenerator = 0;

	private String clientMail;
	private String id;
	private List<String> content;
	
	public Order(){
		id = null;
	}
	
	public Order(String clientMail, List<String> content) {
		this.clientMail = clientMail;
		this.content = content;
		if(clientMail != null) {
			id = clientMail + "_" + idGenerator++;
		} else {
			id = null;
		}
	}

	public String getClientMail() {
		return clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
		if(clientMail != null && id == null) {
			id = clientMail + "_" + idGenerator++;
		}
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}
	
	public String getId() {
		return id;
	}
}