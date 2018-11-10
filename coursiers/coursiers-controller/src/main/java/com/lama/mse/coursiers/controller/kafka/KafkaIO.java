package com.lama.mse.coursiers.controller.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIO {

	@Autowired
	private KafkaTemplate<String, String> kafka;
	
	public KafkaIO() {
		
	}
	
	public void sendCreateCoursierRequest(String orderJson) {
		kafka.send("create-coursier", orderJson);
	}
	
	public void sendEditCoursierRequest(String mail, String coursierAttribute, String attributeValue) {
		String verb = "edit-coursier";
		
		if(coursierAttribute != null) {
			verb += "-" + coursierAttribute;
		}
		
		String requestContent = mail + ";" + attributeValue;
		kafka.send(verb, requestContent);
	}

	public void sendEditOrderStatusCoursierRequest(long orderId){
		//String requestContent coursierId + orderId
		kafka.send("delivered-order-coursier", "" + orderId);
	}

	public void sendAccidentCoursierRequest(String cause){
		kafka.send("accident-coursier", cause);
	}

	public void sendOrdersAroundMetCoursierRequest(String cause){
		kafka.send("consult-coursier-orders-aroundme", cause);
	}


}
