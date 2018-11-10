package com.lama.mse.restaurants.controller.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaIO {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	// ------------------------ Consult ----------------------
	public void sendConsultRestaurant(String restaurantName) {
		kafkaTemplate.send("consult-restautant", restaurantName);
	}

	public void sendConsultOrder(String restaurantName) {
		kafkaTemplate.send("consult-order", restaurantName);
	}

	public void sendConsultFood(String restaurantName) {
		kafkaTemplate.send("consult-food", restaurantName);
	}

	public void sendConsultFoodByCategory(String restaurantName) {
		kafkaTemplate.send("consult-category-food", restaurantName);
	}

	// ------------------------ Modif ----------------------
	public void sendEditRestaurant(String restaurantName) {
		kafkaTemplate.send("edit-restaurant", restaurantName);
	}

	public void sendEditOrder(String restaurantName) {
		kafkaTemplate.send("edit-order", restaurantName);
	}

	public void sendEditFood(String restaurantName) {
		kafkaTemplate.send("edit-food", restaurantName);
	}

	public void sendEditFoodByCategory(String restaurantName) {
		kafkaTemplate.send("edit-category-food", restaurantName);
	}

}
