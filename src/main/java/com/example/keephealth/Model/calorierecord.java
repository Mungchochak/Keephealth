package com.example.keephealth.Model;
import java.time.LocalDate;

public class calorierecord {
    private int userID;
    private int totalcalorie;
    private LocalDate recordDate;
    public calorierecord(int userID, int totalcalorie, LocalDate recordDate) {
        this.userID = userID;
        this.totalcalorie = totalcalorie;
        this.recordDate = recordDate;
    }
    public int getUserID() {
        return userID;
    }
    public int getTotalcalorie() {
        return totalcalorie;
    }
    public LocalDate getRecordDate() {
        return recordDate;
    }
    public void setTotalcalorie(int totalcalorie) {
        this.totalcalorie = totalcalorie;
    }
    public LocalDate getCalorieDate() {
        return recordDate;
    }
    public void setCalorieDate(LocalDate recordDate) {
        this.recordDate = recordDate;

    }

    }


