package com.lama.mse.clients.modification.accounts.service;

public interface IClientService {
	
	public void addClient(String email);
	public void deleteClient(String email);
	public void modifyClientName(String email, String name);
	public void modifyClientAdress(String email, String Adress);
	public void modifyClientPhone(String email, int phoneNumber);
	
}
