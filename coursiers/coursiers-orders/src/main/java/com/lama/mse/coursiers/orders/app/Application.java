package com.lama.mse.coursiers.orders.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.lama.mse.coursier.order.kafka",
		"com.lama.mse.coursier.order.model",
		"com.lama.mse.coursier.order.repository",
		"com.lama.mse.coursier.order.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
