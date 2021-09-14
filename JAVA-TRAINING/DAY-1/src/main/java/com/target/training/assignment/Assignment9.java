package com.target.training.assignment;

import com.target.training.util.KeyboardUtil;

import java.util.Scanner;

public class Assignment9 {

    static public int[] sumOfEvensAndOdds(int nums[]) {

        int res[] = new int[2];
        int even =0, odd =0;

        for(int i=0;i<nums.length ;i++){
            if(i%2!=0){
                even += nums[i];
            }
            else
                odd += nums[i];
        }
        res[0] = even;
        res[1] = odd;
        return res;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = KeyboardUtil.getInt("Enter the length of the array: ");
        int nums[] = new int[size];

        for(int i=0;i<size;i++)
            nums[i] = sc.nextInt();
        int res[] = sumOfEvensAndOdds(nums);

        System.out.println("The sum of even numbers in the array: " + res[0]);
        System.out.println("The sum of odd numbers in the array: " + res[1]);
    }
}
