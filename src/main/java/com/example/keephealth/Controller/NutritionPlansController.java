package com.example.keephealth.Controller;

import com.example.keephealth.Model.NutritionModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
    private TextField heightInput;
    @FXML
    private TextField weightInput;
    @FXML
    private TextField ageInput;
    @FXML
    private ChoiceBox<String> genderChoiceBox;
    @FXML
    private ComboBox<String> activityLevelChoiceBox;
    @FXML
    private Label bmiLabel;
    @FXML
    private Label bfpLabel;
    @FXML
    private Label bmrLabel;
    @FXML
    private Label tdeeLabel;
    @FXML
    private ComboBox<String> foodChoiceBox;
    @FXML
    private TextField foodWeightInput;
    @FXML
    private Label calorieTakenLabel;
    @FXML
    private Label totalCaloriesLabel;
    @FXML
    private Button checkin;
    @FXML
    private Button confirmBasicInfoButton;
    @FXML
    private Button confirmFoodButton;
    @FXML
    private Label bmiConditionLabel, bfpConditionLabel;

    private int intakeToday = 0;
    private int CurrentId = LoginController.getCurrentId();
    private NutritionModel UserModel;
    private int OldIntakeData;
    private LocalDate nowdate = LocalDate.now();
    private LocalDate Lastdate;



    //Creat a model method, simplify create object of model
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



        genderChoiceBox.getItems().addAll("Male", "Female");
        genderChoiceBox.setValue("Male");


        activityLevelChoiceBox.getItems().addAll("Sedentary", "Lightly active", "Moderately active", "Very active");
        activityLevelChoiceBox.setValue("Sedentary");


        foodChoiceBox.getItems().addAll("Beef", "Chicken", "Rice", "Egg", "Milk","Vegetable","Pork");
        foodChoiceBox.setValue("Beef");
    }



    //Click checking button to save current user intake calories
    public void handleCheckinButton(){
        ReadTodaysTotalIntakeData();
        totalCaloriesLabel.setText(String.valueOf(OldIntakeData+intakeToday));
        SaveIntakeData();

        SaveTotalIntake();


    }



    //Read user's last record date
    public LocalDate getLastDate(){
        Lastdate = null;

        try(BufferedReader reader= new BufferedReader(new FileReader("NutritionData.txt"))){
            String data;

            reader.readLine() ;
            data = reader.readLine();
            if (data != null && !data.isEmpty()) {
                String[] userData = data.split("/");
                if (userData.length >= 3) {
                    try {
                        Lastdate = LocalDate.parse(userData[2]);
                    } catch (Exception e) {

                    }
                }
            }
        } catch (IOException e) {

        }

        return Lastdate;

    }


    //If it is a new day, that will renew user's data
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



    //Save user's intake data
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


    // Read today's user total intake data,not just for one time
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





    //Click BMI function confirm button that get result
    public void handleConfirmBasicInfoButton() {
        try {
            double height = Double.parseDouble(heightInput.getText());
            double weight = Double.parseDouble(weightInput.getText());
            int age = Integer.parseInt(ageInput.getText());
            String gender = genderChoiceBox.getValue();
            String activityLevel = activityLevelChoiceBox.getValue();


            double bmi = weight / Math.pow(height / 100.0, 2);
            bmiLabel.setText(String.format("%.2f", bmi));
            String bmiStatus;
            String bmiColor;
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


            bmiConditionLabel.setText(bmiStatus);
            bmiConditionLabel.setStyle("-fx-text-fill: " + bmiColor + ";");



            double bfp = (gender.equals("Male"))
                    ? (1.20 * bmi + 0.23 * age - 16.2)
                    : (1.20 * bmi + 0.23 * age - 5.4);
            bfpLabel.setText(String.format("%.2f", bfp));


            String bfpStatus;
            String bfpColor;
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


            bfpConditionLabel.setText(bfpStatus);
            bfpConditionLabel.setStyle("-fx-text-fill: " + bfpColor + ";");


            bfpConditionLabel.setText(bfpStatus);


            double bmr = (gender.equals("Male"))
                    ? (10 * weight + 6.25 * height - 5 * age + 5)
                    : (10 * weight + 6.25 * height - 5 * age - 161);
            bmrLabel.setText(String.format("%.2f", bmr));


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


    //Click calories record function comfirm button that get this time the food calories
    @FXML
    public void handleComfirmButton() {
        try {
            String food = foodChoiceBox.getValue();
            double foodWeight = Double.parseDouble(foodWeightInput.getText());


            Map<String, Double> calorieMap = Map.of(
                    "Beef", 1.5,
                    "Chicken", 2.5,
                    "Rice", 1.3,
                    "Egg", 1.4,
                    "Milk", 0.6,
                    "Vegetable", 0.5,
                    "Pork",2.5
            );



            int calorieTaken = (int) ((calorieMap.get(food)) * foodWeight);
            calorieTakenLabel.setText(String.format("%d ", calorieTaken));


            intakeToday = 0+calorieTaken;

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




    //Save user's total intake data for workout plans chart.
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


