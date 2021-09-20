package com.target.training.dao;

import com.target.training.entity.Contact;
import com.target.training.entity.Gender;
import com.target.training.exception.DaoException;
import com.target.training.utils.KeyboardUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapContactsDao implements ContactsDao1 {

    private Map<Integer, Contact> contacts = new HashMap<>();

    public HashMapContactsDao() {

        String date = "21/10/1999";
        Date bDate = null;
        try {
        bDate = new SimpleDateFormat("dd/MM/yyyy").parse(date); }
        catch(ParseException e)
        {
        System.out.println("Date not parsed");
        }


        Contact c1 = new Contact(1, "Sanmati", "R M", Gender.FEMALE, "sam@gmail.com", "9845634098", "Yelahanka", "Bangalore", "Karnataka", 560064, "India", bDate);
        Contact c2 = new Contact(2, "Sam", "R M", Gender.FEMALE, "sam2@gmail.com", "9845634097", "Yelahanka", "Bangalore", "Karnataka", 560064, "India", bDate);
        Contact c3 = new Contact(3, "Sannu", "R M", Gender.FEMALE, "sam3@gmail.com", "9845634096", "Yelahanka", "Bangalore", "Karnataka", 560064, "India", bDate);

        contacts.put(c1.getId(),c1);
        contacts.put(c2.getId(),c2);
        contacts.put(c3.getId(),c3);
    }

    @Override
    public void addContact(Contact contact) throws DaoException {

        contacts.put(contact.getId(), contact);
    }

    @Override
    public Contact getContact(int id) throws DaoException {


        return contacts.get(id);
    }

    @Override
    public void updateContact(Contact contact) throws DaoException {

    }

    @Override
    public void deleteContact(int id) throws DaoException {

    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        /*
        Map<Integer, Contact> list = new HashMap<>();

        if (list.containsValue(email))

           return */

        return null;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        return null;
    }

    @Override
    public Map<Integer, Contact> getContactsByLastname(String lastname) throws DaoException {
        return null;
    }

    @Override
    public Map<Integer, Contact> getContactsByCity(String city) throws DaoException {
        return null;
    }

    @Override
    public Map<Integer, Contact> getContacts() throws DaoException {
        return this.contacts;
    }

    @Override
    public Map<Integer, Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        return null;
    }
}
