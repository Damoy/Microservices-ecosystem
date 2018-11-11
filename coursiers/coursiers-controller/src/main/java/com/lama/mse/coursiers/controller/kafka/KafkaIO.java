package com.lama.mse.coursiers.controller.kafka;

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
	private ReplyingKafkaTemplate<String, String, String> kafka;

	public KafkaIO() {
	}

	public RequestReplyFuture<String, String, String> sendCreateCoursierRequest(String orderJson) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("create-coursier", orderJson);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);
		return future;
	}
	
	public RequestReplyFuture<String, String, String> sendConsultCoursier(String coursierMail) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-coursier", coursierMail);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);
		return future;
	}

	public RequestReplyFuture<String, String, String> sendEditCoursierRequest(String mail, String coursierAttribute,
			String attributeValue) {
		String verb = "edit-coursier";
		if (coursierAttribute != null) {
			verb += "-" + coursierAttribute;
		}

		String requestContent = mail + ";" + attributeValue;
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(verb, requestContent);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);
		return future;
	}

	public RequestReplyFuture<String, String, String> sendEditOrderStatusCoursierRequest(String orderId) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("deliver-coursier-order", orderId);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);
		return future;
	}

	public RequestReplyFuture<String, String, String> sendAccidentCoursierRequest(String cause) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("accident-coursier", cause);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);
		return future;
	}

	public RequestReplyFuture<String, String, String> sendOrdersAroundMeCoursierRequest(String mailCoursierPlusLocation) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-coursier-orders-aroundme",
				mailCoursierPlusLocation);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);
		return future;
	}
}