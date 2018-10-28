package com.lama.mse.coursiers.orders.modification.app.service;

import com.lama.mse.coursiers.orders.modification.app.model.Order;
import com.lama.mse.coursiers.orders.modification.app.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;
	
	public OrderService(){
	}

	@Override
	public void addOrder(Order order){
		orderRepository.save(order);
	}

	@Override
	public void deleteOrder(long id) {
		orderRepository.deleteById( (int) id );

	}

	@Override
	public void modifyClientMail(long id, String mail){
		orderRepository.findById( (int) id ).get().setClientMail(mail);

	}

	@Override
	public void modifyRestaurantName(long id, String restaurantName){
		orderRepository.findById( (int) id ).get().setRestaurantName(restaurantName);

	}

	@Override
	public void modifyDeliveryLocation(long id, String deliveryLocation){
		orderRepository.findById( (int) id ).get().setDeliveryLocation(deliveryLocation);

	}

	@Override
	public void modifyFoodNames(long id, List<String> foodNames){
		orderRepository.findById( (int) id ).get().setFoodNames(foodNames);

	}
}
