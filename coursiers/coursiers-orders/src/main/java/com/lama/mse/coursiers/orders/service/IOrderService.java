package com.lama.mse.coursiers.orders.service;

import java.util.List;

import com.lama.mse.coursiers.orders.model.Order;

public interface IOrderService {

	//public List<Order> getOrdersNearBy();
	public Order findById(long id);
	public List<Order> findAll();
	public void saveOrder(Order order);
	public void deleteOrder(long id);
	public void modifyClientMail(long id, String mail);
	public void modifyRestaurantName(long id, String restaurantName);
	public void modifyDeliveryLocation(long id, String deliveryLocation);
	public void modifyFoodNames(long id, List<String> foodNames);


}
