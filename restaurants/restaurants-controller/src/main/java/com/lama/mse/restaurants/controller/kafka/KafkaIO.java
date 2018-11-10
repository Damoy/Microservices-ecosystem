package com.lama.mse.restaurants.controller.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaIO {

	@Autowired
	private ReplyingKafkaTemplate<String,String ,String> kafkaTemplate;

	// ------------------------ Consult ----------------------
//	public RequestReplyFuture<String, String, String> sendConsultRestaurant(String restaurantName) {
//		
//		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-restautant", restaurantName);
//		  // set reply topic in header
//		  record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "create-restaurant".getBytes()));
//		  // post in kafka topic
//		
//		return kafkaTemplate.sendAndReceive(record);
//	}
//	

//	public ListenableFuture<SendResult<String, String>> sendConsultOrder(String restaurantName) {
//	
//		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-order", restaurantName);
//		  // set reply topic in header
//		  record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "consulter-restaurant".getBytes()));
//		  
//		return kafkaTemplate.sendAndReceive("consult-order", restaurantName);
//	}

//	public ListenableFuture<SendResult<String, String>> sendConsultFood(String restaurantName) {
//		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-restautant", restaurantName);
//		  // set reply topic in header
//		  record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "create-restaurant".getBytes()));
//		return kafkaTemplate.sendAndReceive("consult-food", restaurantName);
//	}
//
//	public ListenableFuture<SendResult<String, String>> sendConsultFoodByCategory(String restaurantName) {
//		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-restautant", restaurantName);
//		  // set reply topic in header
//		  record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "create-restaurant".getBytes()));
//		return kafkaTemplate.sendAndReceive("consult-category-food", restaurantName);
//	}
//
//	// ------------------------ Modif ----------------------
//	public ListenableFuture<SendResult<String, String>> sendEditRestaurant(String restaurantName) {
//		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-restautant", restaurantName);
//		  // set reply topic in header
//		  record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "create-restaurant".getBytes()));
//		return kafkaTemplate.sendAndReceive("edit-restaurant", restaurantName);
//	}
//
//	public ListenableFuture<SendResult<String, String>> sendEditOrder(String restaurantName) {
//		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-restautant", restaurantName);
//		  // set reply topic in header
//		  record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "create-restaurant".getBytes()));
//		return kafkaTemplate.sendAndReceive("edit-order", restaurantName);
//	}
//
	public RequestReplyFuture<String,String,String> sendCreateFood(String foodJson) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("create-food", foodJson);
		  // set reply topic in header
		  record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "food-created".getBytes()));
		return kafkaTemplate.sendAndReceive(record);
	}
//
//	public ListenableFuture<SendResult<String, String>> sendEditFoodByCategory(String restaurantName) {
//		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-restautant", restaurantName);
//		  // set reply topic in header
//		  record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "create-restaurant".getBytes()));
//		return kafkaTemplate.sendAndReceive("edit-category-food", restaurantName);
//	}
}