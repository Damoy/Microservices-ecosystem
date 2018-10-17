package com.lama.mse.database.restaurant.businessObjectRepresentation;

public class Restaurant {
    
    @ID
    private long ID;
    private String address;
    private String name;
    private String adminLogin;
    private String hashedPassWord; 
    private String phoneNumber;
    private String fax;

   


    public long getID() {
        return this.ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

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
        return "{" +
            " ID='" + getID() + "'" +
            ", address='" + getAddress() + "'" +
            ", name='" + getName() + "'" +
            ", adminLogin='" + getAdminLogin() + "'" +
            ", hashedPassWord='" + getHashedPassWord() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", fax='" + getFax() + "'" +
            "}";
    }
}

