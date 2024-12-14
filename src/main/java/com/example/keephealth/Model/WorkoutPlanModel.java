package com.example.keephealth.Model;

public class WorkoutPlanModel {

    @Override
    public String toString() {
        return id+"/"+CalorieTarget+"/"+WorkoutTarget+"/"+WeightTarget;
    }

    public WorkoutPlanModel(int calorieTarget, int id, int weightTarget, int workoutTarget) {
        CalorieTarget = calorieTarget;
        this.id = id;
        WeightTarget = weightTarget;
        WorkoutTarget = workoutTarget;
    }

    private int id;
    private int CalorieTarget;
    private int WorkoutTarget;
    private int WeightTarget;




    public WorkoutPlanModel() {

    }

    public int getWorkoutTarget() {
        return WorkoutTarget;
    }

    public void setWorkoutTarget(int workoutTarget) {
        WorkoutTarget = workoutTarget;
    }


    public int getCalorieTarget() {
        return CalorieTarget;
    }

    public void setCalorieTarget(int calorieTarget) {
        CalorieTarget = calorieTarget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getWeightTarget() {
        return WeightTarget;
    }

    public void setWeightTarget(int weightTarget) {
        WeightTarget = weightTarget;
    }
}
