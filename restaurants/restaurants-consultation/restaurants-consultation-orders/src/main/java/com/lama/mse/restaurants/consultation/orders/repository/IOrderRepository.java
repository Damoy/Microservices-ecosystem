package com.lama.mse.restaurants.consultation.orders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.restaurants.consultation.orders.model.Order;

public interface IOrderRepository extends MongoRepository<Order, Integer>{

	public List<Order> findByRestaurantName(String restaurantName);
	
}
