package com.lama.mse.coursier.account.service;


import com.lama.mse.coursier.account.model.Coursier;

public interface ICoursierService {


    public Coursier findByEmail(String email);
    public void deleteCoursier(String email);
    public void modifyEmail(String email);
    public void modifyPhoneNumber(String email, int phone);
    public void modifyName(String email, String name);
    public void modifyLocation(String email, String Location);
    public void addCoursier(Coursier coursier);


}
