package com.lama.mse.coursiers.accounts.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.lama.mse.coursiers.accounts.model.Coursier;


@Component
public class KafkaIO  {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaIO(){
		
	}

	public void sendCreationCoursierMessage(String coursier) {
		kafkaTemplate.send("coursier-created", coursier);
	}

	public void sendConsultedCoursierMessage(String coursier) {
		kafkaTemplate.send("coursier-consulted", coursier);
	}

	public void sendDeletedCoursierMessage(String coursier) {
		kafkaTemplate.send("coursier-deleted", coursier);
	}

	public void sendModifiedEmailMessage(String coursier) {
		kafkaTemplate.send("coursier-modified-email", coursier);
	}

	public void sendModifiedPhoneNumberMessage(String coursier) {
		kafkaTemplate.send("coursier-modified-phone", coursier);
	}

	public void sendModifiedNameMessage(String coursier) {
		kafkaTemplate.send("coursier-modified-name", coursier);
	}

	public void sendModifiedLocationMessage(String coursier) {
		kafkaTemplate.send("coursier-modified-location", coursier);
	}


}
