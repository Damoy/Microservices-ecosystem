package com.lama.mse.clients.orders.service;

import java.util.List;

import com.lama.mse.clients.orders.model.Order;

public interface IOrderService {

	public List<Order> getByClientMail(String mail);
	public void storeNewOrder(Order order);
	public Order getByOrderId(String orderId);
	
}
