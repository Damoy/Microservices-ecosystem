package com.lama.mse.coursier.account.kafka;

import com.lama.mse.coursier.account.model.Coursier;
import com.lama.mse.coursier.account.service.ICoursierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;


public class CoursierKafkaListener {

    @Autowired
    private ICoursierService coursierService;

    public CoursierKafkaListener() {
    }

    @KafkaListener(topics = "create-coursier",
			topicPartitions = {@TopicPartition(topic = "create-coursier", partitions = {"0"})})
    public void consultClientListener(Coursier coursier, Acknowledgment acknowledgment) {
        coursierService.findByEmail(coursier.getEmail());
        acknowledgment.acknowledge();
    }

}
