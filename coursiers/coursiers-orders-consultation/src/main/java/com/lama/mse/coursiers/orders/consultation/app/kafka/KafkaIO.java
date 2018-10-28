package com.lama.mse.coursiers.orders.consultation.app.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.lama.mse.coursiers.orders.consultation.app.model.Order;

@Component
public class KafkaIO implements IKafkaIO{

public class KafkaIO implements IKafkaIO {
	
	public KafkaIO(){
		
	}
	
	@Override
	public void sendConsultedCOursier(Coursier coursier) {
		kafkaTemplate.send("coursier-consulted", coursier);
	}
	

}
