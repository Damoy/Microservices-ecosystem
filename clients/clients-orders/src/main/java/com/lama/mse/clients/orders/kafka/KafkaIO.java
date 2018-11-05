package com.lama.mse.clients.orders.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIO {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaIO(){}

	public void sendCreatedOrderMessage(String orderJson) {
		kafkaTemplate.send("order-created", orderJson);
	}

}
