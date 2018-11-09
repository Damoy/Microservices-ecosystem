package com.lama.mse.coursiers.accounts.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.lama.mse.coursiers.accounts.model.Coursier;


@Component
public class KafkaIO  {
	
	@Autowired
	private KafkaTemplate<String, Coursier> kafkaTemplate;
	
	public KafkaIO(){
		
	}
	
	public void sendConsultedCoursierMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-consulted", coursier);
	}

	public void sendDeletedCoursierMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-deleted", coursier);
	}

	public void sendModifiedEmailMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-modified-email", coursier);
	}

	public void sendModifiedPhoneNumberMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-modified-phone", coursier);
	}

	public void sendModifiedNameMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-modified-name", coursier);
	}

	public void sendModifiedLocationMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-modified-location", coursier);
	}


}
