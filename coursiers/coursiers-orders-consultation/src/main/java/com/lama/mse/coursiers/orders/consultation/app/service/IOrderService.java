package com.lama.mse.coursiers.orders.consultation.app.service;

import com.lama.mse.coursiers.orders.consultation.app.model.Order;

import java.util.List;

public interface IOrderService {

	public List<Order> getOrdersWithCoursierLocation(String coursierLocation);
	public Order findById(long id);

	}
