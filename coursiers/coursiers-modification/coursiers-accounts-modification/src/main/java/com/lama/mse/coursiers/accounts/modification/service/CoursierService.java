package com.lama.mse.coursiers.accounts.modification.service;

import ch.qos.logback.core.net.server.Client;

import com.lama.mse.coursiers.accounts.modification.kafka.IKafkaIO;
import com.lama.mse.coursiers.accounts.modification.model.Coursier;
import com.lama.mse.coursiers.accounts.modification.repository.ICoursierRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("CoursierService")
public class CoursierService implements ICoursierService{

    @Autowired
    private ICoursierRepository repository;

    @Autowired
    private IKafkaIO kafkaIO;

    public CoursierService() {
    	
    }

    @Override
    public Coursier findByEmail(String email) {
    	List<Coursier> coursiers = repository.findByEmail(email);
    	if(coursiers == null || coursiers.isEmpty()) return null;
    	return coursiers.get(0);
    }

    @Override
    public void modifyEmail(String email) {
        Coursier coursier = repository.findByEmail( email ).get(0);
        coursier.setEmail(email);
        kafkaIO.sendModifiedEmailMessage(coursier);
    }

    @Override
    public void modifyPhoneNumber(String email, int phone) {
        Coursier coursier = repository.findByEmail( email ).get(0);
        coursier.setPhone( phone );
        kafkaIO.sendModifiedPhoneNumberMessage(coursier);
    }

    @Override
    public void modifyName(String email, String name){
        Coursier coursier = repository.findByEmail( email ).get(0);
        coursier.setName( name );
        kafkaIO.sendModifiedNameMessage( coursier );
    }

    @Override
    public void modifyLocation(String email, String location) {
        Coursier coursier = repository.findByEmail( email ).get(0);
        coursier.setLocation( location );
        kafkaIO.sendModifiedLocationMessage( coursier );

    }

    @Override
    public void deleteCoursier(String email) {
        Coursier coursier = repository.findByEmail( email ).get(0);
        repository.delete( coursier );
        kafkaIO.sendDeletedCoursierMessage( coursier );
    }

}








