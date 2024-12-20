package com.example.keephealth.Controller;

import com.example.keephealth.Model.WorkoutPlanModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;

import static com.example.keephealth.Controller.PublicMethod.ReadData;


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


    //Click first video to watch video
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

    //Click second video to watch video
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

    //Click third video to watch video
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
    private TextField Intaketinput;

    @FXML
    private TextField Workoutinput;


    @FXML
    private Label Calorieoutput;

    @FXML
    private Label Intakeoutput;

    public static WorkoutPlanModel Model;





    @FXML
     private Label Workoutoutput;
     public static final String Fileuser = "Workoutplans.txt";
     private int Currentid;


     //Read current user id
     private int getcurrentId(){


         Currentid = LoginController.getCurrentId();

         System.out.println(Currentid);

         return Currentid;

     }



     //Click Cal burning goal save button to get user id
    @FXML
    private void handlesetB1Button() {
        WorkoutPlanModel workoutPlanModel = new WorkoutPlanModel();

        Currentid = LoginController.getCurrentId();

    }

    //Click Workout hours goal save button to get user id
    @FXML
    private void handlesetB2Button() {
        WorkoutPlanModel workoutPlanModel = new WorkoutPlanModel();

        Currentid = LoginController.getCurrentId();

    }

    //Click Intake (cal) goal button to get user id
    @FXML
    private void handlesetB3Button() {
        WorkoutPlanModel workoutPlanModel = new WorkoutPlanModel();

        Currentid = LoginController.getCurrentId();

    }



    //Save user Calories burned goal
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


    //Save workout hours goal
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


    //Save intake calories goal
    private void SaveIntakeInfo(WorkoutPlanModel model){
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



    //Show each goal
    private void showinfo(){

        try(BufferedReader reader= new BufferedReader(new FileReader(Fileuser))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(Currentid))) {

                    Calorieoutput.setText(userData[1]);
                    Workoutoutput.setText(userData[2]);
                    Intakeoutput.setText(userData[3]);



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


    @FXML
    private Label Intakepercent;
    @FXML
    private Label Hourspercent;
    @FXML
    private Label Calpercent;

    @FXML
    private  Arc Intakechart;

    @FXML
    private  Arc Hourschart;

    @FXML
    private  Arc Calchart;



    //Check if user intake goal is completed,if is complete, then clear user data, record again
    public void CheckUserIntakeComdition(){
        double CurrentIntakeTotal = Integer.parseInt(ReadData(getcurrentId(),1,"TotalIntakeData.txt"));

        double userintakegoal = Integer.parseInt(ReadData(getcurrentId(),3,"Workoutplans.txt"));

        if (CurrentIntakeTotal< userintakegoal ){
            return;
        }else {
            List<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("TotalIntakeData.txt"))) {
                String data;
                while ((data = reader.readLine()) != null) {
                    String[] userData = data.split("/");
                    if (!userData[0].equals(Integer.toString(Currentid))) {
                        lines.add(data);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("TotalIntakeData.txt", false))) {
                for (String rewriter : lines) {
                    writer.write(rewriter);
                    writer.newLine();
                }

                writer.write(getcurrentId() + "/" + "0");
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    //Show intake current condition on chart
    public void Intakeshow(){

        double userintakegoal = Integer.parseInt(ReadData(getcurrentId(),3,"Workoutplans.txt"));
        System.out.println(userintakegoal);

        double CurrentIntakeTotal = Integer.parseInt(ReadData(getcurrentId(),1,"TotalIntakeData.txt"));

        double currentintakegoalremaining = userintakegoal - CurrentIntakeTotal;

        System.out.println(currentintakegoalremaining);

        double finalcurrentremaining = 100-(((double) currentintakegoalremaining / userintakegoal) * 100);

        System.out.println(finalcurrentremaining);

        String formattedResult = String.format("%.1f", finalcurrentremaining);

        System.out.println(formattedResult);

        Intakepercent.setText(formattedResult);

        AdjustchartData(finalcurrentremaining,Intakechart);
    }


    //Check if user workout hours goal is completed,if is complete, then clear user data, record again
    public void CheckUserHoursComdition(){
        double CurrentHoursTotal = Double.parseDouble(ReadData(getcurrentId(),1,"TotalCalBurned.txt"));

        double userHoursgoal = Double.parseDouble(ReadData(getcurrentId(),2,"Workoutplans.txt"));

        String OldData = "";

        if (CurrentHoursTotal< userHoursgoal ){
            return;
        }else {
            List<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("TotalCalBurned.txt"))) {
                String data;
                while ((data = reader.readLine()) != null) {
                    String[] userData = data.split("/");
                    if (!userData[0].equals(Integer.toString(Currentid))) {
                        lines.add(data);

                    }if (userData[0].equals(Integer.toString(Currentid))) {
                        OldData = userData[2];

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("TotalCalBurned.txt", false))) {
                for (String rewriter : lines) {
                    writer.write(rewriter);
                    writer.newLine();
                }

                writer.write(getcurrentId() + "/" + "0"+"/"+OldData);
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }




    //Show intake current condition on chart
    public void Hoursworkoutshow(){

        double userHoursgoal = Double.parseDouble(ReadData(getcurrentId(),2,"Workoutplans.txt"));
        System.out.println(userHoursgoal);

        double CurrentHoursTotal = Double.parseDouble(ReadData(getcurrentId(),1,"TotalCalBurned.txt"));

        double currentHoursgoalremaining = userHoursgoal - CurrentHoursTotal;

        System.out.println(currentHoursgoalremaining);

        double finalcurrentremaining = 100-(((double) currentHoursgoalremaining / userHoursgoal) * 100);

        System.out.println(finalcurrentremaining);

        String formattedResult = String.format("%.1f", finalcurrentremaining);

        System.out.println(formattedResult);

        Hourspercent.setText(formattedResult);

        AdjustchartData(finalcurrentremaining,Hourschart);
    }


    //Check if user burned calories goal is completed,if is complete, then clear user data, record again
    public void CheckUserCalComdition(){
        double CurrentCalburnedTotal = Double.parseDouble(ReadData(getcurrentId(),2,"TotalCalBurned.txt"));

        double userCalburngoal = Double.parseDouble(ReadData(getcurrentId(),1,"Workoutplans.txt"));

        String OldData = "";

        if (CurrentCalburnedTotal < userCalburngoal){
            return;
        }else {
            List<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("TotalCalBurned.txt"))) {
                String data;
                while ((data = reader.readLine()) != null) {
                    String[] userData = data.split("/");
                    if (!userData[0].equals(Integer.toString(Currentid))) {
                        lines.add(data);

                    }if (userData[0].equals(Integer.toString(Currentid))) {
                        OldData = userData[1];

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("TotalCalBurned.txt", false))) {
                for (String rewriter : lines) {
                    writer.write(rewriter);
                    writer.newLine();
                }

                writer.write(getcurrentId() + "/" + OldData + "/" + "0");
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    ////Show burned calories  current condition on chart
    public void Calsworkoutshow(){

        double userCalburngoal = Double.parseDouble(ReadData(getcurrentId(),1,"Workoutplans.txt"));
        System.out.println(userCalburngoal);

        double CurrentCalburnedTotal = Double.parseDouble(ReadData(getcurrentId(),2,"TotalCalBurned.txt"));

        double currentCalgoalremaining = userCalburngoal  - CurrentCalburnedTotal;

        System.out.println(currentCalgoalremaining);

        double finalcurrentremaining =100-(((double) currentCalgoalremaining / userCalburngoal) * 100);

        System.out.println(finalcurrentremaining);

        String formattedResult = String.format("%.1f", finalcurrentremaining);

        System.out.println(formattedResult);

        Calpercent.setText(formattedResult);

        AdjustchartData(finalcurrentremaining,Calchart);
    }




    //Convert the data to chart
    public void AdjustchartData(double data,Arc chart){

        double angle = (data / 100) * 360;
        chart.setLength(angle);

    }


    //Preload media player that user can faster load video
    public void preloadmedia(){
        String videoPath = "src/main/resources/Video/video1.MP4";

        File file = new File(videoPath);

        String videoURL = file.toURI().toString();

        Media media = new Media(videoURL);

        MediaPlayer mediaPlayer = new MediaPlayer (media);

    }





    @FXML
    public void initialize() {
        Model = new WorkoutPlanModel();
        Model.setId(getcurrentId());
        preloadmedia();
        showinfo();
        Intakeshow();
        CheckUserIntakeComdition();
        CheckUserHoursComdition();
        Hoursworkoutshow();
        Calsworkoutshow();
        CheckUserCalComdition();



        //Click Cal burning goal save button
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

        //Click Workout hours goal save button
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

        //Click Intake goal save button
        SetButtonThree.setOnAction(event -> {

            String inputTextTwo = Intaketinput.getText();
            if (!inputTextTwo.isEmpty() && inputTextTwo.matches("\\d+")) {


                    Intakeoutput.setText(inputTextTwo);
                    Model.setWeightTarget(Integer.parseInt(inputTextTwo));
                    System.out.println("Weighttarget: " + Model.getWeightTarget());
                    Intaketinput.clear();
                    SaveIntakeInfo(Model);
                    Intakeshow();


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





