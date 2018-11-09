package com.lama.mse.restaurants.consultation.service;

import java.util.List;

import com.lama.mse.restaurants.consultation.model.Food;

public interface IFoodService {

	public Food getByName(String foodName);
	public List<Food> getByCategory(String foodCategory);
	
}
