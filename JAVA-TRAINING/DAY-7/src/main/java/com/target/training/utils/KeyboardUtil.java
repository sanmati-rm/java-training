package com.target.training.utils;

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

}
