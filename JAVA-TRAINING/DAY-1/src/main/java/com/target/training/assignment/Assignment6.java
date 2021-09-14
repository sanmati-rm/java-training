package com.target.training.assignment;

import com.target.training.util.KeyboardUtil;

public class Assignment6 {

    public static void main(String[] args) {
        int rows = KeyboardUtil.getInt("Enter the number of rows: ");

        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
