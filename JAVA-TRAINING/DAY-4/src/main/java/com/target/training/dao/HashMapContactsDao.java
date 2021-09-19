package com.target.training.dao;

import com.target.training.entity.Contact;
import com.target.training.exception.DaoException;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapContactsDao implements ContactsDao{

    private Map<Integer, Contact> contacts = new HashMap<>();

    @Override
    public void addContact(Contact contact) throws DaoException {

    }

    @Override
    public Contact getContact(int id) throws DaoException {
        return null;
    }

    @Override
    public void updateContact(Contact contact) throws DaoException {

    }

    @Override
    public void deleteContact(int id) throws DaoException {

    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        return null;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        return null;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        return null;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        return null;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {
        return null;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        return null;
    }
}
