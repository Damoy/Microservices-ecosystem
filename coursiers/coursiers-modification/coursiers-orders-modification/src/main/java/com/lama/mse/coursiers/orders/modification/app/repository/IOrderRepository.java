package com.lama.mse.coursiers.orders.modification.app.repository;

import com.lama.mse.coursiers.orders.modification.app.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderRepository extends MongoRepository<Order, Integer> {

}
