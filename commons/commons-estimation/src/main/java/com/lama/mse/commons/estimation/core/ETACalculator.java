package com.lama.mse.commons.estimation.core;

import java.util.Random;

public class ETACalculator implements IETACalculator {
	
	public ETACalculator(){}
	
	private final static IETACalculator calculator = new ETACalculator();
	
	@Override
	public int compute(String restaurantLocation, String deliveryLocation) {
		return 15 + new Random().nextInt(20);
	}
	
	public static IETACalculator getCalculator() {
		return calculator;
	}
	
}
