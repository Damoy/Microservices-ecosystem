package com.lama.mse.restaurants.consultation.food.kafka;


public interface IKafkaIO {
	
	public void sendConsultedFoodByCategoryMessage(String category);
	
}

