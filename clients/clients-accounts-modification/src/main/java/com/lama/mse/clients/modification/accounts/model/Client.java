package com.lama.mse.clients.modification.accounts.model;

public class Client {
	
	private int phoneNumber;
	private String mail;
    private String name;
    private String address;
    
    public Client() {}

    public Client(String mail, String name, String address, int phoneNumber) {
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
    }
    
    public String getMail() {
        return this.mail;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getNumber() {
        return this.phoneNumber;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
