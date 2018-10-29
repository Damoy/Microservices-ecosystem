package com.lama.mse.restaurants.consultation.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.restaurants.consultation.orders.model.Order;
import com.lama.mse.restaurants.consultation.orders.repository.IOrderRepository;


@Service("OrderSerice")
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository foodRepository;

	@Override
	public List<Order> getAllRestaurantsOrder(String restaurantName) {
		return foodRepository.findByRestaurantName(restaurantName);
	}
	
	
	


}
