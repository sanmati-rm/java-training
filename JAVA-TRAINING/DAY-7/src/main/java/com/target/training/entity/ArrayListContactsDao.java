package com.target.training.entity;

import com.target.training.entity.Contact;
import com.target.training.entity.Gender;
import com.target.training.exception.DaoException;
import com.target.training.utils.KeyboardUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ArrayListContactsDao implements ContactsDao {

    private List<Contact> contacts = new ArrayList<>();

    public ArrayListContactsDao() {


        String date = "21/10/1999";
        Date bDate = null;
        try{
            bDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        }
        catch (ParseException e)
        {
            System.out.println("Date not parsed");
        }


        contacts.add(new Contact(1,"Sanmati","R M",Gender.FEMALE,"sam@gmail.com","9845634098","Yelahanka","Bangalore","Karnataka",560064,"India",bDate));
        contacts.add(new Contact(2,"Sam","R M",Gender.FEMALE,"sam2@gmail.com","9845634097","Yelahanka","Bangalore","Karnataka",560064,"India",bDate));
        contacts.add(new Contact(3,"Sannu","R M",Gender.FEMALE,"sam3@gmail.com","9845634096","Yelahanka","Bangalore","Karnataka",560064,"India",bDate));


    }

    @Override
    public void addContact(Contact contact) throws DaoException {
        contacts.add(contact);
    }

    @Override
    public Contact getContact(int id) throws DaoException {

        for(Contact c: contacts)
            if(c.getId() == id)
                return c;

        return null;
    }

    @Override
    public void updateContact(Contact contact) throws DaoException{

        contact.setFirstname(KeyboardUtil.getString("Enter FirstName: "));
        contact.setLastname(KeyboardUtil.getString("Enter Lastname: "));
        int choice = KeyboardUtil.getInt("Select gender: 1-MALE 2-FEMALE");
        switch (choice) {
            case 1:
                contact.setGender(Gender.MALE);
                break;
            case 2:
                contact.setGender(Gender.FEMALE);
                break;
            default:
                System.out.println("Invalid choice");
        }

        contact.setEmail(KeyboardUtil.getString("Enter email: "));
        contact.setPhone(KeyboardUtil.getString("Enter Phone: "));
        contact.setAddress(KeyboardUtil.getString("Enter address: "));
        contact.setCity(KeyboardUtil.getString("Enter city: "));
        contact.setState(KeyboardUtil.getString("Enter state: "));
        contact.setPincode(KeyboardUtil.getInt("Enter pinCode"));
        contact.setCountry(KeyboardUtil.getString("Enter country: "));
        contact.setBirthDate(KeyboardUtil.getDate("Enter Date: "));

    }

    @Override
    public void deleteContact(int id) throws DaoException {
        contacts.remove(id-1);

    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {

        for(Contact c: contacts)
            if(c.getEmail().equalsIgnoreCase(email))
                return c;

        return null;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {

        for(Contact c: contacts)
            if(c.getPhone().equalsIgnoreCase(phone))
                return c;

        return null;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {

        List<Contact> list = new ArrayList<Contact>();
        for(Contact c: contacts)
            if(c.getLastname().equalsIgnoreCase(lastname)){
                list.add(c);
                return list;
            }

        return null;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {

        List<Contact> list = new ArrayList<Contact>();
        for(Contact c: contacts)
            if(c.getCity().equalsIgnoreCase(city)){
                list.add(c);
                return list;
            }
        return null;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {
        return this.contacts;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {

        List<Contact> list = new ArrayList<Contact>();
        for(Contact c:contacts)
            if(c.getBirthDate().after(from) && c.getBirthDate().before(to)){
                list.add(c);
                return list;
            }

        return null;
    }


}
