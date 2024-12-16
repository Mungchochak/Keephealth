package com.example.keephealth.Controller;


import com.example.keephealth.Model.FitnessData;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HomeController {
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
    private TableView<FitnessData> FitnessdaysTable;

    @FXML
    private TableColumn<FitnessData, String> monthColumn;

    @FXML
    private TableColumn<FitnessData, Integer> daysColumn;

    private ObservableList<FitnessData> data;

    @FXML
    private LineChart<String, Number> Caloriechart;

    public void initialize() {

        showTable();
        showChart();

    }




    private void showTable(){


        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<>("fitnessdays"));


        data = FXCollections.observableArrayList(
                new FitnessData("January", 10),
                new FitnessData("February", 15),
                new FitnessData("March", 20),
                new FitnessData("April", 30),
                new FitnessData("May", 25),
                new FitnessData("June", 18),
                new FitnessData("July", 22),
                new FitnessData("August", 28),
                new FitnessData("September", 19),
                new FitnessData("October", 26),
                new FitnessData("November", 24),
                new FitnessData("December", 31)
        );


        FitnessdaysTable.setItems(data);

    }


    private void showChart(){

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        series.setName("Calories per Day");


        series.getData().add(new XYChart.Data<>("Mon", 1000));
        series.getData().add(new XYChart.Data<>("Tue", 1200));
        series.getData().add(new XYChart.Data<>("Wed", 300));
        series.getData().add(new XYChart.Data<>("Thur", 900));
        series.getData().add(new XYChart.Data<>("Fri", 1100));
        series.getData().add(new XYChart.Data<>("Sat", 1400));
        series.getData().add(new XYChart.Data<>("Sun", 1500));


        Caloriechart.getData().add(series);

    }











}
