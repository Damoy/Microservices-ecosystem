package com.lama.mse.coursiers.accounts.modification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.lama.mse.coursiers.accounts.modification.model.Coursier;

@Component
public class KafkaIO implements IKafkaIO {
	
	@Autowired
	private KafkaTemplate<String, Coursier> kafkaTemplate;
	
	public KafkaIO(){
		
	}
	
	@Override
	public void sendConsultedCoursierMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-consulted", coursier);
	}

}
