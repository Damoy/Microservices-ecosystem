package com.lama.mse.consultation.accounts.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.consultation.accounts.model.Client;
import com.lama.mse.consultation.accounts.service.IClientService;

@Component
public class ClientKafkaListener {
	
	@Autowired
	private IClientService clientService;

	public ClientKafkaListener() {
	}

	@KafkaListener(topics = {"consult-client"},
			topicPartitions = {@TopicPartition(topic = "consult-client", partitions = {"0"})})
	public void consultClientListener(Client client, Acknowledgment acknowledgment) {
		clientService.findByMail(client.getMail());
		acknowledgment.acknowledge();
	}


}
