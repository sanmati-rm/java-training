package com.target.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class KeyboardUtil {

    static Scanner sc = new Scanner(System.in);

    public static Integer getInt(String message){
        System.out.println(message);
        return sc.nextInt();
    }

    public static String getString(String message){
        System.out.println(message);
        return sc.nextLine();
    }

    public static Date getDate(String message){
        System.out.println(message);
        String s = sc.nextLine();
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(s);
        } catch (ParseException e) {
            System.out.println("Parsing Date error");
        }
        return date;
    }

}
