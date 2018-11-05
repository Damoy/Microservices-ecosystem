package com.lama.mse.commons.estimation.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.commons.estimation.app",
		"com.lama.mse.commons.estimation.core",
		"com.lama.mse.commons.estimation.kafka"
})

public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}
}
