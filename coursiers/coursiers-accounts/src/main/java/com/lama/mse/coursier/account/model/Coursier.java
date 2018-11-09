package com.lama.mse.coursier.account.model;

import org.springframework.data.annotation.Id;

public class Coursier {

	//@Id
	private String email;
	private String name;
    private int phone;
    private String location;
    
    public Coursier() {
    }
    
	public Coursier(String email, String name, int phone, String location) {
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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