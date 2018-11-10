package com.lama.mse.clients.controller.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.clients.controller.app",
		"com.lama.mse.clients.controller.core",
		"com.lama.mse.clients.controller.kafka",
})
public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}
	
}
