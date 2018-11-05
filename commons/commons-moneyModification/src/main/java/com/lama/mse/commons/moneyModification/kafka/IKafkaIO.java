package com.lama.mse.commons.moneyModification.kafka;

public interface IKafkaIO {

	public void sendRestaurantName(String RestaurantName);
	public void sendBankAccount(String BankAccount);

}
