package com.lama.mse.coursier.order.service;

import com.lama.mse.coursier.order.model.Order;

import java.util.List;

public interface IOrderService {

	public List<Order> getOrdersAroundMe();
	public Order findById(long id);
	public List<Order> findAll();
	public void saveOrder(Order order);
	public void deleteOrder(long id);
	public void modifyClientMail(long id, String mail);
	public void modifyRestaurantName(long id, String restaurantName);
	public void modifyDeliveryLocation(long id, String deliveryLocation);
	public void modifyFoodNames(long id, List<String> foodNames);


}
