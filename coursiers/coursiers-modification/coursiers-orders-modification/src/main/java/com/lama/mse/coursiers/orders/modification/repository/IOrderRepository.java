package com.lama.mse.coursiers.orders.modification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.coursiers.orders.modification.model.Order;

public interface IOrderRepository extends MongoRepository<Order, Integer> {

}
