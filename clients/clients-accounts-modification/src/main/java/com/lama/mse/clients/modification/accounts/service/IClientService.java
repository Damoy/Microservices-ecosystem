package com.lama.mse.clients.modification.accounts.service;

import com.lama.mse.clients.modification.accounts.model.Client;

public interface IClientService {
	
	public void addClient(Client client);
	public void deleteClient(String mail);
	public void modifyClientName(String mail, String name);
	public void modifyClientAddress(String mail, String Adress);
	public void modifyClientPhone(String mail, int phoneNumber);
	
}
