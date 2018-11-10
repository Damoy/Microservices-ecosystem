package com.lama.mse.coursiers.orders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.coursiers.orders.model.Order;

public interface IOrderRepository extends MongoRepository<Order, Integer> {

}
