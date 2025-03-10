package com.example.keephealth.Model;

import java.time.LocalDate;

public class ActivityTrackingModel {

    private LocalDate LastCheckInDate;
    private double ExerciseDuration;
    private int CalBurned ;
    private int currentId;
    private int checkedInDays;
    private int checkedMonths;

    public int getCheckedMonths() {
        return checkedMonths;
    }

    public void setCheckedMonths(int checkedMonths) {
        this.checkedMonths = checkedMonths;
    }



    private LocalDate RecordDate;

    @Override
    public String toString() {
        return currentId+"/"+ExerciseDuration+"/"+CalBurned+"/"+RecordDate;
    }

    public LocalDate getRecordDate() {
        return RecordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        RecordDate = recordDate;
    }

    public int getCurrentId() {
        return currentId;
    }

    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    public LocalDate getLastCheckInDate() {
        return LastCheckInDate;
    }

    public void setLastCheckInDate(LocalDate LastCheckInDate) {
        this.LastCheckInDate = LastCheckInDate;
    }

    public int getCheckedInDays() {
        return checkedInDays;
    }

    public void setCheckedInDays(int checkedInDays) {
        this.checkedInDays = checkedInDays;
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


    public String toString2() {
        return currentId + "/" + LastCheckInDate + "/"+ checkedInDays;
    }

    public String TotaltoString() {
        return currentId + "/" + ExerciseDuration+"/"+CalBurned;
    }

    public String DailytoString() {
        return currentId + "/" +CalBurned;
    }

    public String MonthtoString() {
        return currentId + "/" +checkedMonths;
    }





}

