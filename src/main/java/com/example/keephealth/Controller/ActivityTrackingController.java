package com.example.keephealth.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ActivityTrackingController {

    public Button MarkButton;
    public Label CheckInOutput;
    public TextFlow DailyEncouragement;
    //Record Part
    public Label FinalBurnedCalOutput;
    public Button RecordButton;
    //Choice of Exercise button
    public Button WalikingButton;
    public Button HikingButton;
    public Button CyclingButton;
    public Button PushUpButton;
    public Button SwimmingButton;
    public Button PullUpButton;
    //Input Duration
    public TextField DurationInput;
    public Button ConfirmButton;
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

    private void dailyEncouragement() {
        ArrayList<String> encouragements = new ArrayList<>();
        encouragements.add(1,"If you give up at the first sign of struggle, you're really not ready to be successful — Kevin Hart");
        encouragements.add(2,"'Everyone's dream can come true if you just stick to it and work hard.' —Serena Williams");
        encouragements.add(3,"“The successful warrior is the average man with laser-like focus.” —Bruce Lee ");
        encouragements.add(4,"“Never give up because great things take time.” —Adrian Williams");
        encouragements.add(5,"\"Nothing is impossible; the word itself says ‘I'm possible!’\" —Audrey Hepburn");
        encouragements.add(6,"“Never give up on a dream just because of the time it will take to accomplish it. The time will pass anyway.” —Earl Nightingale");
        encouragements.add(7,"“Just believe in yourself. Even if you don’t, pretend that you do, and at some point, you will.\" —Venus Williams");
        encouragements.add(8,"Believe you can, and you're halfway there.");
        Random randQuote = new Random();
        int quote = randQuote.nextInt(encouragements.size())+1;



    }
    
    
    


}