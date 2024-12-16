package com.example.keephealth.Model;

public class HomeModel {
    int id;
    String CheckingDays;
    String BurningToday;
    String IntakeToday;
    String CalGoalRemaining;

    public String getIntakeToday() {
        return IntakeToday;
    }

    public void setIntakeToday(String intakeToday) {
        IntakeToday = intakeToday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckingDays() {
        return CheckingDays;
    }

    public void setCheckingDays(String checkingDays) {
        CheckingDays = checkingDays;
    }

    public String getCalGoalRemaining() {
        return CalGoalRemaining;
    }

    public void setCalGoalRemaining(String calGoalRemaining) {
        CalGoalRemaining = calGoalRemaining;
    }

    public String getBurningToday() {
        return BurningToday;
    }

    public void setBurningToday(String burningToday) {
        BurningToday = burningToday;
    }


}
