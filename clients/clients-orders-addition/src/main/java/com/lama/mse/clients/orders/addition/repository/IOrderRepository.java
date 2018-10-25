package com.lama.mse.clients.orders.addition.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.clients.orders.addition.model.Order;

public interface IOrderRepository extends MongoRepository<Order, Integer>{

	public List<Order> findByClientId(int clientId);
	
}
