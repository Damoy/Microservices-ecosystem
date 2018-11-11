package com.lama.mse.clients.controller.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.lama.mse.clients.controller.commons.Logs;

@Component
public class KafkaIO {

	@Autowired
	private ReplyingKafkaTemplate<String, String, String> template;
	
	public KafkaIO() {}
	
	public RequestReplyFuture<String,String,String>  sendCreateOrderRequest(String orderJson) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("create-order", orderJson);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String,String,String> future = template.sendAndReceive(record);
		Logs.infoln("Sent create-order.");
		return future;
	}
	
	public RequestReplyFuture<String,String,String>  sendCreateClientRequest(String clientJson) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("create-client", clientJson);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String,String,String>  future = template.sendAndReceive(record);
		Logs.infoln("Sent create-client.");
		return future;
	}
	
	public RequestReplyFuture<String,String,String>  sendConsultClientRequest(String clientMail) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-client", clientMail);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String,String,String>  future = template.sendAndReceive(record);
		Logs.infoln("Sent consult-client.");
		return future;
	}
	
	public RequestReplyFuture<String,String,String>  sendConsultClientOrdersRequest(String clientMail) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("consult-client-orders", clientMail);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String,String,String>  future = template.sendAndReceive(record);
		Logs.infoln("Sent consult-client-orders.");
		return future;
	}
	
	public RequestReplyFuture<String,String,String>  sendEditClientRequest(String mail, String clientAttribute, String attributeValue) {
		String verb = "edit-client";
		
		if(clientAttribute != null) {
			verb += "-" + clientAttribute;
		}
		
		String requestContent = mail + ";" + attributeValue;
		String replyVerb = "client-" + attributeValue + "-edited";
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(verb, requestContent);
		record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "topic".getBytes()));
		RequestReplyFuture<String,String,String>  future = template.sendAndReceive(record);
		
		Logs.infoln("Sent edit-client: " + requestContent);
		return future;
	}
	
}
