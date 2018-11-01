package com.lama.mse.coursiers.orders.modification.service;

import java.util.List;

import com.lama.mse.coursiers.orders.modification.model.Order;

public interface IOrderService {

	public void saveOrder(Order order);
	public void deleteOrder(long id);
	public void modifyClientMail(long id, String mail);
	public void modifyRestaurantName(long id, String restaurantName);
	public void modifyDeliveryLocation(long id, String deliveryLocation);
	public void modifyFoodNames(long id, List<String> foodNames);

	
}
