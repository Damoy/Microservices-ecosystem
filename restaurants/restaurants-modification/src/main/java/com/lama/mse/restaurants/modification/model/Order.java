package com.lama.mse.restaurants.modification.model;

import java.util.List;

public class Order {

	private int id;
	private String clientMail;
	private String restaurantName;
	private List<String> foods; // food names
	
	public Order() {
		
	}

	public Order(int id, String clientMail, String restaurantName, List<String> foods) {
		this.id = id;
		this.clientMail = clientMail;
		this.restaurantName = restaurantName;
		this.foods = foods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<String> getFoods() {
		return foods;
	}

	public void setFoods(List<String> foods) {
		this.foods = foods;
	}

}