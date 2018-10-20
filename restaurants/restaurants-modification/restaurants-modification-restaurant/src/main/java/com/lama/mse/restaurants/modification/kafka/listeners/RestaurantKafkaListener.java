package com.lama.mse.restaurants.modification.kafka.listeners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.restaurants.modification.restaurant.model.Restaurant;
import com.lama.mse.restaurants.modification.restaurant.services.RestaurantService;



@Component
@KafkaListener 

public class RestaurantKafkaListener {

	@Autowired
	private RestaurantService restaurantService;

	public RestaurantKafkaListener() {
	}

	@KafkaListener(topics = "RestaurantCreation")
	public void order(Restaurant restaurant, Acknowledgment acknowledgment){
		restaurantService.register(restaurant);
		acknowledgment.acknowledge();
	}


}
