package com.target.training.assignment;


import java.util.Scanner;

import static java.lang.System.exit;

public class Assignment8
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the month: ");
        int month = sc.nextInt();

        System.out.println("Enter the year: ");
        int year = sc.nextInt(); // year

        // months[i] = name of month i
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        // days[i] = number of days in month i
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // check for leap year
        if (month == 2 && isLeapYear(year))
            days[month] = 29;

        if(month>12) {
            System.out.println("Month entered is invalid");
            exit(0);
        }
        else if(year<0 || year>9999) {
            System.out.println("Year entered is invalid");
            exit(0);
        }
        else{
            // print calendar header
            System.out.println("   " + months[month] + " " + year);
            System.out.println(" S  M Tu  W Th  F  S");

            // starting day
            int d = day(month, 1, year);

            // print the calendar
            for (int i = 0; i < d; i++)
                System.out.print("   ");
            for (int i = 1; i <= days[month]; i++) {
                System.out.printf("%2d ", i);
                if (((i + d) % 7 == 0) || (i == days[month])) System.out.println();
            }
        }


    }

    public static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }

    // return true if the given year is a leap year
    public static boolean isLeapYear(int year) {
        if((year % 4 == 0) && (year % 100 != 0) && (year % 400 == 0))
            return true;
        else
            return false;
    }
}
