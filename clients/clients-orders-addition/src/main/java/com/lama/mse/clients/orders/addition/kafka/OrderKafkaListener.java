package com.lama.mse.clients.orders.addition.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.clients.orders.addition.model.Order;
import com.lama.mse.clients.orders.addition.service.IOrderService;

@Component
@KafkaListener
public class OrderKafkaListener {
	
	@Autowired
	private IOrderService orderService;
	
	public OrderKafkaListener() {
	}

	@KafkaListener(topics = "create-order")
	public void clientCreateOrder(Order order, Acknowledgment acknowledgment) {
		orderService.storeNewOrder(order);
		acknowledgment.acknowledge();
	}
	
//	@KafkaListener(topics = "order-created")
//	public void clientCreateOrder(Order order, Acknowledgment acknowledgment) {
//		acknowledgment.acknowledge();
//	}

}