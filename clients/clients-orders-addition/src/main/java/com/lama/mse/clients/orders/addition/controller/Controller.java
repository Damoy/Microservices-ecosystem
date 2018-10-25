package com.lama.mse.clients.orders.addition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.clients.orders.addition.kafka.IKafkaIO;
import com.lama.mse.clients.orders.addition.model.Order;

//@EnableKafka
@RestController
@RequestMapping("/MS/ORDERS")
@SuppressWarnings("rawtypes")
public class Controller {

	private static Controller instance = null;
	
	@Autowired
	private IKafkaIO kafkaIO;
	
	@Autowired
	public Controller() {
		instance = this;
	}
	
	// TODO SEE
	@RequestMapping(value = "/CREATE", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@RequestBody Order order) {
		kafkaIO.sendHaveToCreateOrderMessage(order);
		return new ResponseEntity<>("Order created", HttpStatus.ACCEPTED);
//		ListenableFuture<SendResult<String, Order>> future = kafkaIO.sendHaveToCreateOrderMessage(order);
//		future.addCallback(new ListenableFutureCallback<SendResult<String, Order>>() {
//
//			@Override
//			public void onSuccess(SendResult<String, Order> arg0) {
//				arg0.getProducerRecord().
//			}
//
//			@Override
//			public void onFailure(Throwable arg0) {
//				
//			}
//		});
	}
	
	public static Controller getInstance() {
		return instance;
	}
	
}
