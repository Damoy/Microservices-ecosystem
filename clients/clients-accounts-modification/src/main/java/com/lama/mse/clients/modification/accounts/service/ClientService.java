package com.lama.mse.clients.modification.accounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.clients.modification.accounts.kafka.IKafkaIO;
import com.lama.mse.clients.modification.accounts.model.Client;
import com.lama.mse.clients.modification.accounts.repository.IClientRepository;

@Service("ClientService")
public class ClientService implements IClientService {
	
	@Autowired
	private IClientRepository clientRepository;
	
	@Autowired
	private IKafkaIO kafkaIO;

	public ClientService() {
		
	}
	
	@Override
	public void addClient(Client client) {
		clientRepository.save(client);
		kafkaIO.sendCreateClientMessage(client);
	}

	@Override
	public void deleteClient(String mail) {
		Client client = clientRepository.findByMail(mail).get(0);
		clientRepository.delete(client);
		kafkaIO.sendDeleteClientMessage(client);
	}

	@Override
	public void modifyClientName(String mail, String name) {
		Client client = clientRepository.findByMail(mail).get(0);
		client.setName(name);
		clientRepository.delete(client);
		clientRepository.insert(client);
	}

	@Override
	public void modifyClientAddress(String mail, String address) {
		Client client = clientRepository.findByMail(mail).get(0);
		client.setAddress(address);
		clientRepository.delete(client);
		clientRepository.insert(client);
	}

	@Override
	public void modifyClientPhone(String mail, int phoneNumber) {
		Client client = clientRepository.findByMail(mail).get(0);
		client.setNumber(phoneNumber);
		clientRepository.delete(client);
		clientRepository.insert(client);
	}

}
