package com.lama.mse.restaurants.consultation.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.lama.mse.restaurants.consultation.model.Order;
import com.lama.mse.restaurants.consultation.service.FoodService;
import com.lama.mse.restaurants.consultation.service.OrderService;


@Component
public class ClientKafkaListener {
	
	@Autowired
	private FoodService clientService;
	
	@Autowired
	private OrderService orderService;

	public ClientKafkaListener() {
	
	}
	
	
	
	@KafkaListener(topics = {"consult-Restaurant"},
			topicPartitions = {@TopicPartition(topic = "consult-client", partitions = {"0"})})
	public void consultRestaurantListener(String restaurant, Acknowledgment acknowledgment) {
		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = {"consult-food"},
			topicPartitions = {@TopicPartition(topic = "consult-client", partitions = {"0"})})
	public void consultFoodListener(String restaurant, Acknowledgment acknowledgment) {

		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = {"consult-category-food"},
			topicPartitions = {@TopicPartition(topic = "consult-category-food", partitions = {"0"})})
	public void consultConsultCategoryFood(String food, Acknowledgment acknowledgment) {

		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = {"consult-order"},
			topicPartitions = {@TopicPartition(topic = "consult-order", partitions = {"0"})})
	public void consultConsultOrder(String restaurant, Acknowledgment acknowledgment) {
		
		acknowledgment.acknowledge();
	}
	



	
	

}
