package com.target.training.assignment;

import com.target.training.util.KeyboardUtil;

public class Assignment1 {

    static boolean isValidDate(int year, int month, int day) {
        if(year%400 == 0 && year%100 ==0 || year%4 ==0 ){  //For leap years
            if(month == 2){ //For month of Feb
                if(day <=29){
                    return true;
                }
            }
            else if(month%2==1 || month==8){ //For months with 31 days
                if(day<=31){
                    return true;
                }
            }
            else{
                if(day<=30) //For months with 30 days
                    return true;
            }
        }
        else{ //For non-leap years
            if(month == 2){
                if(day <=28){
                    return true;
                }
            }
            else if(month%2==1 || month==8){
                if(day<=31){
                    return true;
                }
            }
            else{
                if(day<=30)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int year = KeyboardUtil.getInt("Enter the year");
        int month = KeyboardUtil.getInt("Enter the month");
        int day = KeyboardUtil.getInt("Enter the day");

        boolean result = isValidDate(year,month,day);
        if(result)
            System.out.println("The date" + year + "/" + month + "/" + day +  "is valid");
        else
            System.out.println("The date" + year + "/" + month + "/" + day +  "is not valid");
    }
}