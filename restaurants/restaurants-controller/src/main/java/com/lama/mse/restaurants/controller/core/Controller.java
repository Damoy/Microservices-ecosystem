package com.lama.mse.restaurants.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lama.mse.restaurants.controller.kafka.KafkaIO;

@RestController
@RequestMapping("/MS/CONSULT/")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Controller {

	@Autowired
	private KafkaIO kafkaIO;

	public Controller() {
	}

	@RequestMapping(value = "FOOD/{category}", method = RequestMethod.GET)
	public ResponseEntity consultFoodByCategoryEntryPoint(@PathVariable("category") String category) {
		System.out.println("consult-category !");

		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultFoodByCategory(category);
		// TODO future.addCallback(arg0);

		return new ResponseEntity("", HttpStatus.OK);
	}

	@RequestMapping(value = "FOODS/{restaurant}", method = RequestMethod.GET)
	public ResponseEntity consultFoodEntryPoint(@PathVariable("restaurant") String restaurantName) {
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultFood(restaurantName);
		return new ResponseEntity("", HttpStatus.OK);
	}

	@RequestMapping(value = "RESTAURANT/{restaurant}", method = RequestMethod.GET)
	public ResponseEntity consultRestaurantEntryPoint(@PathVariable("restaurant") String restaurant) {
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultRestaurant(restaurant);
		return new ResponseEntity("", HttpStatus.OK);
	}

	@RequestMapping(value = "ORDER/{restaurant}", method = RequestMethod.GET)
	public ResponseEntity consultOrderEntryPoint(@PathVariable("restaurant") String restaurant) {
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultOrder(restaurant);
		return new ResponseEntity("", HttpStatus.OK);
	}

	@RequestMapping(value = "FOOD/{category}", method = RequestMethod.POST)
	public ResponseEntity editFoodByCategoryEntryPoint(@PathVariable("category") String category) {
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultFoodByCategory(category);
		return new ResponseEntity("", HttpStatus.OK);
	}

	@RequestMapping(value = "FOODS/{restaurant}", method = RequestMethod.POST)
	public ResponseEntity editFoodEntryPoint(@PathVariable("restaurant") String restaurantName) {
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultFood(restaurantName);
		return new ResponseEntity("", HttpStatus.OK);
	}

	@RequestMapping(value = "RESTAURANT/{restaurant}", method = RequestMethod.POST)
	public ResponseEntity editRestaurantEntryPoint(@PathVariable("restaurant") String restaurant) {
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultRestaurant(restaurant);
		return new ResponseEntity("", HttpStatus.OK);
	}

	@RequestMapping(value = "ORDER/{restaurant}", method = RequestMethod.POST)
	public ResponseEntity editOrderEntryPoint(@PathVariable("restaurant") String restaurant) {
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultOrder(restaurant);
		return new ResponseEntity("", HttpStatus.OK);
	}

}