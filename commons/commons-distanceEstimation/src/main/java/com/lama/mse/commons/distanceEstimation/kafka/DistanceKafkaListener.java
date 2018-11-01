package com.lama.mse.commons.distanceEstimation.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.commons.distanceEstimation.core.DistanceEstimator;

@Component
public class DistanceKafkaListener {
	
	@Autowired
	private KafkaIO kafka;
	
	public DistanceKafkaListener() {
	}

	@KafkaListener(topics = "estimate-distance",
			topicPartitions = {@TopicPartition(topic = "estimate-distance", partitions = {"0"})})
	public void listenToEstimateDistanceEvent( String startLocationEndLocation, Acknowledgment acknowledgment) {
		String[] location = startLocationEndLocation.split(";");
		String startLocation = location[0];
		String endLocation = location[1];
		
		Long distance = DistanceEstimator.getEstimator().estimate(startLocation, endLocation);
		
		kafka.sendEstimatedDistance(distance);
		
		acknowledgment.acknowledge();
	}

}
