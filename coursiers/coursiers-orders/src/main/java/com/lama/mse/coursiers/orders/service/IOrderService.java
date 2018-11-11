package com.lama.mse.coursiers.orders.service;

import java.util.List;

import com.lama.mse.coursiers.orders.model.Order;

public interface IOrderService {
	
	public List<Order> findById(String orderId);

	public List<Order> getOrdersAroundMe();

	public List<Order> findByCoursierMail(String coursierMail);

	public List<Order> findAll();

	public void saveOrder(Order order);

	// TODO remove, methods are not relevant
	public void deleteOrder(long id);

	public void modifyClientMail(long id, String mail);

	public void modifyRestaurantName(long id, String restaurantName);

	public void modifyDeliveryLocation(long id, String deliveryLocation);

	public void modifyFoodNames(long id, List<String> foodNames);

}