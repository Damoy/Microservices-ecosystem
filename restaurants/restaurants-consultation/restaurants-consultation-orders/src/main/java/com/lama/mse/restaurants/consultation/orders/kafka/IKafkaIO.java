package com.lama.mse.restaurants.consultation.orders.kafka;


public interface IKafkaIO {
	
	public void sendConsultedRestaurantFoodMessage(String category);
	
}

