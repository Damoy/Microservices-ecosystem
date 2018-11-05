package com.lama.mse.clients.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.clients.controller.kafka.KafkaIO;

@RestController
@RequestMapping("/MS")
@SuppressWarnings("rawtypes")
public class Controller {

	@Autowired
	private KafkaIO kafkaIO;
	
	public Controller() {}
	
	@RequestMapping(value = "/CREATE/ORDER", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@RequestBody String orderJson) {
		kafkaIO.sendCreateOrderRequest(orderJson);
		return new ResponseEntity<>("Order created", HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "{clientMail}/EDIT/{clientAttribute}/{attributeValue}", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@PathVariable String clientMail,
			@PathVariable String clientAttribute, @PathVariable String attributeValue) {
		kafkaIO.sendEditClientRequest(clientMail, clientAttribute, attributeValue);
		return new ResponseEntity<>("Client attribute edited.", HttpStatus.ACCEPTED);
	}
	
}
