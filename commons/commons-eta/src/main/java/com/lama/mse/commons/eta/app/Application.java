package com.lama.mse.commons.eta.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.commons.eta.app",
		"com.lama.mse.commons.eta.core",
		"com.lama.mse.commons.eta.kafka"
})

public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}
}
