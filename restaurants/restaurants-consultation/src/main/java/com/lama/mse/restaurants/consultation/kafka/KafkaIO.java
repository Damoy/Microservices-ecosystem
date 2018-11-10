package com.lama.mse.restaurants.consultation.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaIO {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaIO() {}
	
	public ListenableFuture<SendResult<String, String>> sendConsultedFood(String foodJson) {
		return kafkaTemplate.send("food-consulted", foodJson);
	}
	
	public ListenableFuture<SendResult<String, String>> sendConsultedFoodByCategory(String foodJson) {
		return kafkaTemplate.send("food-category-consulted", foodJson);
	}

	public ListenableFuture<SendResult<String, String>> sendConsultedRestaurantOrders(String restaurantJson) {
		return kafkaTemplate.send("order-consulted", restaurantJson);
	}

	public ListenableFuture<SendResult<String, String>> sendConsultedRestaurant(String restaurantJson) {
		return kafkaTemplate.send("restaurant-consulted", restaurantJson);
	}

}
