package com.lama.mse.commons.moneyModification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.lama.mse.commons.moneyModification.core.MoneyModification;

@Component
public class MoneyModificationListener {
	
	@Autowired
	private IKafkaIO kafka;
	
	public MoneyModificationListener() {
	}
	
	@KafkaListener(topics = "add-money",
			topicPartitions = {@TopicPartition(topic = "add-money", partitions = {"0"})})
	@SendTo("topic")
	public String listenToMoneyAdditionEvent(String restaurantNameAmount) {
		String[] restaurantAmount = restaurantNameAmount.split(";");
		String restaurant = restaurantAmount[0];
		String amountS = restaurantAmount[1];
		String restaurantName = MoneyModification.getModificator().moneyAddition(restaurant, amountS);
		kafka.sendRestaurantName(restaurantName);
		return "Added " + amountS + " to " + restaurantName + " restaurant.\n";
	}
	
	@KafkaListener(topics = "withdraw-money",
			topicPartitions = {@TopicPartition(topic = "withdraw-money", partitions = {"0"})})
	@SendTo("topic")
	public String listenToEstimateMoneyWitdrawalEvent(String bankAccountAmount) {
		String[] bankAmount = bankAccountAmount.split(";");
		String bankAccount = bankAmount[0];
		String amountS = bankAmount[1];
		MoneyModification.getModificator().moneyWitdrawal(bankAccount, amountS);
		kafka.sendBankAccount(bankAccount);
		return "Withdrawaled " + amountS + " from " +  bankAccount + " account.\n";
	}

}