package com.lama.mse.clients.orders.addition.service;

import java.util.List;

import com.lama.mse.clients.orders.addition.model.Order;

public interface IOrderService {

	public List<Order> getByClientId(int clientId);
	public void storeNewOrder(Order order);
	
}
