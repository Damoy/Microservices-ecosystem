package com.lama.mse.restaurants.modification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaIO {

	@Autowired
	private KafkaTemplate<String,String> template;
	
	public ListenableFuture<SendResult<String, String>> sendFoodCreated(String foodJson){
		return template.send("food-created", foodJson);
	}
	
	public ListenableFuture<SendResult<String, String>> sendOrderCreated(String orderJson){
		return template.send("order-created", orderJson);
	}
	
	public ListenableFuture<SendResult<String, String>> sendRestaurantCreated(String restaurantJson){
		return template.send("restaurant-created", restaurantJson);
	}
}
