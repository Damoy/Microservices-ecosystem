package com.lama.mse.restaurants.modification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.restaurants.modification.model.Restaurant;


public interface IRestaurantRepository extends MongoRepository<Restaurant, String>{

}
