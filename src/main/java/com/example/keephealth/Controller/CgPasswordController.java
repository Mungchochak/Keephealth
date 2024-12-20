package com.example.keephealth.Controller;

import com.example.keephealth.Model.UserModel;
import com.example.keephealth.Start;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CgPasswordController {
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
    private Button Comfirmbutton;





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

    //Click the back button back to profile page
    @FXML
    private void handleBackButton() {
        try {
            Stage stage = (Stage) LogoutButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Profile-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    @FXML
    private TextField OldPasswrodField;

    @FXML
    private TextField NewPasswrodField;

    @FXML
    private TextField ConfirmPasswrodField;

    private int currentid = LoginController.getCurrentId();


    private String OldPassword;
    private String NewPassword;
    private String ComfirmPassword;


    //Check old password if is correct
    public boolean CheckOldPassword(int id, String Password) {
        Alert alertnotcorrect = new Alert(Alert.AlertType.WARNING);
        alertnotcorrect.setTitle("Error");
        alertnotcorrect.setHeaderText(null);
        alertnotcorrect.setContentText("OldPassword is not correct");

        try (BufferedReader reader = new BufferedReader(new FileReader("Accounts.txt"))) {
            String data;
            while ((data = reader.readLine()) != null) {
                String[] userData = data.split("/");
                if (userData[0].equals(Integer.toString(id))) {
                    if (userData[2].equals(Password)) {
                        return true;
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        alertnotcorrect.showAndWait();
        return false;
    }



    //Check new password is same to Confirm new password
    public boolean CheckNewPassword(String NewPassword, String ConfirmPassword) {
        Alert alertnotcorrect = new Alert(Alert.AlertType.WARNING);
        alertnotcorrect.setTitle("Error");
        alertnotcorrect.setHeaderText(null);
        alertnotcorrect.setContentText("New Password and Confirm Password is not same");

        Alert alertempty = new Alert(Alert.AlertType.WARNING);
        alertempty.setTitle("Error");
        alertempty.setHeaderText(null);
        alertempty.setContentText("New Password and Confirm Password can not be empty");

        Alert alertsameoldpassword = new Alert(Alert.AlertType.WARNING);
        alertsameoldpassword.setTitle("Error");
        alertsameoldpassword.setHeaderText(null);
        alertsameoldpassword.setContentText("Old Password and New Password can not be same");

        if (NewPassword.equals("") || ConfirmPassword.equals("")) {
            alertempty.showAndWait();
            return false;
        }

        if (OldPassword.equals(ConfirmPassword)) {
            alertsameoldpassword.showAndWait();
            return false;
        }

        if (NewPassword.equals(ConfirmPassword)) {
            return true;
        }


        alertnotcorrect.showAndWait();
        return false;


    }


    //Save user's new password
    private void SaveNewPassword(int id) {
        UserModel user = new UserModel();
        List<String> lines = new ArrayList<>();

        Alert AlertSuccess = new Alert(Alert.AlertType.INFORMATION);
        AlertSuccess.setTitle("Success");
        AlertSuccess.setHeaderText(null);
        AlertSuccess.setContentText("Password successfully changed!");

        try(BufferedReader reader= new BufferedReader(new FileReader("Accounts.txt"))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (!userData[0].equals(Integer.toString(id))) {
                    lines.add(data);

                }if (userData[0].equals(Integer.toString(id))) {
                    user.setUserID(Integer.parseInt(userData[0]));
                    user.setUsername(userData[1]);
                    user.setPassword(NewPassword);
                    user.setRegisterdate(userData[3]);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Accounts.txt", false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }

            writer.write(user.toString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        AlertSuccess.showAndWait();


    }


    //When the changing password step finished, it will clear all input.
    private void Refresh() {
        OldPasswrodField.clear();
        NewPasswrodField.clear();
        ConfirmPasswrodField.clear();

        try{
            Stage stage = (Stage) Comfirmbutton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Login-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }


    }


    //Click confirm then start save new password
    @FXML
    private void handelConfirmButton(){
        OldPassword = OldPasswrodField.getText();
        NewPassword = NewPasswrodField.getText();
        ComfirmPassword = ConfirmPasswrodField.getText();

        if(CheckOldPassword(currentid, OldPassword)){
            if (CheckNewPassword(ComfirmPassword, NewPassword)) {
                SaveNewPassword(currentid);
                Refresh();
            }
        }



    }

}
