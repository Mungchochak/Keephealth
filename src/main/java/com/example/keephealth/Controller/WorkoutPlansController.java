package com.example.keephealth.Controller;

import com.example.keephealth.Model.WorkoutPlanModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    private Button MediaoneButton;


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
    private void handleMediaoneButton() {

        try {
            Stage stage = (Stage) MediaoneButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Mediaone.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Media player");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleMediaTwoButton() {

        try {
            Stage stage = (Stage) MediaoneButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Mediatwo.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Media player");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleMediaThreeButton() {

        try {
            Stage stage = (Stage) MediaoneButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Mediathree.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Media player");
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
    public static final String Fileuser = "Workoutplans.txt";
     private int Currentid;


     private int getcurrentId(){


         Currentid = LoginController.getCurrentId();

         System.out.println(Currentid);

         return Currentid;

     }





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






    private void SavecalInfo(WorkoutPlanModel model){
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader= new BufferedReader(new FileReader(Fileuser))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (!userData[0].equals(Integer.toString(Currentid))) {
                    lines.add(data);

                } if (userData[0].equals(Integer.toString(Currentid))) {
                    model.setWeightTarget(Integer.parseInt(userData[3]));
                    model.setWorkoutTarget(Integer.parseInt(userData[2]));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Fileuser, false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }

            writer.write(model.toString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    private void SavehoursInfo(WorkoutPlanModel model){
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader= new BufferedReader(new FileReader(Fileuser))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (!userData[0].equals(Integer.toString(Currentid))) {
                    lines.add(data);

                } if (userData[0].equals(Integer.toString(Currentid))) {
                    model.setCalorieTarget(Integer.parseInt(userData[1]));
                    model.setWeightTarget(Integer.parseInt(userData[3]));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Fileuser, false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }

            writer.write(model.toString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void SaveWeightInfo(WorkoutPlanModel model){
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader= new BufferedReader(new FileReader(Fileuser))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (!userData[0].equals(Integer.toString(Currentid))) {
                    lines.add(data);

                } if (userData[0].equals(Integer.toString(Currentid))) {
                    model.setCalorieTarget(Integer.parseInt(userData[1]));
                    model.setWorkoutTarget(Integer.parseInt(userData[2]));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Fileuser, false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }

            writer.write(model.toString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void showinfo(){

        try(BufferedReader reader= new BufferedReader(new FileReader(Fileuser))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(Currentid))) {

                    Calorieoutput.setText(userData[1]);
                    Workoutoutput.setText(userData[2]);
                    Weightoutput.setText(userData[3]);



                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }








    @FXML
    private Button SetButtonOne;
    @FXML
    private Button SetButtonTwo;
    @FXML
    private Button SetButtonThree;

    public static WorkoutPlanModel Model;






    @FXML
    public void initialize() {
        Model = new WorkoutPlanModel();
        Model.setId(getcurrentId());
        showinfo();










        SetButtonOne.setOnAction(event -> {

            String inputText = Calorieinput.getText();

            if (!inputText.isEmpty() && inputText.matches("\\d+")) {
                int IntCalorieinput = Integer.parseInt(Calorieinput.getText());

                if (IntCalorieinput >= 100000) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Input error");
                    alert.setHeaderText("Invalid input");
                    alert.setContentText("Please No more than 100,000！");
                    alert.showAndWait();
                } else {
                    Calorieoutput.setText(inputText );
                    Model.setCalorieTarget(Integer.parseInt(inputText));
                    System.out.println("Calorietarget: " + Model.getCalorieTarget());
                    Calorieinput.clear();
                    SavecalInfo(Model);


                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input error");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Please input valid number！");
                alert.showAndWait();
            }
        });
        SetButtonTwo.setOnAction(event -> {
            String inputtext= Workoutinput.getText();

            if (!inputtext.isEmpty() && inputtext.matches("\\d+")) {
                int IntWorkoutinput = Integer.parseInt(Workoutinput.getText());

                if (IntWorkoutinput >= 1000) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Input error");
                    alert.setHeaderText("Invalid input");
                    alert.setContentText("Please No more than 1000 hours");
                    alert.showAndWait();
                } else {
                    Workoutoutput.setText(inputtext);
                    Model.setWorkoutTarget(Integer.parseInt(inputtext));
                    System.out.println("Workouttarget: " + Model.getWorkoutTarget());
                    Workoutinput.clear();
                    SavehoursInfo(Model);

                }
            }
            else {
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
                int IntWeightinput = Integer.parseInt(Weightinput.getText());

                if (IntWeightinput >= 250) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Input error");
                    alert.setHeaderText("Invalid input");
                    alert.setContentText("You won't be that strong");
                    alert.showAndWait();
                } else if (IntWeightinput <= 25 ) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Input error");
                    alert.setHeaderText("Invalid input");
                    alert.setContentText("That's not a healthy weight！");
                    alert.showAndWait();

                } else {
                    Weightoutput.setText(inputTextTwo );
                    Model.setWeightTarget(Integer.parseInt(inputTextTwo));
                    System.out.println("Weighttarget: " + Model.getWeightTarget());
                    Weightinput.clear();
                    SaveWeightInfo(Model);

                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input error");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Please input valid number！");
                alert.showAndWait();
            }
        });

    }










}





