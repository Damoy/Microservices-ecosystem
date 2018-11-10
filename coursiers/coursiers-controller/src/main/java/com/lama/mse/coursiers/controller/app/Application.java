package com.lama.mse.coursiers.controller.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursiers.controller.app",
		"com.lama.mse.coursiers.controller.core",
		"com.lama.mse.coursiers.controller.kafka",
})
public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class);
	}
	
}
