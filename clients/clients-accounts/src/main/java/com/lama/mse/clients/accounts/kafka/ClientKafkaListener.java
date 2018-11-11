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
		
		if(clientService.findByMail(client.getMail()) != null) {
			return "Client " + client.getMail() + " already exists.\n";
		}
		
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
	@KafkaListener(id="editAddressClient",topics = {"edit-client-address"},
			topicPartitions = {@TopicPartition(topic = "edit-client-address", partitions = {"0"})})
	public String editAddressClientListener(String clientMailAddress) {
		String[] split = clientMailAddress.split(";");
		String sentMessageContent = null;
			
		if(split.length == 2) {
			Client client = clientService.editClientAddress(split[0], split[1]);
			if(client != null) {
				sentMessageContent = new Gson().toJson(client);
			} else {
				sentMessageContent = "Client " + split[0] + " does not exist.\n";
			}
		}
		
		kafkaIO.sendEditedAddressClientMessage(sentMessageContent);
		return sentMessageContent;
	}
	
	//TODO RAJOUTER ID
	// >> EDIT-PHONE-CLIENT  <<
	@KafkaListener(id="editClientPhone", topics = {"edit-client-phone"},
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
			
			if(newPhone == -1) {
				Client client = clientService.findByMail(split[0]);
				if(client != null) {
					newPhone = client.getPhoneNumber();
				}
			}
			
			Client client = clientService.editClientPhone(split[0], newPhone);
			if(client != null) {
				sentMessageContent = new Gson().toJson(client);
			} else {
				sentMessageContent = "Client " + split[0] + " does not exist.\n";
			}
		}
		
		kafkaIO.sendEditedPhoneClientMessage(sentMessageContent);
		return sentMessageContent;
	}
	
}