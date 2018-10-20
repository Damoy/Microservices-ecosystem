package com.lama.mse.restaurants.modification.restaurant.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.restaurants.modification.restaurant.model.Restaurant;
public interface IRestaurantRepository extends MongoRepository<Restaurant, String>{

}
