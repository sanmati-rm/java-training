package com.target.training.programs;

import com.target.training.utils.KeyboardUtil;
import com.target.training.entity.Gender;
import com.target.training.exception.DaoException;
import com.target.training.entity.DaoFactory;
import com.target.training.entity.ContactsDao;
import com.target.training.entity.Contact;

import java.util.Date;
import java.util.List;

public class Application {
    ContactsDao dao;

    public static void main(String[] args) {

        new Application().start();
    }

    void start() {
        try {
            dao = DaoFactory.getContactsDao(); // loose coupling
        } catch (DaoException e) {
            e.printStackTrace();
            return;
        }
        int choice;

        while ((choice = menu()) != 0) {
            switch (choice) {
                case 1:
                    addContactDetails();
                    break;
                case 2:
                    listContacts();
                    break;
                case 3: getContactById();
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

    private void addContactDetails() {
        try
        {
        String firstname = KeyboardUtil.getString("Enter FirstName: ");
        String lastname = KeyboardUtil.getString("Enter Lastname: ");
        String genderInput = KeyboardUtil.getString("Enter gender: MALE, FEMALE, OTHERS");
        Gender gender = Gender.valueOf(genderInput.toUpperCase());
        String email = KeyboardUtil.getString("Enter email: ");
        String phone = KeyboardUtil.getString("Enter Phone: ");
        String address = KeyboardUtil.getString("Enter address: ");
        String city = KeyboardUtil.getString("Enter city: ");
        String state = KeyboardUtil.getString("Enter state: ");
        String pinCode = KeyboardUtil.getString("Enter pinCode");
        String country = KeyboardUtil.getString("Enter country: ");
        Date date = KeyboardUtil.getDate("Enter Date: ");
        Contact c = new Contact(firstname, lastname, gender, email, phone, address, city, state, pinCode, country, date);
        dao.addContact(c);
    }
        catch (Exception e) {
        System.out.println("There was a problem while adding the product details.");
        System.out.println(e.getMessage());
    }
    }

    private void listContacts() {
        try {
            List<Contact> list = dao.getContacts();
            line('=');
            System.out.printf("%-10s %-40s %-40s\n", "ID", "Name", "LName");
            line('=');
            for (Contact c : list) {
                System.out.printf("%-10d %-40s %-40s\n", c.getId(), c.getFirstname(), c.getLastname());
            }
            line('-');
        } catch (DaoException e) {
            System.out.println("There was a problem");
        }
    }

    private void getContactById() {

        int id = KeyboardUtil.getInt("Enter ID of contact to be searched");

        try {
            Contact c = dao.getContact(id);
            System.out.println(c);

        } catch (DaoException e) {
            System.out.println("There was a problem");
        }

    }

    int menu() {
        line('.');
        int choice = -1;

        do {
            System.out.println("0. Exit");
            System.out.println("1. Add new contact");
            System.out.println("2. List all contacts");
            System.out.println("3. Search by id");
            System.out.println("4. Search by price range");
            System.out.println("5. Update contact");
            try {
                choice = KeyboardUtil.getInt("Enter your choice: ");
                if (choice < 0 || choice > 5) {
                    System.out.println("Invalid choice, please retry!");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice, please retry!");
            }


        } while (choice < 0 || choice > 5);

        return choice;
    }
}