package com.lama.mse.clients.controller.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.clients.controller.commons.Logs;
import com.lama.mse.clients.controller.kafka.KafkaIO;

@RestController
@RequestMapping("/MS")
@SuppressWarnings("rawtypes")
public class Controller {

	@Autowired
	private KafkaIO kafkaIO;
	
	public Controller() {}
	
	// -------------------------------- CREATE ----------------------------------
	
	@RequestMapping(value = "/CREATE/ORDER", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@RequestBody String orderJson) {
		Logs.infoln("Listened new event on /MS/CREATE/ORDER");
		RequestReplyFuture<String,String,String>  future = kafkaIO.sendCreateOrderRequest(orderJson);
		String result = "Order could not been created.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		try {
			result = future.get(10000, TimeUnit.MILLISECONDS).value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result,status);
	}
	
	@RequestMapping(value = "/CREATE/CLIENT", method = RequestMethod.POST)
	public ResponseEntity createClientrEntryPoint(@RequestBody String clientJson) {
		Logs.infoln("Listened new event on /MS/CREATE/CLIENT");
		RequestReplyFuture<String,String,String>  future = kafkaIO.sendCreateClientRequest(clientJson);
		String result = "Client could not been created.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		try {
			result = future.get(10000, TimeUnit.MILLISECONDS).value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		status = HttpStatus.OK;
		return new ResponseEntity<>(result,status);
	}
	
	// -------------------------------- CONSULT ----------------------------------
	@RequestMapping(value = "/CONSULT/CLIENT/{clientMail]", method = RequestMethod.POST)
	public ResponseEntity consultClientEntryPoint(@PathVariable String clientMail) {
		Logs.infoln("Listened new event on /MS/CONSULT/CLIENT");
		RequestReplyFuture<String,String,String>  future = kafkaIO.sendConsultClientRequest(clientMail);
		String result = "Client could not be consulted.\n";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		try {
			result = future.get(10000, TimeUnit.MILLISECONDS).value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result,status);
	}
	
	@RequestMapping(value = "/CONSULT/ORDERS/{clientMail}", method = RequestMethod.GET)
	public ResponseEntity consultClientOrdersEntryPoint(@PathVariable String clientMail) {
		Logs.infoln("Listened new event on /MS/CONSULT/ORDERS/" + clientMail);
		RequestReplyFuture<String,String,String>  future = kafkaIO.sendConsultClientOrdersRequest(clientMail);
		String result = "Client orders could not be consulted.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		try {
			result = future.get(10000, TimeUnit.MILLISECONDS).value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result,status);
	}
	
	
	// -------------------------------- EDITION ----------------------------------
	
	@RequestMapping(value = "{clientMail}/EDIT/{clientAttribute}/{attributeValue}", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@PathVariable String clientMail,
			@PathVariable String clientAttribute, @PathVariable String attributeValue) {
		Logs.infoln("Listened new event on /MS/EDIT/ATTRIBUTE");
		String result = "Could not edit " + clientMail + "'s" + clientAttribute + ".";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		RequestReplyFuture<String,String,String>  future = kafkaIO.sendEditClientRequest(clientMail, clientAttribute, attributeValue);
		
		try {
			result = future.get(10000, TimeUnit.MILLISECONDS).value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result,status);
	}
	
	@RequestMapping(value = "/PAY/{clientMail}/{orderId}", method = RequestMethod.POST)
	public ResponseEntity clientPayOrder(@PathVariable String clientMail, @PathVariable String orderId) {
		Logs.infoln("Listened new event on MS/PAY/{orderId}" + orderId);
		RequestReplyFuture<String,String,String> future = kafkaIO.sendConsultOrder(orderId);
		String order = null;
		String result = "Could not perform paiement operation.\n";
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		
		try {
			order = future.get(10000, TimeUnit.MILLISECONDS).value();
			result = kafkaIO.sendPaiementRequest(order).get(10000, TimeUnit.MILLISECONDS).value();
			if(result != null) status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result,status);
	}
	
}