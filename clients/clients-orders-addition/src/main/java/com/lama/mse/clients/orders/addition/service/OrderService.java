package com.lama.mse.clients.orders.addition.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.clients.orders.addition.model.Order;
import com.lama.mse.clients.orders.addition.repository.IOrderRepository;

@Service("OrderService")
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;
	
	public OrderService() {

	}
	
	@Override
	public List<Order> getByClientId(int clientId) {
		return orderRepository.findByClientId(clientId);
	}

	@Override
	public void storeNewOrder(Order order) {
		orderRepository.save(order);
	}

}
