package com.lama.mse.restaurants.consultation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.restaurants.modification.kafka.IKafkaIO;


@RestController
@RequestMapping("/MS/CONSULT/")
@SuppressWarnings({"rawtypes", "unchecked"})
public class Controller {

	@Autowired
	private IKafkaIO kafkaIO;
	
	
	public Controller() {
	}
	
	@RequestMapping(value = "FOOD/{category}", method = RequestMethod.GET)
	public ResponseEntity consultFoodEntryPoint(@PathVariable("category") String category) {
		
		return new ResponseEntity("xd",HttpStatus.OK );
	}
	
}
