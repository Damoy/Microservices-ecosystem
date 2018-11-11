package com.lama.mse.clients.controller.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
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
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendCreateOrderRequest(orderJson);
		String result = "Order could not been created.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		try {
			result = future.get(6000, TimeUnit.MILLISECONDS).getProducerRecord().value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result,status);
	}
	
	@RequestMapping(value = "/CREATE/CLIENT", method = RequestMethod.POST)
	public ResponseEntity createClientrEntryPoint(@RequestBody String clientJson) {
		Logs.infoln("Listened new event on /MS/CREATE/CLIENT");
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendCreateClientRequest(clientJson);
		String result = "Client could not been created.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		try {
			result = future.get(6000, TimeUnit.MILLISECONDS).getProducerRecord().value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result,status);
	}
	
	// -------------------------------- CONSULT ----------------------------------
	@RequestMapping(value = "/CONSULT/CLIENT/{clientMail]", method = RequestMethod.POST)
	public ResponseEntity consultClientEntryPoint(@PathVariable String clientMail) {
		Logs.infoln("Listened new event on /MS/CONSULT/CLIENT");
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultClientRequest(clientMail);
		String result = "Client could not be consulted.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		try {
			result = future.get(6000, TimeUnit.MILLISECONDS).getProducerRecord().value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result,status);
	}
	
	@RequestMapping(value = "/CONSULT/ORDERS/{clientMail}", method = RequestMethod.POST)
	public ResponseEntity consultClientOrdersEntryPoint(@PathVariable String clientMail) {
		Logs.infoln("Listened new event on /MS/CONSULT/CLIENT");
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendConsultClientOrdersRequest(clientMail);
		String result = "Client orders could not be consulted.";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		try {
			result = future.get(6000, TimeUnit.MILLISECONDS).getProducerRecord().value();
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
		ListenableFuture<SendResult<String, String>> future = kafkaIO.sendEditClientRequest(clientMail, clientAttribute, attributeValue);
		
		try {
			result = future.get(6000, TimeUnit.MILLISECONDS).getProducerRecord().value();
			status = HttpStatus.OK;
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result,status);
	}
	
}