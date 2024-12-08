package com.example.keephealth.Model;

public class WorkoutPlanModel {

    @Override
    public String toString() {
        return id+"/"+caloTaget+"/"+caloPercent+"/"+length;
    }

    private int id;
    private int caloTaget;
    private int caloPercent;
    private int length;

    public int getCaloPercent() {return caloPercent;}

    public void setCaloPercent(int caloPercent) {this.caloPercent = caloPercent;}

    public int getCaloTaget() {return caloTaget;}

    public void setCaloTaget(int caloTaget) {this.caloTaget = caloTaget;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getLength() {return length;}

    public void setLength(int length) {this.length = length;}
}
