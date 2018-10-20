package com.lama.mse.commons.distanceEstimation.core;

import java.util.Random;

public class DistanceEstimator implements IDistanceEstimator {
	
	public DistanceEstimator() {};

	@Override
	public int estimate(String restaurantLocation, String coursierLocation) {	
		return 15 + new Random().nextInt(20);
	}
	

}
