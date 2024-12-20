package com.example.keephealth.Controller;

import com.example.keephealth.Model.ActivityTrackingModel;
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
import java.time.format.DateTimeFormatter;
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

    private int CurrentId = LoginController.getCurrentId();

    private LocalDate LastDate;
    private LocalDate nowdate = LocalDate.now();

    public String mode;




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


    //The user clicks the button to have a pressing effect
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

    //Cancel button effect
    private void SetEffectNull(Button button ) {
        button.setEffect(null);

    }

    //Refresh button effect
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
        if(isFileRecorded("CalBurned.txt")){
            LastDate = PublicMethod.getLastDate("CalBurned.txt",3,LastDate);
            System.out.println(LastDate);
            PublicMethod.RenewData(LastDate,nowdate,"CalBurned.txt");
        }
        HandleMarkButton();
        if(isFileRecorded("CheckInData.txt")){
            if(isCheckIn()){
                CheckInOutput.setText("Successful");
            }
        }


    }


    //This Method is Use for Showing and Saving he burned calories data
    private void ShowBurnedCal(){
        choiceOfExercise();
        ActivityTrackingModel ATModel = new ActivityTrackingModel();

        ActivityTrackingModel TotalATModel = new ActivityTrackingModel();

        ATModel.setCurrentId(CurrentId);
        TotalATModel.setCurrentId(CurrentId);

        LocalDate CurrentDate = LocalDate.now();
        //this part return the burned calories and saves into the database
        ConfirmButton.setOnAction(actionEvent -> {

            ATModel.setExerciseDuration(Double.parseDouble(DurationInput.getText()));
            TotalATModel.setExerciseDuration(Double.parseDouble(DurationInput.getText()));

            int calories = calculateCalBurned(mode, ATModel.getExerciseDuration());
            ATModel.setCalBurned(calories);

            TotalATModel.setCalBurned(calories+Integer.parseInt(PublicMethod.ReadData(TotalATModel.getCurrentId(),2,"TotalCalBurned.txt")));
            TotalATModel.setExerciseDuration(TotalATModel.getExerciseDuration()+Double.parseDouble(PublicMethod.ReadData(TotalATModel.getCurrentId(),1,"TotalCalBurned.txt")));

            FinalBurnedCalOutput.setText(String.valueOf(ATModel.getCalBurned()));

            ATModel.setRecordDate(CurrentDate);

            if(checkFile()){
                int CurrentCal = Integer.parseInt(ReadCalData());
                double CurrentDuration = Double.parseDouble(ReadDurationData());
                ATModel.setCalBurned(ATModel.getCalBurned() + CurrentCal);
                ATModel.setExerciseDuration(ATModel.getExerciseDuration() + CurrentDuration);
            }

            SaveDailyBurnedCal(ATModel);
            SaveBurnedCal(ATModel);
            SaveTotalBurnedCal(TotalATModel);

            DurationInput.setText("");

        });

    }

    //This Method is used for checking CalBurned.txt file is empty or not
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

    //This Method is use to read the DurationData from the CalBurned.txt file
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
    //This Method is use to read the Calories Burned data from the CalBurned.txt file
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


    //Save each user burned Calories
    private void SaveBurnedCal(ActivityTrackingModel CurrentUser){
        List<String> lines = new ArrayList<>();
        Checkweight();

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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CalBurned.txt", false))) {
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


    //Save each user burned Calories for not clear data every day
    private void SaveTotalBurnedCal(ActivityTrackingModel CurrentUser){
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader= new BufferedReader(new FileReader("TotalCalBurned.txt"))){
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TotalCalBurned.txt", false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }

            writer.write(CurrentUser.TotaltoString());

            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //This the Method that shows the daily encouragement quote
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


    //This Method is used for determine what exercise user have choosen
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

    //This is the Calories Calculator Method
    private int calculateCalBurned(String m, Double dur){
        //Before start calculate, we will need to read the weight data from the Profiledata.txt file for the calories burned formula
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

    //This method will check the user had check in for the day or not
    private boolean isCheckIn(){
        LocalDate DateNow = LocalDate.now();
        LocalDate LastCheckInDate = LocalDate.parse(PublicMethod.ReadData(CurrentId,1,"CheckInData.txt"));
        boolean checker;
        if(DateNow.isEqual(LastCheckInDate)){
            checker = true;
        }else{
            checker = false;
        }
        return checker ;
    }


    //This Method will handle what the Mark Button do and keep track how many days they had continuously check in
    // And also user will be shown an alert notice that notice user that they had check in for the day
    private void HandleMarkButton(){
        LocalDate currentDate = LocalDate.now();
        ActivityTrackingModel ATModel = new ActivityTrackingModel();


        MarkButton.setOnAction(event -> {
            CheckInOutput.setText("Successful");
            ATModel.setCurrentId(CurrentId);
            ATModel.setLastCheckInDate(currentDate);

            boolean isRun = true;
            if (isFileRecorded("CheckInData.txt")) {
                if (isCheckIn()) {
                    Alert NoticeAlert = new Alert(Alert.AlertType.INFORMATION);
                    NoticeAlert.setTitle("Check-In Notice");
                    NoticeAlert.setHeaderText(null);
                    NoticeAlert.setContentText("You had Checked In for today! Please Check In tomorrow");
                    NoticeAlert.showAndWait();
                    ATModel.setCheckedInDays(Integer.parseInt(PublicMethod.ReadData(CurrentId, 2, "CheckInData.txt")));
                    isRun = false;
                } else {
                    int numOfDay = Integer.parseInt(PublicMethod.ReadData(CurrentId, 2, "CheckInData.txt"));
                    ATModel.setCheckedInDays(numOfDay + 1);


                }

            } else {
                ATModel.setCheckedInDays(1);

            }
            if (isRun) {
                RecordTotalChecking();
                System.out.println("Run");
            }

            SaveCheckInData(ATModel);

        });
    }

    //This method is used for saving the check in data for the HandleMarkButton Method
    private void SaveCheckInData(ActivityTrackingModel CurrentUser){
        List<String> lines = new ArrayList<>();

        try(BufferedReader reader= new BufferedReader(new FileReader("CheckInData.txt"))){
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CheckInData.txt", false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }

            writer.write(CurrentUser.toString2());

            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    ////Save each user Daily burned Calories for not clear data every day
    private void SaveDailyBurnedCal(ActivityTrackingModel CurrentUser) {
        List<String> lines = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        String today = LocalDate.now().format(formatter);
        boolean isUpdated = false;


        try (BufferedReader reader = new BufferedReader(new FileReader("DailyCalBurned.txt"))) {
            String data;
            while ((data = reader.readLine()) != null) {
                String[] userData = data.split("/");
                if (data.trim().isEmpty()) continue;


                if (userData[0].equals(Integer.toString(CurrentId)) && userData[2].equals(today)) {

                    lines.add(CurrentUser.DailytoString()+"/"+today);
                    isUpdated = true;
                } else {

                    lines.add(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (!isUpdated) {
            if (!lines.isEmpty()) lines.add("");
            lines.add(CurrentUser.DailytoString() + "/" + today);
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DailyCalBurned.txt", false))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data Sucessful Saved！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //this method is used for checking the file is empty or not
    private Boolean isFileRecorded(String fileName){
        boolean FileExist = false;
        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))){
            String data;
            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (userData[0].equals(Integer.toString(CurrentId))) {
                    if(userData[1]!= null){
                        FileExist = true;
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return FileExist;
    }


    //Save each user checking days for each days not delete every day
    private void RecordTotalChecking(){
        ActivityTrackingModel Model = new ActivityTrackingModel();
        DateTimeFormatter Monthformatter = DateTimeFormatter.ofPattern("MM");
        String CurrentMonth = LocalDate.now().format(Monthformatter);
        Model.setCurrentId(CurrentId);
        Model.setCheckedMonths(Integer.parseInt(CurrentMonth));


        try(BufferedWriter writer = new BufferedWriter(new FileWriter("MonthsChecking",true))) {
            writer.write(Model.MonthtoString());
            writer.newLine();


        }catch (IOException e){
            e.printStackTrace();

        }

    }


    //Check the user profile if haven't set weight, it will warn the user.
    private void Checkweight(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("notify");
        alert.setHeaderText(null);
        alert.getDialogPane().setStyle("-fx-font-size: 17px;");
        alert.setContentText("You have to set your weight in profile so that we can provide you with accurate calorie consumption data.");


        if (PublicMethod.CheckWeight(CurrentId)){
            alert.showAndWait();

        }
    }


    
    


}