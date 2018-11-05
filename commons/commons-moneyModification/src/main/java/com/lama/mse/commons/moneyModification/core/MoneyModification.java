package com.lama.mse.commons.moneyModification.core;

public class MoneyModification implements IMoneyModification{
	
private final static IMoneyModification moneyModificator = new MoneyModification();
	
	public MoneyModification() {};
	
	public String moneyWitdrawal(String bankAccount, String amount) {
		System.out.println(amount + "$ were took from the account " + bankAccount);
		return bankAccount;
	}
	
	public String moneyAddition(String restaurantName, String amount) {
		System.out.println(amount + "$ were credited to the restaurant " + restaurantName);
		return restaurantName;
	}
	
	public static IMoneyModification getModificator() {
		return moneyModificator;
	}

}
