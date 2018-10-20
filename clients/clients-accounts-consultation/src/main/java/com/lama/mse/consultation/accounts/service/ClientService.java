package com.lama.mse.consultation.accounts.service;

import com.lama.mse.consultation.accounts.model.Client;
import com.lama.mse.consultation.accounts.repository.IClientRepository;

//@Transactionnal
//@Service("ClientService")
public class ClientService implements IClientService {
	
	// @Autowired
	private IClientRepository repository;
	
	public void ClientService() {}
	
	@Override
	public Client findByEmail(String email) {
	//	return Repository.findByEmail(email)
		return null;
	}

}
