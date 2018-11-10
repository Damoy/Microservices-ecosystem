package com.lama.mse.clients.orders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.clients.orders.model.Order;

public interface IOrderRepository extends MongoRepository<Order, Integer>{

	public List<Order> findByClientMail(String clientMail);
	
}
