package com.lama.mse.coursiers.accounts.service;


import com.lama.mse.coursiers.accounts.model.Coursier;

public interface ICoursierService {


    public Coursier findByEmail(String email);
    public void deleteCoursier(String email);
    public void modifyEmail(String email);
    public void modifyPhoneNumber(String email, int phone);
    public void modifyName(String email, String name);
    public void modifyLocation(String email, String Location);


}
