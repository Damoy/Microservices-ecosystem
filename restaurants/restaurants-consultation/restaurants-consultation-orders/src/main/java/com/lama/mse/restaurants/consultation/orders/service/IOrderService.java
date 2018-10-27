package com.lama.mse.restaurants.consultation.orders.service;

import java.util.List;

import com.lama.mse.restaurants.consultation.orders.model.Order;

public interface IOrderService {
	
	public List<Order> getAllRestaurantsOrder(String restaurantName);
	
}
