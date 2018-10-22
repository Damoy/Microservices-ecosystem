package com.lama.mse.clients.modification.accounts.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.lama.mse.clients.modification.accounts.model.Client;

@Component
public class KafkaIO implements IKafkaIO{

	private KafkaTemplate<String, Client> kafkaTemplate;
	
	public KafkaIO(){
		
	}
	
	@Override
	public void sendCreatedClientMessage(Client client) {
		kafkaTemplate.send("client-created", client);
	}
	
	@Override
	public void sendDeletedClientMessage(Client client) {
		kafkaTemplate.send("client-deleted", client);
	}
	
	@Override
	public void sendEditedClientAllMessage(Client client) {
		kafkaTemplate.send("client-all-edited", client);
	}

	@Override
	public void sendEditedClientAttributeMessage(Client client, String clientAttributeModified) {
		kafkaTemplate.send("client-" + clientAttributeModified + "-edited", client);
	}
	
}
