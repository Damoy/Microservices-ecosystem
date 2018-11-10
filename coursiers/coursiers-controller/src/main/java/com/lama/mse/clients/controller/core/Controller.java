package com.lama.mse.clients.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.clients.controller.kafka.KafkaIO;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/MS")
@SuppressWarnings("rawtypes")
public class Controller {

	@Autowired
	private KafkaIO kafkaIO;
	
	public Controller() {}
	
	@RequestMapping(value = "/CREATE/COURSIER", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@RequestBody String coursierJson) {
		//Logs.infoln("Listener new event on /CREATE/ORDER");
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendCreateCoursierRequest(coursierJson);
		String result = "Coursier could not been created.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		try {
			result = future.get(2000, TimeUnit.MILLISECONDS).getProducerRecord().value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result,status);

	}
	
	@RequestMapping(value = "{coursierMail}/EDIT/{coursierAttribute}/{attributeValue}", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@PathVariable String coursierMail,
			@PathVariable String coursierAttribute, @PathVariable String attributeValue) {
		//Logs.infoln("Listener new event on coursier /EDIT/ATTRIBUTE");
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendEditCoursierRequest(coursierMail, coursierAttribute, attributeValue);
		return new ResponseEntity<>("Coursier attribute edited.", HttpStatus.ACCEPTED);
	}



	@RequestMapping(value = "{coursierMail}/DELIVERD{orderId}", method = RequestMethod.POST)
	public ResponseEntity 	notifyDeliverdOrder(@PathVariable String coursierMail,@PathVariable long orderId) {
		//Logs.infoln("Listener new event on  {coursierMail}/DELIVERD{orderId}");
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendEditOrderStatusCoursierRequest(orderId);
		return new ResponseEntity<>("Coursier order delivered.", HttpStatus.ACCEPTED);
	}


	@RequestMapping(value = "{coursierMail}/ACCIDENT{cause}", method = RequestMethod.POST)
	public ResponseEntity 	notifyDeliverdOrder(@PathVariable String coursierMail, @PathVariable String cause) {
		//Logs.infoln("Listener new event on  {coursierMail}/ACCIDENT{cause}");
		ListenableFuture<SendResult<String, String>> future =  kafkaIO.sendAccidentCoursierRequest(cause);
		return new ResponseEntity<>("Coursier accident.", HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "{coursierMail}/ORDERS", method = RequestMethod.POST)
	public ResponseEntity 	notifyDeliverdOrder(@PathVariable String coursierMail) {
		//Logs.infoln("Listener new event on  {coursierMail}/ORDERS");
		ListenableFuture<SendResult<String, String>> future =  kafkaIO.sendOrdersAroundMetCoursierRequest(coursierMail);
		return new ResponseEntity<>("Coursier get orders around me.", HttpStatus.ACCEPTED);
	}






}
