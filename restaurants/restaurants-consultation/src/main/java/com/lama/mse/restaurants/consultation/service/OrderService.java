package com.lama.mse.restaurants.consultation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.restaurants.consultation.model.Order;
import com.lama.mse.restaurants.consultation.repository.IOrderRepository;



@Service("OrderSerice")
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository foodRepository;

	@Override
	public List<Order> getAllRestaurantsOrder(String restaurantName) {
		return foodRepository.findByRestaurantName(restaurantName);
	}
}
