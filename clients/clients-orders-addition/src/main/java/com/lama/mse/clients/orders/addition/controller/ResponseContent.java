package com.lama.mse.clients.orders.addition.controller;

import org.springframework.http.HttpStatus;

public class ResponseContent {

	public Object content;
	public HttpStatus status;
	
	public ResponseContent(Object content, HttpStatus status) {
		this.content = content;
		this.status = status;
	}
	
}
