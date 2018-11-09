package com.lama.mse.restaurants.modification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.restaurants.modification.model.Restaurant;
import com.lama.mse.restaurants.modification.service.RestaurantService;

@Component
public class RestaurantKafkaListener {

	@Autowired
	private RestaurantService restaurantService;

	public RestaurantKafkaListener() {
	}

	@KafkaListener(topics = "edit-food", topicPartitions = { @TopicPartition(topic = "edit-client", partitions = {"0"})})
	public void editFood(String restaurant, Acknowledgment acknowledgment) {

		
		System.out.println("reçu edit-food");
		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = "edit-order", topicPartitions = { @TopicPartition(topic = "edit-order", partitions = {"0"})})
	public void editOrder(String restaurant, Acknowledgment acknowledgment) {
		System.out.println("reçu edit-order");
		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = "edit-restaurant", topicPartitions = { @TopicPartition(topic = "edit-restaurant", partitions = {"0"})})
	public void editRestaurant(String restaurant, Acknowledgment acknowledgment) {
		System.out.println("reçu edit-restaurant");
		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = "edit-category-food", topicPartitions = { @TopicPartition(topic = "edit-category-food", partitions = {"0"})})
	public void order(String restaurant, Acknowledgment acknowledgment) {
		System.out.println("reçu edit-category-food");
		acknowledgment.acknowledge();
	}
	
	
}
