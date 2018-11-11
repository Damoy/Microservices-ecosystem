package com.lama.mse.restaurants.consultation.model;


public class Food {

	private String name;
	private String description;
	private String restaurantId;
	private float price;
	private FoodCategory category;
	
	public Food(String name, String description, FoodCategory category, String restaurantId, float price) {
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

	public FoodCategory getCategory() {
		return category;
	}

	public void setCategory(FoodCategory category) {
		this.category = category;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}