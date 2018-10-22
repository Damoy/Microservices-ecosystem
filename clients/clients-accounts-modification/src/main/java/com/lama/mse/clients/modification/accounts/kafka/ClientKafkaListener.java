package com.lama.mse.clients.modification.accounts.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import com.lama.mse.clients.modification.accounts.model.Client;
import com.lama.mse.clients.modification.accounts.service.IClientService;

@Component
@KafkaListener
public class ClientKafkaListener {

	@Autowired
	private IClientService clientService;

	public ClientKafkaListener() {
	}

	@KafkaListener(topics = "create-client")
	public void createClientListener(Client client, Acknowledgment acknowledgment) {
		clientService.addClient(client);
		acknowledgment.acknowledge();
	}

}
