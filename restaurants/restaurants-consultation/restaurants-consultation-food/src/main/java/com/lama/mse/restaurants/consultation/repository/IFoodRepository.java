package com.lama.mse.restaurants.consultation.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.restaurants.consultation.model.Food;

public interface IFoodRepository extends MongoRepository<Food, String>{

	// name is id
	public List<Food> findByName(String name);
	public List<Food> findByCategory(String category);
	
}
