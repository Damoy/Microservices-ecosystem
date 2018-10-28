package com.lama.mse.coursiers.accounts.modification.kafka;

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

}
