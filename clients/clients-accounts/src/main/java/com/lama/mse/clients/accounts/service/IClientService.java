package com.lama.mse.clients.accounts.service;

import com.lama.mse.clients.accounts.model.Client;

public interface IClientService {
	
	public Client findByMail(String mail);
	public void addClient(Client client);
	public void deleteClient(String mail);
	public Client editClientName(String mail, String name);
	public Client editClientAddress(String mail, String Adress);
	public Client editClientPhone(String mail, int phoneNumber);
	public Client editClientCreditCard(String mail, String creditCard);

}
