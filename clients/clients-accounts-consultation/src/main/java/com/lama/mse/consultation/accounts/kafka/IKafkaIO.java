package com.lama.mse.consultation.accounts.kafka;

import com.lama.mse.consultation.accounts.model.Client;

public interface IKafkaIO {
	
	 public void sendConsultedClientMessage(Client client);
	
}
