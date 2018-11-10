package com.lama.mse.clients.controller.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.lama.mse.clients.controller.commons.Logs;

@Component
public class KafkaIO {

	@Autowired
	private KafkaTemplate<String, String> template;
	
	public KafkaIO() {
		
	}
	
	public void sendCreateOrderRequest(String orderJson) {
		template.send("create-order", orderJson);
		Logs.infoln("Sent create-order.");
	}
	
	public void sendEditClientRequest(String mail, String clientAttribute, String attributeValue) {
		String verb = "edit-client";
		
		if(clientAttribute != null) {
			verb += "-" + clientAttribute;
		}
		
		String requestContent = mail + ";" + attributeValue;
		template.send(verb, requestContent);
		Logs.infoln("Sent edit-client: " + requestContent);
	}
	
}
