package com.lama.mse.restaurants.modification.food.service;

import com.lama.mse.restaurants.modification.food.model.Food;

public interface IFoodService {

	/**
	 * Food id is name
	 */
	public Food getByName(String name);
	
}
