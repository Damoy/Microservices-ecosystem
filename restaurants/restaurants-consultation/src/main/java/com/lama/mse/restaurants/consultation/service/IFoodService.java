package com.lama.mse.restaurants.consultation.service;

import com.lama.mse.restaurants.consultation.model.Food;

public interface IFoodService {

	public Food getByName(String foodName);
	public Food getByCategory(String foodCategory);
	
}
