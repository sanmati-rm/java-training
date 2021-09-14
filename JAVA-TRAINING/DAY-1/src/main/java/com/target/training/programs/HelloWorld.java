package com.target.training.programs;

import com.target.training.util.KeyboardUtil;

import java.util.Scanner;

public class HelloWorld {

    static void sayHello(){
        System.out.println("Hello!!");
    }

    static void sayBye(){
        System.out.println("BYE!!");
    }

    public static void main(String[] args) {

        System.out.println("Start of main");
        sayHello();
        sayHello();
        sayBye();
        System.out.println("End of main");
        ;
        String name = KeyboardUtil.getString("Enter your name:");
        int age = KeyboardUtil.getInt("Enter your age:");

        System.out.println(" is years old");

    }
}
