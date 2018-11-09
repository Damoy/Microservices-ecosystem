package com.lama.mse.coursier.order.repository;

import com.lama.mse.coursier.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderRepository extends MongoRepository<Order, Integer> {

}
