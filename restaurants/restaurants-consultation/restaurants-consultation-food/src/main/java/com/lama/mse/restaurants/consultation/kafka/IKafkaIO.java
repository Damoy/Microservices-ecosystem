package com.lama.mse.restaurants.consultation.kafka;


public interface IKafkaIO {
	
	public void sendConsultedFoodByCategoryMessage(String category);

	void sendConsultedRestaurantOrderMessage(String restaurantName);
}

