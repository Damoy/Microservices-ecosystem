package com.lama.mse.restaurants.modification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.restaurants.modification.model.Order;

public interface IOrderRepository extends MongoRepository<Order, String> {
}
