package com.lama.mse.coursiers.orders.consultation.app.kafka;

import com.lama.mse.coursiers.orders.consultation.app.model.Coursier;
import com.lama.mse.coursiers.orders.consultation.app.service.ICoursierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

public class CoursierKafkaListener {

    @Autowired
    private ICoursierService coursierService;

    public CoursierKafkaListener() {
    }

    @KafkaListener(topics = "consult-orders")
    public void consultCoursieristener(Coursier coursier, Acknowledgment acknowledgment) {
        coursierService.findByEmail(coursier.getEmail());
        acknowledgment.acknowledge();
    }

}
