package com.lama.mse.restaurants.modification.order.model;

import java.util.List;

public class Order {

	private int id;
	private int clientId;
	private List<Integer> menus;
	private List<Integer> foods;
	private int restaurantId;

	//---------------------GETTERS----------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public List<Integer> getMenus() {
		return menus;
	}
	public void setMenus(List<Integer> menus) {
		this.menus = menus;
	}
	public List<Integer> getFoods() {
		return foods;
	}
	public void setFoods(List<Integer> foods) {
		this.foods = foods;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
}
