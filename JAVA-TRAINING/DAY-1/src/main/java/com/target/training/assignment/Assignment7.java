package com.target.training.assignment;

import com.target.training.util.KeyboardUtil;

import java.util.Scanner;

public class Assignment7 {


    public static int numerator(int n){
        int num;
        if(n%2==0)
            num = 1;
        else
            num=-1;
        //System.out.println(num);
        return num;
    }

    public static double denominator(int d){
        double den=1;
        for(double i=d;i>0;i--)
            den = den * i;
        //System.out.println(den);
        return den;

    }

    public static double coefficient(float degree, int power){
        double coeff = 1;
        while(power!=0 ){
            coeff *= degree;
            power--;
        }

        //System.out.println(coeff);
        return coeff;
    }

    public static void main(String[] args) {
        double res =0;

        float degree;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the degree value: ");
        degree = sc.nextFloat();

        for(int i=0;i<=10;i++){
            res += (numerator(i)/denominator((2*i)+1))*coefficient(degree,((2*i)+1));
        }

        System.out.println(res);

    }
}
