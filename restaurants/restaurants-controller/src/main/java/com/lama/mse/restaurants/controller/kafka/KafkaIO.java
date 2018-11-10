package com.lama.mse.restaurants.controller.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public class KafkaIO {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	// ------------------------ Consult ----------------------
	public ListenableFuture<SendResult<String, String>> sendConsultRestaurant(String restaurantName) {
		return kafkaTemplate.send("consult-restautant", restaurantName);
	}

	public ListenableFuture<SendResult<String, String>> sendConsultOrder(String restaurantName) {
		return kafkaTemplate.send("consult-order", restaurantName);
	}

	public ListenableFuture<SendResult<String, String>> sendConsultFood(String restaurantName) {
		return kafkaTemplate.send("consult-food", restaurantName);
	}

	public ListenableFuture<SendResult<String, String>> sendConsultFoodByCategory(String restaurantName) {
		return kafkaTemplate.send("consult-category-food", restaurantName);
	}

	// ------------------------ Modif ----------------------
	public ListenableFuture<SendResult<String, String>> sendEditRestaurant(String restaurantName) {
		return kafkaTemplate.send("edit-restaurant", restaurantName);
	}

	public ListenableFuture<SendResult<String, String>> sendEditOrder(String restaurantName) {
		return kafkaTemplate.send("edit-order", restaurantName);
	}

	public ListenableFuture<SendResult<String, String>> sendEditFood(String restaurantName) {
		return kafkaTemplate.send("edit-food", restaurantName);
	}

	public ListenableFuture<SendResult<String, String>> sendEditFoodByCategory(String restaurantName) {
		return kafkaTemplate.send("edit-category-food", restaurantName);
	}
}