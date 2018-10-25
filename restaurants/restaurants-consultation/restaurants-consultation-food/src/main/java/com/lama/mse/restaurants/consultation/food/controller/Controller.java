package com.lama.mse.restaurants.consultation.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.restaurants.consultation.food.kafka.IKafkaIO;
import com.lama.mse.restaurants.consultation.food.model.Food;

@RestController
@RequestMapping("/MS/CONSULT/")
@SuppressWarnings({"rawtypes", "unchecked"})
public class Controller {

	private static Controller instance = null;
	
	@Autowired
	private IKafkaIO kafkaIO;
	
	@Autowired
	public Controller() {
		instance = this;
	}
	
	// TODO SEE
	@RequestMapping(value = "FOOD/{category}", method = RequestMethod.GET)
	public ResponseEntity consultAllFoodEntryPoint(@PathVariable("category") String category) {
		if("all".equals(category)) {
			kafkaIO.sendConsultAllFoodMessage();
		} else {
			kafkaIO.sendConsultFoodByCategoryMessage(category);
		}
		
		// TODO get all foods
		List<Food> foods = null;
		return new ResponseEntity(foods, HttpStatus.OK);
	}
	
	public static Controller getInstance() {
		return instance;
	}
	
}
