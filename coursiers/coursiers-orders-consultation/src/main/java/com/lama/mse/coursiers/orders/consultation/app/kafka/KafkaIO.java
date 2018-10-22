package com.lama.mse.coursiers.orders.consultation.app.kafka;

import com.lama.mse.coursiers.orders.consultation.app.model.Coursier;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaIO implements IKafkaIO {
	
	private KafkaTemplate<String, Coursier> kafkaTemplate;
	
	public KafkaIO(){
		
	}
	
	@Override
	public void sendConsultedCOursierMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-consulted", coursier);
	}
	

}
