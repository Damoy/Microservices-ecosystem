package com.lama.mse.clients.accounts.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lama.mse.clients.accounts.model.Client;

public interface IClientRepository extends MongoRepository<Client, String>  {
	
    public List<Client> findByMail(String mail);

}