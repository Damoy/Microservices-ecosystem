package com.lama.mse.clients.modification.accounts.kafka;

import com.lama.mse.clients.modification.accounts.model.Client;

public interface IKafkaIO {

	public void sendCreateClientMessage(Client client);
	public void sendDeleteClientMessage(Client client);
	
}
