package com.lama.mse.clients.orders.addition.kafka;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.lama.mse.clients.orders.addition.model.Order;

public interface IKafkaIO {
	
	public ListenableFuture<SendResult<String, Order>> sendCreatedOrderMessage(Order order);
	public ListenableFuture<SendResult<String, Order>> sendHaveToCreateOrderMessage(Order order);
	
}
