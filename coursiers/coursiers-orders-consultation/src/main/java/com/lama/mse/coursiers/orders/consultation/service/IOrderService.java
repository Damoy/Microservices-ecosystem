package com.lama.mse.coursiers.orders.consultation.service;

import com.lama.mse.coursiers.orders.consultation.model.Order;

import java.util.List;

public interface IOrderService {

	public List<Order> getOrdersNearBy();
	public Order findById(long id);
	public List<Order> findAll();

	}
