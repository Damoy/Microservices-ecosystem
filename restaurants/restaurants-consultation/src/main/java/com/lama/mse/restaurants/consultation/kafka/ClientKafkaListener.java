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

	@KafkaListener(topics = {"consult-client"},
			topicPartitions = {@TopicPartition(topic = "consult-client", partitions = {"0"})})
	public void consultClientListener(Order client, Acknowledgment acknowledgment) {

		acknowledgment.acknowledge();
	}


}
