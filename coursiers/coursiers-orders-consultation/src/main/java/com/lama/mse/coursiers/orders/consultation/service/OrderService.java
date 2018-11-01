package com.lama.mse.coursiers.orders.consultation.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//import com.lama.mse.coursiers.orders.consultation.app.kafka.IKafkaIO;
import com.lama.mse.coursiers.orders.consultation.kafka.IKafkaIO;
import com.lama.mse.coursiers.orders.consultation.model.Order;
import com.lama.mse.coursiers.orders.consultation.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("OrderService")
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private IKafkaIO kafka;
	
	public OrderService(){
	}

	@Override
	public Order findById(long id) {
		Order order = orderRepository.findById((int)id).get();
		return order;

	}

	@Override
	public List<Order> getOrdersNearBy() {
		List<Order> orders = new ArrayList<>(  );
		orders =  orderRepository.findAll().stream().filter( order -> order.getNearby() == true).collect( Collectors.toList());
		return orders;
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}


}
