package com.lama.mse.coursiers.orders.consultation.app.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.lama.mse.coursiers.orders.consultation.app.model.Order;

@Component
public class KafkaIO implements IKafkaIO{

	private KafkaTemplate<String, Order> kafkaTemplate;
	
	public KafkaIO(){
		
	}

	@Override
	public void sendConsultedOredrMessage(Order order){
		kafkaTemplate.send("order-consulted", order);

	}


}
