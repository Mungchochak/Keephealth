package com.example.keephealth.Controller;

import com.example.keephealth.Model.UserModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;


public class RegisterController {
    @FXML private TextField AccountName;
    @FXML private TextField Password;
    @FXML private TextField ConfirmPassword;
    @FXML private Button BackButton;
    public static final String Fileuser = "Accounts.txt";
    String confirmPassword;
    private static int id =1;


    


    private static int getnewId() {
        int lastid = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(Fileuser))){
            String data;
            while((data = reader.readLine())!= null){
                String[] userData = data.split("/");
                if (userData[0].isEmpty()){
                    lastid = id;
                }else {
                    lastid = Integer.parseInt(userData[0]);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return lastid +1 ;
    }




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
        LocalDate registrationDate = LocalDate.now();
        String registerdate = registrationDate.toString();



        UserModel newuser = new UserModel();

        newuser.setUsername(AccountName.getText());
        newuser.setPassword(Password.getText());
        confirmPassword = ConfirmPassword.getText();
        newuser.setRegisterdate(registerdate);


        if (newuser.getUsername().isEmpty() || newuser.getPassword().isEmpty() || confirmPassword.isEmpty()) {
                alertempty.showAndWait();
        } else if (!newuser.getPassword().equals(confirmPassword)) {
            alertpdnotsame.showAndWait();
        } else if (CheckAccountExist(newuser.getUsername())) {
            CheckAccountExist(newuser.getUsername());
        } else{
            int newid = getnewId();
            System.out.println(newid);
            SaveAccount(newid,newuser.getUsername(),newuser.getPassword(), newuser.getRegisterdate());
        }
    }



    private void SaveAccount(int newid,String name, String password,String registerdate){
        Alert SucessRegister = new Alert(Alert.AlertType.INFORMATION);
        SucessRegister.setTitle("Success");
        SucessRegister.setHeaderText(null);
        SucessRegister.setContentText("Account successfully registered!");

        UserModel user = new UserModel(newid,name,password,registerdate);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(Fileuser,true))) {
            writer.write(user.toString());
            writer.newLine();
            SucessRegister.showAndWait();

        }catch (IOException e){
            e.printStackTrace();

        }
    }



    private boolean CheckAccountExist(String name){
        Alert alertExist = new Alert(Alert.AlertType.WARNING);
        alertExist.setTitle("Error");
        alertExist.setHeaderText(null);
        alertExist.setContentText("Account already exists");

        try(BufferedReader reader = new BufferedReader(new FileReader(Fileuser))){
            String data;
            while((data = reader.readLine())!= null){
                String[] userData = data.split("/");
                if(userData[1].equals(name)){
                    alertExist.showAndWait();
                    return true;
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return false;

    }










}

