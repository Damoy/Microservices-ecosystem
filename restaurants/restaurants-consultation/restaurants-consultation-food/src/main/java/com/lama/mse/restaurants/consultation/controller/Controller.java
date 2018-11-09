package com.lama.mse.restaurants.consultation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.restaurants.consultation.kafka.IKafkaIO;
import com.lama.mse.restaurants.consultation.model.Category;
import com.lama.mse.restaurants.consultation.model.Food;
import com.lama.mse.restaurants.consultation.service.IFoodService;

@RestController
@RequestMapping("/MS/CONSULT/")
@SuppressWarnings({"rawtypes", "unchecked"})
public class Controller {

	@Autowired
	private IKafkaIO kafkaIO;
	
	@Autowired
	private IFoodService foodService;
	
	public Controller() {
	}
	
	@RequestMapping(value = "FOOD/{category}", method = RequestMethod.GET)
	public ResponseEntity consultFoodEntryPoint(@PathVariable("category") String category) {
		category = Category.parseCategory(category.trim()).getTitle();
		List<Food> foods = foodService.getByCategory(category);
		kafkaIO.sendConsultedFoodByCategoryMessage(category);
		
		HttpStatus status = HttpStatus.OK;
		
		if(foods == null || foods.isEmpty()){
			status = HttpStatus.NOT_FOUND;
		}
		
		return new ResponseEntity(foods, status);
	}
	
}
