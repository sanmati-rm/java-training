package com.target.training.programs;

import java.util.Arrays;

public class ExceptionsDemo {
    public static void main(String[] args) {

        try {
            String s1 = args[0];
            String s2 = args[1];

            int num = Integer.parseInt(s1);
            int den = Integer.parseInt(s2);
            int q = num / den;

            System.out.println(num + den + q);
            System.out.println("Exception demo application");
            System.out.println("args is " + Arrays.toString(args));

        }
        catch(Exception ex){
            System.out.println("Exception occured " + ex.getMessage());
            System.out.println(ex.getClass().getName());
        }
    }

}
