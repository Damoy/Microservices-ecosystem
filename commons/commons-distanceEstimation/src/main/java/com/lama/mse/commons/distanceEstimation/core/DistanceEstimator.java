package com.lama.mse.commons.distanceEstimation.core;

import java.util.Random;

public class DistanceEstimator implements IDistanceEstimator {
	
	private final static IDistanceEstimator estimator = new DistanceEstimator();
	
	public DistanceEstimator() {};

	@Override
	public int estimate(String startLocation, String endLocation) {	
		return 15 + new Random().nextInt(20);
	}

	public static IDistanceEstimator getEstimator() {
		return estimator;
	}
	
	
}
