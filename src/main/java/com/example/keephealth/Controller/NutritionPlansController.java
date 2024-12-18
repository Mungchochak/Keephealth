package com.example.keephealth.Controller;

import com.example.keephealth.Model.NutritionModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.example.keephealth.Controller.PublicMethod.ReadData;

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
    @FXML
    private Label bmiConditionLabel, bfpConditionLabel;

    private int intakeToday = 0;
    private int CurrentId = LoginController.getCurrentId();
    private NutritionModel UserModel;
    private int OldIntakeData;
    private LocalDate nowdate = LocalDate.now();
    private LocalDate Lastdate;

    public static boolean Clicked;
    public static int intakeonetimedata;
    public static int CheckinIntaketoday;


    public void ClassModel(){
        UserModel = new NutritionModel();
        UserModel.setUserId(CurrentId);
        UserModel.setIntakeToday(intakeToday);
        UserModel.setCheckinDate(nowdate);


    }


    @FXML
    public void initialize() {

        RenewData();
        ReadTodaysTotalIntakeData();
        totalCaloriesLabel.setText(String.valueOf(OldIntakeData));


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



    public void handleCheckinButton(){
        ReadTodaysTotalIntakeData();
        totalCaloriesLabel.setText(String.valueOf(OldIntakeData+intakeToday));
        SaveIntakeData();

        SaveTotalIntake();


    }



    public LocalDate getLastDate(){

        try(BufferedReader reader= new BufferedReader(new FileReader("NutritionData.txt"))){
            String data;

            data = reader.readLine() ;
            data = reader.readLine() ;
            String [] userData = data.split("/");
            Lastdate = LocalDate.parse(userData[2]);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return Lastdate;

    }


    public void RenewData(){
        Lastdate = getLastDate();
        if (Lastdate == null || Lastdate.isBefore(nowdate)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("NutritionData.txt"))) {
                writer.write("");
                writer.newLine();
                System.out.println("Renew Data");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("Didn't renew Data");
        }
    }



    public void SaveIntakeData(){

        List<String> lines = new ArrayList<>();
        ClassModel();



        try(BufferedReader reader= new BufferedReader(new FileReader("NutritionData.txt"))){
            String data;
            ReadTodaysTotalIntakeData();

            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (!userData[0].equals(Integer.toString(UserModel.getCurrentId()))) {
                    lines.add(data);
                }else {
                    UserModel.setIntakeToday(OldIntakeData+intakeToday);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("NutritionData.txt", false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }

            writer.write(UserModel.toString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ReadTodaysTotalIntakeData(){

        try(BufferedReader reader= new BufferedReader(new FileReader("NutritionData.txt"))){
            String data;
            ClassModel();

            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(UserModel.getCurrentId()))) {
                    OldIntakeData = Integer.parseInt(userData[1]);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


/*    public int GetTotalIntakeData(){

        try(BufferedReader reader= new BufferedReader(new FileReader("NutritionData.txt"))){
            String data;
            ClassModel();

            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(UserModel.getCurrentId()))) {
                    OldIntakeData = Integer.parseInt(userData[1]);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OldIntakeData;

    }*/










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
            String bmiStatus;
            String bmiColor; // 颜色
            if (bmi < 18.5) {
                bmiStatus = "Underweight";
                bmiColor = "red";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                bmiStatus = "Normal";
                bmiColor = "green";
            } else if (bmi >= 25 && bmi < 29.9) {
                bmiStatus = "Overweight";
                bmiColor = "red";
            } else {
                bmiStatus = "Obesity";
                bmiColor = "red";
            }

            // 显示 BMI 状态并设置颜色
            bmiConditionLabel.setText(bmiStatus);
            bmiConditionLabel.setStyle("-fx-text-fill: " + bmiColor + ";");


            // 计算BFP
            double bfp = (gender.equals("Male"))
                    ? (1.20 * bmi + 0.23 * age - 16.2)
                    : (1.20 * bmi + 0.23 * age - 5.4);
            bfpLabel.setText(String.format("%.2f", bfp));


            String bfpStatus;
            String bfpColor; // 颜色
            if (gender.equals("Male")) {
                if (bfp < 6) {
                    bfpStatus = "Underfat";
                    bfpColor = "red";
                } else if (bfp >= 6 && bfp < 25) {
                    bfpStatus = "Healthy";
                    bfpColor = "green";
                } else if (bfp >= 25 && bfp < 30) {
                    bfpStatus = "Overfat";
                    bfpColor = "red";
                } else {
                    bfpStatus = "Obese";
                    bfpColor = "red";
                }
            } else {
                if (bfp < 16) {
                    bfpStatus = "Underfat";
                    bfpColor = "red";
                } else if (bfp >= 16 && bfp < 30) {
                    bfpStatus = "Healthy";
                    bfpColor = "green";
                } else if (bfp >= 30 && bfp < 35) {
                    bfpStatus = "Overfat";
                    bfpColor = "red";
                } else {
                    bfpStatus = "Obese";
                    bfpColor = "red";
                }
            }

            // 显示 BFP 状态并设置颜色
            bfpConditionLabel.setText(bfpStatus);
            bfpConditionLabel.setStyle("-fx-text-fill: " + bfpColor + ";");

            // 显示 BFP 状态
            bfpConditionLabel.setText(bfpStatus);

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
    public void handleComfirmButton() {
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
            intakeToday = 0+calorieTaken;

        } catch (NumberFormatException e) {
            System.out.println("please enter valid number！");
        }
    }










   /* public void startDailyResetTask() {
        // 计算从当前时间到今天 0 点的时间差
        Calendar now = Calendar.getInstance();
        Calendar midnight = Calendar.getInstance();
        midnight.set(Calendar.HOUR_OF_DAY, 0);
        midnight.set(Calendar.MINUTE, 0);
        midnight.set(Calendar.SECOND, 0);
        midnight.set(Calendar.MILLISECOND, 0);

        // 如果当前时间已经过了 0 点，则设置为明天 0 点
        if (now.after(midnight)) {
            midnight.add(Calendar.DATE, 1);
        }

        // 计算从当前时间到 0 点的剩余时间（毫秒）
        long initialDelay = midnight.getTimeInMillis() - now.getTimeInMillis();

        // 每天 0 点重置 intakeToday
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            resetIntakeToday();
        }, initialDelay, TimeUnit.DAYS.toMillis(1), TimeUnit.MILLISECONDS);
    }

    // 重置 intakeToday 为 0，并更新 UI 显示
    private void resetIntakeToday() {
        intakeToday = 0; // 重置今日卡路里值
        System.out.println("intakeToday has been reset at midnight.");

        // 更新 UI 上显示的卡路里值
        totalCaloriesLabel.setText("0.00 cal");
    }

    // 在构造器或初始化方法中启动定时任务
    public NutritionPlansController() {
        startDailyResetTask(); // 启动每日 0 点重置卡路里的定时任务
    }*/












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




    public void SaveTotalIntake(){
        List<String> lines = new ArrayList<>();
        ClassModel();
        int TotalOldData = Integer.parseInt(ReadData(UserModel.getCurrentId(),1,"TotalIntakeData.txt"));



        try(BufferedReader reader= new BufferedReader(new FileReader("TotalIntakeData.txt"))){
            String data;
            ReadTodaysTotalIntakeData();

            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (!userData[0].equals(Integer.toString(UserModel.getCurrentId()))) {
                    lines.add(data);
                }else {
                    UserModel.setIntakeToday(TotalOldData+intakeToday);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TotalIntakeData.txt", false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }

            writer.write(UserModel.toStringNodate());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }








}


