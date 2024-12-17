package com.example.keephealth.Controller;

import java.io.*;

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





}
