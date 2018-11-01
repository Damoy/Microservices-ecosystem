package com.lama.mse.commons.moneyModification.core;

public class MoneyModification implements IMoneyModification{
	
	public void moneyWitdrawal(String BankAccount, float amount) {
		System.out.println(amount + "$ were took from the account " + BankAccount);
	}
	
	public void moneyAddition(String RestaurantName, float amount) {
		System.out.println(amount + "$ were credited to the restaurant " + RestaurantName);
	}

}
