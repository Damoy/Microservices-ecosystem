package com.lama.mse.clients.accounts.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaIO {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaIO() {}

	public void sendConsultedClientMessage(String clientJson) {
		kafkaTemplate.send("client-consulted", clientJson);
	}

	public void sendCreatedClientMessage(String clientJson) {
		kafkaTemplate.send("client-created", clientJson);
	}

	public void sendDeletedClientMessage(String clientJson) {
		kafkaTemplate.send("client-deleted", clientJson);
	}

	public void sendEditedClientAllMessage(String clientJson) {
		kafkaTemplate.send("client-edited", clientJson);
	}

	public void sendEditedNameClientMessage(String clientJson) {
		kafkaTemplate.send("client-name-edited", clientJson);
	}
	
	public void sendEditedAddressClientMessage(String clientJson) {
		kafkaTemplate.send("client-address-edited", clientJson);
	}
	
	public void sendEditedCreditCardClientMessage(String clientJson) {
		kafkaTemplate.send("client-creditCard-edited", clientJson);
	}
	
	public void sendEditedPhoneClientMessage(String clientJson) {
		kafkaTemplate.send("client-phoneNumber-edited", clientJson);
	}

}