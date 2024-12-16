package com.example.keephealth.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class NutritionPlansController {
    @FXML
    private Button ProfileButton;

    @FXML
    private Button HomeButton;

    @FXML
    private Button WorkoutPlansButton;

    @FXML
    private Button NutritionPlansButton;

    @FXML
    private Button ActivityTrackingButton;

    @FXML
    private Button CustomerSupportButton;
    @FXML
    private Button LogoutButton;





    @FXML
    private TextField heightInput; // 身高输入框
    @FXML
    private TextField weightInput; // 体重输入框
    @FXML
    private TextField ageInput; // 年龄输入框
    @FXML
    private ChoiceBox<String> genderChoiceBox; // 性别选择框
    @FXML
    private ComboBox<String> activityLevelChoiceBox; // 活动水平选择框
    @FXML
    private Label bmiLabel; // 显示 BMI
    @FXML
    private Label bfpLabel; // 显示 BFP（体脂率）
    @FXML
    private Label bmrLabel; // 显示 BMR
    @FXML
    private Label tdeeLabel; // 显示 TDEE
    @FXML
    private ComboBox<String> foodChoiceBox; // 食物选择框
    @FXML
    private TextField foodWeightInput; // 食物重量输入框
    @FXML
    private Label calorieTakenLabel; // 显示摄入卡路里
    @FXML
    private Label totalCaloriesLabel; // 显示今日总摄入卡路里
    @FXML
    private Button checkin;
    @FXML
    private Button confirmBasicInfoButton; // 第一个Confirm按钮
    @FXML
    private Button confirmFoodButton; // 第二个Confirm按钮

    private double totalCalories = 0.0;
    @FXML
    public void initialize() {
        // 初始化性别
        genderChoiceBox.getItems().addAll("Male", "Female");
        genderChoiceBox.setValue("Male");

        // 初始化活动水平
        activityLevelChoiceBox.getItems().addAll("Sedentary", "Lightly active", "Moderately active", "Very active");
        activityLevelChoiceBox.setValue("Sedentary");

        // 初始化食物
        foodChoiceBox.getItems().addAll("Beef", "Chicken", "Rice", "Egg", "Milk","Vegetable","Pork");
        foodChoiceBox.setValue("Beef");
    }
    public void handleConfirmBasicInfoButton() {
        try {
            double height = Double.parseDouble(heightInput.getText());
            double weight = Double.parseDouble(weightInput.getText());
            int age = Integer.parseInt(ageInput.getText());
            String gender = genderChoiceBox.getValue();
            String activityLevel = activityLevelChoiceBox.getValue();

            // 计算BMI
            double bmi = weight / Math.pow(height / 100.0, 2);
            bmiLabel.setText(String.format("%.2f", bmi));

            // 计算BFP
            double bfp = (gender.equals("Male"))
                    ? (1.20 * bmi + 0.23 * age - 16.2)
                    : (1.20 * bmi + 0.23 * age - 5.4);
            bfpLabel.setText(String.format("%.2f", bfp));

            // 计算BMR
            double bmr = (gender.equals("Male"))
                    ? (10 * weight + 6.25 * height - 5 * age + 5)
                    : (10 * weight + 6.25 * height - 5 * age - 161);
            bmrLabel.setText(String.format("%.2f", bmr));

            // 计算TDEE
            double activityFactor = switch (activityLevel) {
                case "Sedentary" -> 1.2;
                case "Lightly active" -> 1.375;
                case "Moderately active" -> 1.55;
                case "Very active" -> 1.725;
                default -> 1.2;
            };
            double tdee = bmr * activityFactor;
            tdeeLabel.setText(String.format("%.2f", tdee));
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers for height, weight, and age.");
        }
    }

    @FXML
    public void handleCheckInButton() {
        try {
            String food = foodChoiceBox.getValue();
            double foodWeight = Double.parseDouble(foodWeightInput.getText());

            // 每100g食物的热量
            Map<String, Double> calorieMap = Map.of(
                    "Beef", 1.5,
                    "Chicken", 2.5,
                    "Rice", 1.3,
                    "Egg", 1.4,
                    "Milk", 0.6,
                    "Vegetable", 0.5,
                    "Pork",2.5
            );


            // 计算摄入热量
            int calorieTaken = (int) ((calorieMap.get(food)) * foodWeight);
            calorieTakenLabel.setText(String.format("%d ", calorieTaken));

// 累加到总热量
            totalCalories += calorieTaken;
            totalCaloriesLabel.setText(String.format("%d ", (int) totalCalories));

        } catch (NumberFormatException e) {
            System.out.println("please enter valid number！");
        }
    }










    @FXML
    private void handleProfileClick() {

        try {
            Stage stage = (Stage) ProfileButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Profile-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    @FXML
    private void handleHomeButtonClick() {

        try {
            Stage stage = (Stage) HomeButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Home-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleWorkoutPlansButtonClick() {

        try {
            Stage stage = (Stage) WorkoutPlansButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/WorkoutPlans-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleNutritionPlansButtonClick() {

        try {
            Stage stage = (Stage) NutritionPlansButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/NutritionPlans-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleActivityTrackingButtonClick() {

        try {
            Stage stage = (Stage) ActivityTrackingButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/ActivityTracking-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleCustomerSupportButtonClick() {

        try {
            Stage stage = (Stage) CustomerSupportButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/CustomerSupport-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @FXML
    private void handleLogoutButton() {
        try {
            Stage stage = (Stage) LogoutButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Login-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}


