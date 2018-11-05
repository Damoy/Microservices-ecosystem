package com.lama.mse.commons.moneyModification.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.commons.moneyModification.app",
		"com.lama.mse.commons.moneyModification.core",
		"com.lama.mse.commons.moneyModification.kafka"
})

public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}

}
