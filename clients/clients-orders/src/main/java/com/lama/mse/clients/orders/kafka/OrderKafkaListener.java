package com.lama.mse.clients.orders.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
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

	@KafkaListener(id="ClientCreator",topics = {"create-order"},
			topicPartitions = {@TopicPartition(topic = "create-order", partitions = {"0"})})
	@SendTo("topic")
	public String createClientOrderListener(String orderJson) {
		orderService.storeNewOrder(new Gson().fromJson(orderJson, Order.class));
		kafkaIO.sendCreatedOrderMessage(orderJson);
		System.out.println("Order stored to memory.");
		return orderJson;
	}
	
	@KafkaListener(id="ClientConsultor",topics = {"consult-client-orders"},
			topicPartitions = {@TopicPartition(topic = "consult-client-orders", partitions = {"0"})})
	@SendTo("topic")
	public String consultClientOrdersListener(String clientMail) {
		List<Order> clientOrders = orderService.getByClientMail(clientMail);
		String result = clientOrders == null || clientOrders.isEmpty() ? ("No order could be found for "
				+ clientMail + ".\n") : new Gson().toJson(clientOrders);
		kafkaIO.sendConsultedClientOrders(result);
		return result;
	}

}