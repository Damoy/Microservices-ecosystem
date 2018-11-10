package com.lama.mse.coursiers.accounts.model;

public class Coursier {

	private String mail;
	private String name;
    private int phone;
    private String location;
    
    public Coursier() {
    }
    
	public Coursier(String mail, String name, int phone, String location) {
		this.mail = mail;
		this.name = name;
		this.phone = phone;
		this.location = location;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}