package com.lama.mse.coursiers.orders.consultation.repository;


import com.lama.mse.coursiers.orders.consultation.model.Order;

import java.util.List;

public interface IOrderService {

	public List<Order> getOrdersWithCoursierLocation(int distance);
	public Order findById(long id);

	}
