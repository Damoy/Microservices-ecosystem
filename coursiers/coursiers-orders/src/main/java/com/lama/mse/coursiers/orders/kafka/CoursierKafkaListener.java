package com.lama.mse.coursiers.orders.kafka;

import com.google.gson.Gson;
import com.lama.mse.coursiers.orders.model.Order;
import com.lama.mse.coursiers.orders.service.IOrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class CoursierKafkaListener {

	@Autowired
	private IOrderService orderService;

	@Autowired
	private KafkaIO kafkaIO;

	public CoursierKafkaListener() {
	}

	@KafkaListener(id="deliverCoursierOrder", topics="deliver-coursier-order", topicPartitions={
			@TopicPartition(topic="deliver-coursier-order", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String deliverCoursierOrder(String orderId) {
		List<Order> orders = orderService.findById(orderId);
		
		if(orders == null || orders.isEmpty()) {
			return "Could not deliver " + orderId + " order.";
		}
		
		String orderJson = new Gson().toJson(orders.get(0));
		kafkaIO.sendModifiedDeliveryLocationMessage(orderJson);
		return orderJson;
	}
	
	@KafkaListener(id="consultOrdersAroundMe", topics="consult-coursier-orders-aroundme", topicPartitions={
			@TopicPartition(topic="consult-coursier-orders-aroundme", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String consultCoursierOrdersAroundMe(String coursierMailPlusLocation) {
		String[] split = coursierMailPlusLocation.split(";");
		String coursiermail = split[0];
		String coursierlocation = split[1];
		
		List<Order> orders = orderService.findByCoursierMail(coursiermail);
		if(orders == null || orders.isEmpty()) {
			return "No orders around " + coursiermail + " (" + coursierlocation + ") can be found.";
		}
		
		// TODO send distance estimation request to commons
		orders = mockByDistance(orders, coursierlocation);
		String ordersJson = new Gson().toJson(orders);
		kafkaIO.sendConsultedOredrMessage(ordersJson);
		return ordersJson;
	}
	
	private List<Order> mockByDistance(List<Order> orders, String coursierlocation){
		return orders;
	}

}