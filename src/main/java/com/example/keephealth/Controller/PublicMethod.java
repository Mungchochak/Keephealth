package com.example.keephealth.Controller;

import java.io.*;
import java.time.LocalDate;

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


    public static LocalDate getLastDate(String fileName,int position,LocalDate Lastdate){


        try(BufferedReader reader= new BufferedReader(new FileReader(fileName))){
            String data;

            data = reader.readLine() ;
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





}
