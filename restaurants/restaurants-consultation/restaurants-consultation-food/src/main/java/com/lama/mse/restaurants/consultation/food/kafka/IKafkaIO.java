package com.lama.mse.restaurants.consultation.food.kafka;


public interface IKafkaIO {
	
	public void sendConsultAllFoodMessage();
	public void sendConsultFoodByCategoryMessage(String category);
	
}

