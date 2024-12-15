package com.example.keephealth.Model;

public class FitnessData {

    private String month;
    private int fitnessdays;



    public FitnessData(String month, int fitnessdays) {
        this.fitnessdays =fitnessdays;
        this.month = month;
    }

    public FitnessData() {

    }





    public int getFitnessdays() {
        return fitnessdays;
    }

    public void setFitnessdays(int fitnessdays) {
        this.fitnessdays = fitnessdays;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


}
