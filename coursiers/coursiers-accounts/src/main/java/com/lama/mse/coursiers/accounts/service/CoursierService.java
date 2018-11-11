package com.lama.mse.coursiers.accounts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lama.mse.coursiers.accounts.kafka.KafkaIO;
import com.lama.mse.coursiers.accounts.model.Coursier;
import com.lama.mse.coursiers.accounts.repository.ICoursierRepository;

@Service("CoursierService")
public class CoursierService implements ICoursierService{

    @Autowired
    private ICoursierRepository repository;

    @Autowired
    private KafkaIO kafkaIO;

    public CoursierService() {
    	
    }

    @Override
    public void addCoursier(Coursier coursier) {
        repository.save(coursier);
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
        coursier.setMail(email);
        //kafkaIO.sendModifiedEmailMessage(coursier);
    }

    @Override
    public void modifyPhoneNumber(String email, int phone) {
        Coursier coursier = repository.findByEmail( email ).get(0);
        coursier.setPhone( phone );
        //kafkaIO.sendModifiedPhoneNumberMessage(coursier);
    }

    @Override
    public void modifyName(String email, String name){
        Coursier coursier = repository.findByEmail( email ).get(0);
        coursier.setName( name );
        //kafkaIO.sendModifiedNameMessage( coursier );
    }

    @Override
    public void modifyLocation(String email, String location) {
        Coursier coursier = repository.findByEmail( email ).get(0);
        coursier.setLocation( location );
        //kafkaIO.sendModifiedLocationMessage( coursier );

    }

    @Override
    public void deleteCoursier(String email) {
        Coursier coursier = repository.findByEmail( email ).get(0);
        repository.delete( coursier );
        //kafkaIO.sendDeletedCoursierMessage( coursier );
    }

}








