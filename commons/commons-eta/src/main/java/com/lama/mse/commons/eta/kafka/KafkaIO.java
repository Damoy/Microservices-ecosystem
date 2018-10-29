package com.lama.mse.commons.eta.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIO implements IKafkaIO {
	
	@Autowired
	private KafkaTemplate<String, Integer> kafkaTemplate;
	
	public KafkaIO(){
		
	}

	@Override
	public void sendETA(int eta) {
		kafkaTemplate.send("eta-calculated", eta);
		
	}

}