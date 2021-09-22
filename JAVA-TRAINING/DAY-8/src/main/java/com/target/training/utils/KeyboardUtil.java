package com.target.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Scanner;

public class KeyboardUtil {

    static Scanner sc = new Scanner(System.in);

    public static Integer getInt(String message){
        System.out.println(message);
        return sc.nextInt();
    }

    public static String getString(String message){
        System.out.println(message);
        return sc.next();
    }

    public static Double getDouble(String message){
        System.out.println(message);
        return sc.nextDouble();
    }

    public static Date getDate(String message){
        System.out.println(message);
        String s = sc.next();
        Date date = null;
        try {
            date = Date.valueOf(s);
        } catch (Exception e) {
            System.out.println("Parsing Date error" + e);
        }
        return date;


    }

}
