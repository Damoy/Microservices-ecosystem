package com.lama.mse.commons.eta.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.commons.eta.core.ETACalculator;

@Component
@KafkaListener
public class ETAKafkaListener {
	
	@Autowired
	private KafkaIO kafka;
	
	public ETAKafkaListener() {
	}

	@KafkaListener(topics = "estimate-distance")
	public void listenToEstimateDistanceEvent(String restaurantLocationDeliveryLocation, Acknowledgment acknowledgment) {
		String[] location = restaurantLocationDeliveryLocation.split(";");
		String restaurantLocation = location[0];
		String deliveryLocation = location[1];
		
		int eta = ETACalculator.getCalculator().compute(restaurantLocation, deliveryLocation);
		
		kafka.sendETA(eta);
		
		acknowledgment.acknowledge();
	}

}
