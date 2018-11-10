package com.lama.mse.commons.estimation.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIO implements IKafkaIO {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaIO(){
		
	}

	@Override
	public void sendETA(int eta) {
		kafkaTemplate.send("eta-calculated", String.valueOf(eta));
		
	}
	
	@Override
	public void sendEstimatedDistance(int distance) {
		kafkaTemplate.send("distance-estimated", String.valueOf(distance));
		
	}

}
