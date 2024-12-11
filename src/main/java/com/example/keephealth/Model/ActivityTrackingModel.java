package com.example.keephealth.Model;

public class ActivityTrackingModel {

    private boolean checkIn;
    private int ExerciseDuration;
    private int CalBurned ;

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

    public int getExerciseDuration() {
        return ExerciseDuration;
    }

    public void setExerciseDuration(int exerciseDuration) {
        ExerciseDuration = exerciseDuration;
    }



}
