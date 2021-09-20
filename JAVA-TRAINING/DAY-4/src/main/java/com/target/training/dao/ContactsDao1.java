package com.target.training.dao;

import com.target.training.entity.Contact;
import com.target.training.exception.DaoException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ContactsDao1 {

    //CRUD operations
    public void addContact(Contact contact) throws DaoException;
    public Contact getContact(int id) throws DaoException;
    public void updateContact(Contact contact) throws DaoException;
    public void deleteContact(int id) throws DaoException;

    // Queries
    public Contact getContactByEmail(String email) throws DaoException;
    public Contact getContactByPhone(String phone) throws DaoException;
    public Map<Integer, Contact> getContactsByLastname(String lastname) throws DaoException;
    public Map<Integer, Contact> getContactsByCity(String city) throws DaoException;
    public Map<Integer, Contact> getContacts() throws DaoException;
    public Map<Integer, Contact> getContactsByBirthDate(Date from, Date to) throws DaoException;


}
