package com.lama.mse.consultation.accounts.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import com.lama.mse.consultation.accounts.model.Client;

public class KafkaIO implements IKafkaIO {
	
	private KafkaTemplate<String, Client> kafkaTemplate;
	
	public KafkaIO(){
		
	}
	
	@Override
	public void sendConsultedClientMessage(Client client) {
		kafkaTemplate.send("client-consulted", client);
	}
	

}
