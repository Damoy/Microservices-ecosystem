package com.lama.mse.restaurants.modification.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.record.TimestampType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lama.mse.restaurants.modification.commons.Logs;
import com.lama.mse.restaurants.modification.model.Food;
import com.lama.mse.restaurants.modification.model.Order;
import com.lama.mse.restaurants.modification.model.Restaurant;
import com.lama.mse.restaurants.modification.service.FoodService;
import com.lama.mse.restaurants.modification.service.OrderService;
import com.lama.mse.restaurants.modification.service.RestaurantService;

@Component
public class RestaurantKafkaListener {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private FoodService foodService;

	@Autowired
	private KafkaIO kafkaIO;

	public RestaurantKafkaListener() {}
	//String json
	@KafkaListener(id="test",topics = "create-food",topicPartitions = { @TopicPartition(topic="create-food", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String createFood(String json,
			@Header(KafkaHeaders.CORRELATION_ID) byte[] correlation) {
		foodService.store(new Gson().fromJson(json, Food.class));
		System.out.println(correlation);
		
		Logs.infoln("Listened create-food");
		return 	"FOOD Created";

	}

	@KafkaListener(id="test2",topics = "create-order", topicPartitions = { @TopicPartition(topic = "create-order", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String createOrder(String orderJson) {
		orderService.store(new Gson().fromJson(orderJson, Order.class));
		kafkaIO.sendOrderCreated(orderJson);
		Logs.infoln("Listened create-order");
		return "Order Created";
	}
	
	@KafkaListener(id="test2",topics="create-restaurant", topicPartitions = { @TopicPartition(topic = "create-restaurant", partitions = {"0"})})
	@SendTo(value= {"topic"})
	public String createRestaurant(String restaurantJson) {
		restaurantService.store(new Gson().fromJson(restaurantJson, Restaurant.class));
		kafkaIO.sendRestaurantCreated(restaurantJson);
		Logs.infoln("Listened create-restaurant");
		return "restaurant Created";
	}

}