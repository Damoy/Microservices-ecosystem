package com.lama.mse.coursiers.orders.modification.app.service;

import com.lama.mse.coursiers.orders.modification.app.model.Order;

import java.util.List;

public interface IOrderService {

	public void saveOrder(Order order);
	public void deleteOrder(long id);
	public void modifyClientMail(long id, String mail);
	public void modifyRestaurantName(long id, String restaurantName);
	public void modifyDeliveryLocation(long id, String deliveryLocation);
	public void modifyFoodNames(long id, List<String> foodNames);

	
}
