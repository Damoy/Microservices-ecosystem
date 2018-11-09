package com.lama.mse.restaurants.modification.service;

import com.lama.mse.restaurants.modification.model.Food;

public interface IFoodService {

	/**
	 * Food id is name
	 */
	public Food getByName(String name);
	
}
