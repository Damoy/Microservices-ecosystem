package com.lama.mse.coursiers.orders.consultation.repository;

import com.lama.mse.coursiers.orders.consultation.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderRepository extends MongoRepository<Order, Integer> {

}
