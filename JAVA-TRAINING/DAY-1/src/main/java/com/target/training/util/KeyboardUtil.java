package com.target.training.util;

import java.util.Scanner;

public class KeyboardUtil {

    public static String getString(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int getInt(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
