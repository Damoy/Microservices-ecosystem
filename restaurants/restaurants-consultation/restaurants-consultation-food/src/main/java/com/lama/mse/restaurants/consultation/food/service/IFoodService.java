package com.lama.mse.restaurants.consultation.food.service;

import java.util.List;

import com.lama.mse.restaurants.consultation.food.model.Food;

public interface IFoodService {

	public Food getByName(String foodName);
	public List<Food> getByCategory(String foodCategory);
	
}
