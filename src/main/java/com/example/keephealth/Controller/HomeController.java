package com.example.keephealth.Controller;


import com.example.keephealth.Model.FitnessData;
import com.example.keephealth.Model.HomeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.example.keephealth.Controller.PublicMethod.ReadData;

public class HomeController {
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

//Click button into profile page
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


//Click button into homepage
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

    //click button into workoutplans page
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


//Click button into nutritionplans page
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

    //click button into activity tracking page
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

//Click button into customer support page
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



    //Click button to log out
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
    private TableView<FitnessData> FitnessdaysTable;

    @FXML
    private TableColumn<FitnessData, String> monthColumn;

    @FXML
    private TableColumn<FitnessData, Integer> daysColumn;

    private ObservableList<FitnessData> data;

    @FXML
    private LineChart<String, Number> Caloriechart;

    @FXML
    private Label CheckingDaysL;
    @FXML
    private Label BurningTodayL;
    @FXML
    private Label IntakeTodayL;
    @FXML
    private Label CalGoalRemainingL;

    private String CheckingDays;

    private String BurningToday;

    private String IntakeToday;

    private String CalGoalRemaining;

    public HomeModel Model;

    String day5,day4,day3,day2,day1;

    String ReadDate;

    String data5,data4,data3,data2,data1;

    int idata5,idata4,idata3,idata2,idata1;

    int January,February,March,April,May,June,July,August,September,October,November,December;

    //Create model
    private void Model(){
        Model = new HomeModel();
    }

    //get current user id
    private int getcurrentId(){
        Model();

        Model.setId(LoginController.getCurrentId());

        return Model.getId();

    }

    //show today's burned cal
    public void ShowBurningToday(){

        BurningToday= PublicMethod.ReadData(getcurrentId(),2,"CalBurned.txt");
        BurningTodayL.setText(BurningToday+" cal");

    }

    //show today's Intake cal
    public void ShowIntakeToday(){
        IntakeToday= PublicMethod.ReadData(getcurrentId(),1,"NutritionData.txt");
        IntakeTodayL.setText(IntakeToday+" cal");
    }

    //show today's cal remaining
   public void ShowCalorieremaining(){
       double userCalburngoal = Double.parseDouble(ReadData(getcurrentId(),1,"Workoutplans.txt"));

       double CurrentCalburnedTotal = Double.parseDouble(ReadData(getcurrentId(),2,"TotalCalBurned.txt"));

       int currentCalgoalremaining = (int) (userCalburngoal  - CurrentCalburnedTotal);

       CalGoalRemaining = String.valueOf(currentCalgoalremaining);

       CalGoalRemainingL.setText(CalGoalRemaining+" cal");
   }

    public void initialize() {
        ShowBurningToday();
        ShowIntakeToday();
        ShowCalorieremaining();

        showTable();
        showChart();
        ShowCheckingDays();

        PublicMethod.ClearCheckingData(getcurrentId(),"CheckInData.txt");


    }

    //Show checking days
    private void ShowCheckingDays(){
        CheckingDays=PublicMethod.ReadData(getcurrentId(),2,"CheckInData.txt");
        CheckingDaysL.setText(CheckingDays);


    }




    //Show each month fitness days on table
    private void showTable(){


        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<>("fitnessdays"));
        ReadMonths();
        System.out.println("January: "+January+"February: "+February+"March: "+March+"April: "+April+"May: "+May);


        data = FXCollections.observableArrayList(
                new FitnessData("January", January),
                new FitnessData("February", February),
                new FitnessData("March", March),
                new FitnessData("April", April),
                new FitnessData("May", May),
                new FitnessData("June", June),
                new FitnessData("July", July),
                new FitnessData("August", August),
                new FitnessData("September", September),
                new FitnessData("October", October),
                new FitnessData("November", November),
                new FitnessData("December", December)
        );


        FitnessdaysTable.setItems(data);

    }




    //Read user fitness days for each months
    private void ReadMonths(){

        try(BufferedReader reader = new BufferedReader(new FileReader("MonthsChecking"))){
            String data;
            while((data = reader.readLine())!= null){
                String[] userData = data.split("/");
                if(userData[0].equals(String.valueOf(getcurrentId()))){
                    if (userData[1].equals("1")){
                        January++;
                    }if(userData[1].equals("2")){
                        February++;
                    }if (userData[1].equals("3")){
                        March++;
                    }if (userData[1].equals("4")){
                        April++;
                    }if (userData[1].equals("5")){
                        May++;
                    }if (userData[1].equals("6")){
                        June++;
                    }if (userData[1].equals("7")){
                        July++;
                    }if (userData[1].equals("8")){
                        August++;
                    }if (userData[1].equals("9")){
                        September++;
                    }if (userData[1].equals("10")){
                        October++;
                    }if (userData[1].equals("11")){
                        November++;
                    }if (userData[1].equals("12")){
                        December++;
                    }

                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    //Show recent 5days burned cal data
    private void showChart(){

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        getDailyCalBurnedData();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");

        LocalDate date5 = LocalDate.now();
        String dateS5 = date5.format(formatter);

        LocalDate date4 = date5.minusDays(1);
        String dateS4 = date4.format(formatter);

        LocalDate date3 = date4.minusDays(1);
        String dateS3 = date3.format(formatter);

        LocalDate date2 = date3.minusDays(1);
        String dateS2 = date2.format(formatter);

        LocalDate date1 = date2.minusDays(1);

        String dateS1 = date1.format(formatter);

        series.getData().add(new XYChart.Data<>(dateS1, idata1));
        series.getData().add(new XYChart.Data<>(dateS2 , idata2));
        series.getData().add(new XYChart.Data<>(dateS3, idata3));
        series.getData().add(new XYChart.Data<>(dateS4, idata4));
        series.getData().add(new XYChart.Data<>(dateS5, idata5));

        Caloriechart.getData().add(series);

    }

    //read recent 5 days burned cal data
    public void getDailyCalBurnedData(){

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");

        day5=today.format(formatter);

        day4=today.minusDays(1).format(formatter);

        day3=today.minusDays(2).format(formatter);

        day2=today.minusDays(3).format(formatter);

        day1=today.minusDays(4).format(formatter);

        ReadDate = day5;

        System.out.println(day1+" "+day2+" "+day3+" "+day4+" "+day5);


        data1=PublicMethod.ReadtwoData(getcurrentId(), day1,1, "DailyCalBurned.txt");
        idata1=Integer.parseInt(data1);


        data2=PublicMethod.ReadtwoData(getcurrentId(), day2,1, "DailyCalBurned.txt");
        idata2=Integer.parseInt(data2);


        data3=PublicMethod.ReadtwoData(getcurrentId(), day3,1, "DailyCalBurned.txt");
        idata3=Integer.parseInt(data3);


        data4=PublicMethod.ReadtwoData(getcurrentId(), day4,1, "DailyCalBurned.txt");
        idata4=Integer.parseInt(data4);


        data5=PublicMethod.ReadtwoData(getcurrentId(), day5,1, "DailyCalBurned.txt");
        idata5=Integer.parseInt(data5);
        System.out.println(idata1+" "+idata2+" "+idata3+" "+idata4+" "+idata5);



    }











}
