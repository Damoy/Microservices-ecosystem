package com.lama.mse.coursiers.accounts.kafka;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.lama.mse.coursiers.accounts.model.Coursier;
import com.lama.mse.coursiers.accounts.service.ICoursierService;

@Component
public class CoursierKafkaListener {

	@Autowired
	private ICoursierService coursierService;

	@Autowired
	private KafkaIO kafkaIO;

	public CoursierKafkaListener() {
	}

	@KafkaListener(id="createCoursier", topics="create-coursier", topicPartitions={
			@TopicPartition(topic="create-coursier", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String createCoursier(String coursierjson) {
		Coursier coursier = new Gson().fromJson(coursierjson, Coursier.class);
		coursierService.addCoursier(coursier);
		kafkaIO.sendCreationCoursierMessage(coursierjson);
		return "Coursier " + coursier.getMail() + " created.\n";
	}

	@KafkaListener(id="consultCoursier",topics = "consult-coursier", topicPartitions = {
			@TopicPartition(topic = "consult-coursier", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String consultCoursier(String coursierMail) {
		Gson gson = new Gson();
		Coursier coursierToConsult = coursierService.findByMail(coursierMail);
		String coursierJson = coursierToConsult != null ? gson.toJson(coursierToConsult) : null;
		kafkaIO.sendConsultedCoursierMessage(coursierJson);
		return coursierJson;
	}

	@KafkaListener(id="editEmailCoursier",topics = "edit-coursier-mail", topicPartitions = {
			@TopicPartition(topic = "edit-coursier-email", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String modifyEmailCoursier(String email, Acknowledgment acknowledgment) {
		String[] split = email.split(";");
		String sentMessageContent = null;

		if (split.length == 2) {
			Coursier coursier = coursierService.findByMail(split[0].trim());
			if (coursier != null)
				coursier.setMail(split[1].trim());
			sentMessageContent = new Gson().toJson(coursier);
		}

		kafkaIO.sendModifiedEmailMessage(sentMessageContent);
		acknowledgment.acknowledge();
		return sentMessageContent;
	}

	@KafkaListener(id="4",topics = "edit-coursier-name", topicPartitions = {
			@TopicPartition(topic = "edit-coursier-name", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String modifyNameCoursier(String name, Acknowledgment acknowledgment) {
		String[] split = name.split(";");
		String sentMessageContent = null;

		if (split.length == 2) {
			Coursier coursier = coursierService.findByMail(split[0].trim());
			if (coursier != null)
				coursier.setName(split[1].trim());
			sentMessageContent = new Gson().toJson(coursier);
		}
		kafkaIO.sendModifiedNameMessage(sentMessageContent);
		acknowledgment.acknowledge();
		return sentMessageContent;
	}

	@KafkaListener(id="5", topics = "edit-coursier-phone", topicPartitions = {
			@TopicPartition(topic = "edit-coursier-phone", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String modifyPhoneCoursier(String phone, Acknowledgment acknowledgment) {
		String[] split = phone.split(";");
		String sentMessageContent = null;

		if (split.length == 2) {
			Coursier coursier = coursierService.findByMail(split[0].trim());
			if (coursier != null)
				coursier.setPhone(Integer.parseInt(split[1].trim()));
			sentMessageContent = new Gson().toJson(coursier);
		}
		kafkaIO.sendModifiedPhoneNumberMessage(sentMessageContent);
		acknowledgment.acknowledge();
		return sentMessageContent;
	}

	@KafkaListener(id="6",topics = "edit-coursier-location", topicPartitions = {
			@TopicPartition(topic = "edit-coursier-location", partitions = { "0" }) })
	@SendTo(value= {"topic"})
	public String modifyLocatinCoursier(String location, Acknowledgment acknowledgment) {
		String[] split = location.split(";");
		String sentMessageContent = null;

		if (split.length == 2) {
			Coursier coursier = coursierService.findByMail(split[0].trim());
			if (coursier != null)
				coursier.setLocation(split[1].trim());
			sentMessageContent = new Gson().toJson(coursier);
		}
		kafkaIO.sendModifiedLocationMessage(sentMessageContent);
		acknowledgment.acknowledge();
		return sentMessageContent;
	}
	
}