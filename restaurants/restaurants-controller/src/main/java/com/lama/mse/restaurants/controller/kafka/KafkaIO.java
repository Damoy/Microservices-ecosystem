package com.lama.mse.restaurants.controller.kafka;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Component;

@Component
public class KafkaIO {

	@Autowired
	private ReplyingKafkaTemplate<String, String, String> kafkaTemplate;

	// ------------------------ Consult ----------------------
	public RequestReplyFuture<String, String, String> sendConsultRestaurant(String restaurantName) {

		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-restautant",
				restaurantName);
		// set reply topic in header
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		// post in kafka topic
		return kafkaTemplate.sendAndReceive(record);
	}
	
	public RequestReplyFuture<String, String, String> sendCreateRestaurant(String restaurantjSON) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("create-restautant",
				restaurantjSON);
		// set reply topic in header
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		// post in kafka topic
		return kafkaTemplate.sendAndReceive(record);
	}

	public RequestReplyFuture<String, String, String> sendConsultOrder(String restaurantName) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-order", restaurantName);
		// set reply topic in header
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		return kafkaTemplate.sendAndReceive(record);
	}

	public RequestReplyFuture<String, String, String> sendConsultFood(String foodName) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-food", foodName);
		// set reply topic in header
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		return kafkaTemplate.sendAndReceive(record);
	}

	//
	public RequestReplyFuture<String, String, String> sendConsultFoodByCategory(String foodCategory) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-category-food",
				foodCategory);
		// set reply topic in header
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		return kafkaTemplate.sendAndReceive(record);
	}

	//
	// // ------------------------ Modif ----------------------
	public RequestReplyFuture<String, String, String> sendEditRestaurant(String restaurantjson) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("create-restaurant", restaurantjson);
		// set reply topic in header
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		return kafkaTemplate.sendAndReceive(record);
	}

	//
	public RequestReplyFuture<String, String, String> sendEditOrder(String restaurantName) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("edit-order", restaurantName);
		// set reply topic in header
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		return kafkaTemplate.sendAndReceive(record);
	}

	//
	public RequestReplyFuture<String, String, String> sendCreateFood(String foodJson)
			throws InterruptedException, ExecutionException {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("create-food", foodJson);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		return kafkaTemplate.sendAndReceive(record);
	}
	//
	// public ListenableFuture<SendResult<String, String>>
	// sendEditFoodByCategory(String restaurantName) {
	// ProducerRecord<String, String> record = new ProducerRecord<String,
	// String>("create-food" ,foodJson);
	// record.headers().add(new
	// RecordHeader(KafkaHeaders.REPLY_TOPIC,"topic".getBytes()));
	// return kafkaTemplate.sendAndReceive(record);
	// }
}