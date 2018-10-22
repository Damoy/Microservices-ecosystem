package com.lama.mse.consultation.accounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lama.mse.consultation.accounts.kafka.IKafkaIO;
import com.lama.mse.consultation.accounts.model.Client;
import com.lama.mse.consultation.accounts.repository.IClientRepository;

@Service("ClientService")
public class ClientService implements IClientService {
	
	
	@Autowired
	private IClientRepository clientRepository;
	
	@Autowired
	private IKafkaIO kafka;
	
	public void ClientService() {}
	
	@Override
	public Client findByMail(String mail) {
		Client client = clientRepository.findByMail(mail).get(0);
		kafka.sendConsultedClientMessage(client);
		return client;
		
	}
	
}


