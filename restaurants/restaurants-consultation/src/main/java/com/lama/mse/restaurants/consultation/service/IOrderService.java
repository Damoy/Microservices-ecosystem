package com.lama.mse.restaurants.consultation.service;

import java.util.List;

import com.lama.mse.restaurants.consultation.model.Order;


public interface IOrderService {
	
	public List<Order> getAllRestaurantsOrder(String restaurantName);
	
}
