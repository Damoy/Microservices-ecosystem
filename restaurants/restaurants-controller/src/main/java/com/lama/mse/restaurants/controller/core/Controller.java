package com.lama.mse.restaurants.controller.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.restaurants.controller.kafka.KafkaConsumerConfig;
import com.lama.mse.restaurants.controller.kafka.KafkaIO;

@RestController
@RequestMapping("/MS")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Controller {

	@Autowired
	private KafkaIO kafkaIO;

	public Controller() {
	}

	//	@RequestMapping(value = "FOOD/{category}", method = RequestMethod.GET)
	//	public ResponseEntity consultFoodByCategoryEntryPoint(@PathVariable("category") String category) {
	//		System.out.println("consult-category !");
	//
	//		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultFoodByCategory(category);
	//		// TODO future.addCallback(arg0);
	//
	//		return new ResponseEntity("", HttpStatus.OK);
	//	}
	//
	//	@RequestMapping(value = "FOODS/{restaurant}", method = RequestMethod.GET)
	//	public ResponseEntity consultFoodEntryPoint(@PathVariable("restaurant") String restaurantName) {
	//		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultFood(restaurantName);
	//		return new ResponseEntity("", HttpStatus.OK);
	//	}
	//
	//	@RequestMapping(value = "RESTAURANT/{restaurant}", method = RequestMethod.GET)
	//	public ResponseEntity consultRestaurantEntryPoint(@PathVariable("restaurant") String restaurant) {
	//		ListenableFuture<ConsumerRecord<String, String>> future = kafkaIO.sendConsultRestaurant(restaurant);
	//		
	//		return new ResponseEntity("", HttpStatus.OK);
	//	}
	//
	//	@RequestMapping(value = "ORDER/{restaurant}", method = RequestMethod.GET)
	//	public ResponseEntity consultOrderEntryPoint(@PathVariable("restaurant") String restaurant) {
	//		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultOrder(restaurant);
	//		return new ResponseEntity("", HttpStatus.OK);
	//	}
	//
	//	@RequestMapping(value = "FOOD/{category}", method = RequestMethod.POST)
	//	public ResponseEntity editFoodByCategoryEntryPoint(@PathVariable("category") String category) {
	//		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultFoodByCategory(category);
	//		return new ResponseEntity("", HttpStatus.OK);
	//	}

	@RequestMapping(value = "FOOD", method = RequestMethod.POST)
	public ResponseEntity editFoodEntryPoint(@RequestBody String foodJson) throws InterruptedException, ExecutionException {
		RequestReplyFuture<String, String, String> future = kafkaIO.sendCreateFood(foodJson);
		String result = "Food could not been created.";

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		//		try {
		//		SendResult<String, String> sendResult = future.getSendFuture().get();
		//print all headers
		//		sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));

		ConsumerRecord<String, String> consumerRecord = null;
		try {
			System.out.println("là");
			while(!future.isDone()) {
				consumerRecord = future.get(10000,TimeUnit.MILLISECONDS);}
				result = consumerRecord.value();
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("là2");
			e.printStackTrace();
		}
		status = HttpStatus.OK;
		System.out.println("là3");
		return new ResponseEntity<>(result,status);
	}

	//	@RequestMapping(value = "RESTAURANT/{restaurant}", method = RequestMethod.POST)
	//	public ResponseEntity editRestaurantEntryPoint(@PathVariable("restaurant") String restaurant) {
	//		ListenableFuture<ConsumerRecord<String, String>> future = kafkaIO.sendConsultRestaurant(restaurant);
	//		return new ResponseEntity("", HttpStatus.OK);
	//	}

	//	@RequestMapping(value = "ORDER/{restaurant}", method = RequestMethod.POST)
	//	public ResponseEntity editOrderEntryPoint(@PathVariable("restaurant") String restaurant) {
	//		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultOrder(restaurant);
	//		return new ResponseEntity("", HttpStatus.OK);
	//	}

}