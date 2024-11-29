package com.example.keephealth;

public class UserModel {
    private String username;
    private String password;
    private int userID;

    public UserModel() {
    }

    public UserModel(int userID,String username,String password) {
        this.password = password;
        this.userID = userID;
        this.username = username;
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

    @Override
    public String toString() {
        return userID+"/"+username+"/"+password;
    }




}

