package com.lama.mse.restaurants.consultation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.restaurants.consultation.model.Restaurant;
import com.lama.mse.restaurants.consultation.repository.IRestaurantRepository;

@Service("RestaurantService")
public class RestaurantService implements IRestaurantService {

	@Autowired
	private IRestaurantRepository repository;

	@Override
	public Restaurant findByName(String restaurantName) {
		List<Restaurant> restaurants = repository.findByName(restaurantName);
		if(restaurants != null && !restaurants.isEmpty())
			return restaurants.get(0);
		return null;
	}
}
