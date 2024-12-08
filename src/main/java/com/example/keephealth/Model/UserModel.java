package com.example.keephealth.Model;



public class UserModel {
    private String username;
    private String password;
    private int userID;
    String registerdate;

    public UserModel() {
    }

    public UserModel(int userID,String username,String password,String registerdate) {
        this.password = password;
        this.userID = userID;
        this.username = username;
        this.registerdate = registerdate;
    }



    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }

    @Override
    public String toString() {
        return userID+"/"+username+"/"+password+"/"+registerdate;
    }




}

