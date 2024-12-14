package com.example.keephealth.Controller;

import com.example.keephealth.Model.ProfileModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ProfileController {
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
    private void handleChangepasswordButtonClick() {

        try {
            Stage stage = (Stage) CustomerSupportButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/CgPassword-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Keephealth");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



    private String name;
    private String gender;
    private String email;
    private String phone;
    private String weight;
    private String height;
    private int age;
    private int currentid = LoginController.getCurrentId();


    @FXML
    private TextField agefield;

    @FXML
    private TextField emailfield;

    @FXML
    private ChoiceBox<String> genderbox;

    @FXML
    private TextField heightfield;

    @FXML
    private TextField namefield;

    @FXML
    private TextField phonefield;

    @FXML
    private TextField weightfield;

    @FXML
    private Label ShowdateLabel;

    @FXML
    private Label AccountnameLabel;

    public static final String Fileuser = "Profiledata.txt";

    private String Joindate;

    private int Totaljoindate;





    @FXML
    public void initialize() {
        Showinfo();
        GetUserId();


    }


    public void GetUserId(){
        ProfileModel Currentuser = new ProfileModel();

        Currentuser.setCurrentid(currentid);

        System.out.println("Currentid = "+currentid);
    }





    @FXML
    private void handleeditbutton() {
        Alert Shownsucess = new Alert(Alert.AlertType.INFORMATION);
        Shownsucess.setTitle("Edit Profile");
        Shownsucess.setHeaderText(null);
        Shownsucess.setContentText("Personal information can be edited");


        agefield.setEditable(true);
        emailfield.setEditable(true);
        phonefield.setEditable(true);
        weightfield.setEditable(true);
        namefield.setEditable(true);
        heightfield.setEditable(true);
        genderbox.setDisable(false);

        Shownsucess.showAndWait();


    }


    private void Disablebuttion() {

        agefield.setEditable(false);
        emailfield.setEditable(false);
        phonefield.setEditable(false);
        weightfield.setEditable(false);
        namefield.setEditable(false);
        heightfield.setEditable(false);
        genderbox.setDisable(true);

    }


    @FXML
    private void handlesavebutton() {
        Alert SucessSave = new Alert(Alert.AlertType.INFORMATION);
        SucessSave.setTitle("Success");
        SucessSave.setHeaderText(null);
        SucessSave.setContentText("Information successfully saved!");

        ProfileModel Currentuser = new ProfileModel();
        Currentuser.setAge(agefield.getText());
        Currentuser.setEmail(emailfield.getText());
        Currentuser.setGender(genderbox.getValue());
        Currentuser.setHeight(heightfield.getText());
        Currentuser.setName(namefield.getText());
        Currentuser.setPhone(phonefield.getText());
        Currentuser.setWeight(weightfield.getText());
        Currentuser.setGender(genderbox.getValue());
        Currentuser.setCurrentid(currentid);



        if (!CheckuserExist(currentid)) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Fileuser, true))) {
                writer.write(Currentuser.toString());
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Disablebuttion();
            SucessSave.showAndWait();

        }else{
            SavenewInfo(Currentuser);
            Disablebuttion();
            SucessSave.showAndWait();
        }


    }

    private void SavenewInfo(ProfileModel Currentuser){
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader= new BufferedReader(new FileReader("Profiledata.txt"))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (!userData[0].equals(Integer.toString(currentid))) {
                    lines.add(data);

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

            writer.write(Currentuser.toString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }







    private void Showinfo(){
        genderbox.getItems().addAll("Male", "Female");
        DisplayData();
        setShowdateLabel();
        setAccountnameLabel();

    }


    private void setShowdateLabel(){
        Totaljoindate = GetJoinDate();
        ShowdateLabel.setText("You have persisted for " + Totaljoindate + " days !");
    }

    private void setAccountnameLabel(){
        String username = GetUserName(currentid);
        AccountnameLabel.setText("Welcome " + username + " to Keephealth !");
    }




    private void DisplayData(){
        try(BufferedReader reader= new BufferedReader(new FileReader("Profiledata.txt"))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(currentid))) {
                    namefield.setText(userData[1]);
                    genderbox.setValue(userData[2]);
                    emailfield.setText(userData[3]);
                    phonefield.setText(userData[4]);
                    weightfield.setText(userData[5]);
                    heightfield.setText(userData[6]);
                    agefield.setText(userData[7]);


                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private int GetJoinDate(){

        LocalDate Nowdate = LocalDate.now();
        try(BufferedReader reader = new BufferedReader(new FileReader("Accounts.txt"))){
            String data;
            while((data = reader.readLine())!= null){
                String[] userData = data.split("/");
                if (userData[0].equals(Integer.toString(currentid))) {
                    Joindate = userData[3];
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate Registerdate = LocalDate.parse(Joindate, formatter);

        int TotalJoindate = (int) ChronoUnit.DAYS.between(Registerdate, Nowdate);


        return TotalJoindate;
    }








    public boolean CheckuserExist(int id){

        try(BufferedReader reader = new BufferedReader(new FileReader(Fileuser))){
            String data;
            while((data = reader.readLine())!= null){
                String[] userData = data.split("/");
                if(userData[0].equals(Integer.toString(id))){
                    return true;
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return false;

    }


    private String GetUserName(int id) {

        String Accountname = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("Accounts.txt"))) {
            String data;
            while ((data = reader.readLine()) != null) {
                String[] userData = data.split("/");
                if (userData[0].equals(Integer.toString(id))) {
                    Accountname = userData[1];
                    break;

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Accountname;

    }

















}
    






