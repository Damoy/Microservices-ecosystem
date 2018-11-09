package com.lama.mse.restaurants.modification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.restaurants.modification.model.Food;
import com.lama.mse.restaurants.modification.repository.IFoodRepository;

@Service("FoodService")
public class FoodService implements IFoodService {

	@Autowired
	private IFoodRepository foodRepository;
	
	public FoodService() {
	}
	
	@Override
	public Food getByName(String name) {
		List<Food> foods = foodRepository.findByName(name);
		if(foods.isEmpty()) return null;
		return foods.get(0);
	}

}
