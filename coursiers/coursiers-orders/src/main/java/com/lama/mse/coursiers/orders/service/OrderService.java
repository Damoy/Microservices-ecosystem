package com.lama.mse.coursiers.orders.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.coursiers.orders.kafka.KafkaIO;
import com.lama.mse.coursiers.orders.model.Order;
import com.lama.mse.coursiers.orders.repository.IOrderRepository;


@Service("OrderService")
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private KafkaIO kafkaIO;
	
	public OrderService(){
	}

	@Override
	public Order findById(long id) {
		Order order = orderRepository.findById((int)id).get();
		return order;

	}

	@Override
	public List<Order> getOrdersAroundMe() {
		List<Order> orders = new ArrayList<>(  );
		orders =  orderRepository.findAll().stream().filter( order -> order.getAroundMe() == true).collect( Collectors.toList());
		return orders;
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}


	@Override
	public void saveOrder(Order order){
		orderRepository.save(order);
	}

	@Override
	public void deleteOrder(long id) {
		Order order = orderRepository.findById( (int)id ).get();
		orderRepository.delete( order );
		kafkaIO.sendDeletedOrderMessage( order );
	}

	@Override
	public void modifyClientMail(long id, String mail){
		Order order = orderRepository.findById( (int)id ).get();
		order.setClientMail(mail);
		kafkaIO.sendDeletedOrderMessage( order );
	}

	@Override
	public void modifyRestaurantName(long id, String restaurantName){
		Order order = orderRepository.findById( (int)id ).get();
		order.setRestaurantName(restaurantName);
		kafkaIO.sendDeletedOrderMessage( order );
	}

	@Override
	public void modifyDeliveryLocation(long id, String deliveryLocation){
		Order order = orderRepository.findById( (int)id ).get();
		order.setDeliveryLocation(deliveryLocation);
		kafkaIO.sendDeletedOrderMessage( order );
	}

	@Override
	public void modifyFoodNames(long id, List<String> foodNames){
		Order order = orderRepository.findById( (int)id ).get();
		order.setFoodNames(foodNames);
		kafkaIO.sendDeletedOrderMessage( order );
	}




}
