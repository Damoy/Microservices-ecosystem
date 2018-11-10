package com.lama.mse.restaurants.consultation.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.lama.mse.restaurants.consultation.model.Food;
import com.lama.mse.restaurants.consultation.model.Order;
import com.lama.mse.restaurants.consultation.model.Restaurant;
import com.lama.mse.restaurants.consultation.service.FoodService;
import com.lama.mse.restaurants.consultation.service.OrderService;
import com.lama.mse.restaurants.consultation.service.RestaurantService;

@Component
public class RestaurantKafkaListener {
	
	@Autowired
	private KafkaIO kafkaIO;

	@Autowired
	private FoodService foodService;

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestaurantService restaurantService;

	public RestaurantKafkaListener() {}

	@KafkaListener(topics = { "consult-restaurant" }, topicPartitions = {
			@TopicPartition(topic = "consult-restaurant", partitions = { "0" }) })
	public void consultRestaurantListener(String restaurantName, Acknowledgment acknowledgment) {
		Restaurant restaurant = restaurantService.findByName(restaurantName);
		kafkaIO.sendConsultedRestaurant(new Gson().toJson(restaurant));
		acknowledgment.acknowledge();
	}

	@KafkaListener(topics = { "consult-food" }, topicPartitions = {
			@TopicPartition(topic = "consult-food", partitions = { "0" }) })
	public void consultFoodByNameListener(String foodName, Acknowledgment acknowledgment) {
		Food food = foodService.getByName(foodName);
		kafkaIO.sendConsultedRestaurant(new Gson().toJson(food));
		acknowledgment.acknowledge();
	}

	@KafkaListener(topics = { "consult-category-food" }, topicPartitions = {
			@TopicPartition(topic = "consult-category-food", partitions = { "0" }) })
	public void consultConsultCategoryFood(String foodCategory, Acknowledgment acknowledgment) {
		Food food = foodService.getByCategory(foodCategory);
		kafkaIO.sendConsultedFoodByCategory(new Gson().toJson(food));
		acknowledgment.acknowledge();
	}

	@KafkaListener(topics = { "consult-order" }, topicPartitions = {
			@TopicPartition(topic = "consult-order", partitions = { "0" }) })
	public void consultConsultOrder(String restaurantName, Acknowledgment acknowledgment) {
		List<Order> orders = orderService.getAllRestaurantsOrder(restaurantName);
		kafkaIO.sendConsultedRestaurantOrders(new Gson().toJson(orders));
		acknowledgment.acknowledge();
	}

}
