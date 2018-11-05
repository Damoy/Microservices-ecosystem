package com.lama.mse.clients.accounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.clients.accounts.model.Client;
import com.lama.mse.clients.accounts.repository.IClientRepository;

@Service("ClientService")
public class ClientService implements IClientService {
	
	@Autowired
	private IClientRepository clientRepository;
	
	public ClientService() {}
	
	@Override
	public Client findByMail(String mail) {
		return clientRepository.findByMail(mail).get(0);
	}
	
	@Override
	public void addClient(Client client) {
		clientRepository.save(client);
	}

	@Override
	public void deleteClient(String mail) {
		clientRepository.delete(clientRepository.findByMail(mail).get(0));
	}

	@Override
	public Client editClientName(String mail, String name) {
		Client client = clientRepository.findByMail(mail).get(0);
		client.setName(name);
		clientRepository.delete(client);
		clientRepository.insert(client);
		return client;
	}

	@Override
	public Client editClientAddress(String mail, String address) {
		Client client = clientRepository.findByMail(mail).get(0);
		client.setAddress(address);
		clientRepository.delete(client);
		clientRepository.insert(client);
		return client;
	}

	@Override
	public Client editClientPhone(String mail, int phoneNumber) {
		Client client = clientRepository.findByMail(mail).get(0);
		client.setNumber(phoneNumber);
		clientRepository.delete(client);
		clientRepository.insert(client);
		return client;
	}
	
	@Override
	public Client editClientCreditCard(String mail, String creditCard) {
		Client client = clientRepository.findByMail(mail).get(0);
		client.setCreditCard(creditCard);
		clientRepository.delete(client);
		clientRepository.insert(client);
		return client;
	}
}
