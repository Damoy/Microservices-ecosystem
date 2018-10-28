package com.lama.mse.commons.distanceEstimation.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.commons.distanceEstimation.app",
		"com.lama.mse.commons.distanceEstimation.core",
		"com.lama.mse.commons.distanceEstimation.kafka"
})

public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}
	
}
