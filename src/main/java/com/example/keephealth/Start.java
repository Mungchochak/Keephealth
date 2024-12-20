package com.example.keephealth;

import com.example.keephealth.Controller.PublicMethod;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class Start extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 740, 490);
        stage.setTitle("Keephealth");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        String[] fileNames = {
                "Accounts.txt",
                "CalBurned.txt",
                "CheckInData.txt",
                "DailyCalBurned.txt",
                "NutritionData.txt",
                "Profiledata.txt",
                "TotalCalBurned.txt",
                "TotalIntakeData.txt",
                "Workoutplans.txt",
                "CurrentYearDate.txt"
        };
        PublicMethod.initializeFiles(fileNames);
        if(PublicMethod.isTextFileEmpty("CurrentYearDate.txt")){
            PublicMethod.CreatYearDate();
            System.out.println("Current Year Date");
        }else {
            PublicMethod.RenewYear();
            System.out.println("Renew Year");
        }



        launch();
    }
}