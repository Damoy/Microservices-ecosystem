package com.lama.mse.coursiers.accounts.modification.kafka;

import com.lama.mse.coursiers.accounts.modification.model.Coursier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

import com.lama.mse.coursiers.accounts.modification.service.ICoursierService;

@KafkaListener
public class CoursierKafkaListener {

    @Autowired
    private ICoursierService coursierService;

    public CoursierKafkaListener() {
    }

    @KafkaListener(topics = "create-coursier")
    public void consultClientListener(Coursier coursier, Acknowledgment acknowledgment) {
        coursierService.findByEmail(coursier.getEmail());
        acknowledgment.acknowledge();
    }

}
