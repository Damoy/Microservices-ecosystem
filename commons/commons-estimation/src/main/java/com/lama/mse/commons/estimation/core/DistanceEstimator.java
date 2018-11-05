package com.lama.mse.commons.estimation.core;

import java.util.Random;

import com.lama.mse.commons.estimation.core.IDistanceEstimator;

public class DistanceEstimator implements IDistanceEstimator {
	
	private final static IDistanceEstimator estimator = new DistanceEstimator();
	
	public DistanceEstimator() {};

	@Override
	public int estimate(String startLocation, String endLocation) {	
		return (int) (15 + new Random().nextInt(20));
	}

	public static IDistanceEstimator getEstimator() {
		return estimator;
	}
	
	
}
