package com.target.training.assignment;

import com.target.training.util.KeyboardUtil;

public class Assignment3 {

    public static void main(String[] args) {
        int a = KeyboardUtil.getInt("Enter the first number \n");
        int b = KeyboardUtil.getInt("Enter the second number \n");
        int c = KeyboardUtil.getInt("Enter the third number \n");

        int small = 0, big =0, mid=0;

        if(a>b && a>c)
            big = a;
        else if(b>c && b>a)
            big = b;
        else
            big = c;

        if(a<b && a<c)
            small = a;
        else if(b<c && b<c)
            small = b;
        else
            small = c;

        if(big == a && small == b)
            mid = c;
        else if(big==b && small==c)
            mid=a;
        else
            mid=b;

        System.out.println("Ascending order of numbers \n" + small + "\t" + mid + "\t" + big);
    }
}
