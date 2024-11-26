package com.example.keephealth;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button LoginButton;
    @FXML
    private Button SignupButton;

    @FXML
    private void handleLoginButtonClick() {
        System.out.println("Login button clicked!");
        try {
            Stage stage = (Stage) LoginButton.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Home-view.fxml"));
            Scene scene = new Scene(loader.load());

            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSighupButtonClick() {
        try{
            Stage stage = (Stage) SignupButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Register-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}