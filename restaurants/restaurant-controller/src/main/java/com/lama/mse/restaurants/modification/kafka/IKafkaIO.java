package com.lama.mse.restaurants.modification.kafka;

public interface IKafkaIO {
	
	public void sendConsultRestaurant(String restaurantName);
	
	public void sendConsultOrder(String restaurantName);
	
	public void sendConsultFood(String restaurantName);
	
	public void sendConsultFoodByCategory(String restaurantName);

	void sendEditRestaurant(String restaurantName);

	void sendEditOrder(String restaurantName);

	void sendEditFood(String restaurantName);

	void sendEditFoodByCategory(String restaurantName);
}
