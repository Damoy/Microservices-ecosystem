package com.lama.mse.coursiers.orders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.coursiers.orders.model.Order;

public interface IOrderRepository extends MongoRepository<Order, String> {
	
	public List<Order> findByCoursierMail(String coursierMail);
	public List<Order> findByOrderId(String orderID);
}
