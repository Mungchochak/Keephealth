package com.example.keephealth.Controller;

import com.example.keephealth.Model.WorkoutPlanModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.TextField;


public class WorkoutPlansController {
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


    @FXML
    private TextField Calorieinput;

    @FXML
    private TextField Weightinput;

    @FXML
    private TextField Workoutinput;



    @FXML
    private Label Calorieoutput;

    @FXML
    private Label Weightoutput;



    @FXML
     private Label Workoutoutput;
     private  String userCalorieInput;
     private  String userWorkoutInput;
     private  String userWeightInput;
     private int Currentid;



    @FXML
    private void handlesetB1Button() {
        WorkoutPlanModel workoutPlanModel = new WorkoutPlanModel();

        Currentid = LoginController.getCurrentId();

        System.out.println(Currentid);

    }

    @FXML
    private void handlesetB2Button() {
        WorkoutPlanModel workoutPlanModel = new WorkoutPlanModel();

        Currentid = LoginController.getCurrentId();

        System.out.println(Currentid);

    }
    @FXML
    private void handlesetB3Button() {
        WorkoutPlanModel workoutPlanModel = new WorkoutPlanModel();

        Currentid = LoginController.getCurrentId();

        System.out.println(Currentid);

    }


    @FXML
    private Button SetButtonOne;
    @FXML
    private Button SetButtonTwo;
    @FXML
    private Button SetButtonThree;

    @FXML
    public void initialize() {

        SetButtonOne.setOnAction(event -> {
            String inputText = Calorieinput.getText();
            if (!inputText.isEmpty() && inputText.matches("\\d+")) {
                Calorieoutput.setText(inputText );
                Calorieinput.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input error");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Please input valid number！");
                alert.showAndWait();
            }
        });
        SetButtonTwo.setOnAction(event -> {
            String inputTextOne = Workoutinput.getText();
            if (!inputTextOne.isEmpty() && inputTextOne.matches("\\d+")) {
                Workoutoutput.setText(inputTextOne);
                Workoutinput.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input error");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Please input valid number！");
                alert.showAndWait();
            }
        });

        SetButtonThree.setOnAction(event -> {
            String inputTextTwo = Weightinput.getText();
            if (!inputTextTwo.isEmpty() && inputTextTwo.matches("\\d+")) {
                Weightoutput.setText(inputTextTwo);
                Weightinput.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input error");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Please input valid number！");
                alert.showAndWait();
            }
        });



    }






}





