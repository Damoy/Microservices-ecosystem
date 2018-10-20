package com.lama.mse.consultation.accounts.repository;

import java.util.List;

import com.lama.mse.consultation.accounts.model.Client;

public interface IClientRepository // extends MongoRepository<Client, String> 
{
	
    public List<Client> findByMail(String mail);

}