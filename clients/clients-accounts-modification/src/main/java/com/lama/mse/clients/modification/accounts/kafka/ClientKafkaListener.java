package com.lama.mse.clients.modification.accounts.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

import com.lama.mse.clients.modification.accounts.model.Client;
import com.lama.mse.clients.modification.accounts.service.IClientService;

@Component

public class ClientKafkaListener {

	@Autowired
	private IClientService clientService;

	public ClientKafkaListener() {
	}

	@KafkaListener(topics = {"create-client"}, 
			topicPartitions = {
					@TopicPartition(topic = "create-client", partitions = {"0"})})
	public void createClientListener(Client client, Acknowledgment acknowledgment) {
		clientService.addClient(client);
		acknowledgment.acknowledge();
	}

}
