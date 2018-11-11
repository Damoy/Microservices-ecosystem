package com.lama.mse.clients.accounts.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
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
	
	// >> CREATE-CLIENT <<
	@KafkaListener(id="createClient",topics = {"create-client"},
			topicPartitions = {@TopicPartition(topic = "create-client", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String createClientListener(String clientJson) {
		Client client = new Gson().fromJson(clientJson, Client.class);
		clientService.addClient(client);
		kafkaIO.sendCreatedClientMessage(clientJson);
		return "Client " + client.getMail() + " successfully created.\n";
	}

	// >> CONSULT-CLIENT <<
	@KafkaListener(id="consultClient",topics = {"consult-client"},
			topicPartitions = {@TopicPartition(topic = "consult-client", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String consultClientListener(String clientMail) {
		Gson gson = new Gson();
		Client clientToConsult = clientService.findByMail(clientMail);
		String res = clientToConsult != null ? gson.toJson(clientToConsult) : "Client does not exist.\n";
		kafkaIO.sendConsultedClientMessage(res);
		return res;
	}
	
	// >> EDIT-NAME-CLIENT  <<
	@KafkaListener(id="editNameClient",topics = {"edit-client-name"},
			topicPartitions = {@TopicPartition(topic = "edit-client-name", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String editNameClientListener(String clientMailName) {
		String[] split = clientMailName.split(";");
		String sentMessageContent = null;
			
		if(split.length == 2) {
			Client client = clientService.findByMail(split[0].trim());
			if(client != null)
				client.setName(split[1].trim());
			sentMessageContent = new Gson().toJson(client);
		}
		
		kafkaIO.sendEditedNameClientMessage(sentMessageContent);
		return sentMessageContent;
	}
	// >> EDIT-ADDRESS-CLIENT  <<
	@KafkaListener(id="createClient",topics = {"edit-client-address"},
			topicPartitions = {@TopicPartition(topic = "edit-client-address", partitions = {"0"})})
	public String editAddressClientListener(String clientMailAddress) {
		String[] split = clientMailAddress.split(";");
		String sentMessageContent = null;
			
		if(split.length == 2) {
			sentMessageContent = new Gson().toJson(
					clientService.editClientAddress(split[0], split[1]));
		}
		
		kafkaIO.sendEditedAddressClientMessage(sentMessageContent);
		return sentMessageContent;
		
	}
	
	
	//TODO RAJOUTER ID
	// >> EDIT-CREDITCARD-CLIENT  <<
	@KafkaListener(topics = {"edit-client-creditCard"},
			topicPartitions = {@TopicPartition(topic = "edit-client-creditCard", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String editCreditCardClientListener(String clientMailCreditCard) {
		String[] split = clientMailCreditCard.split(";");
		String sentMessageContent = null;
			
		if(split.length == 2) {
			sentMessageContent = new Gson().toJson(
					clientService.editClientCreditCard(split[0], split[1]));
		}
		
		kafkaIO.sendEditedCreditCardClientMessage(sentMessageContent);
		return sentMessageContent;
	}
	//TODO RAJOUTER ID
	// >> EDIT-PHONE-CLIENT  <<
	@KafkaListener(topics = {"edit-client-phone"},
			topicPartitions = {@TopicPartition(topic = "edit-client-phone", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String editPhoneClientListener(String clientMailPhone) {
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
		return sentMessageContent;
	}
	
}