package com.lama.mse.coursiers.accounts.service;

import com.lama.mse.coursiers.accounts.model.Coursier;

public interface ICoursierService {

	
    public Coursier findByMail(String email);
    public void deleteCoursier(String email);
    public void modifyMail(String email);
    public void modifyPhoneNumber(String email, int phone);
    public void modifyName(String email, String name);
    public void modifyLocation(String email, String Location);
    public void addCoursier(Coursier coursier);
}
