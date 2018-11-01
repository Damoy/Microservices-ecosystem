package com.lama.mse.coursiers.accounts.modification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.coursiers.accounts.modification.model.Coursier;

import java.util.List;


public interface ICoursierRepository extends MongoRepository<Coursier, String> {


    public List<Coursier> findByEmail(String mail);


}
