package com.example.keephealth.Controller;

import com.example.keephealth.Model.ProfileModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ActivityTrackingController {
    //Check In Part
    public Button MarkButton;
    public Label CheckInOutput;
    public TextFlow DailyEncouragement;
    //Record Part
    public Label FinalBurnedCalOutput;
    public Button RecordButton;
    //Choice of Exercise buttons
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

    private int currentid = LoginController.getCurrentId();


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
    public void initialize() {
        dailyEncouragement();
        ShowBurnedCal();

    }

    private void ShowBurnedCal(){
        choiceOfExercise();
        //this part return the burned calories
        ConfirmButton.setOnAction(actionEvent -> {
            double calories = calculateCalBurned(mode,duration);
            FinalBurnedCalOutput.setText(calories+" Cal");
        });

    }

    private void dailyEncouragement() {

        ArrayList<String> encouragements = new ArrayList<>();
        encouragements.add("If you give up at the first sign of struggle, you're really not ready to be successful — Kevin Hart");
        encouragements.add("'Everyone's dream can come true if you just stick to it and work hard.' —Serena Williams");
        encouragements.add("“The successful warrior is the average man with laser-like focus.” —Bruce Lee ");
        encouragements.add("“Never give up because great things take time.” —Adrian Williams");
        encouragements.add("\"Nothing is impossible; the word itself says ‘I'm possible!’\" —Audrey Hepburn");
        encouragements.add("“Never give up on a dream just because of the time it will take to accomplish it. The time will pass anyway.” —Earl Nightingale");
        encouragements.add("“Just believe in yourself. Even if you don’t, pretend that you do, and at some point, you will.\" —Venus Williams");
        encouragements.add("Believe you can, and you're halfway there.");
        encouragements.add("Every day is another chance to get stronger, to eat better, to live healthier, and to be the best version of you.");

        Random randQuote = new Random();
        int n = randQuote.nextInt(encouragements.size());
        String quote = encouragements.get(n);

        Text text1 = new Text(quote);
        DailyEncouragement.getChildren().clear();
        DailyEncouragement.getChildren().add(text1);
    }

    public String mode,duration;

    private void choiceOfExercise(){
        WalikingButton.setOnAction(event -> {
            mode = "Walking";
            System.out.println(mode);
        });
        HikingButton.setOnAction(event -> {
            mode = "Hiking";
            System.out.println(mode);
        });
        CyclingButton.setOnAction(event -> {
            mode = "Cycling";
            System.out.println(mode);
        });
        PushUpButton.setOnAction(event -> {
            mode = "Push Up";
        });
        SwimmingButton.setOnAction(event -> {
            mode = "Swimming";
        });
        PullUpButton.setOnAction(event -> {
            mode = "Pull Up";
        });
        duration = DurationInput.getText();

    }




    private double calculateCalBurned(String m, String d){
        String w =" ";
        try(BufferedReader reader= new BufferedReader(new FileReader("Profiledata.txt"))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(currentid))) {
                    if (userData.length > 5) {
                        w = userData[5];
                    } else {
                        throw new IllegalArgumentException("Insufficient data for the current user in the file.");
                    }
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        double calBurned = 0, MET;
        double weight = Double.parseDouble(w);
        double dur = Double.parseDouble(d);
        switch (m){
            case "Walking":
                MET = 3.3;
                calBurned = MET * weight * dur;
                break;

            case "Hiking":
                MET = 6.0;
                calBurned = MET * weight * dur;
                break;

            case "Cycling":
                MET = 6.8;
                calBurned = MET * weight * dur;
                break;

            case "Push Up":
                MET = 3.8;
                calBurned = MET * weight * dur;
                break;

            case "Swimming":
                MET = 7.0;
                calBurned = MET * weight * dur;
                break;

            case "Pull Up":
                MET = 5.0;
                calBurned = MET * weight * dur;
                break;

        }
        return calBurned;

    }
    
    


}