package com.lama.mse.commons.moneyModification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaIO implements IKafkaIO {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaIO(){
		
	}

	@Override
	public void sendRestaurantName(String RestaurantName) {
		kafkaTemplate.send("money-added", RestaurantName);	
	}

	@Override
	public void sendBankAccount(String BankAccount) {
		kafkaTemplate.send("money-removed", BankAccount);	
	}
	
}
