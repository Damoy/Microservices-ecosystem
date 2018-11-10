package com.lama.mse.restaurants.modification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.restaurants.modification.model.Order;
import com.lama.mse.restaurants.modification.repository.IOrderRepository;

@Service("OrderService")
public class OrderService {

	@Autowired
	private IOrderRepository orderRepository;

	public OrderService() {

	}
	
	public void store(Order order) {
		orderRepository.save(order);
	}
	
}
