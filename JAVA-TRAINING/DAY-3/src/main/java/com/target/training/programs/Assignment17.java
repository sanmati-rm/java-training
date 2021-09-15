package com.target.training.programs;


import java.util.Scanner;

public class Assignment17
{
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int month,year;

        System.out.println("Enter the month anf year in YYYY-MM format");
        String date= sc.nextLine();
        try {
            checkValidInput(date);
        } catch (InvalidInputException e) {
            e.getMessage();
        }

        String[] arrOfStr = date.split("-", 2);

        year = Integer.parseInt(arrOfStr[0]);
        month = Integer.parseInt(arrOfStr[1]);

        try {
            checkValidDate(month,year);
        } catch (InvalidDateException e) {
            e.getMessage();
        }


    }

    public static boolean checkValidInput(String date) throws InvalidInputException
    {
        if(!date.matches("\\d\\d\\d\\d[\\-]\\d\\d"))
        {
            throw new InvalidInputException("Date not entered in proper format");
        }
        else
            return true;
    }

    public static void checkValidDate(int month,int year) throws InvalidDateException
    {
        if(month<0 || month>12 || year<0 || year>9999)
        {
            System.out.println("print");
            throw new InvalidDateException("The date entered is invalid");
        }
        else
        {
            // months[i] = name of month i
            String[] months = {"","January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

            // dayOfTheMonths[i] = number of days in month i
            int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            // check for leap year
            if (month == 2 && leapYearCheck(year)) days[month] = 29;

            // print calendar header
            System.out.println("   " + months[month] + " " + year);
            System.out.println(" S  M Tu  W Th  F  S");

            // starting day
            int d = dayOfTheMonth(month, 1, year);

            // print the calendar
            for (int i = 0; i < d; i++)
                System.out.print("   ");
            for (int i = 1; i <= days[month]; i++) {
                System.out.printf("%2d ", i);
                if (((i + d) % 7 == 0) || (i == days[month])) System.out.println();
            }
        }


    }


    public static int dayOfTheMonth(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }

    // return true if the given year is a leap year
    public static boolean leapYearCheck(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0) && (year%400 ==0 ))
            return true;
        else
            return false;
    }
}
