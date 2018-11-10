package com.lama.mse.coursier.account.kafka;

import com.lama.mse.coursier.account.model.Coursier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


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
