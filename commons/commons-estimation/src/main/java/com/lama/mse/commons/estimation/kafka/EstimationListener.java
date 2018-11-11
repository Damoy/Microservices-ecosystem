package com.lama.mse.commons.estimation.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.lama.mse.commons.estimation.core.DistanceEstimator;
import com.lama.mse.commons.estimation.core.ETACalculator;

@Component
public class EstimationListener {
	
	@Autowired
	private KafkaIO kafka;
	
	public EstimationListener() {
	}

	@KafkaListener(topics = "estimate-eta",
			topicPartitions = {@TopicPartition(topic = "estimate-eta", partitions = {"0"})})
	@SendTo("topic")
	public void listenToEstimateETAEvent(String restaurantLocationDeliveryLocation, Acknowledgment acknowledgment) {
		String[] location = restaurantLocationDeliveryLocation.split(";");
		String restaurantLocation = location[0];
		String deliveryLocation = location[1];
		
		int eta = ETACalculator.getCalculator().compute(restaurantLocation, deliveryLocation);
		
		kafka.sendETA(eta);
		
		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = "estimate-distance",
			topicPartitions = {@TopicPartition(topic = "estimate-distance", partitions = {"0"})})
	@SendTo("topic")
	public void listenToEstimateDistanceEvent( String startLocationEndLocation, Acknowledgment acknowledgment) {
		String[] location = startLocationEndLocation.split(";");
		String startLocation = location[0];
		String endLocation = location[1];
		
		int distance = DistanceEstimator.getEstimator().estimate(startLocation, endLocation);
		
		kafka.sendEstimatedDistance(distance);
		
		acknowledgment.acknowledge();
	}
	
}
