package com.lama.mse.coursiers.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.coursiers.controller.kafka.KafkaIO;

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



	//consult orders that belong to coursier
	@RequestMapping(value = "{coursierMail}/ORDERS", method = RequestMethod.GET)
	public ResponseEntity consultOrderCoursier(@PathVariable String coursierMail) {
		//Logs.infoln("Listener new event on  coursierMail}/ORDER/{orderId}");
		RequestReplyFuture<String, String, String> future = kafkaIO.sendConsultOrderCoursierRequest(coursierMail);
		String result = "Coursier's orders could not be consulted.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		try {
			result = future.get(10000, TimeUnit.MILLISECONDS).value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(result,status);
	}

	
	@RequestMapping(value = "/CREATE/COURSIER", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@RequestBody String coursierJson) {
		//Logs.infoln("Listener new event on /CREATE/ORDER");
		RequestReplyFuture<String, String, String> future = kafkaIO.sendCreateCoursierRequest(coursierJson);
		String result = "Coursier could not been created.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		try {
			result = future.get(2000, TimeUnit.MILLISECONDS).value();
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
		RequestReplyFuture<String, String, String> future = kafkaIO.sendEditCoursierRequest(coursierMail, coursierAttribute, attributeValue);
		String result = "Coursier could not been created.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		try {
			result = future.get(2000, TimeUnit.MILLISECONDS).value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}



	@RequestMapping(value = "{coursierMail}/DELIVERD{orderId}", method = RequestMethod.POST)
	public ResponseEntity 	notifyDeliverdOrder(@PathVariable String coursierMail,@PathVariable long orderId) {
		//Logs.infoln("Listener new event on  {coursierMail}/DELIVERD{orderId}");
		RequestReplyFuture<String, String, String> future = kafkaIO.sendEditOrderStatusCoursierRequest(orderId);
		String result = "Coursier could not been created.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		try {
			result = future.get(2000, TimeUnit.MILLISECONDS).value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, status);
	}

	@RequestMapping(value = "{coursierMail}/ACCIDENT{cause}", method = RequestMethod.POST)
	public ResponseEntity 	notifyDeliverdOrder(@PathVariable String coursierMail, @PathVariable String cause) {
		//Logs.infoln("Listener new event on  {coursierMail}/ACCIDENT{cause}");
		RequestReplyFuture<String, String, String> future =  kafkaIO.sendAccidentCoursierRequest(cause);
		
		String result = "BAD request";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		try {
			result = future.get(2000, TimeUnit.MILLISECONDS).value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, status);
	}

	@RequestMapping(value = "{coursierMail}/ORDERS", method = RequestMethod.POST)
	public ResponseEntity 	notifyDeliverdOrder(@PathVariable String coursierMail) {
		//Logs.infoln("Listener new event on  {coursierMail}/ORDERS");
		RequestReplyFuture<String, String, String> future =  kafkaIO.sendOrdersAroundMetCoursierRequest(coursierMail);
		
		return new ResponseEntity<>("Coursier get orders around me.", HttpStatus.ACCEPTED);
	}

}
