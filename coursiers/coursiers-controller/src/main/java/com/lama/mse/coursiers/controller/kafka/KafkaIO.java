package com.lama.mse.coursiers.controller.kafka;

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
	private ReplyingKafkaTemplate<String, String ,String> kafka;

	public KafkaIO() {
	}


	//consult coursier orders

	public RequestReplyFuture<String, String, String> sendConsultOrderCoursierRequest(String coursierMail) {

		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-coursier-orders", coursierMail);

		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));

		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);

		return  future;
	}



	//create coursier
	public RequestReplyFuture<String, String, String>  sendCreateCoursierRequest(String orderJson) {

		ProducerRecord<String, String> record = new ProducerRecord<String, String>("create-coursier", orderJson);
		
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));

		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);

		return  future;
	}


	//edit one of the coursier attributs
	public RequestReplyFuture<String, String, String> sendEditCoursierRequest(String mail, String coursierAttribute, String attributeValue) {

		String verb = "edit-coursier";
		
		

		if(coursierAttribute != null) {
			verb += "-" + coursierAttribute;
		}

		String requestContent = mail + ";" + attributeValue;
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(verb, requestContent);
		
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);

		return future;
	}


	//food delivered status
	public RequestReplyFuture<String, String, String> sendEditOrderStatusCoursierRequest(long orderId){
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("create-coursier",((Long) orderId).toString());
		
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));

		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);
		
		return future;
	}

	//notify accident coursier
	public RequestReplyFuture<String, String, String> sendAccidentCoursierRequest(String cause){
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("accident-coursier",cause);
		
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));

		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);
		return future;
	}

	//display orders around me
	public RequestReplyFuture<String, String, String> sendOrdersAroundMetCoursierRequest(String cause){
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-coursier-orders-aroundme",cause);
		
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));

		RequestReplyFuture<String, String, String> future = kafka.sendAndReceive(record);

		return future;
	}

}
