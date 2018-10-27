package com.lama.mse.coursiers.orders.consultation.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.coursiers.orders.consultation.app.model.Order;

public interface IOrderRepository extends MongoRepository<Order, Integer> {

}
