package com.target.training.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment16 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter number of inputs");
        //int n = sc.nextInt();

        //String[] input = new String[n+1];

        List<String> input = new ArrayList<String>();
        System.out.println("Please start entering inputs");
        boolean done = false;

            while(!done){
                String in = sc.next();
                if(in.equalsIgnoreCase("NO"))
                    done = true;
                else{
                    input.add(in);
                }
            }




        int strCount=0,intCount = 0,sum=0;
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        for(int i = 0; i<input.size(); i++)
        {
            try{
                if(input.get(i).matches("[0-9]*")) {
                    intCount += 1;
                    integers.add(Integer.parseInt(input.get(i)));
                    sum += Integer.parseInt(input.get(i));
                }
                else{
                    strCount += 1;
                    strings.add(input.get(i));
                }

            }
            catch (NumberFormatException e){

            }
        }

        System.out.println("Number of inputs: " + input.size());
        System.out.println("Number of integer inputs: " + intCount);
        System.out.println("Number of non-integer inputs: " + strCount);
        System.out.println("Sum of all integer inputs: " + sum);
        System.out.println("The integer inputs are: " + integers);
        System.out.println("The non-integer inputs are: " + strings);




    }
}
