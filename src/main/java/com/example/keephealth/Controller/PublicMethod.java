package com.example.keephealth.Controller;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Easy-to-use methods for frequent use
public class PublicMethod {

    //Read specified data
    public static String ReadData(int currentId, int position, String fileName) {
        String data = "0";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] userData = line.split("/");


                if (userData.length > position && userData[0].equals(Integer.toString(currentId))) {
                    data = userData[position];
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }


    // Read specified two data
    public static String ReadtwoData(int currentId,String data,int position,String fileName){
        String Data ="0";

        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))){
            String line;

            while((line = reader.readLine())!= null) {
                String [] userData = line.split("/");
                if (userData[0].equals(Integer.toString(currentId)) && userData[2].equals(data)) {
                    Data = userData[position];

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return Data;
    }



    //Read date data
    public static LocalDate getLastDate(String fileName,int position,LocalDate Lastdate){


        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))){
            String data;

            reader.readLine() ;
            data = reader.readLine() ;
            String [] userData = data.split("/");
            Lastdate = LocalDate.parse(userData[position]);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return Lastdate;

    }


    //Clear data
    public static void RenewData(LocalDate Lastdate,LocalDate Currentdate,String fileName){

        if (Lastdate == null || Lastdate.isBefore(Currentdate)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write("");
                writer.newLine();
                System.out.println("Renew Data");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("Didn't renew Data");
        }
    }


    //Clear checking days data, if the user does not check in continuously
    public static void ClearCheckingData(int CurrentId,String fileName){
        List<String> lines = new ArrayList<>();
        LocalDate LastDate;

        String ReadLastdate = PublicMethod.ReadData(CurrentId, 1, fileName);

        if (ReadLastdate != null && !ReadLastdate.equals("0")) {

            LastDate = LocalDate.parse(ReadLastdate);
        } else {

            LastDate = LocalDate.now();
        }

        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))){
            String data;

            while((data = reader.readLine())!= null) {
                String [] userData = data.split("/");
                if (!userData[0].equals(Integer.toString(CurrentId))) {

                    lines.add(data);
                } else {

                    if (!LastDate.isBefore(LocalDate.now().minusDays(2))) {

                        lines.add(data);
                    } else {

                        userData[2] = "0";

                        String updatedData = String.join("/", userData);

                        lines.add(updatedData);
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for (String rewriter : lines){
                writer.write(rewriter);
                writer.newLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //Check if the user has weight information
    public static boolean CheckWeight(int id){
        boolean weightexist = true;
        String weight= ReadData(id,5,"Profiledata.txt");
        if (weight != null && !weight.equals("0")) {
            weightexist = false;
        }
        return weightexist;

    }

    // Create text files required by the software to avoid missing text file bugs
    public static void initializeFiles(String[] fileNames) {
        for (String fileName : fileNames) {
            File file = new File(fileName);
            try {
                if (file.exists()) {
                    System.out.println(fileName + " File already exists");
                } else {
                    if (file.createNewFile()) {
                        System.out.println(fileName + " File created");

                        try (FileWriter writer = new FileWriter(file)) {
                            writer.write("");
                        }
                    } else {
                        System.out.println("Unable to create file: " + fileName);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error: " + fileName);
                e.printStackTrace();
            }
        }
    }

    //Create a txt for record current year
    public static void CreatYearDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String currentYear = LocalDate.now().format(formatter);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("CurrentYearDate.txt",true))) {
            writer.write(currentYear);
            writer.newLine();

        }catch (IOException e){
            e.printStackTrace();

        }
    }

    //Check current year
    public static boolean CheckYear() {
        String year = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String currentYear = LocalDate.now().format(formatter);
        try (BufferedReader reader = new BufferedReader(new FileReader("CurrentYearDate.txt" ))) {

            year = reader.readLine();


        } catch (Exception e) {
            e.printStackTrace();
        }
        if (year.equals(currentYear)){
            return true;
        }else {
            return false;
        }

    }

    //If it is new year, renew the year and renew user total MonthsChecking.txt
    public static void RenewYear(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String currentYear = LocalDate.now().format(formatter);

        if (!CheckYear()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("CurrentYearDate.txt" ))) {
                writer.write(currentYear);
                writer.newLine();
                System.out.println("Renew Year");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("MonthsChecking.txt" ))) {
                writer.write("");
                writer.newLine();
                System.out.println("New Year");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("it is not new year");
        }
    }

    //Check if text file if empty
    public static boolean isTextFileEmpty(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }







}
