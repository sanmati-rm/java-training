package com.target.training.programs;

import com.target.training.dao.ArrayListContactsDao;
import com.target.training.dao.ContactsDao;
import com.target.training.entity.Contact;
import com.target.training.entity.Gender;
import com.target.training.exception.DaoException;
import com.target.training.utils.KeyboardUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Assignment18 {

    static Scanner sc = new Scanner(System.in);
    ContactsDao dao;


    public static void main(String[] args) {
        new Assignment18().start();
        }


    private void start() {
        dao = new ArrayListContactsDao();

        int choice;

        while ((choice = menu()) != 0) {
            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                   listAllContacts();
                    break;
                case 3:
                    System.out.println("Searching by id; TBD");
                    break;
                case 4:
                    System.out.println("Search by price range");
                    break;
                case 5:
                    System.out.println("Update; TBD");
            }
        }

        System.out.println("Bye!");

    }

    void line(char pattern) {
        for (int i = 1; i <= 80; i++) {
            System.out.print(pattern);
        }
        System.out.println();
    }

    private void addNewContact() {
        try {
            Integer id = KeyboardUtil.getInt("Enter ID: ");
            String firstname = KeyboardUtil.getString("Enter FirstName: ");
            String lastname = KeyboardUtil.getString("Enter Lastname: ");
            Gender gender;
            System.out.println("Select gender: 1-MALE 2-FEMALE");
            int choice = sc.nextInt();
            switch(choice){
                case 1: gender = Gender.MALE;
                        break;
                case 2: gender = Gender.FEMALE;
                        break;
                default: System.out.println("Invalid choice");
            }

            String email = KeyboardUtil.getString("Enter email: ");
            String phone = KeyboardUtil.getString("Enter Phone: ");
            String address = KeyboardUtil.getString("Enter address: ");
            String city = KeyboardUtil.getString("Enter city: ");
            String state = KeyboardUtil.getString("Enter state: ");
            int pinCode = KeyboardUtil.getInt("Enter pinCode");
            String country = KeyboardUtil.getString("Enter country: ");
            Date date = KeyboardUtil.getDate("Enter Date: ");
            Contact c = new Contact(id,firstname,lastname,gender,email,phone,address,city,state,pinCode,country,date);
            dao.addContact(c);
            System.out.println("New product added successfully!");
        }
        catch(Exception e){
            System.out.println("There was a problem while adding the product details.");
            System.out.println(e.getMessage());
        }
    }

    private void listAllContacts() {
        try {
            List<Contact> list = dao.getContacts();
            line('=');
            System.out.printf("%-10s %-40s %10s\n", "ID", "Name", "LastName");
            line('=');
            for (Contact c : list) {
                System.out.printf("%-10d %-40s %10.2f\n", c.getId(), c.getFirstname(), c.getLastname());
            }
            line('-');
        } catch (DaoException e) {
            System.out.println("There was a problem");
        }

    }

    int menu() {
        line('.');
        int choice = -1;
        do {
            System.out.println("Please choose from the below set of options");
            System.out.println("1: Create new contact \n 2: View contact with id \n 3: Update a contact \n 4: Delete a contact \n" +
                    "5: View contact with email \n 6: View contact with phone \n 7: View contact with last name \n" +
                    "8: View contact from city \n 9: View all contacts \n 10: View contact with birthday");
            try {
                choice = KeyboardUtil.getInt("Enter your choice: ");
                if (choice < 0 || choice > 10) {
                    System.out.println("Invalid choice, please retry!");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice, please retry!");
            }


        } while (choice < 0 || choice > 10);

        return choice;
    }
}
