package com.lama.mse.coursiers.accounts.modification.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.lama.mse.coursiers.accounts.modification.model.Coursier;

@Component
public class KafkaIO implements IKafkaIO {
	
	@Autowired
	private KafkaTemplate<String, Coursier> kafkaTemplate;
	
	public KafkaIO(){
		
	}
	
	@Override
	public void sendConsultedCoursierMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-consulted", coursier);
	}

	@Override
	public void sendDeletedCoursierMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-deleted", coursier);
	}

	@Override
	public void sendModifiedEmailMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-modified-email", coursier);
	}

	@Override
	public void sendModifiedPhoneNumberMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-modified-phone", coursier);
	}

	@Override
	public void sendModifiedNameMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-modified-name", coursier);
	}

	@Override
	public void sendModifiedLocationMessage(Coursier coursier) {
		kafkaTemplate.send("coursier-modified-location", coursier);
	}


}
