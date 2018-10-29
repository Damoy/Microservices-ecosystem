package com.lama.mse.commons.distanceEstimation.kafka;

public interface IKafkaIO {
	
	public void sendEstimatedDistance(int distance,long id);


}
