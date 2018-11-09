package com.lama.mse.commons.moneyModification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.commons.moneyModification.core.MoneyModification;

@Component
public class MoneyModificationListener {
	
	@Autowired
	private KafkaIO kafka;
	
	public MoneyModificationListener() {
	}
	
	@KafkaListener(topics = "add-money",
			topicPartitions = {@TopicPartition(topic = "add-money", partitions = {"0"})})
	public void listenToMoneyAdditionEvent(String restaurantNameAmount, Acknowledgment acknowledgment) {
		String[] restaurantAmount = restaurantNameAmount.split(";");
		String restaurant = restaurantAmount[0];
		String amountS = restaurantAmount[1];
		
		String restaurantName = MoneyModification.getModificator().moneyAddition(restaurant, amountS);
		
		kafka.sendRestaurantName(restaurantName);
		
		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = "withdraw-money",
			topicPartitions = {@TopicPartition(topic = "withdraw-money", partitions = {"0"})})
	public void listenToEstimateMoneyWitdrawalEvent(String bankAccountAmount, Acknowledgment acknowledgment) {
		String[] bankAmount = bankAccountAmount.split(";");
		String bankAccount = bankAmount[0];
		String amountS = bankAmount[1];
		
		MoneyModification.getModificator().moneyWitdrawal(bankAccount, amountS);
		
		kafka.sendBankAccount(bankAccount);
		
		acknowledgment.acknowledge();
	}

}
