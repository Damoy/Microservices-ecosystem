package com.lama.mse.restaurants.consultation.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
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
	@SendTo(value= {"topic"})
	public String consultRestaurantListener(String restaurantName) {
		Restaurant restaurant = restaurantService.findByName(restaurantName);
		String res = new Gson().toJson(restaurant);
		kafkaIO.sendConsultedRestaurant(res);
		return res;
	}


	
	@KafkaListener(topics = { "consult-food" }, topicPartitions = {
			@TopicPartition(topic = "consult-food", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String consultFoodByNameListener(String foodName) {
		Food food = foodService.getByName(foodName);
		kafkaIO.sendConsultedRestaurant(new Gson().toJson(food));
		String res = new Gson().toJson(food);
		return res;
	}
	
	@KafkaListener(topics = { "consult-category-food" }, topicPartitions = {
			@TopicPartition(topic="consult-category-food", partitions = { "0" })})
	@SendTo(value={"topic"})
	public String consultConsultCategoryFood(String foodCategory) {
		Food food = foodService.getByCategory(foodCategory);
		//List<Food> x = foodService.getAll();
		System.out.println("ici");
		System.out.println(foodCategory);
		kafkaIO.sendConsultedFoodByCategory(new Gson().toJson(food));
		String res = new Gson().toJson(food);
		return res;
	}

	@KafkaListener(topics = { "consult-order" }, topicPartitions = {
			@TopicPartition(topic = "consult-order", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String consultConsultOrder(String restaurantName) {
		List<Order> orders = orderService.getAllRestaurantsOrder(restaurantName);
		kafkaIO.sendConsultedRestaurantOrders(new Gson().toJson(orders));
		String res = new Gson().toJson(orders);
		return res;
	}
}
