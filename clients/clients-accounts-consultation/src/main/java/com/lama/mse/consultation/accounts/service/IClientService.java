package com.lama.mse.consultation.accounts.service;

import com.lama.mse.consultation.accounts.model.Client;

public interface IClientService {
	
	public Client findByEmail(String email);

}
