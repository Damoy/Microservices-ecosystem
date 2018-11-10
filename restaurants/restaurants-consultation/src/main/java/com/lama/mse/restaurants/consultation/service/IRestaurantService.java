package com.lama.mse.restaurants.consultation.service;

import com.lama.mse.restaurants.consultation.model.Restaurant;

public interface IRestaurantService {

	public Restaurant findByName(String restaurantName);
	
}
