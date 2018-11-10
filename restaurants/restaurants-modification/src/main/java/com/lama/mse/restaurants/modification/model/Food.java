package com.lama.mse.restaurants.modification.model;

import org.springframework.data.annotation.Id;

public class Food {

	@Id
	private String name;
	private String description;
	private long restaurantId;
	private float price;
	private FoodCategory category;

	public Food(long restaurantId, float price, String name, String description, FoodCategory category) {
		this.restaurantId = restaurantId;
		this.price = price;
		this.name = name;
		this.description = description;
		this.category = category;
	}

	public Food() {

	}
	
	public String getId() {
		return name;
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

	public FoodCategory getCategory() {
		return category;
	}

	public void setCategory(FoodCategory category) {
		this.category = category;
	}
	
}