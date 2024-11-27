package com.example.keephealth;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class RegisterController {
    @FXML private TextField AccountName;
    @FXML private TextField Password;
    @FXML private TextField ConfirmPassword;
    @FXML private Button BackButton;
    private static final String Fileuser = "Accounts.txt";
    String name;
    String password;
    String confirmPassword;



    @FXML
    private void handleBackButton() {
        try{
            Stage stage = (Stage) BackButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Login-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    @FXML
    private void handleRegister() {
        Alert alertempty = new Alert(Alert.AlertType.WARNING);
        alertempty.setTitle("Error");
        alertempty.setHeaderText(null);
        alertempty.setContentText("Account name or Password cannot be empty");

        Alert alertpdnotsame = new Alert(Alert.AlertType.WARNING);
        alertpdnotsame.setTitle("Error");
        alertpdnotsame.setHeaderText(null);
        alertpdnotsame.setContentText("Password and Confirm Password are not same");


        name = AccountName.getText();
        password = Password.getText();
        confirmPassword = ConfirmPassword.getText();

        if (name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                alertempty.showAndWait();
                System.out.println("Name or Password cannot be empty");
        } else if (!password.equals(confirmPassword)) {
            alertpdnotsame.showAndWait();
        } else{
            SaveAccount(name,password);
        }
    }


    private void SaveAccount(String name, String password){
        Alert SucessRegister = new Alert(Alert.AlertType.INFORMATION);
        SucessRegister.setTitle("Success");
        SucessRegister.setHeaderText(null);
        SucessRegister.setContentText("Account successfully registered!");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(Fileuser,true))) {
            writer.write(name +","+password);
            writer.newLine();
            SucessRegister.showAndWait();

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private void CheckAccountExist(String name){
        Alert alertExist = new Alert(Alert.AlertType.WARNING);
        alertExist.setTitle("Error");
        alertExist.setHeaderText(null);
        alertExist.setContentText("Account already exists");

        try(BufferedReader reader = new BufferedReader(new FileReader(Fileuser))){

        }catch (IOException e){
            e.printStackTrace();
        }

    }










}

