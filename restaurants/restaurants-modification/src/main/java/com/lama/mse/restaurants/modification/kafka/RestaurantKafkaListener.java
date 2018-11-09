package com.lama.mse.restaurants.modification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.restaurants.modification.model.Restaurant;
import com.lama.mse.restaurants.modification.service.RestaurantService;

@Component
public class RestaurantKafkaListener {

	@Autowired
	private RestaurantService restaurantService;

	public RestaurantKafkaListener() {
	}

	@KafkaListener(topics = "")
	public void order(Restaurant restaurant, Acknowledgment acknowledgment) {
		restaurantService.register(restaurant);
		acknowledgment.acknowledge();
	}

}
