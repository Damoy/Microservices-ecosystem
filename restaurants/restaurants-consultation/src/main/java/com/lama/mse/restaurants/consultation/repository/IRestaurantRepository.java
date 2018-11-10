package com.lama.mse.restaurants.consultation.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.restaurants.consultation.model.Restaurant;

public interface IRestaurantRepository extends MongoRepository<Restaurant, Integer> {

	public List<Restaurant> findByName(String restaurantName);
	
}
