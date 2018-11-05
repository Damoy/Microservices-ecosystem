package com.lama.mse.clients.orders.service;

import java.util.List;

import com.lama.mse.clients.orders.model.Order;

public interface IOrderService {

	public List<Order> getByClientId(int clientId);
	public void storeNewOrder(Order order);
	
}
