package com.lama.mse.clients.orders.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lama.mse.clients.orders.model.Order;
import com.lama.mse.clients.orders.service.IOrderService;

@Component
public class OrderKafkaListener {
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private KafkaIO kafkaIO;
	
	public OrderKafkaListener() {}

	@KafkaListener(topics = {"create-order"},
			topicPartitions = {@TopicPartition(topic = "create-order", partitions = {"0"})})
	public void createClientOrderListener(String orderJson, Acknowledgment acknowledgment) {
		try {
			orderService.storeNewOrder(new Gson().fromJson(orderJson, Order.class));
		} catch(Exception e) {
			// prevent crash in case user gives bad json
		}
		
		kafkaIO.sendCreatedOrderMessage(orderJson);
		acknowledgment.acknowledge();
	}

}
