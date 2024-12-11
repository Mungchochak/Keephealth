package com.example.keephealth.Model;

public class ProfileModel {
    String name;
    String gender;
    String email;
    String phone;
    String weight;
    String height;
    String age;
    int currentid;

    public int getCurrentid() {
        return currentid;
    }

    public void setCurrentid(int currentid) {
        this.currentid = currentid;
    }


    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return currentid+"/"+name+"/"+gender+"/"+email+"/"+phone+"/"+weight+"/"+height+"/"+age;
    }
}
