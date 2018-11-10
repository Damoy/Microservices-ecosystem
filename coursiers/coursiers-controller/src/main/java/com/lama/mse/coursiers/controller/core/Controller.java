package com.lama.mse.coursiers.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lama.mse.coursiers.controller.kafka.KafkaIO;

@RestController
@RequestMapping("/MS")
@SuppressWarnings("rawtypes")
public class Controller {

	@Autowired
	private KafkaIO kafkaIO;
	
	public Controller() {}
	
	@RequestMapping(value = "/CREATE/COURSIER", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@RequestBody String coursierJson) {
		//kafkaIO.sendCreateCoursierRequest(coursierJson);
		return new ResponseEntity<>("Coursier created", HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "{coursierMail}/EDIT/{coursierAttribute}/{attributeValue}", method = RequestMethod.POST)
	public ResponseEntity createOrderEntryPoint(@PathVariable String coursierMail,
			@PathVariable String coursierAttribute, @PathVariable String attributeValue) {
		kafkaIO.sendEditCoursierRequest(coursierMail, coursierAttribute, attributeValue);
		return new ResponseEntity<>("Coursier attribute edited.", HttpStatus.ACCEPTED);
	}


	@RequestMapping(value = "{coursierMail}/DELIVERD{orderId}", method = RequestMethod.POST)
	public ResponseEntity 	notifyDeliverdOrder(@PathVariable String coursierMail,@PathVariable long orderId) {
		kafkaIO.sendEditOrderStatusCoursierRequest(orderId);
		return new ResponseEntity<>("Coursier order delivered.", HttpStatus.ACCEPTED);
	}


	@RequestMapping(value = "{coursierMail}/ACCIDENT{cause}", method = RequestMethod.POST)
	public ResponseEntity 	notifyDeliverdOrder(@PathVariable String coursierMail, @PathVariable String cause) {
		kafkaIO.sendAccidentCoursierRequest(cause);
		return new ResponseEntity<>("Coursier accident.", HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "{coursierMail}/ORDERS", method = RequestMethod.POST)
	public ResponseEntity 	notifyDeliverdOrder(@PathVariable String coursierMail) {
		kafkaIO.sendOrdersAroundMetCoursierRequest(coursierMail);
		return new ResponseEntity<>("Coursier get orders around me.", HttpStatus.ACCEPTED);
	}



}
