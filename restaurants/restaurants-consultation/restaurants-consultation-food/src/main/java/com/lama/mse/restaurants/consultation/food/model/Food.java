package com.lama.mse.restaurants.consultation.food.model;

import org.springframework.data.annotation.Id;

public class Food {

	@Id
	private String name;
	private String description;
	private String category;
	private long restaurantId;
	private float price;
	
	public Food(String name, String description, String category, long restaurantId, float price) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.restaurantId = restaurantId;
		this.price = price;
	}

	public Food(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}