package com.lama.mse.commons.estimation.kafka;

public interface IKafkaIO {
	
	public void sendETA(int eta);
	public void sendEstimatedDistance(int distance);
	
}
