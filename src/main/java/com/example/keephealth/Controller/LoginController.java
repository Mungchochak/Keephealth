package com.example.keephealth.Controller;

import com.example.keephealth.Model.UserModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginController {
    @FXML
    private Button LoginButton;
    @FXML
    private Button SignupButton;
    @FXML
    private TextField AccountNameInput;
    @FXML
    private TextField PasswordInput;

    String filepath = RegisterController.Fileuser;

    private static int CurrentId;

    public static int getCurrentId() {
        return CurrentId;
    }

    public void setCurrentId(int currentId) {
        CurrentId = currentId;
    }





    @FXML
    private void handleLoginButtonClick() {
        UserModel CurrentUser = new UserModel();
        boolean isCorrect= Checkaccount(CurrentUser);

        if(isCorrect){
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




   private boolean Checkaccount(UserModel CurrentUser) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Wrong Account");
        alert.setHeaderText(null);
        alert.setContentText("Please enter Correct account!");


        CurrentUser.setUsername(AccountNameInput.getText());
        CurrentUser.setPassword(PasswordInput.getText());

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String data;
            while ((data = reader.readLine()) != null) {
                String[] userdata = data.split("/");
                if (userdata[1].equals(CurrentUser.getUsername())&&userdata[2].equals(CurrentUser.getPassword())) {

                    CurrentId = Integer.parseInt(userdata[0]);
                    System.out.println("Current userID: "+ CurrentId);
                    return true;

                }

            }

            CurrentId = -1;
            System.out.println(CurrentId);
            alert.showAndWait();
            return false;

        }catch (IOException e){
            e.printStackTrace();
        }

        return false;
    }
}