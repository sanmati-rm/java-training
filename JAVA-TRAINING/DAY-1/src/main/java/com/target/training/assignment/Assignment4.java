package com.target.training.assignment;

import com.target.training.util.KeyboardUtil;

public class Assignment4 {

    static public boolean prime(int n){
        int m = n/2;
        if(n==0 || n==1)
            return false;
        for(int i=2; i<=m ; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static public int sumOfPrimes(int from, int to) {

       int res =0;
       for(int i = from;i<=to;i++){
           if(prime(i))
               res += i;
       }
       return res;
    }

    public static void main(String[] args) {

        int from = KeyboardUtil.getInt("Enter the start number: ");
        int to = KeyboardUtil.getInt("Enter the end number: ");

        int res = sumOfPrimes(from,to);
        System.out.println(res);

    }
}
