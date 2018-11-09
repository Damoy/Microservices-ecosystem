package com.lama.mse.restaurants.consultation.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIO implements IKafkaIO {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaIO(){

	}
	
	@Override
	public void sendConsultedFoodByCategoryMessage(String category) {
		kafkaTemplate.send("food-consulted", category);
	}

	@Override
	public void sendConsultedRestaurantOrderMessage(String restaurantName) {
		kafkaTemplate.send("order-consulted", restaurantName);
	}
	
	@Override
	public void sendConsultedRestaurantFoodMessage(String restaurantName) {
		kafkaTemplate.send("restaurant-consulted", restaurantName);
	}
	
	@Override
	public void sendConsultRestaurant(String restaurantName) {
		kafkaTemplate.send("consult-food", restaurantName);
	}
	
	@Override
	public void sendConsultOrder(String restaurantName) {
		kafkaTemplate.send("consult-order", restaurantName);
	}
	
	@Override
	public void sendConsultFood(String restaurantName) {
		kafkaTemplate.send("consult-food", restaurantName);
	}
	
	@Override
	public void sendConsultFoodByCategory(String restaurantName) {
		kafkaTemplate.send("consult-category-food", restaurantName);
	}
	
}
