package com.lama.mse.coursiers.orders.consultation.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

	// TODO
	@Override
	public List<Order> getOrdersWithCoursierLocation(int distance) {
		/*List<Order> orders = orderRepository.findAll();
		orders = orders.stream()
				.filter(o -> distance(o.getDeliveryLocation(), coursierLocation))
			.collect( Collections::list);
		//getOrdersWithCoursierLocation*/
		List<Order> orders = new ArrayList<Order>( (Collection<? extends Order>) new Order() );
		return orders;
	}
	
}
