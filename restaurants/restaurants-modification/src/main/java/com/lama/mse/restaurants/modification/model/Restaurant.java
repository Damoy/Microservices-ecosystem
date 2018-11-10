package com.lama.mse.restaurants.modification.model;

import com.google.gson.Gson;

public class Restaurant {

	private String name;
    private String address;
    private String adminLogin;
    private String hashedPassWord; 
    private String phoneNumber;
    private String fax;
   
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminLogin() {
        return this.adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getHashedPassWord() {
        return this.hashedPassWord;
    }

    public void setHashedPassWord(String hashedPassWord) {
        this.hashedPassWord = hashedPassWord;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    @Override
    public String toString() {
    	return new Gson().toJson(this);
    }
}

