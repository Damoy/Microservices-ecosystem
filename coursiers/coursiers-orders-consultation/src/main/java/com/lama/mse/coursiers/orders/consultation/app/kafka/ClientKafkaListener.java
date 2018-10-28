package com.lama.mse.coursiers.orders.consultation.app.kafka;

import com.lama.mse.coursiers.orders.consultation.app.model.Order;
import com.lama.mse.coursiers.orders.consultation.app.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@KafkaListener
public class ClientKafkaListener {
	
	@Autowired
	private IOrderService orderService;

	public ClientKafkaListener() {
	}

	@KafkaListener(topics = "consult-order")
	public void consultClientListener(Order order, Acknowledgment acknowledgment) {
		orderService.findById(order.getId());
		acknowledgment.acknowledge();
	}


}
