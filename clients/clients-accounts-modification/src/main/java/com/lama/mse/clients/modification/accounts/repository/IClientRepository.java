package com.lama.mse.clients.modification.accounts.repository;

import java.util.List;

import com.lama.mse.clients.modification.accounts.model.Client;

public interface IClientRepository // extends MongoRepository<Client, String> 
{
	
    public List<Client> findByMail(String mail);


}
