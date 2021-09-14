package com.target.training.assignment;

import com.target.training.util.KeyboardUtil;

public class Assignment2 {

    static boolean isPrimeNumber(int num) {

        int m = num/2;
        if(num==0 || num==1)
            return false;
        for(int i=2; i<=m ; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int num = KeyboardUtil.getInt("Enter the number: ");
        boolean result = isPrimeNumber(num);

        if(result)
            System.out.println(num + " is a prime number");
        else
            System.out.println(num + " is not a prime number");

    }
}
