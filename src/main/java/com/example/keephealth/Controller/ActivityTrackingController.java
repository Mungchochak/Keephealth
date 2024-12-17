package com.example.keephealth.Controller;

import com.example.keephealth.Model.ActivityTrackingModel;
import com.example.keephealth.Model.ProfileModel;
import com.example.keephealth.Model.UserModel;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActivityTrackingController {
    //Check In Part
    public Button MarkButton;
    public Label CheckInOutput;
    public TextFlow DailyEncouragement;
    //Record Part
    public Label FinalBurnedCalOutput;
    //Choice of Exercise buttons
    public Button WalikingButton;
    public Button HikingButton;
    public Button CyclingButton;
    public Button PushUpButton;
    public Button SwimmingButton;
    public Button PullUpButton;
    //Input Duration
    public TextField DurationInput;
    public Button ConfirmButton;
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

    private final int CurrentId = LoginController.getCurrentId();

    public static final String FileUser = "CalBurned.txt";




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


    public void SetButtonStyle(Button button) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(20);
        dropShadow.setOffsetY(0);
        dropShadow.setOffsetX(0);

        ScaleTransition scale = new ScaleTransition(Duration.millis(100),button);
        scale.setToX(0.95);
        scale.setToY(0.95);
        scale.play();

        Bloom bloom = new Bloom();
        bloom.setThreshold(0.1);

        button.setEffect(bloom);
        button.setEffect(dropShadow);

    }

    private void SetEffectNull(Button button ) {
        button.setEffect(null);

    }

    private void RefreshButton(Button button) {
        if (button.equals(WalikingButton)) {
            SetEffectNull(CyclingButton);
            SetEffectNull(PushUpButton);
            SetEffectNull(SwimmingButton);
            SetEffectNull(PullUpButton);
            SetEffectNull(HikingButton);
            SetButtonStyle(WalikingButton);

        } else if (button.equals(CyclingButton)) {
            SetEffectNull(WalikingButton);
            SetEffectNull(PushUpButton);
            SetEffectNull(SwimmingButton);
            SetEffectNull(PullUpButton);
            SetEffectNull(HikingButton);
            SetButtonStyle(CyclingButton);

        } else if (button.equals(PushUpButton)) {
            SetEffectNull(WalikingButton);
            SetEffectNull(CyclingButton);
            SetEffectNull(SwimmingButton);
            SetEffectNull(PullUpButton);
            SetEffectNull(HikingButton);
            SetButtonStyle(PushUpButton);

        } else if (button.equals(SwimmingButton)) {
            SetEffectNull(WalikingButton);
            SetEffectNull(CyclingButton);
            SetEffectNull(PushUpButton);
            SetEffectNull(PullUpButton);
            SetEffectNull(HikingButton);
            SetButtonStyle(SwimmingButton);

        } else if (button.equals(PullUpButton)) {
            SetEffectNull(WalikingButton);
            SetEffectNull(CyclingButton);
            SetEffectNull(PushUpButton);
            SetEffectNull(SwimmingButton);
            SetEffectNull(HikingButton);
            SetButtonStyle(PullUpButton);

        } else if (button.equals(HikingButton)) {
            SetEffectNull(WalikingButton);
            SetEffectNull(CyclingButton);
            SetEffectNull(PushUpButton);
            SetEffectNull(SwimmingButton);
            SetEffectNull(PullUpButton);
            SetButtonStyle(HikingButton);
        }
    }



    @FXML
    public void initialize() {
        ActivityTrackingModel ATModel = new ActivityTrackingModel();
        ATModel.setCurrentId(CurrentId);
        dailyEncouragement();
        ShowBurnedCal();


    }

    private void clearData(){
        LocalDate CurrentDate = LocalDate.now();

    }

    private void ShowBurnedCal(){
        choiceOfExercise();
        ActivityTrackingModel ATModel = new ActivityTrackingModel();
        ATModel.setCurrentId(CurrentId);
        //this part return the burned calories and saves into the database
        ConfirmButton.setOnAction(actionEvent -> {

            ATModel.setExerciseDuration(Double.parseDouble(DurationInput.getText()));

            int calories = calculateCalBurned(mode, ATModel.getExerciseDuration());
            ATModel.setCalBurned(calories);
            FinalBurnedCalOutput.setText(String.valueOf(ATModel.getCalBurned()));

            if(checkFile()){
                int CurrentCal = Integer.parseInt(ReadCalData());
                double CurrentDuration = Double.parseDouble(ReadDurationData());
                ATModel.setCalBurned(ATModel.getCalBurned() + CurrentCal);
                ATModel.setExerciseDuration(ATModel.getExerciseDuration() + CurrentDuration);
            }
            SaveBurnedCal(ATModel);

        });

    }

    private boolean checkFile(){
        boolean FileExist = false;
        try(BufferedReader reader= new BufferedReader(new FileReader("CalBurned.txt"))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(CurrentId))) {
                    if(userData[2]!= null){
                        FileExist = true;
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return FileExist;
    }

    private String ReadDurationData(){
        String Dur = " ";
        try(BufferedReader reader= new BufferedReader(new FileReader("CalBurned.txt"))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(CurrentId))) {
                    Dur = (userData[1]);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Dur;
    }

    private String ReadCalData(){
        String Cal = " ";
        try(BufferedReader reader= new BufferedReader(new FileReader("CalBurned.txt"))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(CurrentId))) {
                    Cal = (userData[2]);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Cal;
    }

    private void SaveBurnedCal(ActivityTrackingModel CurrentUser){
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader= new BufferedReader(new FileReader("CalBurned.txt"))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (!userData[0].equals(Integer.toString(CurrentId))) {
                    lines.add(data);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUser, false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }

            writer.write(CurrentUser.toString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void dailyEncouragement() {

        ArrayList<String> encouragements = new ArrayList<>();
        encouragements.add("If you give up at the first sign of struggle, you're really not ready to be successful — Kevin Hart");
        encouragements.add("'Everyone's dream can come true if you just stick to it and work hard.' —Serena Williams");
        encouragements.add("“The successful warrior is the average man with laser-like focus.” —Bruce Lee ");
        encouragements.add("“Never give up because great things take time.” —Adrian Williams");
        encouragements.add("\"Nothing is impossible; the word itself says ‘I'm possible!’\" —Audrey Hepburn");
        encouragements.add("“Never give up on a dream just because of the time it will take to accomplish it. The time will pass anyway.” —Earl Nightingale");
        encouragements.add("“Just believe in yourself. Even if you don’t, pretend that you do, and at some point, you will.\" —Venus Williams");
        encouragements.add("Believe you can, and you're halfway there.");
        encouragements.add("Every day is another chance to get stronger, to eat better, to live healthier, and to be the best version of you.");

        Random randQuote = new Random();
        int n = randQuote.nextInt(encouragements.size());
        String quote = encouragements.get(n);

        Text text1 = new Text(quote);
        DailyEncouragement.getChildren().clear();
        DailyEncouragement.getChildren().add(text1);
    }

    public String mode;


    private void choiceOfExercise(){
        WalikingButton.setOnAction(event -> {
            RefreshButton(WalikingButton);
            mode = "Walking";
            System.out.println(mode);
        });
        HikingButton.setOnAction(event -> {
            RefreshButton(HikingButton);
            mode = "Hiking";
            System.out.println(mode);
        });
        CyclingButton.setOnAction(event -> {
            RefreshButton(CyclingButton);
            mode = "Cycling";
            System.out.println(mode);
        });
        PushUpButton.setOnAction(event -> {
            RefreshButton(PushUpButton);
            mode = "Push Up";
            System.out.println(mode);
        });
        SwimmingButton.setOnAction(event -> {
            RefreshButton(SwimmingButton);
            mode = "Swimming";
            System.out.println(mode);
        });
        PullUpButton.setOnAction(event -> {
            RefreshButton(PullUpButton);
            mode = "Pull Up";
            System.out.println(mode);
        });

    }


    private int calculateCalBurned(String m, Double dur){
        String w ="0";
        try(BufferedReader reader= new BufferedReader(new FileReader("Profiledata.txt"))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(CurrentId))) {
                    if (userData.length > 5) {
                        w = userData[5];
                    } else {
                        throw new IllegalArgumentException("User have not enter their weight ! ");
                    }
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        double MET = 0.0;
        int calBurned = 0;
        double weight = Double.parseDouble(w);

        switch (m){
            case "Walking":
                MET = 3.3;
                break;

            case "Hiking":
                MET = 6.0;
                break;

            case "Cycling":
                MET = 6.8;
                break;

            case "Push Up":
                MET = 3.8;
                break;

            case "Swimming":
                MET = 7.0;
                break;

            case "Pull Up":
                MET = 5.0;
                break;
        }
        calBurned =(int) (MET * weight * dur);
        return calBurned;

    }

    private boolean isCheckIn(){
        LocalDate currentDate = LocalDate.now();
        ActivityTrackingModel ATModel = new ActivityTrackingModel();
        ATModel.setLastCheckInDate(currentDate);
        boolean c;
        if(currentDate.equals(currentDate)){
            Alert NoticeAlert = new Alert(Alert.AlertType.INFORMATION);
            NoticeAlert.setTitle("Check-In Notice");
            NoticeAlert.setHeaderText(null);
            NoticeAlert.setContentText("You had Checked In for today! Please Check In tomorrow");
            c = true;
        }else{
            c = false;
        }
        return c ;
    }

    private void checkIn(){

        LocalDate currentDate = LocalDate.now();
        ActivityTrackingModel ATModel = new ActivityTrackingModel();

        System.out.println(currentDate);
        MarkButton.setOnAction(actionEvent -> {
            SaveCheckInData(ATModel);
        });

    }

    private void SaveCheckInData(ActivityTrackingModel CurrentUser){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("CheckInRecord.txt",true))) {
            writer.write(CurrentUser.toString2());
            writer.newLine();

        }catch (IOException e){
            e.printStackTrace();

        }
    }
    
    


}