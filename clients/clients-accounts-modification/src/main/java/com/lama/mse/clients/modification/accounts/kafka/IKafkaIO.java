package com.lama.mse.clients.modification.accounts.kafka;

import com.lama.mse.clients.modification.accounts.model.Client;

public interface IKafkaIO {

	public void sendCreatedClientMessage(Client client);
	public void sendDeletedClientMessage(Client client);
	public void sendEditedClientAllMessage(Client client);
	public void sendEditedClientAttributeMessage(Client client, String clientAttributeModified);
	
}
