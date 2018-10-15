package com.lama.mse.commons.eta.core;

import java.util.Random;

public class ETACalculator implements IETACalculator {
	
	public ETACalculator(){}

	@Override
	public int compute(String restaurantLocation, String deliveryLocation) {
		return 15 + new Random().nextInt(20);
	}
	
}
