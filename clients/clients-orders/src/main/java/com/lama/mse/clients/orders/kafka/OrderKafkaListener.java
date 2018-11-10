package com.lama.mse.clients.orders.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
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
	public String createClientOrderListener(String orderJson) {
		orderService.storeNewOrder(new Gson().fromJson(orderJson, Order.class));
		kafkaIO.sendCreatedOrderMessage(orderJson);
		return orderJson;
	}

}