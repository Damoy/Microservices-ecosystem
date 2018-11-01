package com.lama.mse.commons.eta.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.commons.eta.core.ETACalculator;

@Component
public class ETAKafkaListener {
	
	@Autowired
	private KafkaIO kafka;
	
	public ETAKafkaListener() {
	}
//TODO estimate-distance ?
	@KafkaListener(topics = "estimate-distance",
			topicPartitions = {@TopicPartition(topic = "estimate-distance", partitions = {"0"})})
	public void listenToEstimateDistanceEvent(String restaurantLocationDeliveryLocation, Acknowledgment acknowledgment) {
		String[] location = restaurantLocationDeliveryLocation.split(";");
		String restaurantLocation = location[0];
		String deliveryLocation = location[1];
		
		int eta = ETACalculator.getCalculator().compute(restaurantLocation, deliveryLocation);
		
		kafka.sendETA(eta);
		
		acknowledgment.acknowledge();
	}

}
