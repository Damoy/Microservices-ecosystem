package com.lama.mse.coursiers.orders.modification.service;

import com.lama.mse.coursiers.orders.modification.kafka.IKafkaIO;
import com.lama.mse.coursiers.orders.modification.model.Order;
import com.lama.mse.coursiers.orders.modification.repository.IOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private IKafkaIO kafkaIO;
	
	public OrderService(){
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
