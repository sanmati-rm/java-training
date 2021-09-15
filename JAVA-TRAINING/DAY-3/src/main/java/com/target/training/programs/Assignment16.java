package com.target.training.programs;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment16 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of inputs");
        int n = sc.nextInt();


        String[] input = new String[n+1];

        System.out.println("Please start entering inputs");
        for(int i=0;i<input.length;i++)
            input[i]=sc.nextLine();

        int strCount=0,intCount = 0,sum=0;
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        for(int i = 0; i<input.length; i++)
        {
            try{
                if(input[i].matches("[0-9]*")) {
                    intCount += 1;
                    integers.add(Integer.parseInt(input[i]));
                    sum += Integer.parseInt(input[i]);
                }
                else{
                    strCount += 1;
                    strings.add(input[i]);
                }

            }
            catch (NumberFormatException e){

            }
        }

        System.out.println("Number of inputs: " + n);
        System.out.println("Number of integer inputs: " + (intCount-1));
        System.out.println("Number of non-integer inputs: " + (strCount));
        System.out.println("Sum of all integer inputs: " + sum);
        System.out.println("The integer inputs are: " + integers);
        System.out.println("The non-integer inputs are: " + strings);




    }
}
