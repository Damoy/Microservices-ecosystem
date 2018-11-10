package com.lama.mse.clients.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.clients.orders.model.Order;
import com.lama.mse.clients.orders.repository.IOrderRepository;

@Service("OrderService")
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;
	
	public OrderService() {

	}
	
	@Override
	public List<Order> getByClientMail(String clientMail) {
		return orderRepository.findByClientMail(clientMail);
	}

	@Override
	public void storeNewOrder(Order order) {
		orderRepository.save(order);
	}

}