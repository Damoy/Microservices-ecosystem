package com.lama.mse.coursiers.orders.consultation.repository;


import com.lama.mse.coursiers.orders.consultation.model.Order;

import java.util.Arrays;
import java.util.List;

public interface IOrderService {

	public Order findById(long id);
    Arrays findAll();
	List<Order> getOrdersNearBy();
}
