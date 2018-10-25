package com.lama.mse.clients.orders.addition.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.lama.mse.clients.orders.addition.model.Order;

@Component
public class KafkaIO implements IKafkaIO {
	
	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;
	
	public KafkaIO(){
		
	}

	@Override
	public ListenableFuture<SendResult<String, Order>> sendCreatedOrderMessage(Order order) {
		return kafkaTemplate.send("order-created", order);
	}

	@Override
	public ListenableFuture<SendResult<String, Order>> sendHaveToCreateOrderMessage(Order order) {
		return kafkaTemplate.send("create-order", order);
	}

}
