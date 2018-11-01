package com.lama.mse.commons.distanceEstimation.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIO implements IKafkaIO {
	
	@Autowired
	private KafkaTemplate<String, Long> kafkaTemplate;
	
	public KafkaIO(){

	}

	@Override
	public void sendEstimatedDistance(Long distance) {
		kafkaTemplate.send("distance-estimated", distance);
		
	}

}
