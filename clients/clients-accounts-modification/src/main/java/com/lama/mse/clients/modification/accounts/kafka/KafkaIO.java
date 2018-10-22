package com.lama.mse.clients.modification.accounts.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import com.lama.mse.clients.modification.accounts.model.Client;

public class KafkaIO implements IKafkaIO{

	private KafkaTemplate<String, Client> kafkaTemplate;
	
	public KafkaIO(){
		
	}
	
	@Override
	public void sendCreateClientMessage(Client client) {
		kafkaTemplate.send("client-create", client);
	}
	
	@Override
	public void sendDeleteClientMessage(Client client) {
		kafkaTemplate.send("client-delete", client);
	}
	
}
