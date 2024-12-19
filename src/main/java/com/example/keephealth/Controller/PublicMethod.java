package com.example.keephealth.Controller;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PublicMethod {

    public static String ReadData(int currentId,int position,String fileName){
        String Data ="0";
        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))){
            String line;

            while((line = reader.readLine())!= null) {
                String [] userData = line.split("/");
                if (userData[0].equals(Integer.toString(currentId))) {
                    Data = userData[position];

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return Data;
    }

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


    public static void ClearCheckingData(int CurrentId,String fileName){
        List<String> lines = new ArrayList<>();
        LocalDate LastDate;
        // 从文件读取日期
        String ReadLastdate = PublicMethod.ReadData(CurrentId, 1, fileName);

        // 判断 ReadLastdate 是否为有效日期
        if (ReadLastdate != null && !ReadLastdate.equals("0")) {
            // 如果不是 "0"，将其解析为 LocalDate
            LastDate = LocalDate.parse(ReadLastdate);
        } else {
            // 如果是 "0" 或者无效日期，设置为当前日期
            LastDate = LocalDate.now();  // 可以根据需求选择默认日期
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


    public static boolean CheckWeight(int id){
        boolean weightexist = true;
        String weight= ReadData(id,5,"Profiledata.txt");
        if (weight != null && !weight.equals("0")) {
            weightexist = false;
        }
        return weightexist;

    }

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





}
