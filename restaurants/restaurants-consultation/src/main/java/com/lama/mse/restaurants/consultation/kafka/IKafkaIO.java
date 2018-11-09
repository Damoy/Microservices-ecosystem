package com.lama.mse.restaurants.consultation.kafka;


public interface IKafkaIO {

	public void sendConsultedRestaurantFoodMessage(String restaurantName);
	
	public void sendConsultedFoodByCategoryMessage(String category);

	public void sendConsultedRestaurantOrderMessage(String restaurantName);

	public void sendConsultRestaurant(String restaurantName);

	public void sendConsultOrder(String restaurantName);

	public void sendConsultFood(String restaurantName);

	public void sendConsultFoodByCategory(String restaurantName);

}

