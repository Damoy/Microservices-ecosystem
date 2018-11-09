package com.lama.mse.restaurants.consultation.kafka;


public interface IKafkaIO {

	public void sendConsultedRestaurantFoodMessage(String restaurantName);
	
	public void sendConsultedFoodByCategoryMessage(String category);

	public void sendConsultedRestaurantOrderMessage(String restaurantName);

}

