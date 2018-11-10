package com.lama.mse.restaurants.modification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.restaurants.modification.model.Restaurant;
import com.lama.mse.restaurants.modification.repository.IRestaurantRepository;

@Service("RestaurantService")
public class RestaurantService {

	@Autowired
	private IRestaurantRepository restaurantRepository;

	public RestaurantService() {

	}
	
	public void store(Restaurant restaurant) {
		restaurantRepository.insert(restaurant);
	}
}