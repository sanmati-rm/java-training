package com.target.training.assignment;

import com.target.training.util.KeyboardUtil;

public class Assignment5 {

    static public int fibonacci(int index) {

        int f[] = new int[index];
        f[0]=1;
        f[1]=1;

        for(int i=2; i<index;i++)
            f[i] = f[i-1] + f[i-2];

        System.out.println("The fibonacci series is ");
        for(int i=0;i<index;i++)
            System.out.print(f[i] + "\t");
        return 0;
    }

    public static void main(String[] args) {

        int index= KeyboardUtil.getInt("Enter the index: ");

        int res = fibonacci(index);
    }
}
