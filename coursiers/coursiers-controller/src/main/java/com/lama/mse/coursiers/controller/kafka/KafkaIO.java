package com.lama.mse.coursiers.controller.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaIO {

	@Autowired
	private KafkaTemplate<String, String> kafka;
	
	public KafkaIO() {
		
	}
	
	public ListenableFuture<SendResult<String, String>> sendCreateCoursierRequest(String orderJson) {
		ListenableFuture<SendResult<String, String>> future = kafka.send("create-coursier", orderJson);
		//Logs.infoln("Sent create-coursier.");
		return future;	}
	
	public ListenableFuture<SendResult<String, String>> sendEditCoursierRequest(String mail, String coursierAttribute, String attributeValue) {
		String verb = "edit-coursier";
		
		if(coursierAttribute != null) {
			verb += "-" + coursierAttribute;
		}
		
		String requestContent = mail + ";" + attributeValue;
		ListenableFuture<SendResult<String, String>> future = kafka.send(verb, requestContent);
		//Logs.infoln("Sent edit-coursier");
		return future;
	}

	public ListenableFuture<SendResult<String, String>> sendEditOrderStatusCoursierRequest(long orderId){
		//String requestContent coursierId + orderId
		ListenableFuture<SendResult<String, String>> future = kafka.send("delivered-order-coursier", "" + orderId);
		//Logs.infoln("Sent delivered-order-coursier");
		return future;
	}

	public ListenableFuture<SendResult<String, String>> sendAccidentCoursierRequest(String cause){
		ListenableFuture<SendResult<String, String>> future = kafka.send("accident-coursier", cause);
		//Logs.infoln("Sent accident-coursier");
		return future;
	}

	public ListenableFuture<SendResult<String, String>> sendOrdersAroundMetCoursierRequest(String cause){
		ListenableFuture<SendResult<String, String>> future = kafka.send("consult-coursier-orders-aroundme", cause);
		//Logs.infoln("Sent consult-coursier-orders-aroundme");
		return future;
	}



}
