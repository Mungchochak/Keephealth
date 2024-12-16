package com.example.keephealth.Model;

public class ActivityTrackingModel {

    private boolean checkIn;
    private double ExerciseDuration;
    private int CalBurned ;
    private int currentId;

    @Override
    public String toString() {
        return currentId+"/"+ExerciseDuration+"/"+CalBurned;
    }

    public int getCurrentId() {
        return currentId;
    }

    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public int getCalBurned() {
        return CalBurned;
    }

    public void setCalBurned(int calBurned) {
        CalBurned = calBurned;
    }

    public double getExerciseDuration() {
        return ExerciseDuration;
    }

    public void setExerciseDuration(double exerciseDuration) {
        ExerciseDuration = exerciseDuration;
    }



}
