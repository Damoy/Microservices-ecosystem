package com.lama.mse.coursiers.orders.model;

import java.util.List;

public class Order {

	public static int genID = 0;

	private String coursierMail;
	private String orderId;
	private String clientMail;
	private String restaurantName;
	private String deliveryLocation; // address set at order creation
	private List<String> foodNames;
	private boolean aroundMe;

	public Order(String clientMail, String coursierMail, String restaurantName, String deliveryLocation,
			List<String> foodNames) {
		this.clientMail = clientMail;
		this.restaurantName = restaurantName;
		this.deliveryLocation = deliveryLocation;
		this.foodNames = foodNames;
		if (coursierMail != null) {
			this.orderId = coursierMail + "_" + genID++;
		}
	}

	public Order() {

	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCoursierMail() {
		return coursierMail;
	}

	public void setCoursierMail(String coursierMail) {
		this.coursierMail = coursierMail;
		if (orderId != null) {
			this.orderId = coursierMail + "_" + genID++;
		}
	}

	public String getClientMail() {
		return clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public List<String> getFoodNames() {
		return foodNames;
	}

	public void setFoodNames(List<String> foodNames) {
		this.foodNames = foodNames;
	}

	public boolean isAroundMe() {
		return aroundMe;
	}

	public void setAroundMe(boolean aroundMe) {
		this.aroundMe = aroundMe;
	}

}