package com.lama.mse.restaurants.consultation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.restaurants.consultation.model.Food;
import com.lama.mse.restaurants.consultation.repository.IFoodRepository;

@Service("FoodService")
public class FoodService implements IFoodService {

	@Autowired
	private IFoodRepository foodRepository;
	
	public FoodService() {
		
	}
	
	@Override
	public Food getByName(String foodName) {
		List<Food> foods = foodRepository.findByName(foodName);
		if(foods.isEmpty()) return null;
		return foods.get(0);
	}

	@Override
	public List<Food> getByCategory(String foodCategory) {
		return foodRepository.findByCategory(foodCategory);
	}

}
