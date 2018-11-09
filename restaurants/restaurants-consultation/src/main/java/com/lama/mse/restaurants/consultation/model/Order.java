package com.lama.mse.restaurants.consultation.model;

import java.util.List;

public class Order {

	private long id;
	private String clientMail;
	private String restaurantName;
	private List<String> foodNames;
	
	public Order(long id, String clientMail, String restaurantName, List<String> foodNames) {
		this.id = id;
		this.clientMail = clientMail;
		this.restaurantName = restaurantName;
		this.foodNames = foodNames;
	}

	public Order(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<String> getFoodNames() {
		return foodNames;
	}

	public void setFoodNames(List<String> foodNames) {
		this.foodNames = foodNames;
	}
	
}
