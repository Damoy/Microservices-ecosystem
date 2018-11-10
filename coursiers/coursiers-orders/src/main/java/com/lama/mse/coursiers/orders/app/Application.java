package com.lama.mse.coursiers.orders.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursiers.orders.kafka",
		"com.lama.mse.coursiers.orders.model",
		"com.lama.mse.coursiers.orders.repository",
		"com.lama.mse.coursiers.orders.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
