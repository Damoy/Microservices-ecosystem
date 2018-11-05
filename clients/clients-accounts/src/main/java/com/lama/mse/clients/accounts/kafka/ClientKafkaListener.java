package com.lama.mse.clients.accounts.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lama.mse.clients.accounts.model.Client;
import com.lama.mse.clients.accounts.service.IClientService;

@Component
public class ClientKafkaListener {
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private KafkaIO kafkaIO;

	public ClientKafkaListener() {
	}

	// >> CONSULT-CLIENT <<
	@KafkaListener(topics = {"consult-client"},
			topicPartitions = {@TopicPartition(topic = "consult-client", partitions = {"0"})})
	public void consultClientListener(String clientMail, Acknowledgment acknowledgment) {
		Gson gson = new Gson();
		Client clientToConsult = clientService.findByMail(clientMail);
		String clientJson = clientToConsult != null ? gson.toJson(clientToConsult) : null;
		kafkaIO.sendConsultedClientMessage(clientJson);
		acknowledgment.acknowledge();
	}
	
	// >> EDIT-NAME-CLIENT  <<
	@KafkaListener(topics = {"edit-client-name"},
			topicPartitions = {@TopicPartition(topic = "edit-client-name", partitions = {"0"})})
	public void editNameClientListener(String clientMailName, Acknowledgment acknowledgment) {
		String[] split = clientMailName.split(";");
		String sentMessageContent = null;
			
		if(split.length == 2) {
			Client client = clientService.findByMail(split[0].trim());
			if(client != null)
				client.setName(split[1].trim());
			sentMessageContent = new Gson().toJson(client);
		}
		
		kafkaIO.sendEditedNameClientMessage(sentMessageContent);
		acknowledgment.acknowledge();
	}
	
	// >> EDIT-ADDRESS-CLIENT  <<
	@KafkaListener(topics = {"edit-client-address"},
			topicPartitions = {@TopicPartition(topic = "edit-client-address", partitions = {"0"})})
	public void editAddressClientListener(String clientMailAddress, Acknowledgment acknowledgment) {
		String[] split = clientMailAddress.split(";");
		String sentMessageContent = null;
			
		if(split.length == 2) {
			sentMessageContent = new Gson().toJson(
					clientService.editClientAddress(split[0], split[1]));
		}
		
		kafkaIO.sendEditedAddressClientMessage(sentMessageContent);
		acknowledgment.acknowledge();
	}
	
	// >> EDIT-CREDITCARD-CLIENT  <<
	@KafkaListener(topics = {"edit-client-creditCard"},
			topicPartitions = {@TopicPartition(topic = "edit-client-creditCard", partitions = {"0"})})
	public void editCreditCardClientListener(String clientMailCreditCard, Acknowledgment acknowledgment) {
		String[] split = clientMailCreditCard.split(";");
		String sentMessageContent = null;
			
		if(split.length == 2) {
			sentMessageContent = new Gson().toJson(
					clientService.editClientCreditCard(split[0], split[1]));
		}
		
		kafkaIO.sendEditedCreditCardClientMessage(sentMessageContent);
		acknowledgment.acknowledge();
	}
	
	// >> EDIT-PHONE-CLIENT  <<
	@KafkaListener(topics = {"edit-client-phone"},
			topicPartitions = {@TopicPartition(topic = "edit-client-phone", partitions = {"0"})})
	public void editPhoneClientListener(String clientMailPhone, Acknowledgment acknowledgment) {
		String[] split = clientMailPhone.split(";");
		String sentMessageContent = null;
			
		if(split.length == 2) {
			int newPhone = -1;
			
			try {
				newPhone = Integer.parseInt(split[1]);
			} catch(NumberFormatException e) {
				// prevent potential exception
			}
			
			if(newPhone == -1)
				newPhone = clientService.findByMail(split[0]).getPhoneNumber();
			
			sentMessageContent = new Gson().toJson(
					clientService.editClientPhone(split[0], newPhone));
		}
		
		kafkaIO.sendEditedPhoneClientMessage(sentMessageContent);
		acknowledgment.acknowledge();
	}
	
}