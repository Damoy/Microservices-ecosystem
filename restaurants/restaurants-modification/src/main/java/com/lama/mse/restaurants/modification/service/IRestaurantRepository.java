package com.lama.mse.restaurants.modification.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.restaurants.modification.model.Restaurant;


public interface IRestaurantRepository extends MongoRepository<Restaurant, String>{

}
